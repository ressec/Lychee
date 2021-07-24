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
package org.ressec.lychee.localization.test.localizable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.ressec.lychee.localization.base.Localizable;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.base.Rope;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.calendar.DayType;
import org.ressec.lychee.localization.type.calendar.MonthType;

import java.util.Locale;

// day.LOWERCASE(${day}).name
// LOWER, UPPER, CAPITALIZE, CAPFIRST, CAPFIRSTALL
public class LocalizableObject implements Localizable
{
    @Getter
    @Setter
    private DayType day; // Variable used for the day name localization in the I18n annotation

    @Getter
    @Setter
    private MonthType month; // Variable used for the month name localization in the I18n annotation

    // No setter as its computed internally!
    // This field should be annotated with a Localization annotation with: @I18n(bundle = "i18n/test", key = "test.core.extension.iso.time.series.name")
    private String testNameKey;

    // No setter as its computed internally!
    @Localize(bundle = "i18n/day", key = "day.${day}.name")
    private String dayName;

    // No setter as its computed internally!
    @Localize(bundle = "i18n/month", key = "month.${month}.name")
    private String monthName;

    // No setter as its computed internally!
    @Getter
    @Localize(bundle = "i18n/month", key = "month.${month}.name")
    private final Rope stringMonthName;

    @Getter
    private final Rope stringDayName;

    private Locale previous;

    public LocalizableObject(final DayType day, final MonthType month, final Rope i18nDay, final Rope i18nMonth)
    {
        this.day = day;
        this.month = month;
        this.stringDayName = i18nDay;
        this.stringMonthName = i18nMonth;

        previous = localize();
    }

    @Localize(bundle = "i18n/day", key = "day.SUNDAY.name")
    public String getSundayName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized name of the test key name according to the current locale.
     * @return Localized value of the test key 'test.core.extension.iso.time.series.name'.
     */
    @Localize(bundle = "i18n/test", key = "test.core.extension.iso.time.series.name")
    public final String getTestName()
    {
        return testNameKey;
    }

    /**
     * Returns the localized name of the day according to the current locale.
     * @return Name of the day.
     */
    public final String getDayName()
    {
        return dayName;
    }

    /**
     * Returns the localized name of the day according to the given locale.
     * @param locale Locale to use.
     * @return Name of the day.
     */
    public final String getDayName(final @NonNull Locale locale)
    {
        previous = localize(locale, previous);
        return dayName;
    }

    /**
     * Returns the localized name of the month according to the current locale.
     * @return Name of the month.
     */
    public final String getMonthName()
    {
        return monthName;
    }

    /**
     * Returns the localized name of the month according to the given locale.
     * @param locale Locale to use.
     * @return Name of the month.
     */
    public final String getMonthName(final @NonNull Locale locale)
    {
        previous = localize(locale, previous);
        return monthName;
    }
}
