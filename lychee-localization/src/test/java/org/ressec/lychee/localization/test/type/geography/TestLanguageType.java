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
import org.ressec.lychee.localization.type.geography.LanguageType;

import java.util.Locale;

/**
 * A class for unit testing the {@link LanguageType} localized enumeration.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("i18n")
@Tag("i18n.geography")
@Tag("i18n.geography.language")
final class TestLanguageType extends BaseUnitTest
{
    @BeforeEach
    protected void setUpBeforeEach()
    {
        super.setUpBeforeEach();

        ResourceBundleManager.getInstance().setDefaultLocale(Locale.ENGLISH);
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
    }

    @Test
    @DisplayName("Should retrieve the language term definition using a given locale")
    final void shouldRetrieveLanguageTermDefinitionUsingGivenLocale()
    {
        Assertions.assertTrue(
                LanguageType.getTermDefinition(Locale.FRENCH)
                        .startsWith("Une langue est un système de communication structuré utilisé par les humains"));
    }

    @Test
    @DisplayName("Should retrieve the language name using the current locale")
    final void shouldRetrieveLanguageNameUsingCurrentLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Assertions.assertEquals(
                "Allemand",
                LanguageType.GERMAN.getName());
    }

    @Test
    @DisplayName("Should retrieve the language name given a specific locale")
    final void shouldRetrieveLanguageNameUsingGivenLocale()
    {
        Assertions.assertEquals(
                "Spanisch",
                LanguageType.SPANISH.getName(Locale.GERMAN));
    }

    @Test
    @DisplayName("Should retrieve the language definition using the default locale")
    final void shouldRetrieveLanguageNameUsingDefaultLocale()
    {
        Assertions.assertEquals("Italian",
                LanguageType.ITALIAN.getName());
    }

    @Test
    @DisplayName("Should retrieve the language definition using the default locale")
    final void shouldRetrieveLanguageDefinitionUsingDefaultLocale()
    {
        Assertions.assertTrue(
                LanguageType.GERMAN.getDescription().startsWith("The German language is a West Germanic language mainly spoken in Central Europe."));
    }

    @Test
    @DisplayName("Should retrieve the language name using the current locale when the given locale is not available")
    final void shouldRetrieveLanguageNameUsingCurrentLocaleWhenGivenLocaleIsNotAvailable()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("es"));

        Assertions.assertEquals(
                "Español",
                LanguageType.SPANISH.getName(Locale.forLanguageTag("xh"))); // Xhosa language
    }

    @Test
    @DisplayName("Should retrieve the language name using the current locale when the given locale does not exist")
    final void shouldRetrieveLanguageNameUsingCurrentLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.GERMAN);

        Assertions.assertEquals(
                "Französisch",
                LanguageType.FRENCH.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the language name using the default locale when the given locale does not exist")
    final void shouldRetrieveLanguageNameUsingDefaultLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Italian",
                LanguageType.ITALIAN.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the language name using the default locale when the current locale and the given locale do not exist")
    final void shouldRetrieveLanguageNameUsingDefaultLocaleWhenCurrentLocaleAndGivenLocaleDoNotExist()
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.FRENCH);
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Anglais",
                LanguageType.ENGLISH.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }
}