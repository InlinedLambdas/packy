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
import org.inlambda.packy.exceptions.PackageDuplicatedException;
import org.inlambda.packy.pack.PackageCoord;
import org.inlambda.packy.pack.PackageRecord;
import org.jetbrains.annotations.ApiStatus;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * A repository tracks or sync changes for packages, allowing clients to read its contents.
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepository {
    /**
     * Find packages by their name. {@link PackageRecord}
     *
     * @param name name of packages
     * @return a collection of package records or empty set
     */
    Collection<? extends PackageRecord> findByName(String name);

    /**
     * Find a package by its name and version. Sorted by version
     *
     * @param name    name of package
     * @param version version of package
     * @return a package record or {@link Optional#empty()}
     */
    Optional<? extends PackageRecord> findExactly(String name, Version version);

    /**
     * As same as {@link #findExactly(String, Version)}, but for {@link PackageCoord}
     *
     * @param coordinate coord of package
     * @return a package record or {@link Optional#empty()}
     */
    default Optional<? extends PackageRecord> findExactly(PackageCoord coordinate) {
        return findExactly(coordinate.getName(), coordinate.getVersion());
    }

    /**
     * Find packages with a name and a range of version. Sorted by version
     *
     * @param name       name of the package
     * @param versionDsl See <a href="https://github.com/zafarkhaja/jsemver#external-dsl">https://github.com/zafarkhaja/jsemver#external-dsl</a>
     * @return a collection of package records
     */
    default Collection<? extends PackageRecord> findInRange(String name, String versionDsl) {
        return findByName(name).stream()
                .filter(e -> e.getVersion().satisfies(versionDsl))
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Add a record into repository.
     *
     * @param record record to be added
     * @throws PackageDuplicatedException if package already exists.
     */
    void addPackage(PackageRecord record) throws PackageDuplicatedException;
}
