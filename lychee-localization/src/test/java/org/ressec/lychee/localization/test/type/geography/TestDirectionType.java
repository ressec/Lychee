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
import org.ressec.lychee.localization.type.geography.DirectionType;

import java.util.Locale;

/**
 * A class for unit testing the {@link DirectionType} localized enumeration.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("i18n")
@Tag("i18n.geography")
@Tag("i18n.geography.direction")
final class TestDirectionType extends BaseUnitTest
{
    @BeforeEach
    protected void setUpBeforeEach()
    {
        super.setUpBeforeEach();

        ResourceBundleManager.getInstance().setDefaultLocale(Locale.ENGLISH);
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
    }

    @Test
    @DisplayName("Should retrieve the direction term definition using a given locale")
    final void shouldRetrieveDirectionTermDefinitionUsingGivenLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Assertions.assertTrue(
                DirectionType.getTermDefinition(Locale.FRENCH).startsWith("Les quatre directions " +
                        "cardinales, ou points cardinaux, sont les directions nord, est, sud et ouest, communément " +
                        "désignées par leurs initiales N, E, S et W."));
    }

    @Test
    @DisplayName("Should retrieve the direction name using the current locale")
    final void shouldRetrieveDirectionNameUsingCurrentLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Assertions.assertEquals(
                "Sud",
                DirectionType.SOUTH.getName());
    }

    @Test
    @DisplayName("Should retrieve the direction name given a specific locale")
    final void shouldRetrieveDirectionNameUsingGivenLocale()
    {
        Assertions.assertEquals(
                "Ouest",
                DirectionType.WEST.getName(Locale.FRANCE));
    }

    @Test
    @DisplayName("Should retrieve the direction definition using the default locale")
    final void shouldRetrieveDirectionNameUsingDefaultLocale()
    {
        Assertions.assertEquals("East",
                DirectionType.EAST.getName());
    }

    @Test
    @DisplayName("Should retrieve the direction definition using the default locale")
    final void shouldRetrieveDirectionDefinitionUsingDefaultLocale()
    {
        Assertions.assertEquals("East is one of the four cardinal directions or points of the compass. It is the " +
                        "opposite direction from west.",
                DirectionType.EAST.getDescription());
    }

    @Test
    @DisplayName("Should retrieve the direction name using the current locale when the given locale is not available")
    final void shouldRetrieveDirectionNameUsingCurrentLocaleWhenGivenLocaleIsNotAvailable()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("es"));

        Assertions.assertEquals(
                "Este",
                DirectionType.EAST.getName(Locale.forLanguageTag("xh"))); // Xhosa language
    }

    @Test
    @DisplayName("Should retrieve the direction name using the current locale when the given locale does not exist")
    final void shouldRetrieveDirectionNameUsingCurrentLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.GERMAN);

        Assertions.assertEquals(
                "Süden",
                DirectionType.SOUTH.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the direction name using the default locale when the given locale does not exist")
    final void shouldRetrieveDirectionNameUsingDefaultLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "South",
                DirectionType.SOUTH.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the direction name using the default locale when the current locale and the given locale do not exist")
    final void shouldRetrieveDirectionNameUsingDefaultLocaleWhenCurrentLocaleAndGivenLocaleDoNotExist()
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.FRENCH);
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Sud",
                DirectionType.SOUTH.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }
}