/*
 *   Packy - The universal distribution manager suite
 *   Copyright (C) 2022 The Inlined Lambdas and Contributors
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *   USA
 */

package org.inlambda.packy.exceptions;

import org.inlambda.packy.pack.PackageCoord;

/**
 * This kind of exceptions are thrown for failure in package operations.
 */
public abstract class PackageException extends Exception {
    private final PackageCoord packageCoord;

    public PackageException(PackageCoord packageCoord) {
        super();
        this.packageCoord = packageCoord;
    }

    public PackageException(String message, PackageCoord packageCoord) {
        super(message);
        this.packageCoord = packageCoord;
    }

    public PackageException(String message, Throwable cause, PackageCoord packageCoord) {
        super(message, cause);
        this.packageCoord = packageCoord;
    }

    public PackageException(Throwable cause, PackageCoord packageCoord) {
        super(cause);
        this.packageCoord = packageCoord;
    }

    protected PackageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, PackageCoord packageCoord) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.packageCoord = packageCoord;
    }
}
