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

import java.lang.annotation.*;

/**
 * Annotation used to annotate methods and fields.<br>
 * Elements annotated with the {@code Localization} annotation are naturally localizable entities.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE } )
public @interface Localize
{
    /**
     * Resource bundle path and name.
     * <br><br>
     * The path is relative to the {@code resource} folder.
     * <br><br><b>Example:</b><br>
     * bundle = "i18n/day"
     * @return Resource bundle path and name.
     */
    String bundle() default "";

    /**
     * Resource bundle entry key.
     * @return Resource bundle entry key.
     */
    String key() default "";
}
