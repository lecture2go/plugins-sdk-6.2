/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.migration;

import com.liferay.portal.NoSuchModelException;

/**
 * @author unihh
 */
public class NoSuchLegacyL2gSysException extends NoSuchModelException {

	public NoSuchLegacyL2gSysException() {
		super();
	}

	public NoSuchLegacyL2gSysException(String msg) {
		super(msg);
	}

	public NoSuchLegacyL2gSysException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchLegacyL2gSysException(Throwable cause) {
		super(cause);
	}

}