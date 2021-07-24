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
package org.ressec.lychee.localization.type.geography;

import com.google.gson.annotations.SerializedName;
import lombok.NonNull;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.calendar.DayType;

import java.util.Locale;

/**
 * A localized enumeration providing the available values of the different available cardinal direction types.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public enum DirectionType
{
    /**
     * North.
     */
    @SerializedName("North")
    NORTH,

    /**
     * South.
     */
    @SerializedName("South")
    SOUTH,

    /**
     * Eastern.
     */
    @SerializedName("East")
    EAST,

    /**
     * Western.
     */
    @SerializedName("West")
    WEST,

    /**
     * North East.
     */
    @SerializedName("North East")
    NORTH_EAST,

    /**
     * North West.
     */
    @SerializedName("North West")
    NORTH_WEST,

    /**
     * South East.
     */
    @SerializedName("South East")
    SOUTH_EAST,

    /**
     * South est.
     */
    @SerializedName("South West")
    SOUTH_WEST,

    /**
     * Central.
     */
    @SerializedName("Central")
    CENTRAL;

    /**
     * Represents the resource bundle pathname.
     */
    private static final String BUNDLE_NAME = "i18n/direction";

    /**
     * Represents the generic path to access the term 'definition' property.
     */
    private static final String BUNDLE_PATH_FOR_TERM_DEFINITION = "direction.definition";

    /**
     * Represents the generic path to access the 'name' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_NAME = "direction.${this}.name";

    /**
     * Represents the generic path to access the 'description' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION = "direction.${this}.description";

    /**
     * Returns the localized term definition for a direction in the current locale.
     * @return Term definition of a direction.
     */
    public static String getTermDefinition()
    {
        return getTermDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized term definition for a direction in the given locale.
     * @param locale Locale to use.
     * @return Term definition of a direction.
     */
    @Localize(bundle = "i18n/direction", key = "direction.definition")
    public static String getTermDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(DayType.class, locale);
    }

    /**
     * Returns the localized name of the direction in the current locale.
     * @return Localized name of the direction.
     */
    public final String getName()
    {
        return getName(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized name of the direction in the given locale.
     * @param locale Locale to use.
     * @return Name of the direction.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_NAME)
    public final String getName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized description of the direction in the current locale.
     * @return Description of the direction.
     */
    public final String getDescription()
    {
        return getDescription(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized description of the direction in the given locale.
     * @param locale Locale to use.
     * @return Description of the direction.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION)
    public final String getDescription(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }
}
