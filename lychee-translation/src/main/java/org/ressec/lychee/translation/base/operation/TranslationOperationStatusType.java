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

public enum TranslationOperationStatusType
{
    /**
     * Translation operation has been created.
     */
    CREATED,

    /**
     * Translation operation has been executed with success.
     */
    SUCCESS,

    /**
     * Translation operation has been processed but with failure. Consult the {@link ITranslationOperation#getReason}
     * service to get more details about the failure.
     */
    FAILED,

    /**
     * Translation operation has been invalidated (meaning it has not been executed by a translation processor).
     * Consult the {@link ITranslationOperation#getReason} service to get more details.
     */
    INVALIDATED,
}
