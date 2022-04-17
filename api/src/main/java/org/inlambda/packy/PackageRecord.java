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

package org.inlambda.packy;

import com.github.zafarkhaja.semver.Version;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.inlambda.packy.pack.metadata.PackageMeta;
import org.inlambda.packy.pack.metadata.VersionMeta;
import org.jetbrains.annotations.ApiStatus;

import java.nio.file.Path;

/**
 * PackageRecords are what {@link IRepository} is tracking for.
 * More explicitly, PackageRecord defines where to locate the package and its information, and they are immutable.
 * A repository is possible to store multiple package records with same name but differing versions.
 */
@ApiStatus.AvailableSince("0.1.0")
@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public final class PackageRecord { // we don't use records for Java 11 compatibility
    /**
     * The location of the package, this can even be a URL.
     */
    private final Path packagePath;
    /**
     * The name of the package.
     */
    private final String name;
    /**
     * The version of the package, which hardly restricted to be a SemVer. {@link Version}
     */
    private final Version version;
    /**
     * The description of the package.
     */
    private final String description;
    /**
     * The environments this package providing.
     */
    private final String[] provides;
    /**
     * More information about this package.
     */
    private final PackageMeta packageMeta;
    /**
     * More information about this version. Detailed dependency graph relation here.
     */
    private final VersionMeta versionMeta;
}
