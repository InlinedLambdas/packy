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

package org.inlambda.packy.pack.metadata;

import com.github.zafarkhaja.semver.Version;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.ApiStatus;

import java.util.Map;

/**
 * Information about a version
 */
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ApiStatus.AvailableSince("0.1.0")
public final class VersionMeta {
    /* BASIC INFORMATION */

    /**
     * Name of package.
     */
    private final String name;
    /**
     * Its version.
     */
    private final Version version;

    /* Environment and Dependencies */

    /**
     * Conflicted packages and their version range.
     */
    private final Map<String, String> conflicts;

    /**
     * Required dependencies (or virtual) and their version range.
     */
    private final Map<String, String> depends;

    /**
     * Required environments, such as java version, server version etc.
     * Type of value is depended on the key. For example, value should be a {@link Version} while key is `java`
     */
    private final Map<String, String> requires;
}
