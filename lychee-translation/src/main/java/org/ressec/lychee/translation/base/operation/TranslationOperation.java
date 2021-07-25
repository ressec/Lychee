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

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.ressec.lychee.translation.base.TranslationApiVersionType;

import java.util.Locale;
import java.util.Properties;

/**
 * Concrete implementation of a translation operation.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public abstract class TranslationOperation implements ITranslationOperation
{
    /**
     * Translation operation type.
     */
    @Getter
    private final TranslationOperationType operationType;

    /**
     * Translation operation status type.
     */
    @Getter
    @Setter
    private TranslationOperationStatusType statusType;

    /**
     * Source language.
     */
    @Getter
    private final Locale sourceLanguage;

    /**
     * Target language.
     */
    @Getter
    private final Locale targetLanguage;

    /**
     * Text to translate.
     */
    @Getter
    private final String text;

    /**
     * Failure or invalidation reason message.
     */
    @Getter
    @Setter
    private String reason;

    /**
     * Collection of properties.
     */
    @Getter
    private final Properties properties = new Properties();

    /**
     * Operation execution time.
     */
    @Getter
    @Setter
    private long executionTime = 0L;

    /**
     * Translation API version.
     */
    @Getter
    @Setter
    private TranslationApiVersionType apiVersion;

    /**
     * Confidence ratio.
     */
    @Getter
    @Setter
    private double confidence = 1.0d;

    public TranslationOperation(final @NonNull TranslationOperationType operationType, final Locale sourceLanguage,
                                final Locale targetLanguage, final String text, final String propertyName, final String propertyKey)
    {
        this.operationType = operationType;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.text = text;
        this.statusType = TranslationOperationStatusType.CREATED;

        if (propertyName != null)
        {
            properties.put(propertyName, propertyKey);
        }
    }

    @Override
    public final void addProperty(@NonNull String name, @NonNull String value)
    {
        properties.putIfAbsent(name, value);
    }

    @Override
    public final String getProperty(@NonNull String name)
    {
        return (String) properties.get(name);
    }

    @Override
    public final boolean existProperty(@NonNull String name)
    {
        return properties.containsKey(name);
    }

    @Override
    public final Object removeProperty(@NonNull String name)
    {
        return properties.remove(name);
    }

    @Override
    public final void clearProperties()
    {
        properties.clear();
    }
}
