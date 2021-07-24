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
package org.ressec.lychee.localization.test.type.geography;

import org.junit.jupiter.api.*;
import org.ressec.avocado.core.junit.BaseUnitTest;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.geography.country.ContinentType;

import java.util.Locale;

/**
 * A class for unit testing the {@link ContinentType} localized enumeration.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("i18n")
@Tag("i18n.geography")
@Tag("i18n.geography.continent")
final class TestContinentType extends BaseUnitTest
{
    @BeforeEach
    protected void setUpBeforeEach()
    {
        super.setUpBeforeEach();

        ResourceBundleManager.getInstance().setDefaultLocale(Locale.ENGLISH);
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
    }

    @Test
    @DisplayName("Should retrieve the continent term definition using a given locale")
    final void shouldRetrieveDirectionTermDefinitionUsingGivenLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Assertions.assertTrue(
                ContinentType.getTermDefinition(Locale.FRENCH).startsWith("Un continent est l'une des nombreuses grandes masses continentales."));
    }

    @Test
    @DisplayName("Should retrieve the continent name using the current resource bundle manager locale")
    final void shouldRetrieveContinentNameUsingCurrentLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Assertions.assertEquals(
                "Afrique",
                ContinentType.AFRICA.getName());
    }

    @Test
    @DisplayName("Should retrieve the continent name given a specific locale")
    final void shouldRetrieveContinentNameUsingGivenLocale()
    {
        Assertions.assertEquals(
                "Asie",
                ContinentType.ASIA.getName(Locale.FRANCE));
    }

    @Test
    @DisplayName("Should retrieve the continent definition using the default locale")
    final void shouldRetrieveContinentNameUsingDefaultLocale()
    {
        Assertions.assertEquals("North America",
                ContinentType.AMERICA_NORTH.getName());
    }

    @Test
    @DisplayName("Should retrieve the continent definition using the default locale")
    final void shouldRetrieveContinentDefinitionUsingDefaultLocale()
    {
        Assertions.assertTrue(
                ContinentType.OCEANIA.getDefinition().startsWith("Oceania is a geographic region that includes Australasia, Melanesia, Micronesia and Polynesia."));
    }

    @Test
    @DisplayName("Should retrieve the continent name using the current locale when the given locale is not available")
    final void shouldRetrieveContinentNameUsingCurrentLocaleWhenGivenLocaleIsNotAvailable()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("es"));

        Assertions.assertEquals(
                "Europa",
                ContinentType.EUROPE.getName(Locale.forLanguageTag("xh"))); // Xhosa language
    }

    @Test
    @DisplayName("Should retrieve the continent name using the current locale when the given locale does not exist")
    final void shouldRetrieveContinentNameUsingCurrentLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.GERMAN);

        Assertions.assertEquals(
                "Südamerika",
                ContinentType.AMERICA_SOUTH.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the continent name using the default locale when the given locale does not exist")
    final void shouldRetrieveContinentNameUsingDefaultLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Europe",
                ContinentType.EUROPE.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the continent name using the default locale when the current locale and the given locale do not exist")
    final void shouldRetrieveContinentNameUsingDefaultLocaleWhenCurrentLocaleAndGivenLocaleDoNotExist()
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.FRENCH);
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Amérique du Nord",
                ContinentType.AMERICA_NORTH.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }
}