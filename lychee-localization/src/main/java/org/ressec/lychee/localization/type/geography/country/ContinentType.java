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
package org.ressec.lychee.localization.type.geography.country;

import com.google.gson.annotations.SerializedName;
import lombok.NonNull;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.calendar.DayType;

import java.util.Locale;

/**
 * An internationalized enumeration representing the continents of the world.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 * @see Localize
 */
public enum ContinentType
{
    /**
     * Africa.
     */
    @SerializedName("AFRICA")
    AFRICA,

    /**
     * North America.
     */
    @SerializedName("AMERICA_NORTH")
    AMERICA_NORTH,

    /**
     * South America.
     */
    @SerializedName("AMERICA_SOUTH")
    AMERICA_SOUTH,

    /**
     * Antarctica.
     */
    @SerializedName("ANTARCTICA")
    ANTARCTICA,

    /**
     * Asia.
     */
    @SerializedName("ASIA")
    ASIA,

    /**
     * Europe.
     */
    @SerializedName("EUROPE")
    EUROPE,

    /**
     * Oceania.
     */
    @SerializedName("OCEANIA")
    OCEANIA;

    /**
     * Represents the resource bundle pathname.
     */
    private static final String BUNDLE_NAME = "i18n/continent";

    /**
     * Represents the generic path to access the term 'definition' property.
     */
    private static final String BUNDLE_PATH_FOR_TERM_DEFINITION = "continent.definition";

    /**
     * Represents the generic path to access the 'name' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_NAME = "continent.${this}.name";

    /**
     * Represents the generic path to access the 'description' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION = "continent.${this}.description";

    /**
     * Returns the localized term definition for a continent in the current locale.
     * @return Term definition of a continent.
     */
    public static String getTermDefinition()
    {
        return getTermDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized term definition for a continent in the given locale.
     * @param locale Locale to use.
     * @return Term definition of a continent.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_TERM_DEFINITION)
    public static String getTermDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(DayType.class, locale);
    }

    /**
     * Returns the localized name of the continent in the current locale.
     * @return Localized name of continent according to the current locale.
     */
    public final String getName()
    {
        return getName(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized name of the continent in the given locale.
     * @param locale Locale to use.
     * @return Localized name of the continent in the given locale.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_NAME)
    public final String getName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized definition of the continent in the current locale.
     * @return Localized definition of the continent in the current locale.
     */
    public final String getDefinition()
    {
        return getDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized definition of the continent in the given locale.
     * @param locale Locale to use.
     * @return Localized definition of the continent in the given locale.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION)
    public final String getDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }
}
