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
package org.ressec.lychee.translation.engine.google;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

public class GoogleTranslationErrorDetail
{
    @SerializedName("code")
    @Getter
    @Setter
    private String code;

    @SerializedName("message")
    @Getter
    @Setter
    private String message;

    @SerializedName("status")
    @Getter
    @Setter
    private String status;
}
