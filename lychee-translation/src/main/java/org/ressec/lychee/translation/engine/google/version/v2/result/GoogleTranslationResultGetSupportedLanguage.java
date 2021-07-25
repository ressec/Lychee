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
package org.ressec.lychee.translation.engine.google.version.v2.result;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A google (paying) translation API result version 2.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public final class GoogleTranslationResultGetSupportedLanguage implements Serializable
{
    @Getter
    @Setter
    @SerializedName("language")
    private String language;

    @Getter
    @Setter
    @SerializedName("name")
    private String name;

    /**
     * Creates a new Google translation result.
     */
    public GoogleTranslationResultGetSupportedLanguage()
    {
        // Required for JSON serialization.
    }
}
