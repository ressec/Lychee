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
import org.ressec.avocado.core.helper.FileHelper;
import org.ressec.avocado.core.image.IconFormatType;
import org.ressec.avocado.core.image.ImageException;
import org.ressec.avocado.core.image.ImageFileType;
import org.ressec.avocado.core.image.ImageScaleType;
import org.ressec.avocado.core.junit.BaseUnitTest;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.geography.country.ContinentSubRegionType;
import org.ressec.lychee.localization.type.geography.country.ContinentType;
import org.ressec.lychee.localization.type.geography.country.CountryException;
import org.ressec.lychee.localization.type.geography.country.CountryType;

import java.util.Locale;
import java.util.UUID;

/**
 * A class for unit testing the {@link CountryType} localized enumeration.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("i18n")
@Tag("i18n.geography")
@Tag("i18n.geography.country")
final class TestCountryType extends BaseUnitTest
{
    @BeforeEach
    protected void setUpBeforeEach()
    {
        super.setUpBeforeEach();

        ResourceBundleManager.getInstance().setDefaultLocale(Locale.ENGLISH);
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
    }

    @Test
    @DisplayName("Should create a country type from the country ISO Alpha-3 code")
    final void shouldCreateCountryFromIsoAlpha3Code() throws CountryException
    {
        CountryType country = CountryType.from("AUT");

        Assertions.assertEquals(
                CountryType.AUSTRIA,
                country);
    }

    @Test
    @DisplayName("Should retrieve the country ISO Alpha-3 code of a country type")
    final void shouldRetrieveCountryIsoAlpha3Code()
    {
        Assertions.assertEquals(
                "FRA",
                CountryType.FRANCE.getIsoAlpha3());
    }

    @Test
    @DisplayName("Should retrieve the continent type of a country type")
    final void shouldRetrieveContinentType()
    {
        Assertions.assertEquals(
                ContinentType.AFRICA,
                CountryType.GABON.getContinentType());
    }

    @Test
    @DisplayName("Should retrieve the continent's sub-region type of a country type")
    final void shouldRetrieveContinentSubRegionType()
    {
        Assertions.assertEquals(
                ContinentSubRegionType.EUROPE_WEST,
                CountryType.GREAT_BRITAIN.getSubRegionType());
    }

    @Test
    @DisplayName("Should retrieve the country term definition using a given locale")
    final void shouldRetrieveCountryTermDefinitionUsingGivenLocale()
    {
        Assertions.assertTrue(
                CountryType.getTermDefinition(Locale.FRENCH)
                        .startsWith("Un pays est une entité territoriale ou politique distincte. On l'appelle souvent le pays de naissance"));
    }

    @Test
    @DisplayName("Should retrieve the country name using the current locale")
    final void shouldRetrieveCountryNameUsingCurrentLocale()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.FRENCH);

        Assertions.assertEquals(
                "Antarctique",
                CountryType.ANTARCTICA.getName());
    }

    @Test
    @DisplayName("Should retrieve the country name given a specific locale")
    final void shouldRetrieveCountryNameUsingGivenLocale()
    {
        Assertions.assertEquals(
                "Vereinigtes Königreich",
                CountryType.GREAT_BRITAIN.getName(Locale.GERMAN));
    }

    @Test
    @DisplayName("Should retrieve the country name using the default locale")
    final void shouldRetrieveCountryNameUsingDefaultLocale()
    {
        Assertions.assertEquals("China",
                CountryType.CHINA.getName());
    }

    @Test
    @DisplayName("Should retrieve the country name using the current locale when the given locale is not available")
    final void shouldRetrieveCountryNameUsingCurrentLocaleWhenGivenLocaleIsNotAvailable()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("es"));

        Assertions.assertEquals(
                "Guadalupe",
                CountryType.GUADELOUPE.getName(Locale.forLanguageTag("xh"))); // Xhosa language
    }

    @Test
    @DisplayName("Should retrieve the country name using the current locale when the given locale does not exist")
    final void shouldRetrieveCountryNameUsingCurrentLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.GERMAN);

        Assertions.assertEquals(
                "Antarktis",
                CountryType.ANTARCTICA.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the country name using the default locale when the given locale does not exist")
    final void shouldRetrieveCountryNameUsingDefaultLocaleWhenGivenLocaleDoesNotExist()
    {
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Holy See (Vatican city)",
                CountryType.HOLY_SEE.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the country name using the default locale when the current locale and the given locale do not exist")
    final void shouldRetrieveCountryNameUsingDefaultLocaleWhenCurrentLocaleAndGivenLocaleDoNotExist()
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.FRENCH);
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag("xy")); // Non-existent locale

        Assertions.assertEquals(
                "Micronésie",
                CountryType.MICRONESIA.getName(Locale.forLanguageTag("xx"))); // Non-existent locale
    }

    @Test
    @DisplayName("Should retrieve the country description using the default locale")
    final void shouldRetrieveCountryDescriptionUsingDefaultLocale()
    {
        Assertions.assertTrue(
                CountryType.ESTONIA.getDescription().startsWith("Estonia, officially the Republic of Estonia is a country on the eastern coast of the Baltic Sea in Northern Europe."));
    }

    @Test
    @DisplayName("Should retrieve the country's motto given a specific locale")
    final void shouldRetrieveCountryMottoUsingGivenLocale()
    {
        Assertions.assertEquals(
                "In Einheit und Freiheit",
                CountryType.ARGENTINA.getMotto(Locale.GERMAN));
    }

    @Test
    @DisplayName("Should retrieve the country's anthem given a specific locale")
    final void shouldRetrieveCountryAnthemUsingGivenLocale()
    {
        Assertions.assertEquals(
                "\"God Save the Queen\" (alternativamente \"God Save the King\", dependiendo del género del " +
                        "monarca reinante) es el himno real en varios reinos de la Commonwealth, sus territorios y " +
                        "las dependencias de la Corona británica. Se desconoce el autor de la melodía y puede " +
                        "originarse en un canto llano; pero a veces se hace una atribución al compositor John Bull.",
                CountryType.ANGUILLA.getAnthem(Locale.forLanguageTag("es")));
    }

    @Test
    @DisplayName("Should save the country's round flag icon in the test folder")
    final void shouldSaveCountryRoundFlagIcon() throws ImageException
    {
        try
        {
            String iconFilename = CountryType.FRANCE.saveIcon(
                    ImageFileType.PNG,
                    IconFormatType.FORMAT_ROUND,
                    ImageScaleType.IMAGE_SCALE_256X256,
                    getTestFolderName(),
                    UUID.randomUUID().toString()); // Without file extension!

            Assertions.assertTrue(FileHelper.existFile(iconFilename));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Should save the country's round flag icon in the test folder specifying an image name")
    final void shouldSaveCountryRoundFlagIconUsingImageName() throws ImageException
    {
        String iconFilename = CountryType.FRANCE.saveIcon(
                ImageFileType.PNG,
                IconFormatType.FORMAT_ROUND,
                ImageScaleType.IMAGE_SCALE_32X32,
                getTestFolderName(),
                CountryType.FRANCE.getOfficialName());

        Assertions.assertTrue(FileHelper.existFile(iconFilename));
    }

    @Test
    @DisplayName("Should save the country's square flag icon in the test folder using its original size")
    final void shouldSaveCountrySquareFlagIcon() throws ImageException
    {
        String iconFilename = CountryType.FRANCE.saveIcon(
                ImageFileType.PNG,
                IconFormatType.FORMAT_SQUARE,
                getTestFolderName());

        Assertions.assertTrue(FileHelper.existFile(iconFilename));
    }

    @Test
    @DisplayName("Should save the country's square flag icon in the test folder using its original size and format")
    final void shouldSaveCountrySquareFlagIconUsingOriginalSizeAndFormat() throws ImageException
    {
        String iconFilename = CountryType.FRANCE.saveIcon(
                IconFormatType.FORMAT_SQUARE,
                getTestFolderName());

        Assertions.assertTrue(FileHelper.existFile(iconFilename));
    }
}