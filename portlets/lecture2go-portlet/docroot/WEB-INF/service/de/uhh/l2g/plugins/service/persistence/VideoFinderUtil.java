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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Iavor Sturm
 */
public class VideoFinderUtil {
	public static int unlinkLectureseriesFromVideos(
		java.lang.Long lectureseriesId) {
		return getFinder().unlinkLectureseriesFromVideos(lectureseriesId);
	}

	public static de.uhh.l2g.plugins.model.Video findLatestVideoForLectureseries(
		java.lang.Long lectureseriesId) {
		return getFinder().findLatestVideoForLectureseries(lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Video> findLatestVideos() {
		return getFinder().findLatestVideos();
	}

	public static VideoFinder getFinder() {
		if (_finder == null) {
			_finder = (VideoFinder)PortletBeanLocatorUtil.locate(de.uhh.l2g.plugins.service.ClpSerializer.getServletContextName(),
					VideoFinder.class.getName());

			ReferenceRegistry.registerReference(VideoFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(VideoFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VideoFinderUtil.class, "_finder");
	}

	private static VideoFinder _finder;
}