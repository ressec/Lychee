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
import lombok.NonNull;
import org.ressec.lychee.localization.base.Localize;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;

import java.util.Locale;

/**
 * A localized enumeration providing the available values of the available hemisphere types.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public enum HemisphereType
{
    /**
     * North.
     */
    @SerializedName("North")
    NORTH,

    /**
     * South.
     */
    @SerializedName("South")
    SOUTH;

    /**
     * Represents the resource bundle pathname.
     */
    private static final String BUNDLE_NAME = "i18n/hemisphere";

    /**
     * Represents the generic path to access the term 'definition' property.
     */
    private static final String BUNDLE_PATH_FOR_TERM_DEFINITION = "hemisphere.definition";

    /**
     * Represents the generic path to access the 'name' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_NAME = "hemisphere.${this}.name";

    /**
     * Represents the generic path to access the 'description' property.
     */
    private static final String BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION = "hemisphere.${this}.description";

    /**
     * Returns the localized definition of the hemisphere in the current locale.
     * @return Definition of the hemisphere.
     */
    public static String getTermDefinition()
    {
        return getTermDefinition(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized definition of the hemisphere in the given locale.
     * @param locale Locale to use.
     * @return Definition of the hemisphere.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_TERM_DEFINITION)
    public static String getTermDefinition(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(HemisphereType.class, locale);
    }

    /**
     * Returns the localized name of the hemisphere enumerated value in the current locale.
     * @return Name of the hemisphere.
     */
    public final String getName()
    {
        return getName(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized name of the hemisphere enumerated value in the given locale.
     * @param locale Locale to use.
     * @return Name of the hemisphere.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_NAME)
    public final String getName(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }

    /**
     * Returns the localized description of the hemisphere enumerated value in the current locale.
     * @return Description of the hemisphere.
     */
    public final String getDescription()
    {
        return getDescription(ResourceBundleManager.getInstance().getLocale());
    }

    /**
     * Returns the localized description of the hemisphere enumerated value in the given locale.
     * @param locale Locale to use.
     * @return Description of the hemisphere.
     */
    @Localize(bundle = BUNDLE_NAME, key = BUNDLE_PATH_FOR_PROPERTY_DESCRIPTION)
    public final String getDescription(final @NonNull Locale locale)
    {
        return ResourceBundleManager.getInstance().resolve(this, locale);
    }
}
