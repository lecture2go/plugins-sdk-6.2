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

package de.uhh.l2g.plugins.migration.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import de.uhh.l2g.plugins.migration.service.ClpSerializer;
import de.uhh.l2g.plugins.migration.service.LegacyContactLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyLectureSeriesFacilityLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyOfficeLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacySegmentLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.LegacyUserLocalServiceUtil;
import de.uhh.l2g.plugins.migration.service.TestEntityTwoLocalServiceUtil;

/**
 * @author unihh
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			LegacyContactLocalServiceUtil.clearService();

			LegacyLectureSeriesFacilityLocalServiceUtil.clearService();

			LegacyMetadataLocalServiceUtil.clearService();

			LegacyOfficeLocalServiceUtil.clearService();

			LegacySegmentLocalServiceUtil.clearService();

			LegacyUserLocalServiceUtil.clearService();

			TestEntityTwoLocalServiceUtil.clearService();
		}
	}
}