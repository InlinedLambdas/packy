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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.inlambda.packy.security.ValidationType;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Validation properties for {@link ResourceLocator}
 */
@ApiStatus.AvailableSince("0.1.0")
@EqualsAndHashCode
@Getter
@RequiredArgsConstructor
public final class ResourceValidationProperties {
    /**
     * Type of validation.
     */
    @NotNull
    private final ValidationType type;

    /**
     * Argument for validation. can be null if unnecessary
     */
    @Nullable
    private final String argument;
}