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
import lombok.Setter;

import java.util.Locale;

/**
 * Concrete implementation of a {@code Translate} translation operation.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public class TranslationOperationTranslate extends TranslationOperation implements ITranslationOperationTranslate
{
    /**
     * Translate text.
     */
    @Getter
    @Setter
    private String translatedText;

    /**
     * Creates a new {@code Translate} translation operation.
     * @param sourceLanguage Source language.
     * @param targetLanguage Target language.
     * @param text Text to translate.
     * @param propertyName Property name.
     * @param propertyValue Property value.
     */
    @Builder(setterPrefix = "with")
    public TranslationOperationTranslate(final /*@NonNull*/ Locale sourceLanguage, final @NonNull Locale targetLanguage,
                                         final @NonNull String text, final String propertyName, final String propertyValue)
    {
        super(TranslationOperationType.TRANSLATE,sourceLanguage,targetLanguage,text, propertyName, propertyValue);
    }
}
