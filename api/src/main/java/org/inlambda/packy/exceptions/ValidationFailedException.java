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
import org.inlambda.packy.security.ValidationType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This kind of exceptions are thrown for validation failure.
 */
public class ValidationFailedException extends SecurityException {
    @NotNull
    private final ValidationType type;
    @Nullable
    private final String argument;

    public ValidationFailedException(PackageCoord packageCoord, ValidationType type, String argument) {
        super(packageCoord);
        this.type = type;
        this.argument = argument;
    }

    public ValidationFailedException(String message, PackageCoord packageCoord, ValidationType type, String argument) {
        super(message, packageCoord);
        this.type = type;
        this.argument = argument;
    }

    public ValidationFailedException(String message, Throwable cause, PackageCoord packageCoord, ValidationType type, String argument) {
        super(message, cause, packageCoord);
        this.type = type;
        this.argument = argument;
    }

    public ValidationFailedException(Throwable cause, PackageCoord packageCoord, ValidationType type, String argument) {
        super(cause, packageCoord);
        this.type = type;
        this.argument = argument;
    }

    protected ValidationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, PackageCoord packageCoord, ValidationType type, String argument) {
        super(message, cause, enableSuppression, writableStackTrace, packageCoord);
        this.type = type;
        this.argument = argument;
    }
}
