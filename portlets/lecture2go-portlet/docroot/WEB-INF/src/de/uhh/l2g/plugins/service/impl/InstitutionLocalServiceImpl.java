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

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.HostNameException;
import de.uhh.l2g.plugins.HostServerTemplateException;
import de.uhh.l2g.plugins.HostStreamerException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.service.base.InstitutionLocalServiceBaseImpl;
import de.uhh.l2g.plugins.service.persistence.InstitutionFinderUtil;

/**
 * The implementation of the institution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.InstitutionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.InstitutionLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil
 */
public class InstitutionLocalServiceImpl extends InstitutionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil} to access the institution local service.
	 */
	
	public Institution getById(long institutionId) throws SystemException{
		return institutionPersistence.fetchByPrimaryKey(institutionId);
	}
	
	public List<Institution> getByParentId(long parentId, String type) throws SystemException {
		return institutionPersistence.findByParent(parentId);
	}
	
	public Map<String, String> getByParent(long parentId) throws SystemException {
		Map<String,String> institutions = new LinkedHashMap<String, String>();
		List <Institution> fList = institutionPersistence.findByParent(parentId);

		for (Institution faculty : fList) {
			String id = "" + faculty.getInstitutionId();
			String name = "" + faculty.getName();
			institutions.put(id, name);
		}
		return institutions;
	}

	public List<Institution> getByLevel(int level) throws SystemException {
		return institutionPersistence.findBylevel(level);
	}

	public List<Institution> getByLectureseriesId(long lectureseriesId, int begin, int end) throws SystemException {
		return InstitutionFinderUtil.findByLectureseriesId(lectureseriesId, begin, end);
	}

	public Map<String, String> getAllSortedAsTree(int begin, int end) throws SystemException {
		Map<String,String> allFaculties = new LinkedHashMap<String, String>();
		List <Institution> einListAll = InstitutionFinderUtil.findAllSortedAsTree(begin, end);

		for (Institution faculty : einListAll) {
			String id = "" + faculty.getInstitutionId();
			String name = _indentFromPath(faculty.getPath(), "/") + faculty.getName();
			allFaculties.put(id, name);
		}
		
		return allFaculties;
	}
	
	private String _indentFromPath(String path, String sep) {
		String s = "";
		for (int i = 1; i <= path.split(sep).length - 1; i++) {
			s += "--";
		}
		return s;
	}
	
	
	protected void validate (String name, String streamer, String serverTemplate) throws PortalException {
	    
		if (Validator.isNull(name)) {
	       throw new HostNameException();
		 }
		
	     if (Validator.isNull(streamer) || !Validator.isDomain(streamer) ) {
	       throw new HostStreamerException();
	     }     
	     
	     if (Validator.isNull(serverTemplate)) {
	       throw new HostServerTemplateException();
	     }
	}
	
	public Host addInstitution(long userId, String name, String streamer, String serverTemplate,
			String protocol, String serverRoot, int port,
			ServiceContext serviceContext) throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name,streamer,serverTemplate);
		

		long hostId = counterLocalService.increment();

		Host host = hostPersistence.create(hostId);
		
		host.setUuid(serviceContext.getUuid());
		host.setUserId(userId);
		host.setGroupId(groupId);
		host.setCompanyId(user.getCompanyId());
		host.setUserName(user.getFullName());
		host.setCreateDate(serviceContext.getCreateDate(now));
		host.setModifiedDate(serviceContext.getModifiedDate(now));
		host.setName(name);
		host.setServerTemplate(serverTemplate);
		host.setStreamer(streamer);
		host.setProtocol(protocol);
		host.setServerRoot(serverRoot);
		host.setPort(port);
		host.setExpandoBridgeAttributes(serviceContext);

		hostPersistence.update(host);

		return host;
	}
	
}