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
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.ProducerLocalServiceBaseImpl;

/**
 * The implementation of the producer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.ProducerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.ProducerLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.ProducerLocalServiceUtil
 */
public class ProducerLocalServiceImpl extends ProducerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.ProducerLocalServiceUtil} to access the producer local service.
	 */	
	
	public List<Producer> getAllProducers(int begin, int end) throws SystemException{
		List<Producer> prods = ProducerLocalServiceUtil.getProducers(begin, end);
		Iterator<Producer> it = prods.iterator();
		while (it.hasNext()){
			Producer p = it.next();
			User u;
			try {
				u = UserLocalServiceUtil.getUser(p.getProducerId());
				p.setLastName(u.getLastName());
				p.setFirstName(u.getFirstName());
				p.setEmailAddress(u.getEmailAddress());
				p.setLastLoginDate(u.getLastLoginDate());
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		return prods;
	}
	
	public List<Integer> getProducerIds(Long lectureseriesId, int begin, int end)throws SystemException{
		return null;
	}
}