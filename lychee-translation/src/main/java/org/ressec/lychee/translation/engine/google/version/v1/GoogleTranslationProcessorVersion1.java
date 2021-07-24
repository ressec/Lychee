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
package org.ressec.lychee.translation.engine.google.version.v1;

import io.gsonfire.GsonFireBuilder;
import lombok.Builder;
import lombok.NonNull;
import org.ressec.avocado.core.exception.unchecked.NotImplementedException;
import org.ressec.lychee.translation.base.TranslationApiVersionType;
import org.ressec.lychee.translation.base.operation.ITranslationOperation;
import org.ressec.lychee.translation.base.operation.TranslationOperationDetect;
import org.ressec.lychee.translation.base.operation.TranslationOperationTranslate;
import org.ressec.lychee.translation.base.processor.TranslationProcessor;
import org.ressec.lychee.translation.base.request.ITranslationRequest;
import org.ressec.lychee.translation.base.result.ITranslationOperationResult;
import org.ressec.lychee.translation.base.result.ITranslationResult;
import org.ressec.lychee.translation.base.result.ITranslationResultError;
import org.ressec.lychee.translation.engine.google.GoogleTranslationError;
import org.ressec.lychee.translation.engine.google.version.v1.result.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Represents a Google (free) translation API processor.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public final class GoogleTranslationProcessorVersion1 extends TranslationProcessor
{
    @Builder(setterPrefix = "with")
    public GoogleTranslationProcessorVersion1(final @NonNull ITranslationRequest request)
    {
        super(TranslationApiVersionType.GOOGLE_TRANSLATION_API_V1, request);
    }

    @Override
    protected final void createGsonBuilder()
    {
        gsonBuilder = new GsonFireBuilder()
                .createGsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .enableComplexMapKeySerialization()
                .registerTypeAdapter(ITranslationResult.class, new GoogleTranslationResultVersion1Deserializer())
                .registerTypeAdapter(ITranslationResultError.class, new GoogleTranslationResultErrorDeserializer())
                .registerTypeAdapter(ITranslationOperationResult.class, new GoogleTranslationOperationResultVersion1Deserializer())
                .create();
    }


    @Override
    protected String buildUrl(final @NonNull ITranslationOperation operation)
    {
        StringBuilder url = new StringBuilder(getApi().getUrl());
        String textEncoded = null;

        if (operation.getText() != null)
        {
            textEncoded = URLEncoder.encode(operation.getText(), StandardCharsets.UTF_8);
        }

        switch (operation.getOperationType())
        {
            case SUPPORTED_LANGUAGES:
                throw new NotImplementedException("The getSupportedLanguage() service is not available with the free version of the Google Translate API!");

            case DETECT:
                url.append("&dt=t&q=")
                        .append(textEncoded);
                break;

            case TRANSLATE:
            default:
                if (operation.getSourceLanguage() != null)
                {
                    url.append("&sl=")
                            .append(operation.getSourceLanguage().getLanguage());
                }
                url.append("&tl=")
                    .append(operation.getTargetLanguage().getLanguage())
                    .append("&dt=t&q=")
                    .append(textEncoded)
                .append("&dj=1");
                break;
        }

        return url.toString();
    }

    @Override
    protected void processOperationResult(@NonNull ITranslationResult result, @NonNull ITranslationRequest request, @NonNull ITranslationOperation operation)
    {
        switch (operation.getOperationType())
        {
            case DETECT:
                GoogleTranslationResultVersion1 r = (GoogleTranslationResultVersion1) result;
                TranslationOperationDetect o = (TranslationOperationDetect) operation;
                if (r.getDetection() != null)
                {
                    o.setDetectedLanguage(Locale.forLanguageTag(r.getDetection().getLanguages().get(0)));
                    o.setDetectedConfidence(r.getDetection().getConfidences().get(0));
                }
                break;

            case TRANSLATE:
                ((TranslationOperationTranslate) operation).setTranslatedText(result.getTranslation());
                break;

            case SUPPORTED_LANGUAGES:
                break;
        }
    }

    @Override
    protected void setError(final @NonNull ITranslationResultError error, final @NonNull ITranslationOperation operation)
    {
        GoogleTranslationError e = (GoogleTranslationError) error;

        operation.setReason(e.getError().getMessage());
    }
}
