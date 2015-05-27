/** Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package de.uhh.l2g.plugins;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Iavor Sturm
 */
public class Institution_HostInstitutionException extends PortalException {

	public Institution_HostInstitutionException() {
		super();
	}

	public Institution_HostInstitutionException(String msg) {
		super(msg);
	}

	public Institution_HostInstitutionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public Institution_HostInstitutionException(Throwable cause) {
		super(cause);
	}

}
