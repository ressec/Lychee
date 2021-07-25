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
import org.ressec.lychee.translation.base.TranslationApiVersionType;

import java.util.Locale;

/**
 * Provides the basic behavior of a translation operation.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public interface ITranslationOperation
{
    /**
     * Returns the translation operation type.
     * @return Translation operation type.
     */
    TranslationOperationType getOperationType();

    /**
     * Returns the source language.
     * @return Source language.
     */
    Locale getSourceLanguage();

    /**
     * Returns the target language.
     * @return Target language.
     */
    Locale getTargetLanguage();

    /**
     * Returns the text to detect and/or translate.
     * @return Source text.
     */
    String getText();

    /**
     * Sets the execution time for this operation.
     * @param time Execution time expressed in milliseconds.
     */
    void setExecutionTime(final long time);

    /**
     * Returns the execution time took for this operation.
     * @return Execution time expressed in milliseconds.
     */
    long getExecutionTime();

    /**
     * Sets the reason message why a translation operation has failed or has been invalidated.
     * @param message Reason message.
     */
    void setReason(final String message);

    /**
     * Returns the reason why a translation operation has failed or has been invalidated.
     * @return Reason message.
     */
    String getReason();

    /**
     * Returns the translation api version engine this operation has been processed by.
     * @return Translation API engine version.
     */
    TranslationApiVersionType getApiVersion();

    /**
     * Sets the translation API version to use to execute this translation operation.
     * @param api Translation API version.
     */
    void setApiVersion(final TranslationApiVersionType api);

    /**
     * Returns the translation operation status.
     * @return Translation operation status.
     */
    TranslationOperationStatusType getStatusType();

    /**
     * Sets the translation operation status.
     * @param status Translation operation status to set.
     */
    void setStatusType(final TranslationOperationStatusType status);

    /**
     * Sets the confidence ration for this translation operation.
     * @param confidence Confidence between 0 and 1 (1 means full confidence).
     */
    void setConfidence(final double confidence);

    /**
     * Returns the confidence ration for this translation operation.
     * @return Confidence between 0 and 1 (1 means full confidence).
     */
    double getConfidence();

    /**
     * Adds a property.
     * @param name Property name.
     * @param value Property value.
     */
    void addProperty(final @NonNull String name, final @NonNull String value);

    /**
     * Removes a property given its name.
     * @param name Property name.
     * @return Removed property.
     */
    Object removeProperty(final @NonNull String name);

    /**
     * returns a property value given its name.
     * @param name Property name.
     * @return Property value if found, null otherwise.
     */
    String getProperty(final @NonNull String name);

    /**
     * Checks if the given property key exist.
     * @param name Property name.
     * @return True if the given property name exist, false otherwise.
     */
    boolean existProperty(final @NonNull String name);

    /**
     * Clears the properties.
     */
    void clearProperties();
}

