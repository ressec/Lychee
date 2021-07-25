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
package org.ressec.lychee.localization.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.ressec.avocado.core.junit.BaseUnitTest;
import org.ressec.lychee.localization.bundle.ResourceBundleException;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.translation.base.TranslationException;

import java.util.List;
import java.util.Locale;

/**
 * A class for unit testing the {@link ResourceBundleManager} entity.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
final class TestResourceBundleManager extends BaseUnitTest
{
    /**
     * Test resource bundle name.
     */
    private static final String RESOURCE_BUNDLE_NAME = "i18n/day";

    /**
     * Test non-existent resource bundle name.
     */
    private static final String RESOURCE_BUNDLE_NAME_NON_EXISTENT = "i18n/nonexistent";

    @BeforeEach
    void setUp()
    {
        ResourceBundleManager.getInstance().clear();
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);
    }

    /**
     * This test should set the {@link ResourceBundleManager#setLocale(Locale)} service.
     */
    @Test
    @DisplayName("Should set the resource bundle manager locale to German")
    @Tag("ResourceBundleManager")
    final void shouldSetResourceBundleManagerLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.GERMANY);

        Assertions.assertEquals(
                Locale.GERMANY,
                ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * This test should retrieve the number of locales defined for a given resource bundle.
     * Validates the {@link ResourceBundleManager#getLocalesCount(String)} service.
     */
    @ParameterizedTest
    @DisplayName("Should retrieve the number of locales defined for a given resource bundle file")
    @ValueSource(ints = { 28 })
    @Tag("ResourceBundleManager")
    final void shouldRetrieveLocaleCountForResourceBundle(final int expectedLocaleCount)
    {
        ResourceBundleManager.getInstance().load(RESOURCE_BUNDLE_NAME);

        Assertions.assertEquals(
                expectedLocaleCount,
                ResourceBundleManager.getInstance().getLocalesCount(
                        RESOURCE_BUNDLE_NAME));
    }

    /**
     * This test should retrieve the number of locales defined for a non-existing given resource bundle.
     * Validates the {@link ResourceBundleManager#getLocalesCount(String)} service.
     */
    @ParameterizedTest
    @DisplayName("Should retrieve the number of locales defined for a given non-existing resource bundle file")
    @ValueSource(ints = { 0 })
    @Tag("ResourceBundleManager")
    final void shouldRetrieveLocaleCountForNonExistingResourceBundle(final int expectedLocaleCount)
    {
        Assertions.assertEquals(
                expectedLocaleCount,
                ResourceBundleManager.getInstance().getLocalesCount(
                        RESOURCE_BUNDLE_NAME_NON_EXISTENT));
    }

    /**
     * This test should retrieve the resource bundle manager locale list for a non-existing resource bundle file.
     */
    @ParameterizedTest
    @DisplayName("Should retrieve the list of locales for a given non-existing resource bundle file")
    @ValueSource(ints = { 0 })
    @Tag("ResourceBundleManager")
    final void shouldRetrieveResourceBundleManagerLocaleListForNonExistingResourceBundleFile(final int expectedLocaleCount)
    {
        Assertions.assertEquals(
                expectedLocaleCount,
                ResourceBundleManager.getInstance().getLocalesList(RESOURCE_BUNDLE_NAME_NON_EXISTENT).size());
    }

    /**
     * This test should retrieve the resource bundle manager locale list for an existing resource bundle file.
     */
    @ParameterizedTest
    @DisplayName("Should retrieve the list of locales for a given resource bundle file")
    @ValueSource(ints = { 28 })
    @Tag("ResourceBundleManager")
    final void shouldRetrieveResourceBundleManagerLocaleListForExistingResourceBundleFile(final int expectedLocaleCount)
    {
        ResourceBundleManager.getInstance().load(RESOURCE_BUNDLE_NAME);

        Assertions.assertEquals(
                expectedLocaleCount,
                ResourceBundleManager.getInstance().getLocalesList(RESOURCE_BUNDLE_NAME).size());
    }

    /**
     * This test should check a locale does not exist for a given resource bundle file.
     */
    @ParameterizedTest
    @DisplayName("Should check locale does not exist for a given resource bundle file")
    @ValueSource(strings = { "vi" })
    @Tag("ResourceBundleManager")
    final void shouldCheckLocaleDoesNotExistForResourceBundleFile(final String expectedLocale)
    {
        ResourceBundleManager.getInstance().load(RESOURCE_BUNDLE_NAME);

        Assertions.assertFalse(ResourceBundleManager.getInstance().existLocale(
                RESOURCE_BUNDLE_NAME,
                Locale.forLanguageTag(expectedLocale))); // Vietnamese does not exist as a resource bundle file!);
    }

    /**
     * This test should check a locale exist for a given resource bundle file.
     */
    @ParameterizedTest
    @DisplayName("Should check locale exist for a given resource bundle file")
    @ValueSource(strings = { "it" })
    @Tag("ResourceBundleManager")
    final void shouldCheckLocaleExistForResourceBundleFile(final String expectedLocale)
    {
        ResourceBundleManager.getInstance().load(RESOURCE_BUNDLE_NAME);

        Assertions.assertTrue(
                ResourceBundleManager.getInstance().existLocale(
                        RESOURCE_BUNDLE_NAME,
                        Locale.forLanguageTag(expectedLocale)));
    }

    /**
     * This test should load into the resource bundle manager a set of resource bundle files in several locales.
     * Validates the {@link ResourceBundleManager#load(String)} service.
     */
    @Test
    @DisplayName("Should load a set of resource bundles in several locales")
    @Tag("ResourceBundleManager")
    final void shouldLoadResourceBundleFilesInResourceBundleManager()
    {
        ResourceBundleManager.getInstance().clear();

        ResourceBundleManager.getInstance().load(RESOURCE_BUNDLE_NAME);

        Assertions.assertAll("Should load resource bundle files in several locales",
                () -> Assertions.assertTrue(
                        ResourceBundleManager.getInstance().existLocale(
                                RESOURCE_BUNDLE_NAME,
                                Locale.GERMANY)),
                () -> Assertions.assertTrue(
                        ResourceBundleManager.getInstance().existLocale(
                                RESOURCE_BUNDLE_NAME,
                                Locale.ENGLISH)),
                () -> Assertions.assertTrue(
                        ResourceBundleManager.getInstance().existLocale(
                                RESOURCE_BUNDLE_NAME,
                                Locale.FRENCH)),
                () -> Assertions.assertTrue(
                        ResourceBundleManager.getInstance().existLocale(
                                RESOURCE_BUNDLE_NAME,
                                Locale.ITALIAN)),
                () -> Assertions.assertTrue(
                        ResourceBundleManager.getInstance().existLocale(
                                RESOURCE_BUNDLE_NAME,
                                Locale.forLanguageTag("es"))));
    }

    /**
     * This test should load into the resource bundle manager a set of resource bundle files given a locale.
     * Validates the {@link ResourceBundleManager#load(String, Locale)} service.
     */
    @Test
    @DisplayName("Should load a set of resource bundle files in a given locale")
    final void shouldLoadResourceBundleFilesInResourceBundleManagerForGivenLocale()
    {
        ResourceBundleManager.getInstance().load(RESOURCE_BUNDLE_NAME, Locale.GERMANY);

        Assertions.assertTrue(
                ResourceBundleManager.getInstance().existLocale(
                        RESOURCE_BUNDLE_NAME,
                        Locale.GERMANY));

        Assertions.assertFalse(
                ResourceBundleManager.getInstance().existLocale(
                        RESOURCE_BUNDLE_NAME,
                        Locale.ENGLISH));
    }

    /**
     * This test should load a localized value from the resource bundle manager using the current locale.
     * Validates the {@link ResourceBundleManager#get(String)} service.
     */
    @Test
    @DisplayName("Should load a localized value using the current locale")
    @Tag("ResourceBundleManager")
    final void shouldRetrieveLocalizedValueFromResourceBundleManager()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
        ResourceBundleManager.getInstance().load(RESOURCE_BUNDLE_NAME);

        Assertions.assertEquals(
                "Sunday",
                ResourceBundleManager.getInstance().get("day.SUNDAY.name"));
    }

    /**
     * This test should load a localized value from the resource bundle manager given a locale.
     * Validates the {@link ResourceBundleManager#get(String, Locale)} service.
     */
    @Test
    @DisplayName("Should retrieve a resource bundle value given a locale")
    @Tag("ResourceBundleManager")
    final void shouldGetResourceBundleValueForGivenLocale()
    {
        ResourceBundleManager.getInstance().load(RESOURCE_BUNDLE_NAME);

        Assertions.assertEquals(
                "Dimanche",
                ResourceBundleManager.getInstance().get(
                        "day.SUNDAY.name",
                        Locale.FRANCE));
    }

    /**
     * This test should load a localized value from the resource bundle manager given a locale.
     * Test the {@link ResourceBundleManager#get(String, String, Locale)} service.
     */
    @Test
    @DisplayName("Should retrieve a resource bundle value given a locale")
    final void shouldGetResourceBundleGivenLocale()
    {
        Assertions.assertEquals(
                "Dimanche",
                ResourceBundleManager.getInstance().get(
                        RESOURCE_BUNDLE_NAME,
                        "day.SUNDAY.name",
                        Locale.FRANCE));
    }

    /**
     * This test should raise an exception when trying to get a non-existing resource bundle key.
     * Test the {@link ResourceBundleManager#get(String, String, Locale)} service.
     */
    @Test
    @DisplayName("Should raise an exception when trying to get a non-existing resource bundle key")
    final void shouldRaiseExceptionWhenGettingNonExistingResourceBundleKey()
    {
        Assertions.assertThrows(ResourceBundleException.class, () ->
                {
            ResourceBundleManager.getInstance().get("i18n/computer","entry.UNIX.computer",Locale.FRANCE);
        });
    }

    /**
     * This test should translate text from french to spanish.
     * Test the {@link ResourceBundleManager#translate(Locale, Locale, String)} service.
     */
    @ParameterizedTest
    @DisplayName("Should translate text from french to spanish")
    @CsvSource(value = { "Dimanche:domingo" }, delimiter = ':')
    final void shouldTranslateTextFromFrenchToSpanish(final String source, final String target) throws TranslationException
    {
        String dayName = ResourceBundleManager.getInstance().get(RESOURCE_BUNDLE_NAME, "day.SUNDAY.name", Locale.FRANCE);
        Assertions.assertEquals(source,dayName);

        Assertions.assertEquals(
                target,
                ResourceBundleManager.getInstance().translate(
                        Locale.FRENCH,
                        Locale.forLanguageTag("es"), dayName).getTranslatedText());
    }

    /**
     * This test should translate text from french to italian.
     * Test the {@link ResourceBundleManager#translate(Locale, Locale, String)} service.
     */
    @ParameterizedTest
    @DisplayName("Should translate text from french to italian")
    @CsvSource(value = { "Dimanche:Domenica" }, delimiter = ':')
    final void shouldTranslateTextFromFrenchToItalian(final String source, final String target) throws TranslationException
    {
        Assertions.assertEquals(
                source,
                ResourceBundleManager.getInstance().get(RESOURCE_BUNDLE_NAME, "day.SUNDAY.name", Locale.FRANCE));

        Assertions.assertEquals(
                target,
                ResourceBundleManager.getInstance().translate(Locale.ITALIAN, target).getTranslatedText());
    }

    /**
     * This test should translate text from french to german.
     * Test the {@link ResourceBundleManager#translate(Locale, Locale, String)} service.
     */
    @ParameterizedTest
    @DisplayName("Should translate text from french to german")
    @CsvSource(value = { "Dimanche:Sonntag" }, delimiter = ':')
    final void shouldTranslateTextFromFrenchToGerman(final String source, final String target) throws TranslationException
    {
        Assertions.assertEquals(
                source,
                ResourceBundleManager.getInstance().get(RESOURCE_BUNDLE_NAME, "day.SUNDAY.name", Locale.FRANCE));

        Assertions.assertEquals(
                target,
                ResourceBundleManager.getInstance().translate(
                        Locale.GERMAN,
                        source).getTranslatedText());
    }

    /**
     * This test should translate text from french to english.
     * Test the {@link ResourceBundleManager#translate(Locale, Locale, String)} service.
     */
    @ParameterizedTest
    @DisplayName("Should translate text from french to english")
    @CsvSource(value = { "Dimanche:Sunday" }, delimiter = ':')
    final void shouldTranslateTextFromFrenchToEnglish(final String source, final String target) throws TranslationException
    {
        Assertions.assertEquals(
                source,
                ResourceBundleManager.getInstance().get(RESOURCE_BUNDLE_NAME, "day.SUNDAY.name", Locale.FRANCE));

        Assertions.assertEquals(
                target,
                ResourceBundleManager.getInstance().translate(
                        Locale.ENGLISH,
                        source).getTranslatedText());
    }

    /**
     * This test should detect the language of a source text.
     * Test the {@link ResourceBundleManager#detect(String)} service.
     */
    @ParameterizedTest
    @DisplayName("Should detect the language of a source text")
    @CsvSource(value = { "Dimanche:Sonntag" }, delimiter = ':')
    final void shouldDetectLanguage(final String source, final String target) throws TranslationException
    {
        Locale targetLanguage = ResourceBundleManager.getInstance().detect(target).getDetectedLanguage();
        Assertions.assertEquals(
                Locale.GERMANY.getLanguage(),
                targetLanguage.getLanguage());
    }

    /**
     * This test should detect the supported language of a source text.
     * Test the {@link ResourceBundleManager#getSupportedLanguage(Locale)} service.
     */
    @Test
    final void shouldGetSupportedLanguage()
    {
        Assertions.assertThrows(TranslationException.class, () ->
        {
            List<Locale> locales = ResourceBundleManager.getInstance().getSupportedLanguage(Locale.FRENCH).getSupportedLanguages();
            Assertions.assertTrue(locales.size() > 0);
        });
    }
}