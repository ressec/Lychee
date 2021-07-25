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
 * Concrete implementation of a {@code Detect Language} translation operation.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public class TranslationOperationDetect extends TranslationOperation implements ITranslationOperationDetect
{
    /**
     * Locale representing the detected language.
     */
    @Getter
    @Setter
    private Locale detectedLanguage;

    /**
     * Number representing the confidence of the detected language (between 0 to 1).
     */
    @Getter
    @Setter
    private double detectedConfidence;

    /**
     * Creates a new {@code Detect Languages} translation operation.
     * @param text Text for which the language is to be detected.
     */
    @Builder(setterPrefix = "with")
    public TranslationOperationDetect(final @NonNull String text)
    {
        super(TranslationOperationType.DETECT, null, null, text, null, null);
    }
}
