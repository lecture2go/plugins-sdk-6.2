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

package de.uhh.l2g.plugins.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Video service. Represents a row in the &quot;LG_Video&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see VideoModel
 * @see de.uhh.l2g.plugins.model.impl.VideoImpl
 * @see de.uhh.l2g.plugins.model.impl.VideoModelImpl
 * @generated
 */
public interface Video extends VideoModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.uhh.l2g.plugins.model.impl.VideoImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public boolean isHasChapters();

	public void setHasChapters(boolean hasChapters);

	public boolean isHasComments();

	public void setHasComments(boolean hasComments);

	public java.lang.String getStreamUrl();

	public void setStreamUrl(java.lang.String streamUrl);

	public java.lang.String getStreamIosUrl();

	public void setStreamIosUrl(java.lang.String streamIosUrl);

	public java.lang.String getStreamAndroidUrl();

	public void setStreamAndroidUrl(java.lang.String streamAndroidUrl);

	public java.lang.String getUrl();

	public void setUrl(java.lang.String url);

	public java.lang.String getSecureUrl();

	public void setSecureUrl(java.lang.String secureUrl);

	public java.io.File getMp4File();

	public void setMp4File(java.io.File mp4File);

	public java.io.File getPdfFile();

	public void setPdfFile(java.io.File pdfFile);

	public java.io.File getMp3File();

	public void setMp3File(java.io.File mp3File);

	public java.io.File getM4vFile();

	public void setM4vFile(java.io.File m4vFile);

	public java.io.File getM4aFile();

	public void setM4aFile(java.io.File m4aFile);

	public java.lang.String getDate();

	public void setDate(java.lang.String date);

	public java.lang.String getSimpleDate();

	public void setSimpleDate(java.lang.String simpleDate);

	public java.lang.String getBitrate();

	public void setBitrate(java.lang.String bitrate);

	public java.lang.String getImage();

	public void setImage(java.lang.String image);

	public java.lang.String getImageSmall();

	public void setImageSmall(java.lang.String imageSmall);

	public java.lang.String getImageMedium();

	public void setImageMedium(java.lang.String imageMedium);

	public java.lang.String getShortTitle();

	public void setShortTitle(java.lang.String shortTitle);

	public java.lang.String getShortName();

	public void setShortName(java.lang.String shortName);

	public java.lang.String getSPreffix();

	public java.lang.String getPreffix();
}