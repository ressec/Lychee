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
import org.ressec.avocado.core.image.*;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;

/**
 * An internationalized enumeration representing countries.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 * @see Localize
 */
public enum CountryType
{
    /**
     * Afghanistan.
     */
    @SerializedName("AFG")
    AFGHANISTAN("AFG", ContinentSubRegionType.ASIA_SOUTH),

    /**
     * Aland Islands.
     */
    @SerializedName("ALA")
    ALAND_ISLANDS("ALA", ContinentSubRegionType.EUROPE_NORTH), // No round and no wave forms!

    /**
     * Albania.
     */
    @SerializedName("ALB")
    ALBANIA("ALB", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Algeria.
     */
    @SerializedName("DZA")
    ALGERIA("DZA", ContinentSubRegionType.AFRICA_NORTH),

    /**
     * American Samoa.
     */
    @SerializedName("ASM")
    AMERICAN_SAMOA("ASM", ContinentSubRegionType.POLYNESIA),

    /**
     * Andorra.
     */
    @SerializedName("AND")
    ANDORRA("AND", ContinentSubRegionType.EUROPE_SOUTH),

    /**
     * Angola.
     */
    @SerializedName("AGO")
    ANGOLA("AGO", ContinentSubRegionType.AFRICA_CENTRAL),

    /**
     * Anguilla.
     */
    @SerializedName("AIA")
    ANGUILLA("AIA", ContinentSubRegionType.CARIBBEAN),

    /**
     * Antarctica.
     */
    @SerializedName("ATA")
    ANTARCTICA("ATA", ContinentSubRegionType.ANTARCTICA), // No round and wave forms!

    /**
     * Antigua and Bermuda.
     */
    @SerializedName("ATG")
    ANTIGUA_AND_BERMUDA("ATG", ContinentSubRegionType.CARIBBEAN),

    /**
     * Argentina.
     */
    @SerializedName("ARG")
    ARGENTINA("ARG", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Armenia.
     */
    @SerializedName("ARM")
    ARMENIA("ARM", ContinentSubRegionType.ASIA_WEST),

    /**
     * Aruba.
     */
    @SerializedName("ABW")
    ARUBA("ABW", ContinentSubRegionType.CARIBBEAN),

    /**
     * Australia.
     */
    @SerializedName("AUS")
    AUSTRALIA("AUS", ContinentSubRegionType.AUSTRALIA_AND_NEW_ZEALAND),

    /**
     * Austria.
     */
    @SerializedName("AUT")
    AUSTRIA("AUT", ContinentSubRegionType.EUROPE_WEST),

    /**
     * Azerbaijan.
     */
    @SerializedName("AZE")
    AZERBAIJAN("AZE", ContinentSubRegionType.ASIA_WEST),

    /**
     * Bahamas.
     */
    @SerializedName("BHS")
    BAHAMAS("BHS", ContinentSubRegionType.CARIBBEAN),

    /**
     * Bahrain.
     */
    @SerializedName("BHR")
    BAHRAIN("BHR", ContinentSubRegionType.ASIA_WEST),

    /**
     * Bangladesh.
     */
    @SerializedName("BGD")
    BANGLADESH("BGD", ContinentSubRegionType.ASIA_SOUTH),

    /**
     * Barbados.
     */
    @SerializedName("BRB")
    BARBADOS("BRB", ContinentSubRegionType.CARIBBEAN),

    /**
     * Belarus.
     */
    @SerializedName("BLR")
    BELARUS("BLR", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Belgium.
     */
    @SerializedName("BEL")
    BELGIUM("BEL", ContinentSubRegionType.EUROPE_WEST),

    /**
     * Belize.
     */
    @SerializedName("BLZ")
    BELIZE("BLZ", ContinentSubRegionType.AMERICA_CENTRAL),

    /**
     * Benin.
     */
    @SerializedName("BEN")
    BENIN("BEN", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Bermuda.
     */
    @SerializedName("BMU")
    BERMUDA("BMU", ContinentSubRegionType.CARIBBEAN),

    /**
     * Bhutan.
     */
    @SerializedName("BTN")
    BHUTAN("BTN", ContinentSubRegionType.ASIA_SOUTH),

    /**
     * Bolivia.
     */
    @SerializedName("BOL")
    BOLIVIA("BOL", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Bonaire, Sint Eustatius and Saba.
     */
    @SerializedName("BES")
    BONAIRE_SINT_EUSTATIUS_SABA("BES", ContinentSubRegionType.CARIBBEAN),

    /**
     * Bosnia and Herzegovina.
     */
    @SerializedName("BIH")
    BOSNIA_AND_HERZEGOVINA("BIH", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Botswana.
     */
    @SerializedName("BWA")
    BOTSWANA("BWA", ContinentSubRegionType.AFRICA_SOUTH),

    /**
     * Bouvet Island.
     */
    @SerializedName("BVT")
    BOUVET_ISLAND("BVT", ContinentSubRegionType.AMERICA_SOUTH), // No round and wave forms!

    /**
     * Brazil.
     */
    @SerializedName("BRA")
    BRAZIL("BRA", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * British Indian Ocean Territory.
     */
    @SerializedName("IOT")
    BRITISH_INDIAN_OCEAN_TERRITORY("IOT", ContinentSubRegionType.AFRICA_EAST), // No round and wave forms!

    /**
     * Virgin Islands (British).
     */
    @SerializedName("VGB")
    BRITISH_VIRGIN_ISLANDS("VGB", ContinentSubRegionType.CARIBBEAN), // No round and wave forms!

    /**
     * Brunei.
     */
    @SerializedName("BRN")
    BRUNEI("BRN", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Bulgaria.
     */
    @SerializedName("BGR")
    BULGARIA("BGR", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Burkina Faso.
     */
    @SerializedName("BFA")
    BURKINA_FASO("BFA", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Burundi.
     */
    @SerializedName("BDI")
    BURUNDI("BDI", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Cape Verde or Cabo Verde.
     */
    @SerializedName("CPV")
    CAPE_VERDE("CPV", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Cambodia.
     */
    @SerializedName("KHM")
    CAMBODIA("KHM", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Cameroon.
     */
    @SerializedName("CMR")
    CAMEROON("CMR", ContinentSubRegionType.AFRICA_CENTRAL),

    /**
     * Canada.
     */
    @SerializedName("CAN")
    CANADA("CAN", ContinentSubRegionType.AMERICA_NORTH),

    /**
     * Cayman Islands.
     */
    @SerializedName("CYM")
    CAYMAN_ISLANDS("CYM", ContinentSubRegionType.CARIBBEAN), // No round and wave forms!

    /**
     * Central African Republic.
     */
    @SerializedName("CAF")
    CENTRAL_AFRICAN_REPUBLIC("CAF", ContinentSubRegionType.AFRICA_CENTRAL),

    /**
     * Chad.
     */
    @SerializedName("TCD")
    CHAD("TCD", ContinentSubRegionType.AFRICA_CENTRAL),

    /**
     * Chile.
     */
    @SerializedName("CHL")
    CHILE("CHL", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * China.
     */
    @SerializedName("CHN")
    CHINA("CHN", ContinentSubRegionType.ASIA_EAST),

    /**
     * Christmas Island.
     */
    @SerializedName("CXR")
    CHRISTMAS_ISLAND("CXR", ContinentSubRegionType.ASIA_SOUTHEAST), // No round and wave forms!

    /**
     * Cocos (Keeling) Islands.
     */
    @SerializedName("CCK")
    COCOS_ISLANDS("CCK", ContinentSubRegionType.ASIA_SOUTHEAST), // No round and wave forms!

    /**
     * Colombia.
     */
    @SerializedName("COL")
    COLOMBIA("COL", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Comoros.
     */
    @SerializedName("COM")
    COMOROS("COM", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Congo (the).
     */
    @SerializedName("COG")
    CONGO("COG", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Congo (the Democratic Republic of the).
     */
    @SerializedName("COD")
    CONGO_DEMOCRATIC_REPUBLIC_OF("COD", ContinentSubRegionType.AFRICA_CENTRAL),

    /**
     * Cook Islands.
     */
    @SerializedName("COK")
    COOK_ISLANDS("COK", ContinentSubRegionType.POLYNESIA), // No round and wave forms!

    /**
     * Costa Rica.
     */
    @SerializedName("CRI")
    COSTA_RICA("CRI", ContinentSubRegionType.AMERICA_CENTRAL),

    /**
     * Croatia.
     */
    @SerializedName("HRV")
    CROATIA("HRV", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Cuba.
     */
    @SerializedName("CUB")
    CUBA("CUB", ContinentSubRegionType.CARIBBEAN),

    /**
     * Curaçao.
     */
    @SerializedName("CUW")
    CURACAO("CUW", ContinentSubRegionType.CARIBBEAN),

    /**
     * Cyprus.
     */
    @SerializedName("CYP")
    CYPRUS("CYP", ContinentSubRegionType.ASIA_WEST),

    /**
     * Czechia (Czech Republic).
     */
    @SerializedName("CZE")
    CZECHIA("CZE", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Denmark.
     */
    @SerializedName("DNK")
    DENMARK("DNK", ContinentSubRegionType.EUROPE_NORTH),

    /**
     * Djibouti.
     */
    @SerializedName("DJI")
    DJIBOUTI("DJI", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Dominica.
     */
    @SerializedName("DMA")
    DOMINICA("DMA", ContinentSubRegionType.CARIBBEAN),

    /**
     * Dominican Republic.
     */
    @SerializedName("DOM")
    DOMINICAN_REPUBLIC("DOM", ContinentSubRegionType.CARIBBEAN),

    /**
     * Ecuador.
     */
    @SerializedName("ECU")
    ECUADOR("ECU", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Egypt.
     */
    @SerializedName("EGY")
    EGYPT("EGY", ContinentSubRegionType.AFRICA_NORTH),

    /**
     * El Salvador.
     */
    @SerializedName("SLV")
    EL_SALVADOR("SLV", ContinentSubRegionType.AMERICA_CENTRAL),

    /**
     * Equatorial Guinea.
     */
    @SerializedName("GNQ")
    EQUATORIAL_GUINEA("GNQ", ContinentSubRegionType.AFRICA_CENTRAL),

    /**
     * Eritrea.
     */
    @SerializedName("ERI")
    ERITREA("ERI", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Estonia.
     */
    @SerializedName("EST")
    ESTONIA("EST", ContinentSubRegionType.EUROPE_NORTH),

    /**
     * Eswatini (Swaziland).
     */
    @SerializedName("SWZ")
    ESWATINI("SWZ", ContinentSubRegionType.AFRICA_SOUTH),

    /**
     * Ethiopia.
     */
    @SerializedName("ETH")
    ETHIOPIA("ETH", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Falkland Islands.
     */
    @SerializedName("FLK")
    FALKLAND_ISLANDS("FLK", ContinentSubRegionType.AMERICA_SOUTH), // No round and wave forms!

    /**
     * Faroe Islands.
     */
    @SerializedName("FRO")
    FAROE_ISLANDS("FRO", ContinentSubRegionType.EUROPE_NORTH),

    /**
     * Fiji.
     */
    @SerializedName("FJI")
    FIJI("FJI", ContinentSubRegionType.MELANESIA),

    /**
     * Finland.
     */
    @SerializedName("FIN")
    FINLAND("FIN", ContinentSubRegionType.EUROPE_NORTH),

    /**
     * France.
     */
    @SerializedName("FRA")
    FRANCE("FRA", ContinentSubRegionType.EUROPE_WEST),

    /**
     * French Guiana.
     */
    @SerializedName("GUF")
    FRENCH_GUIANA("GUF", ContinentSubRegionType.AFRICA_WEST),

    /**
     * French Polynesia.
     */
    @SerializedName("PYF")
    FRENCH_POLYNESIA("PYF", ContinentSubRegionType.POLYNESIA), // No round and wave forms!

    /**
     * French Southern Territories.
     */
    @SerializedName("ATF")
    FRENCH_SOUTHERN_TERRITORIES("ATF", ContinentSubRegionType.ANTARCTICA), // No round and wave forms!

    /**
     * Gabon.
     */
    @SerializedName("GAB")
    GABON("GAB", ContinentSubRegionType.AFRICA_CENTRAL),

    /**
     * Gambia.
     */
    @SerializedName("GMB")
    GAMBIA("GMB", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Georgia.
     */
    @SerializedName("GEO")
    GEORGIA("GEO", ContinentSubRegionType.ASIA_WEST),

    /**
     * Germany.
     */
    @SerializedName("DEU")
    GERMANY("DEU", ContinentSubRegionType.EUROPE_WEST),

    /**
     * Ghana.
     */
    @SerializedName("GHA")
    GHANA("GHA", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Gibraltar.
     */
    @SerializedName("GIB")
    GIBRALTAR("GIB", ContinentSubRegionType.EUROPE_SOUTH), // No round and wave forms!

    /**
     * Greece.
     */
    @SerializedName("GRC")
    GREECE("GRC", ContinentSubRegionType.EUROPE_SOUTH),

    /**
     * Greenland.
     */
    @SerializedName("GRL")
    GREENLAND("GRL", ContinentSubRegionType.ANTARCTICA),

    /**
     * Grenada.
     */
    @SerializedName("GRD")
    GRENADA("GRD", ContinentSubRegionType.CARIBBEAN),

    /**
     * Guadeloupe.
     */
    @SerializedName("GLP")
    GUADELOUPE("GLP", ContinentSubRegionType.CARIBBEAN),

    /**
     * Guam.
     */
    @SerializedName("GUM")
    GUAM("GUM", ContinentSubRegionType.MICRONESIA),

    /**
     * Guatemala.
     */
    @SerializedName("GTM")
    GUATEMALA("GTM", ContinentSubRegionType.AMERICA_CENTRAL),

    /**
     * Guernsey.
     */
    @SerializedName("GGY")
    GUERNSEY("GGY", ContinentSubRegionType.EUROPE_NORTH), // No round and wave forms!

    /**
     * Guinea.
     */
    @SerializedName("GIN")
    GUINEA("GIN", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Guinea-Bissau.
     */
    @SerializedName("GNB")
    GUINEA_BISSAU("GNB", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Guyana.
     */
    @SerializedName("GUY")
    GUYANA("GUY", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * HAITI.
     */
    @SerializedName("HTI")
    HAITI("HTI", ContinentSubRegionType.CARIBBEAN),

    /**
     * Heard Island and Mc Donald Islands.
     */
    @SerializedName("HMD")
    HEARD_ISLAND_AND_MCDONALD_ISLANDS("HMD", ContinentSubRegionType.AUSTRALIA_AND_NEW_ZEALAND), // Australian external territory

    /**
     * Holy See (Vatican city).
     */
    @SerializedName("VAT")
    HOLY_SEE("VAT", ContinentSubRegionType.EUROPE_SOUTH),

    /**
     * Honduras.
     */
    @SerializedName("HND")
    HONDURAS("HND", ContinentSubRegionType.AMERICA_CENTRAL), // ???

    /**
     * Hong Kong.
     */
    @SerializedName("HKG")
    HONG_KONG("HKG", ContinentSubRegionType.ASIA_SOUTHEAST), // ???

    /**
     * Hungary.
     */
    @SerializedName("HUN")
    HUNGARY("HUN", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Iceland.
     */
    @SerializedName("ISL")
    ICELAND("ISL", ContinentSubRegionType.EUROPE_NORTH),

    /**
     * India.
     */
    @SerializedName("IND")
    INDIA("IND", ContinentSubRegionType.ASIA_SOUTH),

    /**
     * Indonesia.
     */
    @SerializedName("IDN")
    INDONESIA("IDN", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Iran (Islamic Republic of).
     */
    @SerializedName("IRN")
    IRAN("IRN", ContinentSubRegionType.ASIA_WEST),

    /**
     * Iraq.
     */
    @SerializedName("IRQ")
    IRAQ("IRQ", ContinentSubRegionType.ASIA_WEST),

    /**
     * Ireland.
     */
    @SerializedName("IRL")
    IRELAND("IRL", ContinentSubRegionType.EUROPE_NORTH),

    /**
     * Isle of Man.
     */
    @SerializedName("IMN")
    ISLE_OF_MAN("IMN", ContinentSubRegionType.EUROPE_NORTH), // No round and wave forms!

    /**
     * Israel.
     */
    @SerializedName("ISR")
    ISRAEL("ISR", ContinentSubRegionType.ASIA_WEST),

    /**
     * Italy.
     */
    @SerializedName("ITA")
    ITALY("ITA", ContinentSubRegionType.EUROPE_SOUTH),

    /**
     * Ivory Coast.
     */
    @SerializedName("CIV")
    IVORY_COAST("CIV", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Jamaica.
     */
    @SerializedName("JAM")
    JAMAICA("JAM", ContinentSubRegionType.CARIBBEAN),

    /**
     * Japan.
     */
    @SerializedName("JPN")
    JAPAN("JPN", ContinentSubRegionType.ASIA_EAST),

    /**
     * Jersey.
     */
    @SerializedName("JEY")
    JERSEY("JEY", ContinentSubRegionType.EUROPE_NORTH), // No round and wave forms!

    /**
     * Jordan.
     */
    @SerializedName("JOR")
    JORDAN("JOR", ContinentSubRegionType.ASIA_WEST),

    /**
     * Kazakhstan.
     */
    @SerializedName("KAZ")
    KAZAKHSTAN("KAZ", ContinentSubRegionType.ASIA_CENTRAL),

    /**
     * Kenya.
     */
    @SerializedName("KEN")
    KENYA("KEN", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Kiribati.
     */
    @SerializedName("KIR")
    KIRIBATI("KIR", ContinentSubRegionType.AUSTRALIA_AND_NEW_ZEALAND),

    /**
     * Korea (the Democratic People's Republic of).
     */
    @SerializedName("PRK")
    KOREA_NORTH("PRK", ContinentSubRegionType.ASIA_EAST),

    /**
     * Korea (the Republic of).
     */
    @SerializedName("KOR")
    KOREA_SOUTH("KOR", ContinentSubRegionType.ASIA_EAST),

    /**
     * Kuwait.
     */
    @SerializedName("KWT")
    KUWAIT("KWT", ContinentSubRegionType.ASIA_WEST),

    /**
     * Kyrgyzstan.
     */
    @SerializedName("KGZ")
    KYRGYZSTAN("KGZ", ContinentSubRegionType.ASIA_CENTRAL),

    /**
     * Lao People's Democratic Republic (the).
     */
    @SerializedName("LAO")
    LAOS("LAO", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Latvia.
     */
    @SerializedName("LVA")
    LATVIA("LVA", ContinentSubRegionType.EUROPE_NORTH),

    /**
     * Lebanon.
     */
    @SerializedName("LBN")
    LEBANON("LBN", ContinentSubRegionType.ASIA_WEST),

    /**
     * Lesotho.
     */
    @SerializedName("LSO")
    LESOTHO("LSO", ContinentSubRegionType.AFRICA_SOUTH),

    /**
     * Liberia.
     */
    @SerializedName("LBR")
    LIBERIA("LBR", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Libya.
     */
    @SerializedName("LBY")
    LIBYA("LBY", ContinentSubRegionType.AFRICA_NORTH),

    /**
     * Liechtenstein.
     */
    @SerializedName("LIE")
    LIECHTENSTEIN("LIE", ContinentSubRegionType.EUROPE_WEST),

    /**
     * Lithuania.
     */
    @SerializedName("LTU")
    LITHUANIA("LTU", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Luxembourg.
     */
    @SerializedName("LUX")
    LUXEMBOURG("LUX", ContinentSubRegionType.EUROPE_WEST),

    /**
     * Macao.
     */
    @SerializedName("MAC")
    MACAO("MAC", ContinentSubRegionType.ASIA_SOUTH),

    /**
     * Macedonia (North).
     */
    @SerializedName("MKD")
    MACEDONIA_NORTH("MKD", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Madagascar.
     */
    @SerializedName("MDG")
    MADAGASCAR("MDG", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Malawi.
     */
    @SerializedName("MWI")
    MALAWI("MWI", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Malaysia.
     */
    @SerializedName("MYS")
    MALAYSIA("MYS", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Maldives.
     */
    @SerializedName("MDV")
    MALDIVES("MDV", ContinentSubRegionType.ASIA_SOUTH),

    /**
     * Mali.
     */
    @SerializedName("MLI")
    MALI("MLI", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Malta.
     */
    @SerializedName("MLT")
    MALTA("MLT", ContinentSubRegionType.EUROPE_SOUTH),

    /**
     * Marshall Islands (the).
     */
    @SerializedName("MHL")
    MARSHALL_ISLANDS("MHL", ContinentSubRegionType.AUSTRALIA_AND_NEW_ZEALAND),

    /**
     * Martinique.
     */
    @SerializedName("MTQ")
    MARTINIQUE("MTQ", ContinentSubRegionType.CARIBBEAN), // French oversea territory.

    /**
     * Mauritania.
     */
    @SerializedName("MRT")
    MAURITANIA("MRT", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Mauritius.
     */
    @SerializedName("MUS")
    MAURITIUS("MUS", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Mayotte.
     */
    @SerializedName("MYT")
    MAYOTTE("MYT", ContinentSubRegionType.AFRICA_EAST), // French oversea territory.

    /**
     * Mexico.
     */
    @SerializedName("MEX")
    MEXICO("MEX", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Micronesia (Federated States of).
     */
    @SerializedName("FSM")
    MICRONESIA("FSM", ContinentSubRegionType.MICRONESIA),

    /**
     * Moldova (the Republic of).
     */
    @SerializedName("MDA")
    MOLDOVA("MDA", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Monaco.
     */
    @SerializedName("MCO")
    MONACO("MCO", ContinentSubRegionType.EUROPE_WEST),

    /**
     * Mongolia.
     */
    @SerializedName("MNG")
    MONGOLIA("MNG", ContinentSubRegionType.ASIA_EAST),

    /**
     * Montenegro.
     */
    @SerializedName("MNE")
    MONTENEGRO("MNE", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Montserrat.
     */
    @SerializedName("MSR")
    MONTSERRAT("MSR", ContinentSubRegionType.CARIBBEAN), // No round and wave forms!

    /**
     * Morocco.
     */
    @SerializedName("MAR")
    MOROCCO("MAR", ContinentSubRegionType.AFRICA_NORTH),

    /**
     * Mozambique.
     */
    @SerializedName("MOZ")
    MOZAMBIQUE("MOZ", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Myanmar.
     */
    @SerializedName("MMR")
    MYANMAR("MMR", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Namibia.
     */
    @SerializedName("NAM")
    NAMIBIA("NAM", ContinentSubRegionType.AFRICA_SOUTH),

    /**
     * Nauru.
     */
    @SerializedName("NRU")
    NAURU("NRU", ContinentSubRegionType.AUSTRALIA_AND_NEW_ZEALAND),

    /**
     * Nepal.
     */
    @SerializedName("NPL")
    NEPAL("NPL", ContinentSubRegionType.ASIA_SOUTH),

    /**
     * Netherlands (the).
     */
    @SerializedName("NLD")
    NETHERLANDS("NLD", ContinentSubRegionType.EUROPE_WEST),

    /**
     * New Caledonia.
     */
    @SerializedName("NCL")
    NEW_CALEDONIA("NCL", ContinentSubRegionType.MELANESIA),

    /**
     * New Zealand.
     */
    @SerializedName("NZL")
    NEW_ZEALAND("NZL", ContinentSubRegionType.POLYNESIA),

    /**
     * Nicaragua.
     */
    @SerializedName("NIC")
    NICARAGUA("NIC", ContinentSubRegionType.AMERICA_CENTRAL),

    /**
     * Niger (the).
     */
    @SerializedName("NER")
    NIGER("NER", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Nigeria.
     */
    @SerializedName("NGA")
    NIGERIA("NGA", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Niue.
     */
    @SerializedName("NIU")
    NIUE("NIU", ContinentSubRegionType.POLYNESIA),

    /**
     * Norfolk Island.
     */
    @SerializedName("NFK")
    NORFOLK_ISLAND("NFK", ContinentSubRegionType.POLYNESIA), // No round and wave forms!

    /**
     * Northern Mariana Islands (the).
     */
    @SerializedName("MNP")
    NORTHERN_MARIANA_ISLANDS("MNP", ContinentSubRegionType.AUSTRALIA_AND_NEW_ZEALAND),

    /**
     * Norway.
     */
    @SerializedName("NOR")
    NORWAY("NOR", ContinentSubRegionType.EUROPE_NORTH),

    /**
     * Oman.
     */
    @SerializedName("OMN")
    OMAN("OMN", ContinentSubRegionType.ASIA_WEST),

    /**
     * Pakistan.
     */
    @SerializedName("PAK")
    PAKISTAN("PAK", ContinentSubRegionType.ASIA_SOUTH),

    /**
     * Palau.
     */
    @SerializedName("PLW")
    PALAU("PLW", ContinentSubRegionType.AUSTRALIA_AND_NEW_ZEALAND),

    /**
     * Palestine, State of.
     */
    @SerializedName("PSE")
    PALESTINE("PSE", ContinentSubRegionType.ASIA_WEST),

    /**
     * Panama.
     */
    @SerializedName("PAN")
    PANAMA("PAN", ContinentSubRegionType.AMERICA_CENTRAL),

    /**
     * Papua New Guinea.
     */
    @SerializedName("PNG")
    PAPUA_NEW_GUINEA("PNG", ContinentSubRegionType.MELANESIA),

    /**
     * Paraguay.
     */
    @SerializedName("PRY")
    PARAGUAY("PRY", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Peru.
     */
    @SerializedName("PER")
    PERU("PER", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Philippines (the).
     */
    @SerializedName("PHL")
    PHILIPPINES("PHL", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Pitcairn.
     */
    @SerializedName("PCN")
    PITCAIRN("PCN", ContinentSubRegionType.POLYNESIA), // No round and wave forms!

    /**
     * Poland.
     */
    @SerializedName("POL")
    POLAND("POL", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Portugal.
     */
    @SerializedName("PRT")
    PORTUGAL("PRT", ContinentSubRegionType.EUROPE_SOUTH),

    /**
     * Puerto Rico.
     */
    @SerializedName("PRI")
    PUERTO_RICO("PRI", ContinentSubRegionType.CARIBBEAN),

    /**
     * Qatar.
     */
    @SerializedName("QAT")
    QATAR("QAT", ContinentSubRegionType.ASIA_WEST),

    /**
     * Réunion.
     */
    @SerializedName("REU")
    REUNION("REU", ContinentSubRegionType.AFRICA_EAST), // French oversea territory.

    /**
     * Romania.
     */
    @SerializedName("ROU")
    ROMANIA("ROU", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Russian Federation (the).
     */
    @SerializedName("RUS")
    RUSSIAN_FEDERATION("RUS", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Rwanda.
     */
    @SerializedName("RWA")
    RWANDA("RWA", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Saint Barthélemy.
     */
    @SerializedName("BLM")
    SAINT_BARTHELEMY("BLM", ContinentSubRegionType.CARIBBEAN), // French oversea territory.

    /**
     * Saint Helena, Ascension Island, Tristan da Cunha.
     */
    @SerializedName("SHN")
    SAINT_HELENA_ASCENSION_AND_TRISTAN_DA_CUNHA("SHN", ContinentSubRegionType.AFRICA_WEST), // No round and wave forms!

    /**
     * Saint Kitts and Nevis.
     */
    @SerializedName("KNA")
    SAINT_KITTS_AND_NEVIS("KNA", ContinentSubRegionType.CARIBBEAN),

    /**
     * Saint Lucia.
     */
    @SerializedName("LCA")
    SAINT_LUCIA("LCA", ContinentSubRegionType.CARIBBEAN),

    /**
     * Saint Martin (French part).
     */
    @SerializedName("MAF")
    SAINT_MARTIN("MAF", ContinentSubRegionType.CARIBBEAN),

    /**
     * Saint Pierre and Miquelon.
     */
    @SerializedName("SPM")
    SAINT_PIERRE_AND_MIQUELON("SPM", ContinentSubRegionType.AMERICA_NORTH), // French oversea territory.

    /**
     * Saint Vincent and the Grenadines.
     */
    @SerializedName("VCT")
    SAINT_VINCENT_AND_THE_GRENADINES("VCT", ContinentSubRegionType.CARIBBEAN),

    /**
     * Samoa.
     */
    @SerializedName("WSM")
    SAMOA("WSM", ContinentSubRegionType.POLYNESIA),

    /**
     * San Marino.
     */
    @SerializedName("SMR")
    SAN_MARINO("SMR", ContinentSubRegionType.EUROPE_SOUTH),

    /**
     * Sao Tome and Principe.
     */
    @SerializedName("STP")
    SAO_TOME_AND_PRINCIPE("STP", ContinentSubRegionType.AFRICA_CENTRAL),

    /**
     * Saudi Arabia.
     */
    @SerializedName("SAU")
    SAUDI_ARABIA("SAU", ContinentSubRegionType.ASIA_WEST),

    /**
     * Senegal.
     */
    @SerializedName("SEN")
    SENEGAL("SEN", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Serbia.
     */
    @SerializedName("SRB")
    SERBIA("SRB", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Seychelles.
     */
    @SerializedName("SYC")
    SEYCHELLES("SYC", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Sierra Leone.
     */
    @SerializedName("SLE")
    SIERRA_LEONE("SLE", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Singapore.
     */
    @SerializedName("SGP")
    SINGAPORE("SGP", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Sint Maarten (Dutch part).
     */
    @SerializedName("SXM")
    SINT_MAARTEN("SXM", ContinentSubRegionType.CARIBBEAN), // No round and wave forms!

    /**
     * Slovakia.
     */
    @SerializedName("SVK")
    SLOVAKIA("SVK", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Slovenia.
     */
    @SerializedName("SVN")
    SLOVENIA("SVN", ContinentSubRegionType.EUROPE_EAST),

    /**
     * Solomon Islands.
     */
    @SerializedName("SLB")
    SOLOMON_ISLANDS("SLB", ContinentSubRegionType.MELANESIA),

    /**
     * Somalia.
     */
    @SerializedName("SOM")
    SOMALIA("SOM", ContinentSubRegionType.AFRICA_EAST),

    /**
     * South Africa.
     */
    @SerializedName("ZAF")
    SOUTH_AFRICA("ZAF", ContinentSubRegionType.AFRICA_SOUTH),

    /**
     * South Georgia and the South Sandwich Islands.
     */
    @SerializedName("SGS")
    SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS("SGS", ContinentSubRegionType.AMERICA_SOUTH), // No round and wave forms!

    /**
     * Spain.
     */
    @SerializedName("ESP")
    SPAIN("ESP", ContinentSubRegionType.EUROPE_SOUTH),

    /**
     * Sri Lanka.
     */
    @SerializedName("LKA")
    SRI_LANKA("LKA", ContinentSubRegionType.ASIA_SOUTH),

    /**
     * Sudan (the).
     */
    @SerializedName("SDN")
    SUDAN("SDN", ContinentSubRegionType.AFRICA_EAST),

    /**
     * South Sudan.
     */
    @SerializedName("SSD")
    SUDAN_SOUTH("SSD", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Suriname.
     */
    @SerializedName("SUR")
    SURINAME("SUR", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Svalbard and Jan Mayen.
     */
    @SerializedName("SJM")
    SVALBARD_AND_JAN_MAYEN("SJM", ContinentSubRegionType.EUROPE_NORTH), // Norway external territory.

    /**
     * Sweden.
     */
    @SerializedName("SWE")
    SWEDEN("SWE", ContinentSubRegionType.EUROPE_NORTH),

    /**
     * Switzerland.
     */
    @SerializedName("CHE")
    SWITZERLAND("CHE", ContinentSubRegionType.EUROPE_WEST),

    /**
     * Syrian Arab Republic (the).
     */
    @SerializedName("SYR")
    SYRIA("SYR", ContinentSubRegionType.ASIA_WEST),

    /**
     * Taiwan (Province of China).
     */
    @SerializedName("TWN")
    TAIWAN("TWN", ContinentSubRegionType.ASIA_EAST),

    /**
     * Tajikistan.
     */
    @SerializedName("TJK")
    TAJIKISTAN("TJK", ContinentSubRegionType.ASIA_CENTRAL),

    /**
     * Tanzania, the United Republic of.
     */
    @SerializedName("TZA")
    TANZANIA("TZA", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Thailand.
     */
    @SerializedName("THA")
    THAILAND("THA", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Timor-Leste.
     */
    @SerializedName("TLS")
    TIMOR_LESTE("TLS", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Togo.
     */
    @SerializedName("TGO")
    TOGO("TGO", ContinentSubRegionType.AFRICA_WEST),

    /**
     * Tokelau.
     */
    @SerializedName("TKL")
    TOKELAU("TKL", ContinentSubRegionType.POLYNESIA), // No round and wave forms!

    /**
     * Tonga.
     */
    @SerializedName("TON")
    TONGA("TON", ContinentSubRegionType.POLYNESIA),

    /**
     * Trinidad and Tobago.
     */
    @SerializedName("TTO")
    TRINIDAD_AND_TOBAGO("TTO", ContinentSubRegionType.CARIBBEAN),

    /**
     * Tunisia.
     */
    @SerializedName("TUN")
    TUNISIA("TUN", ContinentSubRegionType.AFRICA_NORTH),

    /**
     * Turkey.
     */
    @SerializedName("TUR")
    TURKEY("TUR", ContinentSubRegionType.ASIA_WEST),

    /**
     * Turkmenistan.
     */
    @SerializedName("TKM")
    TURKMENISTAN("TKM", ContinentSubRegionType.ASIA_CENTRAL),

    /**
     * Turks and Caicos Islands (the).
     */
    @SerializedName("TCA")
    TURKS_AND_CAICOS_ISLANDS("TCA", ContinentSubRegionType.CARIBBEAN), // No round and wave forms!

    /**
     * Tuvalu.
     */
    @SerializedName("TUV")
    TUVALU("TUV", ContinentSubRegionType.POLYNESIA),

    /**
     * Uganda.
     */
    @SerializedName("UGA")
    UGANDA("UGA", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Ukraine.
     */
    @SerializedName("UKR")
    UKRAINE("UKR", ContinentSubRegionType.EUROPE_EAST),

    /**
     * United Arab Emirates (the).
     */
    @SerializedName("ARE")
    UNITED_ARAB_EMIRATES("ARE", ContinentSubRegionType.ASIA_WEST),

    /**
     * Great Britain and Northern Ireland (the).
     */
    @SerializedName("GBR")
    GREAT_BRITAIN("GBR", ContinentSubRegionType.EUROPE_WEST),

    /**
     * United States of America (the).
     */
    @SerializedName("USA")
    UNITED_STATES("USA", ContinentSubRegionType.AMERICA_NORTH),

    /**
     * United States Minor Outlying Islands (the).
     */
    @SerializedName("UMI")
    UNITED_STATES_MINOR_OUTLYING_ISLANDS("UMI", ContinentSubRegionType.CARIBBEAN), // United States external territory.

    /**
     * Uruguay.
     */
    @SerializedName("URY")
    URUGUAY("URY", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Virgin Islands (U.S.).
     */
    @SerializedName("VIR")
    US_VIRGIN_ISLANDS("VIR", ContinentSubRegionType.CARIBBEAN), // No round and wave forms!

    /**
     * Uzbekistan.
     */
    @SerializedName("UZB")
    UZBEKISTAN("UZB", ContinentSubRegionType.ASIA_CENTRAL),

    /**
     * Vanuatu.
     */
    @SerializedName("VUT")
    VANUATU("VUT", ContinentSubRegionType.MELANESIA),

    /**
     * Venezuela (Bolivian Republic of).
     */
    @SerializedName("VEN")
    VENEZUELA("VEN", ContinentSubRegionType.AMERICA_SOUTH),

    /**
     * Vietnam.
     */
    @SerializedName("VNM")
    VIETNAM("VNM", ContinentSubRegionType.ASIA_SOUTHEAST),

    /**
     * Wallis and Futuna.
     */
    @SerializedName("WLF")
    WALLIS_AND_FUTUNA("WLF", ContinentSubRegionType.POLYNESIA), // No round and wave forms!

    // TODO Is this a country? According to Wikipedia it's a land area controlled by the Morocco and the SADR
    /**
     * Western Sahara.
     */
    @SerializedName("ESH")
    WESTERN_SAHARA("ESH", ContinentSubRegionType.AFRICA_NORTH), // No round and wave forms!

    /**
     * Yemen.
     */
    @SerializedName("YEM")
    YEMEN("YEM", ContinentSubRegionType.ASIA_WEST),

    /**
     * Zambia.
     */
    @SerializedName("ZMB")
    ZAMBIA("ZMB", ContinentSubRegionType.AFRICA_EAST),

    /**
     * Zimbabwe.
     */
    @SerializedName("ZWE")
    ZIMBABWE("ZWE", ContinentSubRegionType.AFRICA_EAST);

    /**
     * Represents the resource bundle pathname.
     */
    private static final String BUNDLE_NAME = "i18n/country";

    /**
     * Represents the generic path to access the term 'definition' property.
     */
    private static final String BUNDLE_PATH_FOR_TERM_DEFINITION = "country.definition";

    /**
     * Represents the generic path to access the 'name' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_NAME = "country.${this}.name";

    /**
     * Represents the generic path to access the 'description' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION = "country.${this}.description";

    /**
     * Represents the generic path to access the 'anthem' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_ANTHEM = "country.${this}.anthem";

    /**
     * Represents the generic path to access the 'motto' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_MOTTO = "country.${this}.motto";

    /**
     * Represents the generic path to access the 'official' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_OFFICIAL = "country.${this}.official";

    /**
     * Country type icon flag resource base folder path.
     */
    private static final transient String ICON_FOLDER_PATH = "./flag/";

    /**
     * PNG image file extension.
     */
    private static final transient String ICON_EXTENSION_PNG = ".png";

    /**
     * GIF image file extension.
     */
    private static final transient String ICON_EXTENSION_GIF = ".gif";

    /**
     * ISO-3166 alpha 3 country code.
     */
    @Getter
    private final String isoAlpha3;

    /**
     * Country locale.
     */
    @Getter
    private final transient Locale locale;

    /**
     * Continent's sub-region the country belongs to.
     */
    @Getter
    private final transient ContinentSubRegionType subRegionType;

    /**
     * Creates a country type.
     * @param isoAlpha3 Country ISO-3166 alpha 3 code.
     * @param subRegionType Continent's sub-region type.
     */
    CountryType(final @NonNull String isoAlpha3, final @NonNull ContinentSubRegionType subRegionType)
    {
        this.locale = new Locale(isoAlpha3);
        this.isoAlpha3 = isoAlpha3;
        this.subRegionType = subRegionType;
    }

    /**
     * Creates a {@link CountryType} entity given its ISO-3166 Alpha 3 code.
     * @param isoAlpha3 Country ISO-3166 Alpha 3 code.
     * @return {@link CountryType}.
     * @throws CountryException Thrown to indicate that an error occurred while manipulating a country.
     */
    public static CountryType from(final @NonNull String isoAlpha3) throws CountryException
    {
        Optional<CountryType> result = Arrays.stream(CountryType.values()).filter(v -> v.isoAlpha3.equals(isoAlpha3)).findAny();
        if (result.isEmpty())
        {
            throw new CountryException(String.format("Cannot find a country with ISO Alpha-3 code: '%s'", isoAlpha3));
        }

        return result.get();
    }

    /**
     * Saves a country flag icon using its original size and format.
     * @param iconFormatType Icon type.
     * @param destinationPath Destination folder path where to save the country flag icon.
     * @return Saved icon image path name.
     * @throws ImageException Thrown to indicate an error occurred while manipulating an image file.
     */
    public final String saveIcon(final IconFormatType iconFormatType, final @NonNull String destinationPath) throws ImageException
    {
        return saveIcon(ImageFileType.PNG, iconFormatType,ImageScaleType.IMAGE_SCALE_DEFAULT,destinationPath,isoAlpha3);
    }

    /**
     * Saves a country flag icon using its original size.
     * @param imageFileType Image format type.
     * @param iconFormatType Icon type.
     * @param destinationPath Destination folder path where to save the country flag icon.
     * @return Saved icon image path name.
     * @throws ImageException Thrown to indicate an error occurred while manipulating an image file.
     */
    public final String saveIcon(final ImageFileType imageFileType, final IconFormatType iconFormatType, final @NonNull String destinationPath) throws ImageException
    {
        return saveIcon(imageFileType, iconFormatType,ImageScaleType.IMAGE_SCALE_DEFAULT,destinationPath,isoAlpha3);
    }

    /**
     * Saves a country flag icon.
     * @param imageFileType Image format type.
     * @param iconFormatType Icon type.
     * @param iconScaleType Icon scale type.
     * @param destinationPath Destination folder path where to save the country flag icon.
     * @return Saved icon image path name.
     * @throws ImageException Thrown to indicate an error occurred while manipulating an image file.
     */
    public final String saveIcon(final ImageFileType imageFileType, final IconFormatType iconFormatType, final ImageScaleType iconScaleType, final @NonNull String destinationPath) throws ImageException
    {
        return saveIcon(imageFileType,iconFormatType,iconScaleType,destinationPath,isoAlpha3);
    }

    /**
     * Saves a country flag icon.
     * @param iconFormatType Icon type.
     * @param iconScaleType Icon scale type.
     * @param destinationPath Destination folder path where to save the country flag icon.
     * @return Saved icon image path name.
     * @throws ImageException Thrown to indicate an error occurred while manipulating an image file.
     */
    public final String saveIcon(final IconFormatType iconFormatType, final ImageScaleType iconScaleType, final @NonNull String destinationPath) throws ImageException
    {
        return saveIcon(ImageFileType.PNG,iconFormatType,iconScaleType,destinationPath,isoAlpha3);
    }

    /**
     * Saves a country flag icon.
     * @param imageFileType Image format type.
     * @param iconFormatType Icon type.
     * @param iconScaleType Icon scale type.
     * @param destinationPath Destination folder path where to save the country flag icon.
     * @param imageName Image file name (optional).
     * @return Saved icon image path name.
     * @throws ImageException Thrown to indicate an error occurred while manipulating an image file.
     */
    public final String saveIcon(final ImageFileType imageFileType, final IconFormatType iconFormatType, final ImageScaleType iconScaleType, final @NonNull String destinationPath, final @NonNull String imageName) throws ImageException
    {
        return ImageHelper.saveIcon(getIconPathName(iconFormatType),iconScaleType,imageFileType,destinationPath,imageName);
    }

    /**
     * Returns a country icon flag path name given an icon format.
     * @param format Icon format.
     * @return Icon path name.
     */
    private String getIconPathName(final @NonNull IconFormatType format)
    {
        String iconPath;

        switch (format)
        {
            case FORMAT_WAVE:
                iconPath = ICON_FOLDER_PATH + "wave/" + this.isoAlpha3 + ICON_EXTENSION_PNG;
                break;
            case FORMAT_ROUND:
                iconPath = ICON_FOLDER_PATH + "round/" + this.isoAlpha3 + ICON_EXTENSION_PNG;
                break;
            case FORMAT_SQUARE:
            default:
                iconPath = ICON_FOLDER_PATH + "square/" + this.isoAlpha3 + ICON_EXTENSION_PNG;
        }

        return iconPath;
    }

    /**
     * Retrieves a country flag icon.
     * @param iconFormatType Icon type.
     * @param iconScaleType Icon scale type.
     * @return {@link BufferedImage} containing the country flag icon.
     * @throws ImageException Thrown to indicate an error occurred while manipulating an image file.
     */
    public final BufferedImage getIcon(final IconFormatType iconFormatType, final ImageScaleType iconScaleType) throws ImageException
    {
        return ImageHelper.getIcon(getIconPathName(iconFormatType), iconScaleType);
    }

    /**
     * Returns the continent type this country belongs to.
     * @return {@link ContinentType}.
     */
    public final ContinentType getContinentType()
    {
        return this.getSubRegionType().getContinentType();
    }

    /**
     * Returns the localized term definition of a country in the current locale.
     * @return Localized term definition of a country.
     */
    public final String getTermDefinition()
    {
        return getTermDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized term definition of a country in the given locale.
     * @param locale Locale to use.
     * @return Term definition of a country.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_TERM_DEFINITION)
    public static String getTermDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(CountryType.class, locale);
    }

    /**
     * Returns the localized country name using the current locale set.
     * @return Localized country name.
     */
    public final String getName()
    {
        return getName(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized country name using the given locale.
     * @param locale Locale.
     * @return Localized country name.
     */
    @Localize(bundle = CountryType.BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_NAME)
    public final String getName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized country official name using the current locale set.
     * @return Localized country official name.
     */
    public final String getOfficialName()
    {
        return getOfficialName(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the country official name using the current locale set.
     * @param locale Locale.
     * @return Localized country official name.
     */
    @Localize(bundle = CountryType.BUNDLE_NAME, key = CountryType.BUNDLE_PATH_FOR_PROPERTY_OFFICIAL)
    public final String getOfficialName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized country description using the current locale set.
     * @return Localized country description.
     */
    public final String getDescription()
    {
        return getDescription(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized country description using the given locale.
     * @param locale Locale.
     * @return Localized country description.
     */
    @Localize(bundle = CountryType.BUNDLE_NAME, key = CountryType.BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION)
    public final String getDescription(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized country motto using the current locale set.
     * @return Localized country motto.
     */
    public final String getMotto()
    {
        return getMotto(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized country motto using the given locale.
     * @param locale Locale.
     * @return Localized country motto.
     */
    @Localize(bundle = CountryType.BUNDLE_NAME, key = CountryType.BUNDLE_PATH_FOR_PROPERTY_MOTTO)
    public final String getMotto(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized country anthem using the current locale set.
     * @return Localized country anthem.
     */
    public final String getAnthem()
    {
        return getAnthem(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized country anthem using the given locale.
     * @param locale Locale.
     * @return Localized country anthem.
     */
    @Localize(bundle = CountryType.BUNDLE_NAME, key = CountryType.BUNDLE_PATH_FOR_PROPERTY_ANTHEM)
    public final String getAnthem(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }
}
