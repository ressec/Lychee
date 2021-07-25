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
import org.ressec.avocado.core.exception.unchecked.EnumerationException;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.geography.HemisphereType;

import java.time.LocalDate;
import java.util.Locale;

/**
 * A localized enumeration representing the available seasons of the year.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public enum SeasonType
{
    /**
     * Spring.
     */
    @SerializedName("Spring")
    SPRING,

    /**
     * Summer.
     */
    @SerializedName("Summer")
    SUMMER,

    /**
     * Autumn.
     */
    @SerializedName("Autumn")
    AUTUMN,

    /**
     * Winter.
     */
    @SerializedName("Winter")
    WINTER;

    /**
     * Represents the resource bundle pathname.
     */
    private static final String BUNDLE_NAME = "i18n/season";

    /**
     * Represents the generic path to access the term 'definition' property.
     */
    private static final String BUNDLE_PATH_FOR_TERM_DEFINITION = "season.definition";

    /**
     * Represents the generic path to access the 'name' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_NAME = "season.${this}.name";

    /**
     * Represents the generic path to access the 'description' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION = "season.${this}.description";

    /**
     * Returns the season start date for the current year and the given hemisphere.
     * @param type Hemisphere type.
     * @return Season start date.
     * @see HemisphereType
     */
    public LocalDate getStartDate(final HemisphereType type)
    {
        LocalDate today = LocalDate.now();

        switch (this)
        {
            case AUTUMN:
                return type == HemisphereType.NORTH ?
                        LocalDate.of(today.getYear(), 9, 1) :
                        LocalDate.of(today.getYear(), 3, 1);
            case WINTER:
                return type == HemisphereType.NORTH ?
                        LocalDate.of(today.getYear(), 12, 1) :
                        LocalDate.of(today.getYear(), 6, 1);
            case SPRING:
                return type == HemisphereType.NORTH ?
                        LocalDate.of(today.getYear(), 3, 1) :
                        LocalDate.of(today.getYear(), 9, 1);
            case SUMMER:
                return type == HemisphereType.NORTH ?
                        LocalDate.of(today.getYear(), 6, 1) :
                        LocalDate.of(today.getYear(), 12, 1);
        }

        throw new EnumerationException(
                String.format(
                        "Cannot provide season start date for season: '%s and hemisphere: '%s'",
                        this,
                        type.name()));
    }

    /**
     * Returns the season end date for the current year and the given hemisphere.
     * @param type Hemisphere type.
     * @return Season end date.
     * @see HemisphereType
     */
    public LocalDate getEndDate(final HemisphereType type)
    {
        LocalDate today = LocalDate.now();

        switch (this)
        {
            case AUTUMN:
                return type == HemisphereType.NORTH ?
                        LocalDate.of(today.getYear(), 11, 30) :
                        LocalDate.of(today.getYear(), 5, 31);
            case WINTER:
                return type == HemisphereType.NORTH ?
                        LocalDate.of(today.getYear(), 2, 28) : // TODO 29th for leap year.
                        LocalDate.of(today.getYear(), 8, 31);
            case SPRING:
                return type == HemisphereType.NORTH ?
                        LocalDate.of(today.getYear(), 5, 31) :
                        LocalDate.of(today.getYear(), 11, 30);
            case SUMMER:
                return type == HemisphereType.NORTH ?
                        LocalDate.of(today.getYear(), 8, 31) :
                        LocalDate.of(today.getYear(), 2, 28); // TODO 29th for leap year.
        }

        throw new EnumerationException(
                String.format(
                        "Cannot provide season end date for season: '%s and hemisphere: '%s'",
                        this,
                        type.name()));
    }

    /**
     * Returns the localized definition of a season in the current locale.
     * @return Definition of a season.
     */
    public static String getTermDefinition()
    {
        return getTermDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized definition of a season in the given locale.
     * @param locale Locale to use.
     * @return Definition of a season.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_TERM_DEFINITION)
    public static String getTermDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(DayType.class, locale);
    }

    /**
     * Returns the localized name of the season in the current locale.
     * @return Name of the season.
     */
    public final String getName()
    {
        return getName(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized name of the season in the given locale.
     * @param locale Locale to use.
     * @return Name of the season.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_NAME)
    public final String getName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized description of the season in the current locale.
     * @return Description of the season.
     */
    public final String getDescription()
    {
        return getDescription(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized description of the season in the given locale.
     * @param locale Locale to use.
     * @return Description of the season.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION)
    public final String getDescription(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }
}
