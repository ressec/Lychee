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
package org.ressec.lychee.translation.base.processor;

import lombok.NonNull;
import org.ressec.lychee.translation.base.TranslationApiVersionType;
import org.ressec.lychee.translation.base.TranslationException;
import org.ressec.lychee.translation.base.request.ITranslationRequest;

import java.util.List;
import java.util.Optional;

/**
 * Provides the basic behavior of a translation processor.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public interface ITranslationProcessor
{
    /**
     * Executes the translation requests contained in the translation processor.
     * @throws TranslationException Thrown in case an error occurred during a translation.
     */
    void execute() throws TranslationException;

    /**
     * Clears all the translation requests contained in this translation processor.
     */
    void clear();

    /**
     * Adds a translation request to this translation processor.
     * @param request Translation request to add.
     */
    void addRequest(final @NonNull ITranslationRequest request);

    Optional<ITranslationRequest> getRequest(final @NonNull String name);

    /**
     * Returns a list of translation requests contained in this translation processor.
     * @return List of translation requests.
     */
    List<ITranslationRequest> getRequests();

    /**
     * Returns the translation API version type.
     * @return Translation API type.
     */
    TranslationApiVersionType getApi();
}
