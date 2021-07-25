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
package org.ressec.lychee.translation.base;

import lombok.Getter;
import lombok.NonNull;

public enum TranslationApiVersionType
{
    UNKNOWN_TRANSLATION_API("Unknown"),

    GOOGLE_TRANSLATION_API_V1("https://translate.googleapis.com/translate_a/t?client=dict-chrome-ex"),

    GOOGLE_TRANSLATION_API_V2("https://translation.googleapis.com/language/translate/v2"),

    GOOGLE_TRANSLATION_API_V3("https://translation.googleapis.com/language/translate/v3"),

    MICROSOFT_TRANSLATION_API_V1(""),

    IBM_TRANSLATION_API_V1(""),

    AMAZON_TRANSLATION_API_V1("");

    @Getter
    private String url;

    TranslationApiVersionType(final @NonNull String url)
    {
        this.url = url;
    }
}
