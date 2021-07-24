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
import org.ressec.lychee.translation.base.result.ITranslationOperationResult;

//@EqualsAndHashCode
public final class GoogleTranslationOperationResultVersion1 implements ITranslationOperationResult
{
    @Getter
    @Setter
    @SerializedName("trans")
    private String translation;

    @Getter
    @Setter
    @SerializedName("orig")
    private String original;

    @Getter
    @Setter
    @SerializedName("backend")
    private int backend;
}
