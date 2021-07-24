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
package org.ressec.lychee.localization.base;

import lombok.NonNull;
import org.ressec.lychee.localization.bundle.ResourceBundleManager;

import java.io.Serializable;
import java.util.Locale;

/**
 * Entities implementing this interface gain the ability to have their elements annotated with the {@link Localize}
 * annotation automatically and transparently localized by invoking the {@link Localizable#localize()} services.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public interface Localizable extends Serializable
{
    /**
     * Localizes all entities (annotated fields and annotated methods) implementing the {@link Localizable} interface
     * using the locale set in {@link ResourceBundleManager}.
     * @return Locale used to realize the localization.
     */
    default Locale localize()
    {
        ResourceBundleManager.getInstance().resolveLocalizable(this, ResourceBundleManager.getInstance().getLocale());
        return ResourceBundleManager.getInstance().getLocale();
    }

    /**
     * Localizes all entities (annotated fields and annotated methods) implementing the {@link Localizable} interface
     * using the provided locale.
     * @param locale Locale.
     * @return Locale used to realize the localization.
     */
    default Locale localize(@NonNull Locale locale)
    {
        ResourceBundleManager.getInstance().resolveLocalizable(this, locale);
        return locale;
    }

    /**
     * Localizes all entities (annotated fields and annotated methods) implementing the {@link Localizable} interface
     * using the provided locale.
     * @param locale Locale.
     * @param previous Previous locale used for a localization.
     * @return Locale used to realize the localization.
     */
    default Locale localize(final @NonNull Locale locale, final @NonNull Locale previous)
    {
        if (!locale.equals(previous))
        {
            ResourceBundleManager.getInstance().resolveLocalizable(this, locale);
        }

        return locale;
    }
}