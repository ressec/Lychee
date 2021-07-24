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
package org.ressec.lychee.translation.engine.google.version.v1.result;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

//@EqualsAndHashCode
public final class GoogleTranslationResultVersion1Detection implements Serializable
{
    @Getter
    @Setter
    @SerializedName("srclangs")
    private List<String> languages;

    @Getter
    @Setter
    @SerializedName("srclangs_confidences")
    private List<Double> confidences;

    @Getter
    @Setter
    @SerializedName("extended_srclangs")
    private List<String> extensions;
}
