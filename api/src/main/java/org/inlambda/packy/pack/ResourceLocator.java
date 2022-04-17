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

package org.inlambda.packy.pack;

import lombok.RequiredArgsConstructor;
import org.inlambda.packy.PackageCoord;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/**
 * A resource locator defines where to fetch the resource and how to validate them.
 */
@ApiStatus.AvailableSince("0.1.0")
@RequiredArgsConstructor
public final class ResourceLocator {
    /**
     * Determines the repository which the resource located, allowing users to fetch resource from other packages.
     */
    private final PackageCoord repository;

    /**
     * Determines the path of the resource.
     * // TODO: 2022/4/17 add ID support in the future, for accessing resources in the other packages.
     */
    private final String descriptor;

    /**
     * The validation properties, can be null if no validation is required.
     */
    @Nullable
    private final ResourceValidationProperties validation;

}
