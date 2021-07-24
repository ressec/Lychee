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

import lombok.Getter;
import lombok.NonNull;
import org.ressec.lychee.translation.base.operation.ITranslationOperation;
import org.ressec.lychee.translation.base.operation.TranslationOperationStatusType;
import org.ressec.lychee.translation.base.operation.TranslationOperationTranslate;
import org.ressec.lychee.translation.base.operation.TranslationOperationType;

import java.util.*;

/**
 * Concrete implementation of a translation request.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public final class TranslationRequest implements ITranslationRequest
{
    /**
     * List of translation operations.
     */
    @Getter
    private final List<ITranslationOperation> operations = new ArrayList<>();

    /**
     * Request name.
     */
    @Getter
    private final String name;

    /**
     * Source resource bundle.
     */
    private ResourceBundle sourceBundle = null;

    /**
     * Property key.
     */
    private static final String PROPERTY_KEY = "PROPERTY_KEY";

    /**
     * Target properties.
     */
    @Getter
    private Properties targetProperties = new Properties();

    /**
     * Collection of request properties.
     */
    @Getter
    private final Properties properties = new Properties();


    public TranslationRequest()
    {
        this.name = UUID.randomUUID().toString();
    }

    public TranslationRequest(final @NonNull String requestName)
    {
        this.name = requestName;
    }

    public TranslationRequest(final String requestName, final @NonNull String basePackageName, final @NonNull Locale sourceLanguage, final @NonNull Locale targetLanguage)
    {
        this(requestName);

        String key;
        TranslationOperationTranslate operation;

        sourceBundle = ResourceBundle.getBundle(basePackageName, sourceLanguage);
        ResourceBundle targetBundle = ResourceBundle.getBundle(basePackageName, targetLanguage);

        Enumeration<String> enumeration = sourceBundle.getKeys();
        while (enumeration.hasMoreElements())
        {
            key = enumeration.nextElement();
            operation = TranslationOperationTranslate.builder()
                    .withSourceLanguage(sourceLanguage)
                    .withTargetLanguage(targetLanguage)
                    .withText(sourceBundle.getString(key))
                    .withPropertyName(PROPERTY_KEY)
                    .withPropertyValue(key)
                    .build();

            if (!targetBundle.getString(key).isEmpty())
            {
                operation.setStatusType(TranslationOperationStatusType.INVALIDATED); // Do not translate
            }
            operation.setTranslatedText(targetBundle.getString(key));
            addOperation(operation);
        }
    }

    @Override
    public final void clear()
    {
        operations.clear();
    }

    @Override
    public final int getOperationCount()
    {
        return operations.size();
    }

    @Override
    public final int getOperationCount(final TranslationOperationType type)
    {
        return (int) operations.stream()
                .filter(o -> o.getOperationType() == type)
                .count();
    }

    @Override
    public final int getOperationCount(final TranslationOperationType type, final TranslationOperationStatusType status)
    {
        return (int) operations.stream()
                .filter(o -> o.getStatusType() == status && o.getOperationType() == type)
                .count();
    }

    @Override
    public final int getExecutedCount()
    {
        return (int) operations.stream()
                .filter(o -> o.getStatusType() == TranslationOperationStatusType.SUCCESS)
                .count();
    }

    @Override
    public final int getExecutedCount(TranslationOperationType type)
    {
        return (int) operations.stream()
                .filter(o -> o.getOperationType() == type && o.getStatusType() == TranslationOperationStatusType.SUCCESS)
                .count();
    }

    @Override
    public final void addOperation(final @NonNull ITranslationOperation operation)
    {
        operations.add(operation);
    }

//    @Override
//    public final ITranslationOperation find(final @NonNull String key)
//    {
//        for (ITranslationOperation operation : operations)
//        {
//            if (operation.existProperty(key))
//            {
//                return operation;
//            }
//        }
//
//        return null;
//    }

    public final void generateTargetProperties()
    {
        StringBuilder content = new StringBuilder();
        targetProperties = new Properties();
        TranslationOperationTranslate translation;

        if (sourceBundle != null)
        {
            for (ITranslationOperation operation : operations)
            {
                translation = (TranslationOperationTranslate) operation;
                targetProperties.putIfAbsent(translation.getProperty(PROPERTY_KEY), translation.getTranslatedText());
                content.append(translation.getProperty(PROPERTY_KEY)).append("=").append(translation.getTranslatedText()).append(System.lineSeparator());
            }
        }

        System.out.println(content.toString()); // TODO To be replaced
    }

    @Override
    public final long getAverageExecutionTime()
    {
        int count = 0;
        long average = 0;

        for (ITranslationOperation operation : operations)
        {
            if (operation.getExecutionTime() != 0L)
            {
                average += operation.getExecutionTime();
                count += 1;
            }
        }

        return count != 0 ? average / count : 0;
    }

    @Override
    public final long getAverageExecutionTime(final TranslationOperationType type)
    {
        int count = 0;
        long average = 0;

        for (ITranslationOperation operation : operations)
        {
            if (operation.getExecutionTime() != 0L && operation.getOperationType() == type)
            {
                average += operation.getExecutionTime();
                count += 1;
            }
        }

        return count != 0 ? average / count : 0;
    }

    @Override
    public final long getAverageExecutionTime(final TranslationOperationType type, final TranslationOperationStatusType status)
    {
        int count = 0;
        long average = 0;

        for (ITranslationOperation operation : operations)
        {
            if (operation.getExecutionTime() != 0L && operation.getOperationType() == type && operation.getStatusType() == status)
            {
                average += operation.getExecutionTime();
                count += 1;
            }
        }

        return count != 0 ? average / count : 0;
    }

    @Override
    public final long getTotalExecutionTime()
    {
        long total = 0;

        for (ITranslationOperation operation : operations)
        {
            total += operation.getExecutionTime();
        }

        return total;
    }

    @Override
    public final double getAverageConfidence()
    {
        int count = 0;
        double average = 0;

        for (ITranslationOperation operation : operations)
        {
            if (operation.getConfidence() != 0L)
            {
                average += operation.getConfidence();
                count += 1;
            }
        }

        return count != 0 ? average / count : 0;
    }

    @Override
    public final double getAverageConfidence(TranslationOperationType type)
    {
        int count = 0;
        double average = 0;

        for (ITranslationOperation operation : operations)
        {
            if (operation.getConfidence() != 0L && operation.getOperationType() == type)
            {
                average += operation.getConfidence();
                count += 1;
            }
        }

        return count != 0 ? average / count : 0;
    }

    @Override
    public String getSummary()
    {
//        return String.format("Translation Request Summary for (name='%s')%n - processed by          : [%s]%n - total execution time  : [%d] ms%n - # executed entries  : [%d]%n - # total entries       : [%d]%n - average execution time: [%d] ms%n - average confidence     : [%f]%n",
//                this.getName(),
//                this.getApi().name(),
//                this.getTotalExecutionTime(),
//                this.getTranslatedCount(), // TODO Change by getExecutedCount()
//                this.getCount(),
//                this.getAverageExecutionTime(),
//                this.getAverageConfidence());

        return "Summary";
    }

    @Override
    public void addProperty(@NonNull String name, @NonNull String value)
    {
        properties.putIfAbsent(name, value);
    }

    @Override
    public void removeProperty(@NonNull String name)
    {
        properties.remove(name);
    }

    @Override
    public String getProperty(@NonNull String name)
    {
        return properties.getProperty(name);
    }

    @Override
    public int getPropertyCount()
    {
        return properties.size();
    }

    @Override
    public boolean existProperty(@NonNull String name)
    {
        return properties.containsKey(name);
    }

    @Override
    public void clearProperties()
    {
        properties.clear();
    }
}
