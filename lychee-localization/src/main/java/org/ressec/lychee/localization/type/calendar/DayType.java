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
package org.ressec.lychee.localization.type.calendar;

import com.google.gson.annotations.SerializedName;
import lombok.NonNull;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;

import java.util.Locale;

/**
 * A localized enumeration representing the days of a week.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 * @see Localize
 * @see ResourceBundleManager
 */
public enum DayType
{
    /**
     * Monday.
     */
    @SerializedName("Monday")
    MONDAY,

    /**
     * Tuesday.
     */
    @SerializedName("Tuesday")
    TUESDAY,

    /**
     * Wednesday.
     */
    @SerializedName("Wednesday")
    WEDNESDAY,

    /**
     * Thursday.
     */
    @SerializedName("Thursday")
    THURSDAY,

    /**
     * Friday.
     */
    @SerializedName("Friday")
    FRIDAY,

    /**
     * Saturday.
     */
    @SerializedName("Saturday")
    SATURDAY,

    /**
     * Sunday.
     */
    @SerializedName("Sunday")
    SUNDAY;

    /**
     * Represents the resource bundle pathname.
     */
    private static final String BUNDLE_NAME = "i18n/day";

    /**
     * Represents the generic path to access the term 'definition' property.
     */
    private static final String BUNDLE_PATH_FOR_TERM_DEFINITION = "day.definition";

    /**
     * Represents the generic path to access the 'name' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_NAME = "day.${this}.name";

    /**
     * Represents the generic path to access the 'description' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION = "day.${this}.description";

    /**
     * Returns the localized definition of a day in the current locale.
     * @return Definition of a day.
     */
    public static String getTermDefinition()
    {
        return getTermDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized definition of a day in the given locale.
     * @param locale Locale to use.
     * @return Definition of a day.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_TERM_DEFINITION)
    public static String getTermDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(DayType.class, locale);
    }

    /**
     * Returns the localized name of the day in the current locale.
     * @return Localized name of the day.
     */
    public final String getName()
    {
        return getName(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized name of the day in the given locale.
     * @param locale Locale to use.
     * @return Localized name of the day.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_NAME)
    public final String getName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized description of the day in the current locale.
     * @return Localized description of the day.
     */
    public final String getDescription()
    {
        return getDescription(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized description of the day in the given locale.
     * @param locale Locale to use.
     * @return Localized description of the day.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION)
    public final String getDescription(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }
}
