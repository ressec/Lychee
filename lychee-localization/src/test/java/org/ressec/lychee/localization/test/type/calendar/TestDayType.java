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

import java.util.Locale;

/**
 * A class for unit testing the {@link DayType} localized enumeration.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("i18n")
@Tag("i18n.calendar")
@Tag("i18n.calendar.day")
final class TestDayType extends BaseUnitTest
{
    @BeforeEach
    protected void setUpBeforeEach()
    {
        super.setUpBeforeEach();

        ResourceBundleManager.getInstance().setDefaultLocale(Locale.ENGLISH);
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
    }

    @Test
    @DisplayName("Should retrieve the day term definition using a given locale")
    final void shouldRetrieveDayTermDefinitionUsingGivenLocale()
    {
        Assertions.assertTrue(
                DayType.getTermDefinition(Locale.FRENCH)
                        .startsWith("Un jour est approximativement la période pendant laquelle la Terre effectue une rotation autour de son axe, ce qui prend environ 24 heures."));
    }

    @Test
    @DisplayName("Should retrieve the day name using the current locale")
    final void shouldRetrieveDayNameUsingCurrentLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Assertions.assertEquals(
                "Lundi",
                DayType.MONDAY.getName());
    }

    @Test
    @DisplayName("Should retrieve the day name given a specific locale")
    final void shouldRetrieveDayNameUsingGivenLocale()
    {
        Assertions.assertEquals(
                "Donnerstag",
                DayType.THURSDAY.getName(Locale.GERMAN));
    }

    @Test
    @DisplayName("Should retrieve the day name using the default locale")
    final void shouldRetrieveDayNameUsingDefaultLocale()
    {
        Assertions.assertEquals("Wednesday",
                DayType.WEDNESDAY.getName());
    }

    @Test
    @DisplayName("Should retrieve the day description using the default locale")
    final void shouldRetrieveDayDefinitionUsingDefaultLocale()
    {
        Assertions.assertTrue(
                DayType.THURSDAY.getDescription().startsWith("Thursday is the day of the week between Wednesday and Friday. According to the ISO 8601 international standard,"));
    }

    @Test
    @DisplayName("Should retrieve the day name using the current locale when the given locale is not available")
    final void shouldRetrieveDayNameUsingCurrentLocaleWhenGivenLocaleIsNotAvailable()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("es"));

        Assertions.assertEquals(
                "Domingo",
                DayType.SUNDAY.getName(Locale.forLanguageTag("xh"))); // Xhosa language
    }

    @Test
    @DisplayName("Should retrieve the day name using the current locale when the given locale does not exist")
    final void shouldRetrieveDayNameUsingCurrentLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.GERMAN);

        Assertions.assertEquals(
                "Montag",
                DayType.MONDAY.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the day name using the default locale when the given locale does not exist")
    final void shouldRetrieveDayNameUsingDefaultLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Sunday",
                DayType.SUNDAY.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the day name using the default locale when the current locale and the given locale do not exist")
    final void shouldRetrieveDayNameUsingDefaultLocaleWhenCurrentLocaleAndGivenLocaleDoNotExist()
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.FRENCH);
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Mercredi",
                DayType.WEDNESDAY.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

//    /**
//     * This test should retrieve the day name in several languages.
//     */
//    @ParameterizedTest
//    @DisplayName("Should retrieve the day name in several languages")
//    @CsvSource(value = {
//            "monday:fr:lundi", "monday:it:lunedi", "monday:en:monday", "monday:de:montag", "monday:es:lunes",
//            "tuesday:fr:mardi", "tuesday:it:martedi", "tuesday:en:tuesday", "tuesday:de:dienstag", "tuesday:es:martes",
//            "wednesday:fr:mercredi", "wednesday:it:mercoledi", "wednesday:en:wednesday", "wednesday:de:mittwoch", "wednesday:es:miércoles",
//            "thursday:fr:jeudi", "thursday:it:giovedi", "thursday:en:thursday", "thursday:de:donnerstag", "thursday:es:jueves",
//            "friday:fr:vendredi", "friday:it:venerdi", "friday:en:friday", "friday:de:freitag", "friday:es:viernes",
//            "saturday:fr:samedi", "saturday:it:sabato", "saturday:en:saturday", "saturday:de:samstag", "saturday:es:sábado",
//            "sunday:fr:dimanche", "sunday:it:domenica", "sunday:en:sunday", "sunday:de:sonntag", "sunday:es:domingo"
//    }, delimiter = ':')
//    final void shouldRetrieveDayNameInSeveralLanguages(final String original, final String locale, final String expected)
//    {
//        Assertions.assertEquals(
//                expected,
//                DayType.valueOf(original.toUpperCase()).getName(Locale.forLanguageTag(locale)));
//    }
}