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
package org.ressec.lychee.translation.base.request;

import lombok.NonNull;
import org.ressec.lychee.translation.base.operation.ITranslationOperation;
import org.ressec.lychee.translation.base.operation.TranslationOperationStatusType;
import org.ressec.lychee.translation.base.operation.TranslationOperationType;

import java.util.List;
import java.util.Properties;

/**
 * Provides the basic behavior of a translation request.
 * <br>
 * A translation request contains a collection of translation operations.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 * see {@link ITranslationOperation}
 */
public interface ITranslationRequest
{
    /**
     * Returns the list of translation operations contained in the request.
     * @return List of translation operations.
     */
    List<ITranslationOperation> getOperations();

    /**
     * Returns the name of the translation request.
     * @return Translation request name.
     */
    String getName();

    /**
     * Clears the translation operations contained in the translation request.
     */
    void clear();

    /**
     * Returns the number of translation operations.
     * @return Number of translation operations.
     */
    int getOperationCount();

    /**
     * Returns the number of translation operation of the given type.
     * @param type Translation operation type.
     * @return Number of translation operations.
     */
    int getOperationCount(final TranslationOperationType type);

    /**
     * Returns the number of translation operation of the given type.
     * @param type Translation operation type.
     * @param status Translation operation status type.
     * @return Number of translation operations.
     */
    int getOperationCount(final TranslationOperationType type, final TranslationOperationStatusType status);

    /**
     * Returns the number of executed translation operations.
     * @return Number of executed translation operations.
     */
    int getExecutedCount();

    /**
     * Returns the number of executed translation operations for the given type.
     * @param type Translation operation type.
     * @return Number of executed translation operations.
     */
    int getExecutedCount(final TranslationOperationType type);

    /**
     * Adds a translation operation to the translation request.
     * @param operation Translation operation to add.
     */
    void addOperation(final @NonNull ITranslationOperation operation);

    /**
     * Returns the target properties.
     * @return Properties.
     */
    Properties getTargetProperties();

    /**
     * Returns the average execution time of all executed operations.
     * @return Average execution time expressed in milliseconds.
     */
    long getAverageExecutionTime();

    /**
     * Returns the average execution time of all executed operations for the given operation type.
     * @param type Translation operation type.
     * @return Average execution time expressed in milliseconds.
     */
    long getAverageExecutionTime(final TranslationOperationType type);

    /**
     * Returns the average execution time of all executed operations for the given operation type.
     * @param type Translation operation type.
     * @param status Translation operation status type.
     * @return Average execution time expressed in milliseconds.
     */
    long getAverageExecutionTime(final TranslationOperationType type, final TranslationOperationStatusType status);

    /**
     * Returns the total execution time of all executed operations.
     * @return Total execution time expressed in milliseconds.
     */
    long getTotalExecutionTime();

    /**
     * Returns the average confidence of all executed operations.
     * @return Average confidence (number between 0 and 1).
     */
    double getAverageConfidence();

    /**
     * Returns the average confidence of all executed operations for the given operation type.
     * @param type Translation operation type.
     * @return Average confidence (number between 0 and 1).
     */
    double getAverageConfidence(final TranslationOperationType type);

    /**
     * Returns a summary of the request execution.
     * @return Summary.
     */
    String getSummary();

    /**
     * Adds a property.
     * @param name Property name.
     * @param value Property value.
     */
    void addProperty(final @NonNull String name, final @NonNull String value);

    /**
     * Removes a property.
     * @param name Property name.
     */
    void removeProperty(final @NonNull String name);

    /**
     * Returns a property value given its name.
     * @param name Property name.
     * @return Property value if found, null otherwise.
     */
    String getProperty(final @NonNull String name);

    /**
     * Returns the number of request properties.
     * @return Number of properties for this translation request.
     */
    int getPropertyCount();

    /**
     * Checks if the given property key exist.
     * @param name Property name.
     * @return True if the given property name exist, false otherwise.
     */
    boolean existProperty(final @NonNull String name);

    /**
     * Clears the request properties.
     */
    void clearProperties();
}
