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
import org.jetbrains.annotations.ApiStatus;

/**
 * This kind of exception are thrown for some security issues while working with packages.
 */
@ApiStatus.AvailableSince("0.1.0")
public abstract class SecurityException extends PackageException {

    public SecurityException(PackageCoord packageCoord) {
        super(packageCoord);
    }

    public SecurityException(String message, PackageCoord packageCoord) {
        super(message, packageCoord);
    }

    public SecurityException(String message, Throwable cause, PackageCoord packageCoord) {
        super(message, cause, packageCoord);
    }

    public SecurityException(Throwable cause, PackageCoord packageCoord) {
        super(cause, packageCoord);
    }

    protected SecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, PackageCoord packageCoord) {
        super(message, cause, enableSuppression, writableStackTrace, packageCoord);
    }
}
