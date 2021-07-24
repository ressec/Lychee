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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.ressec.avocado.core.junit.BaseUnitTest;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.geography.HemisphereType;

import java.util.Locale;

/**
 * A class for unit testing the {@link HemisphereType} localized enumeration.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("i18n")
@Tag("i18n.geography")
@Tag("i18n.geography.hemisphere")
class TestHemisphereType extends BaseUnitTest
{
    @BeforeEach
    protected void setUpBeforeEach()
    {
        super.setUpBeforeEach();

        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
    }

    /**
     * This test should retrieve the definition of an hemisphere.
     */
    @Test
    @DisplayName("Should retrieve hemisphere term definition")
    void shouldRetrieveHemisphereDefinition()
    {
        Assertions.assertEquals(
                "In geography and cartography, the hemispheres of Earth refer to any division of the globe into two " +
                        "hemispheres (from Ancient Greek meaning \"half of a sphere\").",
                HemisphereType.getTermDefinition());
    }

    /**
     * This test should retrieve for all enumerated values the hemisphere type name in english.
     * @param type Hemisphere type.
     */
    @ParameterizedTest
    @DisplayName("Should retrieve hemisphere type name")
    @EnumSource(HemisphereType.class)
    void shouldRetrieveHemisphereTypeName(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "North", type.getName());
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "South", type.getName());
                break;
        }
    }

    /**
     * This test should retrieve for all enumerated values the hemisphere type definition in english.
     * @param type Hemisphere type.
     */
    @ParameterizedTest
    @DisplayName("Should retrieve hemisphere type definition")
    @EnumSource(HemisphereType.class)
    void shouldRetrieveHemisphereTypeDefinition(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "The Northern Hemisphere is the half of Earth that is north of the Equator.",
                        type.getDescription());
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "The Southern Hemisphere is the half of Earth that is south of the Equator. It contains " +
                                "all or parts of five continents (Antarctica, Australia, about 90% of South America, " +
                                "one third of Africa, and several islands off the continental mainland of Asia), four " +
                                "oceans (Indian, South Atlantic, Southern, and South Pacific) and most of the Pacific " +
                                "Islands in Oceania. Its surface is 80.9% water, compared with 60.7% water in the case " +
                                "of the Northern Hemisphere, and it contains 32.7% of Earth's land.",
                        type.getDescription());
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type name even if the given locale does not exist, default is english")
    @EnumSource(HemisphereType.class)
    void shouldRetrieveHemisphereTypeNameEvenIfLocaleDoesNotExist(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "North",
                        type.getName(Locale.forLanguageTag("vi")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "South",
                        type.getName(Locale.forLanguageTag("vi")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type definition even if the given locale does not exist, default is english")
    @EnumSource(HemisphereType.class)
    void shouldRetrieveHemisphereTypeDefinitionEvenIfLocaleDoesNotExist(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "The Northern Hemisphere is the half of Earth that is north of the Equator.",
                        type.getDescription(Locale.forLanguageTag("vi")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "The Southern Hemisphere is the half of Earth that is south of the Equator. It contains " +
                                "all or parts of five continents (Antarctica, Australia, about 90% of South America, " +
                                "one third of Africa, and several islands off the continental mainland of Asia), four " +
                                "oceans (Indian, South Atlantic, Southern, and South Pacific) and most of the Pacific " +
                                "Islands in Oceania. Its surface is 80.9% water, compared with 60.7% water in the case " +
                                "of the Northern Hemisphere, and it contains 32.7% of Earth's land.",
                        type.getDescription(Locale.forLanguageTag("vi")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type name for latin alphabet (spanish)")
    @EnumSource(HemisphereType.class)
    void shouldRetrieveHemisphereNameForLatinAlphabet(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "Norte",
                        type.getName(Locale.forLanguageTag("es")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "Sur",
                        type.getName(Locale.forLanguageTag("es")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type definition for latin alphabet (french)")
    @EnumSource(HemisphereType.class)
    void shouldRetrieveHemisphereTypeDefinitionForLatinAlphabet(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "L'hémisphère nord est la moitié de la Terre qui se trouve au nord de l'équateur.",
                        type.getDescription(Locale.forLanguageTag("fr")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "L'hémisphère sud est la moitié de la Terre qui se trouve au sud de l'équateur. Il " +
                                "contient tout ou partie des cinq continents (Antarctique, Australie, environ 90% de " +
                                "l'Amérique du Sud, un tiers de l'Afrique et plusieurs îles au large du continent " +
                                "continental de l'Asie), quatre océans (Indien, Atlantique Sud, Sud et Pacifique Sud) " +
                                "et la plupart des îles du Pacifique en Océanie. Sa surface est constituée de 80,9% " +
                                "d'eau, contre 60,7% d'eau dans le cas de l'hémisphère nord, et il contient 32,7% des " +
                                "terres de la Terre.",
                        type.getDescription(Locale.forLanguageTag("fr")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type name for arabic alphabet")
    @EnumSource(HemisphereType.class)
    void shouldRetrieveHemisphereNameForArabicAlphabet(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "شمال",
                        type.getName(Locale.forLanguageTag("ar")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "جنوب",
                        type.getName(Locale.forLanguageTag("ar")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type name for cyrillic alphabet")
    @EnumSource(HemisphereType.class)
    void shouldRetrieveHemisphereNameForCyrillicAlphabet(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "к северу",
                        type.getName(Locale.forLanguageTag("ru")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "Юг",
                        type.getName(Locale.forLanguageTag("ru")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type name for chinese alphabet")
    @EnumSource(HemisphereType.class)
    void shouldGetHemisphereNameForChineseAlphabet(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "北",
                        type.getName(Locale.forLanguageTag("zh")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "南",
                        type.getName(Locale.forLanguageTag("zh")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type name for japanese alphabet")
    @EnumSource(HemisphereType.class)
    void shouldGetHemisphereNameForJapaneseAlphabet(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "北",
                        type.getName(Locale.forLanguageTag("ja")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "南",
                        type.getName(Locale.forLanguageTag("ja")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type name for korean alphabet")
    @EnumSource(HemisphereType.class)
    void shouldGetHemisphereNameForKoreanAlphabet(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "북쪽",
                        type.getName(Locale.forLanguageTag("ko")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "남쪽",
                        type.getName(Locale.forLanguageTag("ko")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type name for hebrew alphabet")
    @EnumSource(HemisphereType.class)
    void shouldGetHemisphereNameForHebrewAlphabet(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "צָפוֹן",
                        type.getName(Locale.forLanguageTag("iw")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "דָרוֹם",
                        type.getName(Locale.forLanguageTag("iw")));
                break;
        }
    }

    @ParameterizedTest
    @DisplayName("Should retrieve the hemisphere type name for greek alphabet")
    @EnumSource(HemisphereType.class)
    void shouldGetHemisphereNameForGreekAlphabet(final HemisphereType type)
    {
        switch (type)
        {
            case NORTH:
                Assertions.assertEquals(
                        "Βόρειος",
                        type.getName(Locale.forLanguageTag("el")));
                break;

            case SOUTH:
                Assertions.assertEquals(
                        "Νότος",
                        type.getName(Locale.forLanguageTag("el")));
                break;
        }
    }
}