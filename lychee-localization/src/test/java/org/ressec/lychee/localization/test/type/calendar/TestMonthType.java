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
package org.ressec.lychee.localization.test.type.calendar;

import org.junit.jupiter.api.*;
import org.ressec.avocado.core.junit.BaseUnitTest;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.calendar.DayType;
import org.ressec.lychee.localization.type.calendar.MonthType;

import java.util.Locale;

/**
 * A class for unit testing the {@link MonthType} localized enumeration.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("i18n")
@Tag("i18n.calendar")
@Tag("i18n.calendar.month")
final class TestMonthType extends BaseUnitTest
{
    @BeforeEach
    protected void setUpBeforeEach()
    {
        super.setUpBeforeEach();

        ResourceBundleManager.getInstance().setDefaultLocale(Locale.ENGLISH);
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
    }

    @Test
    @DisplayName("Should retrieve the month term definition using a given locale")
    final void shouldRetrieveMonthTermDefinitionUsingGivenLocale()
    {
        Assertions.assertTrue(
                MonthType.getTermDefinition(Locale.FRENCH)
                        .startsWith("Un mois est une unité de temps, utilisée avec les calendriers, qui est approximativement"));
    }

    @Test
    @DisplayName("Should retrieve the month name using the current locale")
    final void shouldRetrieveMonthNameUsingCurrentLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Assertions.assertEquals(
                "Février",
                MonthType.FEBRUARY.getName());
    }

    @Test
    @DisplayName("Should retrieve the month name given a specific locale")
    final void shouldRetrieveMonthNameUsingGivenLocale()
    {
        Assertions.assertEquals(
                "Donnerstag",
                DayType.THURSDAY.getName(Locale.GERMAN));
    }

    @Test
    @DisplayName("Should retrieve the month name using the default locale")
    final void shouldRetrieveMonthNameUsingDefaultLocale()
    {
        Assertions.assertEquals("Wednesday",
                DayType.WEDNESDAY.getName());
    }

    @Test
    @DisplayName("Should retrieve the month description using the default locale")
    final void shouldRetrieveMonthDefinitionUsingDefaultLocale()
    {
        Assertions.assertTrue(
                DayType.THURSDAY.getDescription().startsWith("Thursday is the day of the week between Wednesday and Friday. According to the ISO 8601 international standard,"));
    }

    @Test
    @DisplayName("Should retrieve the month name using the current locale when the given locale is not available")
    final void shouldRetrieveMonthNameUsingCurrentLocaleWhenGivenLocaleIsNotAvailable()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("es"));

        Assertions.assertEquals(
                "Domingo",
                DayType.SUNDAY.getName(Locale.forLanguageTag("xh"))); // Xhosa language
    }

    @Test
    @DisplayName("Should retrieve the month name using the current locale when the given locale does not exist")
    final void shouldRetrieveMonthNameUsingCurrentLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.GERMAN);

        Assertions.assertEquals(
                "Montag",
                DayType.MONDAY.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the month name using the default locale when the given locale does not exist")
    final void shouldRetrieveMonthNameUsingDefaultLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Sunday",
                DayType.SUNDAY.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the month name using the default locale when the current locale and the given locale do not exist")
    final void shouldRetrieveMonthNameUsingDefaultLocaleWhenCurrentLocaleAndGivenLocaleDoNotExist()
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.FRENCH);
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Mercredi",
                DayType.WEDNESDAY.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using a latin alphabet")
    final void shouldRetrieveMonthNameUsingLatinAlphabet()
    {
        Assertions.assertEquals("Gennaio",MonthType.JANUARY.getName(Locale.ITALIAN));
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using an arabic alphabet")
    final void shouldRetrieveMonthNameUsingArabicAlphabet()
    {
        Assertions.assertEquals("مارس",MonthType.MARCH.getName(Locale.forLanguageTag("ar")));
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using a cyrillic alphabet")
    final void shouldRetrieveMonthNameUsingCyrillicAlphabet()
    {
        Assertions.assertEquals("Март",MonthType.MARCH.getName(Locale.forLanguageTag("ru")));
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using a greek alphabet")
    final void shouldRetrieveMonthNameUsingGreekAlphabet()
    {
        Assertions.assertEquals("Μάρτιος",MonthType.MARCH.getName(Locale.forLanguageTag("el")));
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using a hindi alphabet")
    final void shouldRetrieveMonthNameUsingHindiAlphabet()
    {
        Assertions.assertEquals("जुलूस",MonthType.MARCH.getName(Locale.forLanguageTag("hi")));
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using a hebrew alphabet")
    final void shouldRetrieveMonthNameUsingHebrewAlphabet()
    {
        Assertions.assertEquals("מרץ",MonthType.MARCH.getName(Locale.forLanguageTag("iw")));
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using a japanese alphabet")
    final void shouldRetrieveMonthNameUsingJapaneseAlphabet()
    {
        Assertions.assertEquals("行進",MonthType.MARCH.getName(Locale.forLanguageTag("ja")));
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using a chinese alphabet")
    final void shouldRetrieveMonthNameUsingChineseAlphabet()
    {
        Assertions.assertEquals("游行",MonthType.MARCH.getName(Locale.forLanguageTag("zh")));
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using a korean alphabet")
    final void shouldRetrieveMonthNameUsingKoreanAlphabet()
    {
        Assertions.assertEquals("행진",MonthType.MARCH.getName(Locale.forLanguageTag("ko")));
    }

    @Test
    @DisplayName("Should be able to retrieve the month name using a thaï alphabet")
    final void shouldRetrieveMonthNameUsingThaiAlphabet()
    {
        Assertions.assertEquals("มีนาคม",MonthType.MARCH.getName(Locale.forLanguageTag("th")));
    }
}