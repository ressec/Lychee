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

//@EqualsAndHashCode
public final class GoogleTranslationResultDetectVersion2 implements Serializable
{
    @Getter
    @Setter
    @SerializedName("confidence")
    private double confidence;

    @Getter
    @Setter
    @SerializedName("isReliable")
    private boolean isReliable;

    @Getter
    @Setter
    @SerializedName("language")
    private String language;

    /**
     * Creates a new Google translation language detection.
     */
    public GoogleTranslationResultDetectVersion2()
    {
        // Required for JSON serialization.
    }
}
