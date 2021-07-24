/*
 * Copyright(c) 2021 by Resse Christophe.
 * --------------------------------------------------------------------------------------
 * This file is part of Resse Christophe public projects which is licensed
 * under the Apache license version 2 and use is subject to license terms.
 * You should have received a copy of the license with the project's artifact
 * binaries and/or sources.
 *
 * License can be consulted at http://www.apache.org/licenses/LICENSE-2.0
 * --------------------------------------------------------------------------------------
 */
package org.ressec.lychee.translation.base.processor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.NonNull;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.ressec.avocado.core.helper.JsonHelper;
import org.ressec.lychee.translation.base.TranslationApiVersionType;
import org.ressec.lychee.translation.base.TranslationException;
import org.ressec.lychee.translation.base.operation.ITranslationOperation;
import org.ressec.lychee.translation.base.operation.TranslationOperationStatusType;
import org.ressec.lychee.translation.base.request.ITranslationRequest;
import org.ressec.lychee.translation.base.request.TranslationRequest;
import org.ressec.lychee.translation.base.result.ITranslationResult;
import org.ressec.lychee.translation.base.result.ITranslationResultError;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Represents a translation processor.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public abstract class TranslationProcessor implements ITranslationProcessor
{
    /**
     * Request property to force the translation even if the translated text is also known.
     */
    private final String PROPERTY_TRANSLATION_FORCE = "request.translation.force";

    /**
     * Translation processor API version type used.
     */
    @Getter
    protected TranslationApiVersionType api;

    /**
     * Gson builder.
     */
    protected Gson gsonBuilder;

    /**
     * Translation requests.
     */
    @Getter
    private final List<ITranslationRequest> requests = new ArrayList<>();

    public TranslationProcessor(final TranslationApiVersionType apiType, final @NonNull ITranslationRequest request)
    {
        this.api = apiType;
        this.requests.add(request);
    }

    @Override
    public final void execute() throws TranslationException
    {
        HttpGet http;
        String url;
        ITranslationResult result = null;
        ITranslationResultError error = null;
        StatusLine statusLine;
        HttpResponse response;
        Instant start;
        Instant stop;

        if (gsonBuilder == null)
        {
            createGsonBuilder();
        }

        if (requests.isEmpty())
        {
            throw new TranslationException("Translation request cannot be null!");
        }

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build())
        {
            for (ITranslationRequest request : requests)
            {
                evaluateRequestProperties(request);

                for (ITranslationOperation operation : request.getOperations())
                {
                    if (operation.getStatusType() != TranslationOperationStatusType.INVALIDATED)
                    {
                        url = buildUrl(operation);

                        http = new HttpGet(url);
                        http.setHeader( "Accept", "application/json" );
                        start = Instant.now();
                        response = httpClient.execute(new HttpGet(url));
                        stop = Instant.now();
                        statusLine = response.getStatusLine();

                        if (statusLine.getStatusCode() == HttpStatus.SC_OK)
                        {
                            result = deserializeResponse(getResponseString(response));
                            operation.setExecutionTime(Duration.between(start, stop).toMillis());
                            operation.setApiVersion(api);
                            operation.setStatusType(TranslationOperationStatusType.SUCCESS);
                            processOperationResult(result, request, operation);
                        }
                        else
                        {
                            error = deserializeErrorResponse(getResponseString(response));
                            operation.setStatusType(TranslationOperationStatusType.FAILED);
                            setError(error, operation);
                        }
                    }
                    else
                    {
                        operation.setReason("Operation has been invalidated because translated text is not empty!");
                    }
                }

                ((TranslationRequest) request).generateTargetProperties(); // TODO Should be a concrete special version of the request
            }
        }
        catch (Exception e)
        {
            throw new TranslationException(e);
        }
    }

    protected abstract void processOperationResult(final @NonNull ITranslationResult result, final @NonNull ITranslationRequest request, final @NonNull ITranslationOperation operation);

    protected abstract void setError(final @NonNull ITranslationResultError error, final @NonNull ITranslationOperation operation);

    /**
     * Creates the json builder used for translation result de-serialization.
     */
    protected abstract void createGsonBuilder();

    @Override
    public final void clear()
    {
        requests.clear();
    }

    @Override
    public final void addRequest(@NonNull ITranslationRequest request)
    {
        requests.add(request);
    }

    @Override
    public final Optional<ITranslationRequest> getRequest(@NonNull String name)
    {
        return requests.stream()
                .filter(request -> request.getName().equals(name))
                .findFirst();
    }

    protected abstract String buildUrl(final @NonNull ITranslationOperation operation);

    /**
     * Extracts the response string from the received HTTP response.
     * @param response HTTP response.
     * @return Response string.
     * @throws IOException Thrown to indicate an error occurred while trying to extracts the response string.
     */
    private String getResponseString(HttpResponse response) throws IOException
    {
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * Deserializes the translation API response.
     * @param response Translation API response.
     * @return De-serialized translation result.
     */
    private ITranslationResult deserializeResponse(String response)
    {
        Locale.setDefault(Locale.ENGLISH);
        return JsonHelper.deserialize(gsonBuilder, response, new TypeToken<ITranslationResult>(){}.getType());
    }

    /**
     * Deserializes the translation API error response.
     * @param response Translation API response.
     * @return De-serialized translation result error.
     */
    private ITranslationResultError deserializeErrorResponse(String response)
    {
        Locale.setDefault(Locale.ENGLISH);
        return JsonHelper.deserialize(gsonBuilder, response, new TypeToken<ITranslationResultError>(){}.getType());
    }

    /**
     *
     * @param request
     */
    private void evaluateRequestProperties(final @NonNull ITranslationRequest request)
    {
       // Does the 'request.translation.force' property is defined?
       if (request.existProperty(PROPERTY_TRANSLATION_FORCE) && Boolean.parseBoolean(request.getProperty(PROPERTY_TRANSLATION_FORCE)))
       {
           for (ITranslationOperation op : request.getOperations())
           {
               if (op.getStatusType() == TranslationOperationStatusType.INVALIDATED)
               {
                   op.setStatusType(TranslationOperationStatusType.CREATED);
               }
           }
       }
    }
}
