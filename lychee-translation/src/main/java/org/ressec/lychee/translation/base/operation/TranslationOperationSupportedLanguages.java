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
package org.ressec.lychee.translation.base.operation;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Concrete implementation of a {@code Get Supported Languages} translation operation.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public class TranslationOperationSupportedLanguages extends TranslationOperation implements ITranslationOperationSupportedLanguages
{
    /**
     * List of supported languages.
     */
    @Getter
    private final List<Locale> supportedLanguages = new ArrayList<>();

    /**
     * Creates a new {@code Supported Languages} translation operation.
     * @param targetLanguage Target language.
     */
    @Builder(setterPrefix = "with")
    public TranslationOperationSupportedLanguages(final @NonNull Locale targetLanguage)
    {
        super(TranslationOperationType.SUPPORTED_LANGUAGES, null,targetLanguage, null, null, null);
    }

    @Override
    public final void addSupportedLanguage(@NonNull Locale locale)
    {
        supportedLanguages.add(locale);
    }

    @Override
    public final boolean isSupportedLanguage(@NonNull Locale locale)
    {
        return supportedLanguages.contains(locale);
    }
}
