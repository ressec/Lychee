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
import org.ressec.lychee.translation.base.result.ITranslationResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A google free translation result.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public final class GoogleTranslationResultVersion1 implements ITranslationResult
{
    /**
     * Result translation of sentences.
     */
    @Getter
    @Setter
    @SerializedName("sentences")
    private List<ITranslationOperationResult> entries;

    /**
     * Source of the translation.
     */
    @Getter
    @Setter
    @SerializedName("src")
    private String source;

    /**
     * Confidence factor of the translation.
     */
    @Getter
    @Setter
    @SerializedName("confidence")
    private double confidence;

    @Getter
    @Setter
    @SerializedName("ld_result")
    private GoogleTranslationResultVersion1Detection detection;

    /**
     * Creates a new Google translation result.
     */
    public GoogleTranslationResultVersion1()
    {
        // Required for JSON serialization.
    }

    public final String getTranslation()
    {
        String result = entries.stream()
                .map(ITranslationOperationResult::getTranslation)
                .collect( Collectors.joining(""));

        return result.replace("null", "");
    }
}
