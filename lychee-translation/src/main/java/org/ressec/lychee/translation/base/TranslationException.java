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
package org.ressec.lychee.translation.base;

import org.ressec.avocado.core.exception.checked.AbstractCheckedException;

/**
 * Checked exception thrown to indicate an error occurred during a translation.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public class TranslationException extends AbstractCheckedException
{
    /**
     * Default serialization identifier.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Thrown to indicate that an error occurred during a translation.
     * @param exception Parent {@link Exception}.
     */
    public TranslationException(final Exception exception)
    {
        super(exception);
    }

    /**
     * Thrown to indicate that an error occurred during a translation.
     * @param message Message describing the error being the cause of the raised exception.
     */
    public TranslationException(final String message)
    {
        super(message);
    }

    /**
     * Thrown to indicate that an error occurred during a translation.
     * @param message Message describing the error being the cause of the raised exception.
     * @param exception Parent {@link Exception}.
     */
    public TranslationException(final String message, final Exception exception)
    {
        super(message, exception);
    }
}
