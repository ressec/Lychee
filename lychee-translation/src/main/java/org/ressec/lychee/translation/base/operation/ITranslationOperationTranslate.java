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
package org.ressec.lychee.translation.base.operation;

import lombok.NonNull;

public interface ITranslationOperationTranslate
{
    /**
     * Returns the source text.
     * @return Source text.
     */
    String getText();

    /**
     * Returns the translated text.
     * @return Translated text.
     */
    String getTranslatedText();

    /**
     * Sets the translated text.
     * @param translated Translated text.
     */
    void setTranslatedText(final @NonNull String translated);
}
