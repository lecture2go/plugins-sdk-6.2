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

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.CoordinatorLocalServiceBaseImpl;

/**
 * The implementation of the coordinator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.CoordinatorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.CoordinatorLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil
 */
public class CoordinatorLocalServiceImpl extends CoordinatorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil} to access the coordinator local service.
	 */

	private List<Coordinator> fillProps(List<Coordinator> cl) throws SystemException{
		Iterator<Coordinator> it = cl.iterator();
		while (it.hasNext()){
			Coordinator c = it.next();
			User u;
			try {
				u = UserLocalServiceUtil.getUser(c.getCoordinatorId());
				c.setLastName(u.getLastName());
				c.setFirstName(u.getFirstName());
				c.setEmailAddress(u.getEmailAddress());
				c.setLastLoginDate(u.getLastLoginDate());
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		return cl;
	}
	
	public List<Coordinator> getAllCoordinators(int begin, int end) throws SystemException{
		List<Coordinator> coords = CoordinatorLocalServiceUtil.getCoordinators(begin, end);
		return fillProps(coords);
	}
	
}