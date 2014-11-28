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

package de.uhh.l2g.plugins.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.service.base.Institution_HostLocalServiceBaseImpl;

/**
 * The implementation of the institution_ host local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.Institution_HostLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.Institution_HostLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil
 */
public class Institution_HostLocalServiceImpl
	extends Institution_HostLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil} to access the institution_ host local service.
	 */
	
	public Host getByInstitutionId(long institutionId) throws SystemException, PortalException {
		long hId = institution_HostPersistence.findByinstitutionId(institutionId).getHostId();
		Host h = hostLocalService.getHost(hId);
		return h;
	}
	
	public Host getByHostId(long hostId) throws SystemException, PortalException {
		long hId = institution_HostPersistence.findByhostId(hostId).getHostId();
		Host h = hostLocalService.getHost(hId);
		return h;
	}
}