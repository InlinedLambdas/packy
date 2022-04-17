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

package org.inlambda.packy.repo.sync;

import com.github.zafarkhaja.semver.Version;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.inlambda.packy.pack.PackageCoord;
import org.inlambda.packy.pack.PackageRecord;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * A client for repositories.
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepositoryClient {
    /**
     * Find packages by their name. {@link PackageRecord}
     *
     * @param name name of packages
     * @return a collection of package records or empty set
     */
    Multi<? extends PackageRecord> findByName(String name);

    /**
     * Find a package by its name and version. Sorted by version
     *
     * @param name    name of package
     * @param version version of package
     * @return a package record or {@link Optional#empty()}
     */
    Uni<? extends PackageRecord> findExactly(String name, @Nullable Version version);

    /**
     * As same as {@link #findExactly(String, Version)}, but for {@link PackageCoord}
     *
     * @param coordinate coord of package
     * @return a package record or {@link Optional#empty()}
     */
    default Uni<? extends PackageRecord> findExactly(PackageCoord coordinate) {
        return findExactly(coordinate.getName(), coordinate.getVersion());
    }

    /**
     * Find packages with a name and a range of version. Sorted by version
     *
     * @param name       name of the package
     * @param versionDsl See <a href="https://github.com/zafarkhaja/jsemver#external-dsl">https://github.com/zafarkhaja/jsemver#external-dsl</a>
     * @return a collection of package records
     */
    default Multi<? extends PackageRecord> findInRange(String name, @NotNull String versionDsl) {
        return findByName(name).filter(e -> e.getVersion().satisfies(versionDsl));
    }
}
