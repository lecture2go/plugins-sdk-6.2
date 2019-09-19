/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.OaiRecord_OaiSet;
import de.uhh.l2g.plugins.model.OaiSet;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.OaiRecord_OaiSetLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.OaiSetLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.OaiRecordFinderUtil;
import de.uhh.l2g.plugins.service.persistence.OaiSetFinderUtil;

/**
 * The implementation of the oai set local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.OaiSetLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.OaiSetLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.OaiSetLocalServiceUtil
 */
public class OaiSetLocalServiceImpl extends OaiSetLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.OaiSetLocalServiceUtil} to access the oai set local service.
	 */
	
	public List<OaiSet> getAll() throws SystemException{
		return oaiSetPersistence.findAll();
	}
	
	public List<OaiSet> getByOaiRecordId(long oaiRecordId) {
		return OaiSetFinderUtil.findByOaiRecord(oaiRecordId);
	}
}