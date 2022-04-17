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

import org.inlambda.packy.PackageCoord;

public class PackageDuplicatedException extends PackageException {
    public PackageDuplicatedException(PackageCoord packageCoord) {
        super(packageCoord);
    }

    public PackageDuplicatedException(String message, PackageCoord packageCoord) {
        super(message, packageCoord);
    }

    public PackageDuplicatedException(String message, Throwable cause, PackageCoord packageCoord) {
        super(message, cause, packageCoord);
    }

    public PackageDuplicatedException(Throwable cause, PackageCoord packageCoord) {
        super(cause, packageCoord);
    }

    protected PackageDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, PackageCoord packageCoord) {
        super(message, cause, enableSuppression, writableStackTrace, packageCoord);
    }
}
