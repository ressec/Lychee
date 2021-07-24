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
import org.ressec.lychee.localization.type.calendar.SeasonType;
import org.ressec.lychee.localization.type.geography.HemisphereType;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A class for unit testing the {@link SeasonType} localized enumeration.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("i18n")
@Tag("i18n.calendar")
@Tag("i18n.calendar.season")
final class TestSeasonType extends BaseUnitTest
{
    private LocalDate today;

    @BeforeEach
    protected void setUpBeforeEach()
    {
        super.setUpBeforeEach();

        today = LocalDate.now();
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.ENGLISH);
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
    }

    @Test
    @DisplayName("Should retrieve the season term definition using a given locale")
    final void shouldRetrieveSeasonTermDefinitionUsingGivenLocale()
    {
        Assertions.assertTrue(
                SeasonType.getTermDefinition(Locale.FRENCH)
                        .startsWith("Une saison est une division de l'année basée sur les changements de temps, d'écologie et du nombre d'heures de clarté dans une région donnée."));
    }

    @Test
    @DisplayName("Should retrieve the season name using the current locale")
    final void shouldRetrieveSeasonNameUsingCurrentLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Assertions.assertEquals(
                "Automne",
                SeasonType.AUTUMN.getName());
    }

    @Test
    @DisplayName("Should retrieve the season name given a specific locale")
    final void shouldRetrieveSeasonNameUsingGivenLocale()
    {
        Assertions.assertEquals(
                "Sommer",
                SeasonType.SUMMER.getName(Locale.GERMAN));
    }

    @Test
    @DisplayName("Should retrieve the season name using the default locale")
    final void shouldRetrieveSeasonNameUsingDefaultLocale()
    {
        Assertions.assertEquals("Spring",
                SeasonType.SPRING.getName());
    }

    @Test
    @DisplayName("Should retrieve the season description using the default locale")
    final void shouldRetrieveSeasonDefinitionUsingDefaultLocale()
    {
        Assertions.assertTrue(
                SeasonType.WINTER.getDescription().startsWith("Winter is the coldest season of the year in polar and temperate zones (winter does not occur in most of the tropical zone)."));
    }

    @Test
    @DisplayName("Should retrieve the season name using the current locale when the given locale is not available")
    final void shouldRetrieveSeasonNameUsingCurrentLocaleWhenGivenLocaleIsNotAvailable()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("es"));

        Assertions.assertEquals(
                "Otoño",
                SeasonType.AUTUMN.getName(Locale.forLanguageTag("xh"))); // Xhosa language
    }

    @Test
    @DisplayName("Should retrieve the season name using the current locale when the given locale does not exist")
    final void shouldRetrieveSeasonNameUsingCurrentLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.GERMAN);

        Assertions.assertEquals(
                "Frühling",
                SeasonType.SPRING.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the season name using the default locale when the given locale does not exist")
    final void shouldRetrieveSeasonNameUsingDefaultLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Winter",
                SeasonType.WINTER.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the season name using the default locale when the current locale and the given locale do not exist")
    final void shouldRetrieveSeasonNameUsingDefaultLocaleWhenCurrentLocaleAndGivenLocaleDoNotExist()
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.FRENCH);
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Hiver",
                SeasonType.WINTER.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should be able to retrieve the season start date for a given hemisphere")
    final void shouldRetrieveSeasonStartDateAccordingToHemisphere()
    {
        assertEquals(
                LocalDate.of(today.getYear(), Month.MARCH, 1),
                SeasonType.SPRING.getStartDate(HemisphereType.NORTH));
    }

    @Test
    @DisplayName("Should be able to retrieve the season end date for a given hemisphere")
    final void shouldRetrieveSeasonEndDateAccordingToHemisphere()
    {
        assertEquals(
                LocalDate.of(today.getYear(), Month.MAY, 31),
                SeasonType.AUTUMN.getEndDate(HemisphereType.SOUTH));
    }
}