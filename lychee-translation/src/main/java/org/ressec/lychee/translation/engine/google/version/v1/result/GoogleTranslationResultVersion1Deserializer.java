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

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import org.ressec.lychee.translation.base.result.ITranslationResult;

import java.lang.reflect.Type;

/**
 * Deserializer used when a {@link ITranslationResult} interface is about to be de-serialized. It indicates which
 * concrete implementation is to be used.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public class GoogleTranslationResultVersion1Deserializer implements JsonDeserializer<ITranslationResult>
{
    @Override
    public ITranslationResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
    {
        return context.deserialize(json, GoogleTranslationResultVersion1.class);
    }
}
