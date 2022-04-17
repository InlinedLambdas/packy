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

package org.inlambda.packy.manager;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.inlambda.packy.pack.PackageRecord;
import org.inlambda.packy.pack.metadata.VersionMeta;
import org.inlambda.packy.repo.sync.IRepositoryClient;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/**
 * A service that provides control of repository synchronization.
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepositoryResolver {
    /**
     * Synchronizes the local repository with the remote repository.
     */
    Multi<PackageRecord> fullSync();

    /**
     * Find a package record in all remote repositories.
     *
     * @param name    name of package
     * @param version version of package
     * @return a {@link Uni} of {@link PackageRecord}s
     */
    Uni<PackageRecord> findRemoteRecord(String name, @Nullable String version);

    /**
     * Synchronizes the local repository with the remote repository for specified record.
     * This also performs dependency solution if necessary.
     *
     * @param targetRepository remote
     * @param name             name of the package
     * @param version          version selector, can be empty or null
     * @return a {@link Uni} of local {@link PackageRecord} or failure
     */
    Uni<PackageRecord> syncRecord(IRepositoryClient targetRepository, String name, @Nullable String version);

    /**
     * Finds required (uninstalled) packages in remote repositories.
     *
     * @param record package record
     * @return a {@link Uni} of {@link PackageRecord}s
     */
    Multi<PackageRecord> solveDependency(VersionMeta record);

    /**
     * Resolves a remote package record.
     * This will download the package from remote repository and turn into local one.
     *
     * @param record remote record
     * @return a {@link Uni} of local {@link PackageRecord} or failure
     */
    Uni<PackageRecord> resolveRecord(PackageRecord record);
}
