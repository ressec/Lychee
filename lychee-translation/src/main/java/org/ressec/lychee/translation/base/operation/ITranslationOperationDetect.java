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

import java.util.Locale;

/**
 * Provides the basic behavior of a {@code Detect Language} translation operation.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public interface ITranslationOperationDetect extends ITranslationOperation
{
    /**
     * Sets the detected language.
     * @param detectedLocale Locale of the detected language.
     */
    void setDetectedLanguage(final @NonNull Locale detectedLocale);

    /**
     * Returns the detected language.
     * @return Locale representing the detected language.
     */
    Locale getDetectedLanguage();

    /**
     * Sets the detected confidence.
     * @param confidence Value between 0 and 1 representing the confidence of the detected language. A value of 1
     * represents a total confidence.
     */
    void setDetectedConfidence(final double confidence);

    /**
     * Returns the detected confidence.
     * @return double value representing the confidence factor of the detected language. A value of 1 represents a
     * total confidence.
     */
    double getDetectedConfidence();
}
