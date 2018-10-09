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

package de.uhh.l2g.plugins.model.impl;

import java.util.NoSuchElementException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

/**
 * The extended model implementation for the Lectureseries service. Represents a row in the &quot;LG_Lectureseries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.model.Lectureseries} interface.
 * </p>
 *
 * @author Iavor Sturm
 */
public class LectureseriesImpl extends LectureseriesBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a lectureseries model instance should use the {@link de.uhh.l2g.plugins.model.Lectureseries} interface instead.
	 */
	
	private String type;
	
	private int videoSort = 0;
	
	public int getNumberOfVideos() {
		int videoCount = 0;
		try {
			videoCount = VideoLocalServiceUtil.countByLectureseries(this.getLectureseriesId());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoCount;
	}

	public int getNumberOfOpenAccessVideos() {
		int videoCount = 0;
		try {
			videoCount = VideoLocalServiceUtil.countByLectureseriesAndOpenaccess(this.getLectureseriesId(), 1);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return videoCount;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public LectureseriesImpl() {
	}
	
	@Override
	public String getLongDesc() {
		return super.getLongDesc().replaceAll("(style|class)=\"[^\"]*\"", "");
	}

	public int getVideoSort() {
		return videoSort;
	}

	public void setVideoSort(int videoSort) {
		this.videoSort = videoSort;
	}
	
	public String getClosedAccessURI(){
		String webhome = PropsUtil.get("lecture2go.web.home");
		String USID = "";
		if (webhome.contains("localhost")) webhome += "/web/vod";
		USID= webhome + "/l2go/-/get/l/" + this.getUSID();
		return USID;
	}
	
	public String getOpenAccessURI(){
		String webhome = PropsUtil.get("lecture2go.web.home");
		String lid = "";
		if (webhome.contains("localhost")) webhome += "/web/vod";
		lid= webhome + "/l2go/-/get/l/" + this.getLectureseriesId();
		return lid;
	}
	
}