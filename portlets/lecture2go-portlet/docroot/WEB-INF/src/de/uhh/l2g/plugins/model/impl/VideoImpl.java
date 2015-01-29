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

import java.io.File;

/**
 * The extended model implementation for the Video service. Represents a row in the &quot;LG_Video&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.model.Video} interface.
 * </p>
 *
 * @author Iavor Sturm
 */
public class VideoImpl extends VideoBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a video model instance should use the {@link de.uhh.l2g.plugins.model.Video} interface instead.
	 */
	private boolean hasChapters = false;
	private boolean hasComments = false;
	
	public boolean isHasChapters() {
		return hasChapters;
	}

	public void setHasChapters(boolean hasChapters) {
		this.hasChapters = hasChapters;
	}

	public boolean isHasComments() {
		return hasComments;
	}

	public void setHasComments(boolean hasComments) {
		this.hasComments = hasComments;
	}

	private String streamUrl;
	private String streamIosUrl;
	private String streamAndroidUrl;
	
	public String getStreamUrl() {
		return streamUrl;
	}

	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}

	public String getStreamIosUrl() {
		return streamIosUrl;
	}

	public void setStreamIosUrl(String streamIosUrl) {
		this.streamIosUrl = streamIosUrl;
	}

	public String getStreamAndroidUrl() {
		return streamAndroidUrl;
	}

	public void setStreamAndroidUrl(String streamAndroidUrl) {
		this.streamAndroidUrl = streamAndroidUrl;
	}

	private String secureUrl;
	
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String shortTitle;
	private String shortName;

	private String image;
	private String imageSmall;
	private String imageMedium;

	private String bitrate;
	
	private String date;
	public String getSecureUrl() {
		return secureUrl;
	}

	public void setSecureUrl(String secureUrl) {
		this.secureUrl = secureUrl;
	}

	public File getMp4File() {
		return mp4File;
	}

	public void setMp4File(File mp4File) {
		this.mp4File = mp4File;
	}

	public File getPdfFile() {
		return pdfFile;
	}

	public void setPdfFile(File pdfFile) {
		this.pdfFile = pdfFile;
	}

	public File getMp3File() {
		return mp3File;
	}

	public void setMp3File(File mp3File) {
		this.mp3File = mp3File;
	}

	public File getM4vFile() {
		return m4vFile;
	}

	public void setM4vFile(File m4vFile) {
		this.m4vFile = m4vFile;
	}

	public File getM4aFile() {
		return m4aFile;
	}

	public void setM4aFile(File m4aFile) {
		this.m4aFile = m4aFile;
	}

	private String simpleDate = "";
	
	private File mp4File;
	private File pdfFile;
	private File mp3File;
	private File m4vFile;
	private File m4aFile;
	private File flvFile;
	private File oggFile;
	private File webmFile;
	
	
	public File getFlvFile() {
		return flvFile;
	}

	public void setFlvFile(File flvFile) {
		this.flvFile = flvFile;
	}

	public File getOggFile() {
		return oggFile;
	}

	public void setOggFile(File oggFile) {
		this.oggFile = oggFile;
	}

	public File getWebmFile() {
		return webmFile;
	}

	public void setWebmFile(File webmFile) {
		this.webmFile = webmFile;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSimpleDate() {
		return simpleDate;
	}

	public void setSimpleDate(String simpleDate) {
		this.simpleDate = simpleDate;
	}

	public String getBitrate() {
		return bitrate;
	}

	public void setBitrate(String bitrate) {
		this.bitrate = bitrate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageSmall() {
		return imageSmall;
	}

	public void setImageSmall(String imageSmall) {
		this.imageSmall = imageSmall;
	}

	public String getImageMedium() {
		return imageMedium;
	}

	public void setImageMedium(String imageMedium) {
		this.imageMedium = imageMedium;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	public VideoImpl() {
		
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	public String getSPreffix() {
		String preffix="";
		try{
			// extract time and date from the originalFileName
			String[] parameter = this.getSurl().split("\\.");
			preffix = parameter[0];
		}catch(NullPointerException npe){}
			return preffix;
		}
		
		public String getPreffix() {
			String preffix="";
			try{
				// extract time and date from the originalFileName
				String[] parameter = this.getFilename().split("\\_");
				// the upload-file has to end on 'mp4' or 'mp3' or 'm4v' or flv
				String parameter4 = parameter[3];
				// check parameter 3 - this is the date
				String l2gDate = parameter[2];
				// and parameter 4 - this is the time
				String l2gTime = parameter4.split("\\.")[0];
				String generationDate = l2gDate + "_" + l2gTime;
				preffix = parameter[0] + "_" + parameter[1] + "_" + generationDate;
			}catch(ArrayIndexOutOfBoundsException aiobe){
				preffix="";
			}
			return preffix;
		}
}