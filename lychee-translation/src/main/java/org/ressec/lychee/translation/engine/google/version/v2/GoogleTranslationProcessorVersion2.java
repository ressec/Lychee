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
package org.ressec.lychee.translation.engine.google.version.v2;

import io.gsonfire.GsonFireBuilder;
import lombok.Builder;
import lombok.NonNull;
import org.ressec.lychee.translation.base.TranslationApiVersionType;
import org.ressec.lychee.translation.base.operation.ITranslationOperation;
import org.ressec.lychee.translation.base.operation.TranslationOperationDetect;
import org.ressec.lychee.translation.base.operation.TranslationOperationSupportedLanguages;
import org.ressec.lychee.translation.base.operation.TranslationOperationTranslate;
import org.ressec.lychee.translation.base.processor.TranslationProcessor;
import org.ressec.lychee.translation.base.request.ITranslationRequest;
import org.ressec.lychee.translation.base.result.ITranslationOperationResult;
import org.ressec.lychee.translation.base.result.ITranslationResult;
import org.ressec.lychee.translation.base.result.ITranslationResultError;
import org.ressec.lychee.translation.engine.google.GoogleTranslationError;
import org.ressec.lychee.translation.engine.google.version.v1.result.GoogleTranslationResultErrorDeserializer;
import org.ressec.lychee.translation.engine.google.version.v2.result.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Represents a Google (paid) translation API processor version 2.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public final class GoogleTranslationProcessorVersion2 extends TranslationProcessor
{
    /**
     * Google translation API key.
     */
    private final String apiKey;

    @Builder(setterPrefix = "with")
    public GoogleTranslationProcessorVersion2(final @NonNull ITranslationRequest request, final @NonNull String apiKey)
    {
        super(TranslationApiVersionType.GOOGLE_TRANSLATION_API_V2, request);
        this.apiKey = apiKey;
    }

    @Override
    protected void createGsonBuilder()
    {
        gsonBuilder = new GsonFireBuilder()
                .createGsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .registerTypeAdapter(ITranslationResult.class, new GoogleTranslationResultVersion2Deserializer())
                .registerTypeAdapter(ITranslationResultError.class, new GoogleTranslationResultErrorDeserializer())
                .registerTypeAdapter(ITranslationOperationResult.class, new GoogleTranslationOperationEntryVersion2Deserializer())
                .enableComplexMapKeySerialization()
                .create();
    }


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
                url.append("/languages?key=")
                        .append(this.apiKey)
                        .append(operation.getTargetLanguage().getLanguage() != null ? "&Target=" + operation.getTargetLanguage().getLanguage() : "");
                break;

            case DETECT:
                url.append("/detect?key=")
                        .append(this.apiKey)
                        .append("&q=")
                        .append(textEncoded);
                break;

            case TRANSLATE:
            default:
                url.append("?key=")
                        .append(this.apiKey)
                        .append("&format=text")
                        .append("&source=")
                        .append(operation.getSourceLanguage().getLanguage())
                        .append("&target=")
                        .append(operation.getTargetLanguage().getLanguage())
                        .append("&q=")
                        .append(textEncoded);
                break;
        }

        return url.toString();
    }

    @Override
    protected void processOperationResult(@NonNull ITranslationResult result, @NonNull ITranslationRequest request, @NonNull ITranslationOperation operation)
    {
        GoogleTranslationResultVersion2 resultV2 = (GoogleTranslationResultVersion2) result;

        switch (operation.getOperationType())
        {
            case SUPPORTED_LANGUAGES:
                if (resultV2.getData() != null)
                {
                    TranslationOperationSupportedLanguages o = (TranslationOperationSupportedLanguages) operation;
                    for (GoogleTranslationResultGetSupportedLanguage tag : resultV2.getData().getLanguages())
                    {
                        o.addSupportedLanguage(Locale.forLanguageTag(tag.getLanguage()));
                        o.setConfidence(1.0d); // Always 100% for this operation
                    }
                }
                break;

            case DETECT:
                if (resultV2.getData() != null)
                {
                    TranslationOperationDetect o = (TranslationOperationDetect) operation;
                    for (List<GoogleTranslationResultDetectVersion2> list : resultV2.getData().getDetections())
                    {
                        for (GoogleTranslationResultDetectVersion2 detection : list)
                        {
                            o.setConfidence(detection.getConfidence());
                            o.setDetectedLanguage(Locale.forLanguageTag(detection.getLanguage()));
                        }
                    }
                }
                break;

            case TRANSLATE:
                if (resultV2.getData() != null)
                {
                    TranslationOperationTranslate o = (TranslationOperationTranslate) operation;
                    String translated = resultV2.getData().getTranslated().stream()
                            .map(ITranslationOperationResult::getTranslation)
                            .collect( Collectors.joining(""));
                    translated = translated.replace("null", "");
                    o.setTranslatedText(translated);
                }
                break;

            default:
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
