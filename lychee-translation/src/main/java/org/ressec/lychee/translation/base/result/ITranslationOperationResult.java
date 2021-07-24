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
package org.ressec.lychee.translation.base.result;

import java.io.Serializable;

/**
 * Provides the basic behavior of a the result of a translation operation.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public interface ITranslationOperationResult extends Serializable
{
    /**
     * Returns the original text of the translation result entry.
     * @return Original text.
     */
    String getOriginal();

    /**
     * Returns the translated text of the translation result entry.
     * @return Translated text.
     */
    String getTranslation();
}
