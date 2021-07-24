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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ressec.avocado.core.junit.BaseUnitTest;
import org.ressec.lychee.localization.base.Rope;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.translation.base.TranslationException;

import java.util.Locale;

/**
 * A class for unit testing the {@link Rope} entity.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
final class TestRope extends BaseUnitTest
{
    /**
     * Test resource bundle property entry for name key.
     */
    private static final String TEST_BUNDLE_ENTRY_KEY_NAME = "lychee.localization.FRUIT.name";

    /**
     * Test resource bundle property entry for definition key.
     */
    private static final String TEST_BUNDLE_ENTRY_KEY_DEFINITION = "lychee.localization.FRUIT.definition";

    @Test
    @DisplayName("Should not localize free text")
    final void shouldNotLocalizeFreeText()
    {
        Assertions.assertEquals(
                "earth",
                Rope.valueOf("earth").getValue()); // Free text string

        Rope earth = Rope.valueOf("earth");
        earth.localize();
        Assertions.assertEquals(
                "earth",
                earth.getValue()); // No effect as it's a free text string

        earth.localize(Locale.GERMAN);
        Assertions.assertEquals(
                "earth",
                earth.getValue()); // No effect as it's a free text string
    }

    @Test
    @DisplayName("Should localize at creation time")
    final void shouldLocalizeAtCreationTime()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Rope element = Rope.builder()
                .withBundle("i18n/test")
                .withKey(TEST_BUNDLE_ENTRY_KEY_NAME)
                .build();

        Assertions.assertEquals("Fruit", element.getValue());

        element.localize(Locale.GERMAN);
        Assertions.assertEquals("Obst", element.getValue());
    }

    @Test
    @DisplayName("Should localize value using given locale")
    final void shouldLocalizeUsingGivenLocale()
    {
        ResourceBundleManager.getInstance().clear();

        Rope rope = Rope.from("i18n/test", "lychee.localization.FRUIT.name");
        rope.localize(Locale.ITALIAN);

        Assertions.assertEquals("Frutta", rope.getValue());
    }

    @Test
    @DisplayName("Should localize value using current locale of resource bundle manager")
    final void shouldLocalizeUsingResourceBundleManagerCurrentLocale()
    {
        ResourceBundleManager.getInstance().clear();
        ResourceBundleManager.getInstance().setLocale(Locale.GERMAN);

        Rope rope = Rope.from("i18n/test", "lychee.localization.FRUIT.name");
        rope.localize();

        Assertions.assertEquals("Obst", rope.getValue());
    }

    @Test
    @DisplayName("Should localize value using default locale of resource bundle manager")
    final void shouldLocalizeUsingResourceBundleManagerDefaultLocale()
    {
        ResourceBundleManager.getInstance().clear();
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("iw")); // Hebrew locale is not available!

        Rope rope = Rope.from("i18n/test", "lychee.localization.FRUIT.name");
        rope.localize();

        Assertions.assertEquals("Fruit", rope.getValue());
    }

    @Test
    @DisplayName("Should handle multiple successive localizations")
    final void shouldHandleMultipleSuccessiveLocalization()
    {
        ResourceBundleManager.getInstance().load("i18n/test");

        Rope text = Rope.from(TEST_BUNDLE_ENTRY_KEY_NAME);
        text.localize(Locale.ITALIAN);
        Assertions.assertEquals(
                "Frutta",
                text.getValue());

        text.localize(Locale.ENGLISH);
        Assertions.assertEquals(
                "Fruit",
                text.getValue());

        text.localize(Locale.FRENCH);
        Assertions.assertEquals(
                "Fruit",
                text.getValue());

        text.localize(Locale.GERMAN);
        Assertions.assertEquals(
                "Obst",
                text.getValue());

        text.localize(Locale.forLanguageTag("es"));
        Assertions.assertEquals(
                "Fruta",
                text.getValue());
    }

    /**
     * Test when a localization is requested in a non-existent language, so the manager
     * should provide the localization in the default language.
     */
    @Test
    final void testRopeLocalizeNonExistentLanguage()
    {
        // Set default locale to english
        ResourceBundleManager.getInstance().setLocale(Locale.ITALIAN);

        // Load resource bundle properties files (all available locales)
        ResourceBundleManager.getInstance().load("i18n/test");

        Rope text = Rope.from(TEST_BUNDLE_ENTRY_KEY_DEFINITION);
        text.localize(Locale.forLanguageTag("ja"));
        Assertions.assertEquals(
                "In botanica, un frutto è la struttura portante del seme nelle piante da fiore (note anche come angiosperme) formate dall'ovaio dopo la fioritura.",
                text.getValue());
    }

    @Test
    @DisplayName("Should translate the given text")
    final void shouldTranslateGivenText() throws TranslationException
    {
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);

        Rope text = Rope.valueOf("Un petit bout de texte à faire traduire dans une langue étrangère");
        text.translate(Locale.FRENCH, Locale.forLanguageTag("iw"));
        Assertions.assertEquals("פיסת טקסט קטנה לתרגום לשפה זרה", text.getValue());
    }

    @Test
    @DisplayName("Should detect the language of the given text")
    final void shouldDetectLanguageOfGivenText() throws TranslationException
    {
        // Set default locale to english
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);

        Rope text = Rope.valueOf("Un petit bout de texte à faire traduire dans une langue étrangère");
        Locale detectedLocale = text.detect();
        Assertions.assertEquals(detectedLocale.getLanguage(), Locale.FRANCE.getLanguage());

        text.translate(Locale.FRENCH, Locale.forLanguageTag("es"));
        detectedLocale = text.detect();
        Assertions.assertEquals(detectedLocale.getLanguage(), Locale.forLanguageTag("es").getLanguage());
    }
}