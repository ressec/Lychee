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
package org.ressec.lychee.localization.bundle;

import org.ressec.avocado.core.exception.unchecked.AbstractUncheckedException;

/**
 * Checked exception thrown to indicate an error occurred during a resource bundle manipulation.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
public class ResourceBundleException extends AbstractUncheckedException
{
    /**
     * Thrown to indicate that an error during a resource bundle manipulation.
     * @param exception Parent {@link Exception}.
     */
    public ResourceBundleException(final Exception exception)
    {
        super(exception);
    }

    /**
     * Thrown to indicate that an error during a resource bundle manipulation.
     * @param message Message describing the error being the cause of the raised exception.
     */
    public ResourceBundleException(final String message)
    {
        super(message);
    }

    /**
     * Thrown to indicate that an error during a resource bundle manipulation.
     * @param message Message describing the error being the cause of the raised exception.
     * @param exception Parent {@link Exception}.
     */
    public ResourceBundleException(final String message, final Exception exception)
    {
        super(message, exception);
    }
}
