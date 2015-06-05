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
<<<<<<< Upstream, based on origin/master
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import de.uhh.l2g.plugins.StreamingServerTemplateNameException;
import de.uhh.l2g.plugins.StreamingServerTemplateStringException;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.StreamingServerTemplate;
import de.uhh.l2g.plugins.service.StreamingServerTemplateLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.StreamingServerTemplateLocalServiceBaseImpl;

/**
 * The implementation of the server template local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.StreamingServerTemplateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.StreamingServerTemplateLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.StreamingServerTemplateLocalServiceUtil
 */
public class StreamingServerTemplateLocalServiceImpl
	extends StreamingServerTemplateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.StreamingServerTemplateLocalServiceUtil} to access the server template local service.
	 */

	public StreamingServerTemplate getById(long institutionId) throws SystemException {
		return streamingServerTemplatePersistence.fetchByPrimaryKey(institutionId);
	}

	public List<StreamingServerTemplate> getByGroupId(long groupId) throws SystemException {
		return streamingServerTemplatePersistence.findByGroupId(groupId);
	}

	public boolean getDeviceSpecificByStreamingServerTemplateId(long streamingServerTemplateId) throws SystemException {
		boolean exists = false;
		int deviceSpecific = streamingServerTemplatePersistence.countByDeviceSpecificURLs(streamingServerTemplateId);
		if (deviceSpecific >0) exists=true;
		return exists;
	}


	protected void validate(String name, String templateURL) throws PortalException {

		if (Validator.isNull(name)) {
	       throw new StreamingServerTemplateNameException();
		 }

	     if (Validator.isNull(templateURL)) {
	       throw new StreamingServerTemplateStringException();
	     }
	}

	public StreamingServerTemplate addStreamingServerTemplate(String name, int type, String templateURL, String prefixURL, String suffixURL, String secExt, long iosId, long androidId, ServiceContext serviceContext) throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();

		User user = userPersistence.findByPrimaryKey(userId);

		validate(name, templateURL);

		long streamingServerTemplateId = counterLocalService.increment(StreamingServerTemplate.class.getName());

		StreamingServerTemplate streamingServerTemplate = streamingServerTemplatePersistence.create(streamingServerTemplateId);

		streamingServerTemplate.setGroupId(groupId);
		streamingServerTemplate.setName(name);
		streamingServerTemplate.setType(type);

		streamingServerTemplate.setTemplateURL(templateURL);
		streamingServerTemplate.setPrefixURL(prefixURL);
		streamingServerTemplate.setSuffixURL(suffixURL);
		streamingServerTemplate.setSecExt(secExt);


		streamingServerTemplate.setTemplateIOS(iosId);
		streamingServerTemplate.setTemplateAndroid(androidId);

		if (iosId != 0){
			String nameIOS = name+" IOS";
			StreamingServerTemplate iosTemplate = StreamingServerTemplateLocalServiceUtil.addStreamingServerTemplate(nameIOS, 1, templateURL, prefixURL,suffixURL,secExt, 0, 0,serviceContext);
			streamingServerTemplate.setTemplateIOS(iosTemplate.getPrimaryKey());
		}
		else{
			streamingServerTemplate.setTemplateIOS(0);
		}

		if (androidId != 0){
			String nameAndroid = name+" Android";
			StreamingServerTemplate androidTemplate = StreamingServerTemplateLocalServiceUtil.addStreamingServerTemplate(nameAndroid, 2, templateURL, prefixURL,suffixURL,secExt, 0, 0,serviceContext);
			streamingServerTemplate.setTemplateAndroid(androidTemplate.getPrimaryKey());
		}
		else{
			streamingServerTemplate.setTemplateAndroid(0);
		}

		streamingServerTemplate.setExpandoBridgeAttributes(serviceContext);

		streamingServerTemplatePersistence.update(streamingServerTemplate);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				StreamingServerTemplate.class.getName(), streamingServerTemplateId, false, true, true);

		return streamingServerTemplate;
	}

	  public StreamingServerTemplate deleteStreamingServerTemplate(long streamingServerTemplateId, ServiceContext serviceContext)
		        throws PortalException, SystemException {

		  StreamingServerTemplate streamingServerTemplate = getById(streamingServerTemplateId);

		        resourceLocalService.deleteResource(serviceContext.getCompanyId(),
		        		Institution.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
		        		streamingServerTemplateId);

		        streamingServerTemplate = deleteStreamingServerTemplate(streamingServerTemplateId);

		        return streamingServerTemplate;

	  }

}
