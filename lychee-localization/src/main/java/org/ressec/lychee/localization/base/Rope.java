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
package org.ressec.lychee.localization.base;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.translation.base.TranslationException;
import org.ressec.lychee.translation.base.operation.TranslationOperationDetect;
import org.ressec.lychee.translation.base.operation.TranslationOperationTranslate;

import java.io.Serializable;
import java.util.Locale;

/**
 * Provides a concrete implementation of a localizable and/or translatable string.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Log4j2
@EqualsAndHashCode
public final class Rope implements Serializable
{
    /**
     * Underlying string current value.
     */
    @SerializedName("string:value")
    @Getter
    @Setter
    private String value;

    /**
     * Original string value (at construction time and/or while using a setter).
     */
    @SerializedName("string:original")
    @Getter
    private String original;

    /**
     * Resource bundle path and file.
     */
    @SerializedName("string:bundle")
    @Getter
    @EqualsAndHashCode.Exclude
    private String bundle;

    /**
     * Resource bundle key.
     */
    @SerializedName("string:key")
    @Getter
    @EqualsAndHashCode.Exclude
    private String key;

    @Getter
    @Setter
    private transient Object reference;

    @Getter
    @Setter
    private double confidence;

    @Getter
    @Setter
    private transient Locale previousLocalized;

    @Getter
    @Setter
    private transient Locale previousTranslated;

    /**
     * Creates a new instance.
     */
    public Rope()
    {
        this.value = "";
    }

    /**
     * Creates a new localizable and translatable string object.
     * @param bundle Resource bundle file pathname or null if a free text string is to be set.
     * @param key Resource bundle entry key or null if a free text string is to be set.
     * @param value Value to set if a free text string is to be set.
     */
    @Builder(setterPrefix = "with")
    public Rope(final String bundle, final String key, final String value)
    {
        this.bundle = bundle;
        this.key = key;
        this.value = value;

        if (bundle != null)
        {
            ResourceBundleManager.getInstance().load(bundle);

            if (key != null)
            {
                localize();
            }
        }
    }

    /**
     * Creates a translatable but not localizable string given a source text.
     * @param value Value to set.
     * @return {@link Rope}.
     */
    public static Rope valueOf(final @NonNull String value)
    {
        return new Rope(null, null, value);
    }

    /**
     * Creates a localizable and/or translatable string given a resource bundle property key. In this case the resource
     * bundle file should have been already loaded by the {@link ResourceBundleManager}.
     * @param key Resource bundle entry key.
     * @return {@link Rope}.
     */
    public static Rope from(final @NonNull String key)
    {
        return new Rope(null, key, null);
    }

    /**
     * Creates a localizable and/or translatable string given a resource bundle and a property key.
     * @param bundle Resource bundle file.
     * @param key Resource bundle entry key.
     * @return {@link Rope}.
     */
    public static Rope from(final @NonNull String bundle, final @NonNull String key)
    {
        return new Rope(bundle, key, null);
    }

    /**
     * Localizes the underlying text using the current {@link ResourceBundleManager} locale.
     */
    public final void localize()
    {
        Locale current = ResourceBundleManager.getInstance().getLocale();
        if (previousLocalized == null || !previousLocalized.equals(current))
        {
            ResourceBundleManager.getInstance().resolveRope(this, reference, current);
        }

        previousLocalized = current;
    }

    /**
     * Localizes the underlying text given a locale.
     * @param locale Locale.
     */
    public final void localize(final @NonNull Locale locale)
    {
        if (previousLocalized == null || !previousLocalized.equals(locale))
        {
            ResourceBundleManager.getInstance().resolveRope(this, reference, locale);
        }

        previousLocalized = locale;
    }

    /**
     * Translates a string from the given source language to the given target language using the free Google
     * translation API.
     * <hr>
     * Be careful: As this process involves a call to a remote REST API service to translate the given text, it's a
     * quite long process that could introduce latency in your application!
     * @param source Source locale (language).
     * @param target Target locale (language).
     * @throws TranslationException Thrown to indicate that an error occurred during a translation.
     */
    public final void translate(final @NonNull Locale source, final @NonNull Locale target) throws TranslationException
    {
        if (previousTranslated == null || !previousTranslated.toLanguageTag().equals(target.toLanguageTag()))
        {
            if (original == null)
            {
                original = value;
            }

            TranslationOperationTranslate operation = ResourceBundleManager.getInstance().translate(source, target, value);
            previousTranslated = target;
            value = operation.getTranslatedText();
            confidence = operation.getConfidence();

            log.debug(String.format("Text translated from source(tag=%s, language=%s, text='%s') to target(tag=%s, language=%s, text='%s')",
                    source,
                    source.getDisplayLanguage(Locale.ENGLISH),
                    original,
                    target,
                    target.getDisplayLanguage(Locale.ENGLISH),
                    value));
        }
    }

    /**
     * Detects the language associated to the underlying text.
     * @return Locale representing the detected language.
     * @throws TranslationException Thrown in case an error occurred while trying to detect the language.
     */
    public final Locale detect() throws TranslationException
    {
        TranslationOperationDetect operation = ResourceBundleManager.getInstance().detect(value);
        this.confidence = operation.getDetectedConfidence();

        return operation.getDetectedLanguage();
    }
}
