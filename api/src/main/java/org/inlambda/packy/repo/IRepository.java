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

package org.inlambda.packy.repo;

import org.inlambda.packy.exceptions.PackageDuplicatedException;
import org.inlambda.packy.pack.PackageRecord;
import org.inlambda.packy.repo.sync.IRepositoryClient;
import org.jetbrains.annotations.ApiStatus;

/**
 * A repository tracks or sync changes for packages, allowing clients to read its contents.
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepository extends IRepositoryClient {

    /**
     * Add a record into repository.
     *
     * @param record record to be added
     * @throws PackageDuplicatedException if package already exists.
     */
    void addPackage(PackageRecord record) throws PackageDuplicatedException;
}
