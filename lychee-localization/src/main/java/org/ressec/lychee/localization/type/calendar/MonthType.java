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

import java.io.Serializable;
import java.util.Locale;

/**
 * A localized enumeration representing the months of the year.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 * @see Localize
 */
public enum MonthType implements Serializable
{
    /**
     * January.
     */
    @SerializedName("January")
    JANUARY,

    /**
     * February.
     */
    @SerializedName("February")
    FEBRUARY,

    /**
     * March.
     */
    @SerializedName("March")
    MARCH,

    /**
     * April.
     */
    @SerializedName("April")
    APRIL,

    /**
     * May.
     */
    @SerializedName("May")
    MAY,

    /**
     * June.
     */
    @SerializedName("June")
    JUNE,

    /**
     * July.
     */
    @SerializedName("July")
    JULY,

    /**
     * August.
     */
    @SerializedName("August")
    AUGUST,

    /**
     * September.
     */
    @SerializedName("September")
    SEPTEMBER,

    /**
     * October.
     */
    @SerializedName("October")
    OCTOBER,

    /**
     * November.
     */
    @SerializedName("November")
    NOVEMBER,

    /**
     * December.
     */
    @SerializedName("December")
    DECEMBER;

    /**
     * Represents the resource bundle pathname.
     */
    private static final String BUNDLE_NAME = "i18n/month";

    /**
     * Represents the generic path to access the term 'definition' property.
     */
    private static final String BUNDLE_PATH_FOR_TERM_DEFINITION = "month.definition";

    /**
     * Represents the generic path to access the 'name' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_NAME = "month.${this}.name";

    /**
     * Represents the generic path to access the 'description' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION = "month.${this}.description";

    /**
     * Returns the localized definition of a month in the current locale.
     * @return Definition of a month.
     */
    public static String getTermDefinition()
    {
        return getTermDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the definition of the term {@code month} in the given locale.
     * @param locale Locale to use.
     * @return Definition of the term {@code month}.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_TERM_DEFINITION)
    public static String getTermDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(DayType.class, locale);
    }

    /**
     * Returns the name of the month in the current locale.
     * @return Name of the month.
     */
    public final String getName()
    {
        return getName(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the name of the month in the given locale.
     * @param locale Locale to use.
     * @return Name of the month.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_NAME)
    public final String getName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the description of the month in the current locale.
     * @return Description of the month.
     */
    public final String getDescription()
    {
        return getDescription(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized description of the month in the given locale.
     * @param locale Locale to use.
     * @return Description of the month.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION)
    public final String getDescription(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }
}
