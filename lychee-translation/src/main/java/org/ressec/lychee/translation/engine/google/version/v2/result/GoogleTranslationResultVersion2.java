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
import org.ressec.lychee.translation.base.result.ITranslationOperationResult;
import org.ressec.lychee.translation.base.result.ITranslationResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A google (paying) translation API result version 2.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public final class GoogleTranslationResultVersion2 implements ITranslationResult
{
    /**
     * Result translation of sentences.
     */
    @Getter
    @Setter
    @SerializedName("data")
    private GoogleTranslationResultVersion2Any data;

    /**
     * Creates a new Google translation result.
     */
    public GoogleTranslationResultVersion2()
    {
        // Required for JSON serialization.
    }

    @Override
    public List<ITranslationOperationResult> getEntries()
    {
        return data.getTranslated();
    }

    @Override
    public String getTranslation()
    {
        String result = getEntries().stream()
                .map(ITranslationOperationResult::getTranslation)
                .collect( Collectors.joining(""));

        return result.replace("null", "");
    }
}
