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

package org.inlambda.packy.security;

import org.inlambda.packy.exceptions.ValidationFailedException;
import org.jetbrains.annotations.ApiStatus;

import java.nio.file.Path;

/**
 * Validator validates resource and they're related to a specified {@link ValidationType}
 */
@ApiStatus.AvailableSince("0.1.0")
public interface ResourceValidator {
    /**
     * Validates resource
     *
     * @param resource resource to validate
     * @param argument validation argument which is up to {@link ValidationType}, such as sha56sum
     */
    void validate(Path resource, String argument) throws ValidationFailedException;

    ValidationType getType();
}
