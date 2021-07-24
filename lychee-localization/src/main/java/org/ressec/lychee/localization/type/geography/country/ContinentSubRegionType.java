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
package org.ressec.lychee.localization.type.geography.country;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NonNull;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;

import java.util.Locale;

/**
 * A localized enumeration representing the continents' sub regions.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 * @see Localize
 * @see ResourceBundleManager
 */
public enum ContinentSubRegionType
{
    /**
     * Northern Africa.
     */
    @SerializedName("Northern Africa")
    AFRICA_NORTH(ContinentType.AFRICA),

    /**
     * Eastern Africa.
     */
    @SerializedName("Eastern Africa")
    AFRICA_EAST(ContinentType.AFRICA),

    /**
     * Central Africa.
     */
    @SerializedName("Central Africa")
    AFRICA_CENTRAL(ContinentType.AFRICA),

    /**
     * Southern Africa.
     */
    @SerializedName("Southern Africa")
    AFRICA_SOUTH(ContinentType.AFRICA),

    /**
     * Western Africa.
     */
    @SerializedName("Western Africa")
    AFRICA_WEST(ContinentType.AFRICA),

    /**
     * Central Asia.
     */
    @SerializedName("Central Asia")
    ASIA_CENTRAL(ContinentType.ASIA),

    /**
     * Eastern Asia.
     */
    @SerializedName("Eastern Asia")
    ASIA_EAST(ContinentType.ASIA),

    /**
     * Southern Asia.
     */
    @SerializedName("Southern Asia")
    ASIA_SOUTH(ContinentType.ASIA),

    /**
     * Southeast Africa.
     */
    @SerializedName("Southeast Asia")
    ASIA_SOUTHEAST(ContinentType.ASIA),

    /**
     * Western Africa.
     */
    @SerializedName("Western Asia")
    ASIA_WEST(ContinentType.ASIA),

    /**
     * Eastern Europe.
     */
    @SerializedName("Eastern Europe")
    EUROPE_EAST(ContinentType.EUROPE),

    /**
     * Northern Europe.
     */
    @SerializedName("Northern Europe")
    EUROPE_NORTH(ContinentType.EUROPE),

    /**
     * Southern Europe.
     */
    @SerializedName("Southern Europe")
    EUROPE_SOUTH(ContinentType.EUROPE),

    /**
     * Western Europe.
     */
    @SerializedName("Western Europe")
    EUROPE_WEST(ContinentType.EUROPE),

    /**
     * Caribbean.
     */
    @SerializedName("Caribbean")
    CARIBBEAN(ContinentType.AMERICA_SOUTH),

    /**
     * Central America.
     */
    @SerializedName("Central America")
    AMERICA_CENTRAL(ContinentType.AMERICA_SOUTH),

    /**
     * South America.
     */
    @SerializedName("South America")
    AMERICA_SOUTH(ContinentType.AMERICA_SOUTH),

    /**
     * North America.
     */
    @SerializedName("North America")
    AMERICA_NORTH(ContinentType.AMERICA_NORTH),

    /**
     * Antarctica.
     */
    @SerializedName("Antarctica")
    ANTARCTICA(ContinentType.ANTARCTICA),

    /**
     * Australia and New Zealand.
     */
    @SerializedName("Australia And New Zealand")
    AUSTRALIA_AND_NEW_ZEALAND(ContinentType.OCEANIA),

    /**
     * Melanesia.
     */
    @SerializedName("Melanesia")
    MELANESIA(ContinentType.OCEANIA),

    /**
     * Micronesia.
     */
    @SerializedName("Micronesia")
    MICRONESIA(ContinentType.OCEANIA),

    /**
     * Polynesia.
     */
    @SerializedName("Polynesia")
    POLYNESIA(ContinentType.OCEANIA);

    /**
     * Represents the resource bundle pathname.
     */
    private static final String BUNDLE_NAME_SUBREGION = "i18n/continent";

    /**
     * Represents the generic path to access the term 'definition' property.
     */
    private static final String BUNDLE_PATH_FOR_TERM_DEFINITION = "continent.sub-region.definition";

    /**
     * Represents the generic path to access the 'name' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_NAME = "continent.sub-region.${this}.name";

    /**
     * Represents the generic path to access the 'description' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION = "continent.sub-region.${this}.description";

    /**
     * Continent the sub-region belongs to.
     */
    @Getter
    private final ContinentType continentType;

    /**
     * Creates a continent sub-region.
     * @param continent Continent the sub-region belongs to.
     */
    ContinentSubRegionType(final @NonNull ContinentType continent)
    {
        this.continentType = continent;
    }

    /**
     * Returns the localized term definition of the continent's sub-region in the current locale.
     * @return Localized term definition of the continent's sub-region.
     */
    public final String getTermDefinition()
    {
        return getTermDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized term definition of a language in the given locale.
     * @param locale Locale to use.
     * @return Term definition of a language.
     */
    @Localize(bundle = BUNDLE_NAME_SUBREGION, key = BUNDLE_PATH_FOR_TERM_DEFINITION)
    public static String getTermDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(ContinentSubRegionType.class, locale);
    }

    /**
     * Returns the localized name of the continent's sub-region in the current locale.
     * @return Localized name of the continent's sub-region.
     */
    public final String getName()
    {
        return getName(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized name of the language in the given locale.
     * @param locale Locale to use.
     * @return Localized name of the language.
     */
    @Localize(bundle = BUNDLE_NAME_SUBREGION, key = BUNDLE_PATH_FOR_PROPERTY_NAME)
    public final String getName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized description of the continent's sub-region in the current locale.
     * @return Localized description of the continent's sub-region.
     */
    public final String getDescription()
    {
        return getDescription(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized description of the continent's sub-region in the given locale.
     * @param locale Locale to use.
     * @return Localized description of the continent's sub-region.
     */
    @Localize(bundle = BUNDLE_NAME_SUBREGION, key = BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION)
    public final String getDescription(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }
}
