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

import lombok.NonNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.ressec.avocado.core.junit.BaseUnitTest;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;
import org.ressec.lychee.localization.type.geography.country.ContinentSubRegionType;
import org.ressec.lychee.localization.type.geography.country.ContinentType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Locale;

/**
 * A class for unit testing the {@link ContinentSubRegionType} localized enumeration.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Tag("internal")
@Tag("i18n")
@Tag("i18n.geography")
@Tag("i18n.geography.continent")
@Tag("i18n.geography.continent.sub-region")
final class TestContinentSubRegionType extends BaseUnitTest
{
    @BeforeEach
    protected void setUpBeforeEach()
    {
        super.setUpBeforeEach();

        ResourceBundleManager.getInstance().setDefaultLocale(Locale.ENGLISH);
        ResourceBundleManager.getInstance().setLocale(Locale.ENGLISH);
    }

    @DisplayName("Throw an exception when continent sub region type does not exist!")
    @ParameterizedTest
    @ValueSource(strings = { "MICRONESIA_ORIENTAL", "EUROPA_CENTRAL" })
    final void testThrowExceptionWhenContinentSubRegionTypeDoesNotExist(final @NonNull String continentSubRegionTypeName)
    {
        assertThatThrownBy(() -> ContinentSubRegionType.valueOf(continentSubRegionTypeName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No enum constant");
    }

    @DisplayName("Retrieve the continent's sub-region name in a given locale")
    @ParameterizedTest
    @CsvSource(value = {
            "EUROPE_WEST;en;fr;Europe de l'Ouest",
            "EUROPE_WEST;en;en;Western Europe",
            "EUROPE_WEST;en;it;Europa occidentale",
            "EUROPE_WEST;en;es;Europa Oriental",
            "EUROPE_WEST;en;de;Westeuropa",
            "EUROPE_WEST;de;xx;Westeuropa", // Locale does not exit!
            "EUROPE_WEST;xx;xx;Western Europe", // Both default locale and locale do not exit!
            "MICRONESIA;en;fr;Micronésie",
            "MICRONESIA;en;en;Micronesia",
            "MICRONESIA;en;de;Mikronesien",
            "MICRONESIA;en;it;Micronesia",
            "MICRONESIA;en;es;Micronesia",
            "AFRICA_EAST;en;fr;Afrique de l'Est",
            "AFRICA_EAST;en;de;Ostafrika",
            "AFRICA_EAST;en;it;Africa dell'est",
            "AFRICA_EAST;en;es;este de Africa",
    }, delimiter = ';')
    final void testContinentSubRegionName(final @NonNull String continentSubRegionTypeName, final @NonNull String defaultLocaleName, final @NonNull String localeName, final @NonNull String expected)
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.forLanguageTag(defaultLocaleName));
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag(localeName));
        final ContinentSubRegionType continentSubRegionType = ContinentSubRegionType.valueOf(continentSubRegionTypeName);

        assertThat(continentSubRegionType.getName())
                .as(String.format(
                        "When default locale is set to: '%s' and locale is set to '%s' then continent sub region name for type: '%s' should be: '%s'",
                        ResourceBundleManager.getInstance().getDefaultLocale(),
                        ResourceBundleManager.getInstance().getLocale(),
                        continentSubRegionType,
                        expected))
                .isEqualTo(expected);
    }

    @DisplayName("Retrieves the continent sub region description in a given locale")
    @ParameterizedTest
    @CsvSource(value = {
            "EUROPE_EAST#en#en#Eastern Europe is the region of the European continent between Western Europe and Asia. There is no consistent definition of the precise area it covers, partly because the term has a wide range of geopolitical, geographical, ethnic, cultural, and socioeconomic connotations. Russia, located in Eastern Europe, is both the largest and most populous country of Europe; spanning roughly 40% of the continent's total landmass, with over 15% of its total population.",
            "EUROPE_EAST#en#fr#L'Europe de l'Est est la région du continent européen entre l'Europe occidentale et l'Asie. Il n'y a pas de définition cohérente de la zone précise qu'il couvre, en partie parce que le terme a un large éventail de connotations géopolitiques, géographiques, ethniques, culturelles et socio-économiques. La Russie, située en Europe de l'Est, est à la fois le pays le plus grand et le plus peuplé d'Europe; couvrant environ 40% de la masse continentale totale du continent, avec plus de 15% de sa population totale.",
            "EUROPE_EAST#en#it#L'Europa orientale è la regione del continente europeo tra l'Europa occidentale e l'Asia. Non esiste una definizione coerente dell'area precisa che copre, in parte perché il termine ha una vasta gamma di connotazioni geopolitiche, geografiche, etniche, culturali e socioeconomiche. La Russia, situata nell'Europa orientale, è il paese più grande e più popoloso d'Europa; copre circa il 40% della massa continentale totale del continente, con oltre il 15% della sua popolazione totale.",
            "EUROPE_EAST#en#es#Europa del Este es la región del continente europeo entre Europa Occidental y Asia. No existe una definición coherente del área precisa que cubre, en parte porque el término tiene una amplia gama de connotaciones geopolíticas, geográficas, étnicas, culturales y socioeconómicas. Rusia, ubicada en Europa del Este, es el país más grande y poblado de Europa; que abarca aproximadamente el 40% de la masa continental total, con más del 15% de su población total.",
            "EUROPE_EAST#en#de#Osteuropa ist die Region des europäischen Kontinents zwischen Westeuropa und Asien. Es gibt keine einheitliche Definition des genauen Gebiets, das es abdeckt, auch weil der Begriff ein breites Spektrum an geopolitischen, geografischen, ethnischen, kulturellen und sozioökonomischen Konnotationen aufweist. Russland in Osteuropa ist sowohl das größte als auch das bevölkerungsreichste Land Europas. Sie erstreckt sich über rund 40% der gesamten Landmasse des Kontinents und über 15% der Gesamtbevölkerung.",
    }, delimiter = '#')
    final void testRetrieveContinentSubRegionDescription(final @NonNull String continentSubRegionTypeName, final @NonNull String defaultLocaleName, final @NonNull String localeName, final @NonNull String expected)
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.forLanguageTag(defaultLocaleName));
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag(localeName));
        final ContinentSubRegionType continentSubRegionType = ContinentSubRegionType.valueOf(continentSubRegionTypeName);

        assertThat(continentSubRegionType.getDescription())
                .as(String.format(
                        "When default locale is set to: '%s' and locale is set to '%s' then continent sub region description for type: '%s' should be: '%s'",
                        ResourceBundleManager.getInstance().getDefaultLocale(),
                        ResourceBundleManager.getInstance().getLocale(),
                        continentSubRegionType,
                        expected))
                .isEqualTo(expected);
    }

    @DisplayName("Retrieves the continent sub region term definition in a given locale")
    @ParameterizedTest
    @CsvSource(value = {
            "en#en#A subregion is a part of a larger region or continent and is usually based on location. Cardinal directions, such as south or southern, are commonly used to define a subregion.",
            "en#xy#A subregion is a part of a larger region or continent and is usually based on location. Cardinal directions, such as south or southern, are commonly used to define a subregion.",
            "en#fr#Une sous-région fait partie d'une région ou d'un continent plus vaste et est généralement basée sur l'emplacement. Les directions cardinales, telles que le sud ou le sud, sont couramment utilisées pour définir une sous-région.",
            "fr#qq#Une sous-région fait partie d'une région ou d'un continent plus vaste et est généralement basée sur l'emplacement. Les directions cardinales, telles que le sud ou le sud, sont couramment utilisées pour définir une sous-région.",
            "en#de#Eine Subregion ist Teil einer größeren Region oder eines größeren Kontinents und basiert normalerweise auf dem Standort. Himmelsrichtungen wie Süd oder Süd werden üblicherweise verwendet, um eine Subregion zu definieren.",
            "en#it#Una sottoregione è una parte di una regione o un continente più ampio e di solito è basata sulla posizione. Le direzioni cardinali, come sud o sud, sono comunemente usate per definire una sottoregione.",
            "en#es#Una subregión es parte de una región o continente más grande y generalmente se basa en la ubicación. Las direcciones cardinales, como sur o sur, se utilizan comúnmente para definir una subregión.",
    }, delimiter = '#')
    final void testRetrieveContinentSubRegionTermDefinition(final @NonNull String defaultLocaleName, final @NonNull String localeName, final @NonNull String expected)
    {
        ResourceBundleManager.getInstance().setDefaultLocale(Locale.forLanguageTag(defaultLocaleName));
        ResourceBundleManager.getInstance().setLocale(Locale.forLanguageTag(localeName));

        assertThat(ContinentSubRegionType.getTermDefinition(Locale.forLanguageTag(localeName)))
                .as(String.format(
                        "When default locale is set to: '%s' and locale is set to '%s' then continent sub region term definition should be: '%s'",
                        ResourceBundleManager.getInstance().getDefaultLocale(),
                        ResourceBundleManager.getInstance().getLocale(),
                        expected))
                .isEqualTo(expected);
    }

    @DisplayName("Retrieves the continent type the given continent sub region type belongs to")
    @ParameterizedTest
    @CsvSource(value = {
            "EUROPE;EUROPE_WEST",
            "EUROPE;EUROPE_EAST",
            "EUROPE;EUROPE_SOUTH",
            "EUROPE;EUROPE_NORTH",
            "AMERICA_SOUTH;CARIBBEAN",
            "AMERICA_SOUTH;AMERICA_CENTRAL",
            "OCEANIA;AUSTRALIA_AND_NEW_ZEALAND",
            "OCEANIA;MELANESIA",
            "OCEANIA;MICRONESIA",
            "OCEANIA;POLYNESIA",
    }, delimiter = ';')
    final void testContinentSubRegionTypeMembership(final @NonNull String continentTypeName, final @NonNull String continentSubRegionTypeName)
    {
        final ContinentType continentType = ContinentType.valueOf(continentTypeName);
        final ContinentSubRegionType continentSubRegionType = ContinentSubRegionType.valueOf(continentSubRegionTypeName);

        assertThat(continentSubRegionType.getContinentType())
                .as(String.format(
                        "Continent sub region type: '%s' should be part of continent type: '%s'",
                        continentSubRegionType,
                        continentType))
                .isEqualTo(continentType);
    }
}