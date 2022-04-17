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

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.inlambda.packy.installer.InstallingAction;
import org.inlambda.packy.pack.metadata.VersionMeta;

import java.util.Map;

/**
 * A package bundle represents an installable package.
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public final class PackageBundle {
    /**
     * Metadata of the version.
     */
    private final VersionMeta metadata;

    /**
     * Resources of the version.
     * The key is the resource id, the value is the resource path.
     */
    private final Map<String, ResourceLocator> resources;

    /**
     * Installer actions.
     * The key is a {@link org.inlambda.packy.installer.InstallingAction} and the value is the resource id to the argument.
     */
    private final Map<InstallingAction, String> actions;

    /**
     * License and agreement.
     * Users accept them by continue installing the package.
     */
    private final String license;

}
