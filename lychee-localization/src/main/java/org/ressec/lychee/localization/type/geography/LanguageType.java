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
package org.ressec.lychee.localization.type.geography;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NonNull;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;

import java.util.Locale;

/**
 * A localized enumeration representing the languages supported by a {@link Locale}.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 * @see Localize
 * @see ResourceBundleManager
 */
public enum LanguageType
{
    /**
     * Albanian.
     */
    @SerializedName("Albanian")
    ALBANIAN(Locale.forLanguageTag("sq_AL")),

    /**
     * Arabic.
     */
    @SerializedName("Arabic")
    ARABIC(Locale.forLanguageTag("ar")),

    /**
     * Belarusian.
     */
    @SerializedName("Belarusian")
    BELARUSIAN(Locale.forLanguageTag("be")),

    /**
     * Bulgarian.
     */
    @SerializedName("Bulgarian")
    BULGARIAN(Locale.forLanguageTag("bg")),

    /**
     * Catalan.
     */
    @SerializedName("Catalan")
    CATALAN(Locale.forLanguageTag("ca_ES")),

    /**
     * Chinese (simplified).
     */
    @SerializedName("Chinese")
    CHINESE(Locale.forLanguageTag("zh")),

    /**
     * Croatian.
     */
    @SerializedName("Croatian")
    CROATIAN(Locale.forLanguageTag("hr")),

    /**
     * Czech.
     */
    @SerializedName("Czech")
    CZECH(Locale.forLanguageTag("cs")),

    /**
     * Danish.
     */
    @SerializedName("Danish")
    DANISH(Locale.forLanguageTag("da")),

    /**
     * Dutch.
     */
    @SerializedName("Dutch")
    DUTCH(Locale.forLanguageTag("nl")),

    /**
     * English.
     */
    @SerializedName("English")
    ENGLISH(Locale.forLanguageTag("en")),

    /**
     * Estonian.
     */
    @SerializedName("Estonian")
    ESTONIAN(Locale.forLanguageTag("et")),

    /**
     * Finnish.
     */
    @SerializedName("Finnish")
    FINNISH(Locale.forLanguageTag("fi")),

    /**
     * French.
     */
    @SerializedName("French")
    FRENCH(Locale.forLanguageTag("fr")),

    /**
     * German.
     */
    @SerializedName("German")
    GERMAN(Locale.forLanguageTag("de")),

    /**
     * Greek.
     */
    @SerializedName("Greek")
    GREEK(Locale.forLanguageTag("el")),

    /**
     * Hebrew.
     */
    @SerializedName("Hebrew")
    HEBREW(Locale.forLanguageTag("iw")),

    /**
     * HINDI.
     */
    @SerializedName("Hindi")
    HINDI(Locale.forLanguageTag("hi")),

    /**
     * Hungarian.
     */
    @SerializedName("Hungarian")
    HUNGARIAN(Locale.forLanguageTag("hu")),

    /**
     * Icelandic.
     */
    @SerializedName("Icelandic")
    ICELANDIC(Locale.forLanguageTag("is")),

    /**
     * Indonesian.
     */
    @SerializedName("Indonesian")
    INDONESIAN(Locale.forLanguageTag("in")),

    /**
     * Irish.
     */
    @SerializedName("Irish")
    IRISH(Locale.forLanguageTag("ga")),

    /**
     * Italian.
     */
    @SerializedName("Italian")
    ITALIAN(Locale.forLanguageTag("it")),

    /**
     * Japanese.
     */
    @SerializedName("Japanese")
    JAPANESE(Locale.forLanguageTag("ja")),

    /**
     * Korean.
     */
    @SerializedName("Korean")
    KOREAN(Locale.forLanguageTag("ko")),

    /**
     * Latvian.
     */
    @SerializedName("Latvian")
    LATVIAN(Locale.forLanguageTag("lv")),

    /**
     * Lithuanian.
     */
    @SerializedName("Lithuanian")
    LITHUANIAN(Locale.forLanguageTag("lt")),

    /**
     * Macedonian.
     */
    @SerializedName("Macedonian")
    MACEDONIAN(Locale.forLanguageTag("mk")),

    /**
     * Malay.
     */
    @SerializedName("Malay")
    MALAY(Locale.forLanguageTag("ms")),

    /**
     * Maltese.
     */
    @SerializedName("Maltese")
    MALTESE(Locale.forLanguageTag("mt")),

    /**
     * Norwegian.
     */
    @SerializedName("Norwegian")
    NORWEGIAN(Locale.forLanguageTag("no")),

    /**
     * Polish.
     */
    @SerializedName("Polish")
    POLISH(Locale.forLanguageTag("pl")),

    /**
     * Portuguese.
     */
    @SerializedName("Portuguese")
    PORTUGUESE(Locale.forLanguageTag("pt")),

    /**
     * Romanian.
     */
    @SerializedName("Romanian")
    ROMANIAN(Locale.forLanguageTag("ro")),

    /**
     * Russian.
     */
    @SerializedName("Russian")
    RUSSIAN(Locale.forLanguageTag("ru")),

    /**
     * Serbian.
     */
    @SerializedName("Serbian")
    SERBIAN(Locale.forLanguageTag("sr")),

    /**
     * Slovak.
     */
    @SerializedName("Slovak")
    SLOVAK(Locale.forLanguageTag("sk")),

    /**
     * Slovenian.
     */
    @SerializedName("Slovenian")
    SLOVENIAN(Locale.forLanguageTag("sl")),

    /**
     * Spanish.
     */
    @SerializedName("Spanish")
    SPANISH(Locale.forLanguageTag("es")),

    /**
     * Swedish.
     */
    @SerializedName("Swedish")
    SWEDISH(Locale.forLanguageTag("sv")),

    /**
     * Thai.
     */
    @SerializedName("Thai")
    THAI(Locale.forLanguageTag("th")),

    /**
     * Turkish.
     */
    @SerializedName("Turkish")
    TURKISH(Locale.forLanguageTag("tr")),

    /**
     * Ukrainian.
     */
    @SerializedName("Ukrainian")
    UKRAINIAN(Locale.forLanguageTag("uk")),

    /**
     * Vietnamese.
     */
    @SerializedName("Vietnamese")
    VIETNAMESE(Locale.forLanguageTag("vi"));

    /**
     * Underlying locale.
     */
    @Getter
    private final Locale locale;

    /**
     * Represents the language resource bundle pathname.
     */
    private static final String BUNDLE_NAME_LANGUAGE = "i18n/language";

    /**
     * Represents the generic path to access the term 'definition' property.
     */
    private static final String BUNDLE_PATH_FOR_TERM_DEFINITION = "language.definition";

    /**
     * Represents the generic path to access the 'name' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_NAME = "language.${this}.name";

    /**
     * Represents the generic path to access the 'description' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION = "language.${this}.description";

    LanguageType(final @NonNull Locale locale)
    {
        this.locale = locale;
    }

    /**
     * Returns the localized term definition of a language in the current locale.
     * @return Term definition of a language.
     */
    public static String getTermDefinition()
    {
        return getTermDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized term definition of a language in the given locale.
     * @param locale Locale to use.
     * @return Term definition of a language.
     */
    @Localize(bundle = BUNDLE_NAME_LANGUAGE, key = BUNDLE_PATH_FOR_TERM_DEFINITION)
    public static String getTermDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(LanguageType.class, locale);
    }

    /**
     * Returns the localized name of the language in the current locale.
     * @return Localized name of the language.
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
    @Localize(bundle = BUNDLE_NAME_LANGUAGE, key = BUNDLE_PATH_FOR_PROPERTY_NAME)
    public final String getName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized description of the language in the current locale.
     * @return Localized description of the language.
     */
    public final String getDescription()
    {
        return getDescription(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized description of the language in the given locale.
     * @param locale Locale to use.
     * @return Localized description of the language.
     */
    @Localize(bundle = BUNDLE_NAME_LANGUAGE, key = BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION)
    public final String getDescription(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }
}
