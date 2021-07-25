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

import lombok.NonNull;

import java.util.List;
import java.util.Locale;

public interface ITranslationOperationSupportedLanguages
{
    /**
     * Adds a supported language.
     * @param locale Locale of the supported language.
     */
    void addSupportedLanguage(final @NonNull Locale locale);

    /**
     * Checks if the given locale is part of the supported languages?
     * @param locale Locale to check.
     * @return True if the locale is part of the supported languages, false otherwise.
     */
    boolean isSupportedLanguage(final @NonNull Locale locale);

    /**
     * Returns a list of supported languages.
     * @return List of locales representing the supported languages.
     */
    List<Locale> getSupportedLanguages();
}
