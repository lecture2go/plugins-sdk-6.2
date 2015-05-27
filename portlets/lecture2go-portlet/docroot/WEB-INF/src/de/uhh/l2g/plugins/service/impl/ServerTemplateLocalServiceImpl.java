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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.HostNameException;
import de.uhh.l2g.plugins.HostServerTemplateException;
import de.uhh.l2g.plugins.HostStreamerException;
import de.uhh.l2g.plugins.ServerTemplateNameException;
import de.uhh.l2g.plugins.ServerTemplateTemplateStringException;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.ServerTemplate;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.ServerTemplateLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.ServerTemplateLocalServiceBaseImpl;

/**
 * The implementation of the server template local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.ServerTemplateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.ServerTemplateLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.ServerTemplateLocalServiceUtil
 */
public class ServerTemplateLocalServiceImpl
	extends ServerTemplateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.ServerTemplateLocalServiceUtil} to access the server template local service.
	 */

	public ServerTemplate getById(long institutionId) throws SystemException {
		return serverTemplatePersistence.fetchByPrimaryKey(institutionId);
	}

	public List<ServerTemplate> getByGroupId(long groupId) throws SystemException {
		return serverTemplatePersistence.findByGroupId(groupId);
	}

	public boolean getDeviceSpecificByServerTemplateId(long serverTemplateId) throws SystemException {
		boolean exists = false;
		int deviceSpecific = serverTemplatePersistence.countByDeviceSpecificURLs(serverTemplateId);
		if (deviceSpecific >0) exists=true;
		return exists;
	}


	protected void validate(String name, String templateURL) throws PortalException {

		if (Validator.isNull(name)) {
	       throw new ServerTemplateNameException();
		 }

	     if (Validator.isNull(templateURL)) {
	       throw new ServerTemplateTemplateStringException();
	     }
	}

	public ServerTemplate addServerTemplate(String name, int type, String templateURL, String prefixURL, String suffixURL, String secExt, long iosId, long androidId, ServiceContext serviceContext) throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);

		validate(name, templateURL);

		long serverTemplateId = counterLocalService.increment(ServerTemplate.class.getName());

		ServerTemplate serverTemplate = serverTemplatePersistence.create(serverTemplateId);

		serverTemplate.setGroupId(0);
		serverTemplate.setName(name);
		serverTemplate.setType(type);

		serverTemplate.setTemplateURL(templateURL);
		serverTemplate.setPrefixURL(prefixURL);
		serverTemplate.setSuffixURL(suffixURL);
		serverTemplate.setSecExt(secExt);


		serverTemplate.setTemplateIOS(iosId);
		serverTemplate.setTemplateAndroid(androidId);

		if (iosId != 0){
			String nameIOS = name+" IOS";
			ServerTemplate iosTemplate = ServerTemplateLocalServiceUtil.addServerTemplate(nameIOS, 1, templateURL, prefixURL,suffixURL,secExt, 0, 0,serviceContext);
			serverTemplate.setTemplateIOS(iosTemplate.getPrimaryKey());
		}
		else{
			serverTemplate.setTemplateIOS(0);
		}

		if (androidId != 0){
			String nameAndroid = name+" Android";
			ServerTemplate androidTemplate = ServerTemplateLocalServiceUtil.addServerTemplate(nameAndroid, 2, templateURL, prefixURL,suffixURL,secExt, 0, 0,serviceContext);
			serverTemplate.setTemplateAndroid(androidTemplate.getPrimaryKey());
		}
		else{
			serverTemplate.setTemplateAndroid(0);
		}

		serverTemplate.setExpandoBridgeAttributes(serviceContext);

		serverTemplatePersistence.update(serverTemplate);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				ServerTemplate.class.getName(), serverTemplateId, false, true, true);

		return serverTemplate;
	}

}