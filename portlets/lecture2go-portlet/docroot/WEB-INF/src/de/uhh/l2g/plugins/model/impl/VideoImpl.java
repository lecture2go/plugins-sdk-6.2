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
import java.util.ArrayList;

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
	private String lectureseriesName;
	private String lectureseriesNumber;
	private String creatorFullName;
	
	public String getLectureseriesName() {
		return lectureseriesName;
	}

	public void setLectureseriesName(String lectureseriesName) {
		this.lectureseriesName = lectureseriesName;
	}

	public String getLectureseriesNumber() {
		return lectureseriesNumber;
	}

	public void setLectureseriesNumber(String lectureseriesNumber) {
		this.lectureseriesNumber = lectureseriesNumber;
	}

	public String getCreatorFullName() {
		return creatorFullName;
	}

	public void setCreatorFullName(String creatorFullName) {
		this.creatorFullName = creatorFullName;
	}

	private String lectureseriesUrl;
	
	public String getLectureseriesUrl() {
		return lectureseriesUrl;
	}

	public void setLectureseriesUrl(String lectureseriesUrl) {
		this.lectureseriesUrl = lectureseriesUrl;
	}

	private Integer accessPermitted = 0;
	
	public Integer getAccessPermitted() {
		return accessPermitted;
	}

	public void setAccessPermitted(Integer accessPermitted) {
		this.accessPermitted = accessPermitted;
	}

	private ArrayList<String> playerUris;
	

	public ArrayList<String> getPlayerUris() {
		return playerUris;
	}

	public void setPlayerUris(ArrayList<String> playerUris) {
		this.playerUris = playerUris;
	}

	private String embedCommsy;
	
	public String getEmbedCommsy() {
		return embedCommsy;
	}

	public void setEmbedCommsy(String embedCommsy) {
		this.embedCommsy = embedCommsy;
	}

	private String embedIframe;

	private String embedHtml5;
	
	public String getEmbedIframe() {
		return embedIframe;
	}

	public void setEmbedIframe(String embedIframe) {
		this.embedIframe = embedIframe;
	}

	public String getEmbedHtml5() {
		return embedHtml5;
	}

	public void setEmbedHtml5(String embedHtml5) {
		this.embedHtml5 = embedHtml5;
	}

	private String vttChapterFile;
	private String vttThumbsFilde;
	

	public String getVttChapterFile() {
		return vttChapterFile;
	}

	public void setVttChapterFile(String vttChapterFile) {
		this.vttChapterFile = vttChapterFile;
	}

	public String getVttThumbsFilde() {
		return vttThumbsFilde;
	}

	public void setVttThumbsFilde(String vttThumbsFilde) {
		this.vttThumbsFilde = vttThumbsFilde;
	}

	private String mp4RssLink;
	private String mp3RssLink;
	private String m4vRssLink;
	private String m4aRssLink;
	private String oggRssLink;
	private String flvRssLink;
	private String webmRssLink;
	
	public String getMp4RssLink() {
		return mp4RssLink;
	}

	public void setMp4RssLink(String mp4RssLink) {
		this.mp4RssLink = mp4RssLink;
	}

	public String getMp3RssLink() {
		return mp3RssLink;
	}

	public void setMp3RssLink(String mp3RssLink) {
		this.mp3RssLink = mp3RssLink;
	}

	public String getM4vRssLink() {
		return m4vRssLink;
	}

	public void setM4vRssLink(String m4vRssLink) {
		this.m4vRssLink = m4vRssLink;
	}

	public String getM4aRssLink() {
		return m4aRssLink;
	}

	public void setM4aRssLink(String m4aRssLink) {
		this.m4aRssLink = m4aRssLink;
	}

	public String getOggRssLink() {
		return oggRssLink;
	}

	public void setOggRssLink(String oggRssLink) {
		this.oggRssLink = oggRssLink;
	}

	public String getFlvRssLink() {
		return flvRssLink;
	}

	public void setFlvRssLink(String flvRssLink) {
		this.flvRssLink = flvRssLink;
	}

	public String getWebmRssLink() {
		return webmRssLink;
	}

	public void setWebmRssLink(String webmRssLink) {
		this.webmRssLink = webmRssLink;
	}

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
	
	private String mp4DownloadLink;
	private String pdfDownloadLink;
	private String mp3DownloadLink;
	private String m4vDownloadLink;
	private String m4aDownloadLink;
	private String flvDownloadLink;
	private String oggDownloadLink;
	private String webmDownloadLink;

	public String getMp4DownloadLink() {
		return mp4DownloadLink;
	}

	public void setMp4DownloadLink(String mp4DownloadLink) {
		this.mp4DownloadLink = mp4DownloadLink;
	}

	public String getPdfDownloadLink() {
		return pdfDownloadLink;
	}

	public void setPdfDownloadLink(String pdfDownloadLink) {
		this.pdfDownloadLink = pdfDownloadLink;
	}

	public String getMp3DownloadLink() {
		return mp3DownloadLink;
	}

	public void setMp3DownloadLink(String mp3DownloadLink) {
		this.mp3DownloadLink = mp3DownloadLink;
	}

	public String getM4vDownloadLink() {
		return m4vDownloadLink;
	}

	public void setM4vDownloadLink(String m4vDownloadLink) {
		this.m4vDownloadLink = m4vDownloadLink;
	}

	public String getM4aDownloadLink() {
		return m4aDownloadLink;
	}

	public void setM4aDownloadLink(String m4aDownloadLink) {
		this.m4aDownloadLink = m4aDownloadLink;
	}

	public String getFlvDownloadLink() {
		return flvDownloadLink;
	}

	public void setFlvDownloadLink(String flvDownloadLink) {
		this.flvDownloadLink = flvDownloadLink;
	}

	public String getOggDownloadLink() {
		return oggDownloadLink;
	}

	public void setOggDownloadLink(String oggDownloadLink) {
		this.oggDownloadLink = oggDownloadLink;
	}

	public String getWebmDownloadLink() {
		return webmDownloadLink;
	}

	public void setWebmDownloadLink(String webmDownloadLink) {
		this.webmDownloadLink = webmDownloadLink;
	}

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
			String[] parameter = this.getSecureFilename().split("\\.");
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
		
		private String linkedCreators;

		public String getLinkedCreators() {
			return linkedCreators;
		}

		public void setLinkedCreators(String linkedCreators) {
			this.linkedCreators = linkedCreators;
		}

		private String creators;

		public String getCreators() {
			return creators;
		}

		public void setCreators(String creators) {
			this.creators = creators;
		} 
}