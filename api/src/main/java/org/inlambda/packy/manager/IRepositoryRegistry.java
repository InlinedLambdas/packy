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

import org.inlambda.packy.repo.IRepository;
import org.inlambda.packy.repo.sync.IRepositoryClient;
import org.jetbrains.annotations.ApiStatus;

import java.util.Collection;

/**
 * A registry for repositories.
 */
@ApiStatus.AvailableSince("0.1.0")
public interface IRepositoryRegistry {
    /**
     * Get the local repository
     *
     * @return the local repository
     */
    IRepository getLocalRepository();

    /**
     * Get remote repositories.
     *
     * @return
     */
    Collection<? extends IRepositoryClient> getRemoteRepositories();

    /**
     * Add a remote repository.
     * This also performs keyring update.
     *
     * @param repository the repository to add
     */
    void addRemoteRepository(IRepositoryClient repository);
}
