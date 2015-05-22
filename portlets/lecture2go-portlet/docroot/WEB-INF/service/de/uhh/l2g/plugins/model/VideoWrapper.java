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

package de.uhh.l2g.plugins.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Video}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video
 * @generated
 */
public class VideoWrapper implements Video, ModelWrapper<Video> {
	public VideoWrapper(Video video) {
		_video = video;
	}

	@Override
	public Class<?> getModelClass() {
		return Video.class;
	}

	@Override
	public String getModelClassName() {
		return Video.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoId", getVideoId());
		attributes.put("title", getTitle());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("producerId", getProducerId());
		attributes.put("containerFormat", getContainerFormat());
		attributes.put("filename", getFilename());
		attributes.put("resolution", getResolution());
		attributes.put("duration", getDuration());
		attributes.put("hostId", getHostId());
		attributes.put("fileSize", getFileSize());
		attributes.put("generationDate", getGenerationDate());
		attributes.put("openAccess", getOpenAccess());
		attributes.put("downloadLink", getDownloadLink());
		attributes.put("metadataId", getMetadataId());
		attributes.put("surl", getSurl());
		attributes.put("hits", getHits());
		attributes.put("uploadDate", getUploadDate());
		attributes.put("permittedToSegment", getPermittedToSegment());
		attributes.put("rootInstitutionId", getRootInstitutionId());
		attributes.put("citation2go", getCitation2go());
		attributes.put("termId", getTermId());
		attributes.put("videoCreatorId", getVideoCreatorId());
		attributes.put("tags", getTags());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Long producerId = (Long)attributes.get("producerId");

		if (producerId != null) {
			setProducerId(producerId);
		}

		String containerFormat = (String)attributes.get("containerFormat");

		if (containerFormat != null) {
			setContainerFormat(containerFormat);
		}

		String filename = (String)attributes.get("filename");

		if (filename != null) {
			setFilename(filename);
		}

		String resolution = (String)attributes.get("resolution");

		if (resolution != null) {
			setResolution(resolution);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Long hostId = (Long)attributes.get("hostId");

		if (hostId != null) {
			setHostId(hostId);
		}

		String fileSize = (String)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		String generationDate = (String)attributes.get("generationDate");

		if (generationDate != null) {
			setGenerationDate(generationDate);
		}

		Integer openAccess = (Integer)attributes.get("openAccess");

		if (openAccess != null) {
			setOpenAccess(openAccess);
		}

		Integer downloadLink = (Integer)attributes.get("downloadLink");

		if (downloadLink != null) {
			setDownloadLink(downloadLink);
		}

		Long metadataId = (Long)attributes.get("metadataId");

		if (metadataId != null) {
			setMetadataId(metadataId);
		}

		String surl = (String)attributes.get("surl");

		if (surl != null) {
			setSurl(surl);
		}

		Long hits = (Long)attributes.get("hits");

		if (hits != null) {
			setHits(hits);
		}

		Date uploadDate = (Date)attributes.get("uploadDate");

		if (uploadDate != null) {
			setUploadDate(uploadDate);
		}

		Integer permittedToSegment = (Integer)attributes.get(
				"permittedToSegment");

		if (permittedToSegment != null) {
			setPermittedToSegment(permittedToSegment);
		}

		Long rootInstitutionId = (Long)attributes.get("rootInstitutionId");

		if (rootInstitutionId != null) {
			setRootInstitutionId(rootInstitutionId);
		}

		Integer citation2go = (Integer)attributes.get("citation2go");

		if (citation2go != null) {
			setCitation2go(citation2go);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		Long videoCreatorId = (Long)attributes.get("videoCreatorId");

		if (videoCreatorId != null) {
			setVideoCreatorId(videoCreatorId);
		}

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
		}
	}

	/**
	* Returns the primary key of this video.
	*
	* @return the primary key of this video
	*/
	@Override
	public long getPrimaryKey() {
		return _video.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video.
	*
	* @param primaryKey the primary key of this video
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_video.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video ID of this video.
	*
	* @return the video ID of this video
	*/
	@Override
	public long getVideoId() {
		return _video.getVideoId();
	}

	/**
	* Sets the video ID of this video.
	*
	* @param videoId the video ID of this video
	*/
	@Override
	public void setVideoId(long videoId) {
		_video.setVideoId(videoId);
	}

	/**
	* Returns the title of this video.
	*
	* @return the title of this video
	*/
	@Override
	public java.lang.String getTitle() {
		return _video.getTitle();
	}

	/**
	* Sets the title of this video.
	*
	* @param title the title of this video
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_video.setTitle(title);
	}

	/**
	* Returns the lectureseries ID of this video.
	*
	* @return the lectureseries ID of this video
	*/
	@Override
	public long getLectureseriesId() {
		return _video.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this video.
	*
	* @param lectureseriesId the lectureseries ID of this video
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_video.setLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the producer ID of this video.
	*
	* @return the producer ID of this video
	*/
	@Override
	public long getProducerId() {
		return _video.getProducerId();
	}

	/**
	* Sets the producer ID of this video.
	*
	* @param producerId the producer ID of this video
	*/
	@Override
	public void setProducerId(long producerId) {
		_video.setProducerId(producerId);
	}

	/**
	* Returns the container format of this video.
	*
	* @return the container format of this video
	*/
	@Override
	public java.lang.String getContainerFormat() {
		return _video.getContainerFormat();
	}

	/**
	* Sets the container format of this video.
	*
	* @param containerFormat the container format of this video
	*/
	@Override
	public void setContainerFormat(java.lang.String containerFormat) {
		_video.setContainerFormat(containerFormat);
	}

	/**
	* Returns the filename of this video.
	*
	* @return the filename of this video
	*/
	@Override
	public java.lang.String getFilename() {
		return _video.getFilename();
	}

	/**
	* Sets the filename of this video.
	*
	* @param filename the filename of this video
	*/
	@Override
	public void setFilename(java.lang.String filename) {
		_video.setFilename(filename);
	}

	/**
	* Returns the resolution of this video.
	*
	* @return the resolution of this video
	*/
	@Override
	public java.lang.String getResolution() {
		return _video.getResolution();
	}

	/**
	* Sets the resolution of this video.
	*
	* @param resolution the resolution of this video
	*/
	@Override
	public void setResolution(java.lang.String resolution) {
		_video.setResolution(resolution);
	}

	/**
	* Returns the duration of this video.
	*
	* @return the duration of this video
	*/
	@Override
	public java.lang.String getDuration() {
		return _video.getDuration();
	}

	/**
	* Sets the duration of this video.
	*
	* @param duration the duration of this video
	*/
	@Override
	public void setDuration(java.lang.String duration) {
		_video.setDuration(duration);
	}

	/**
	* Returns the host ID of this video.
	*
	* @return the host ID of this video
	*/
	@Override
	public long getHostId() {
		return _video.getHostId();
	}

	/**
	* Sets the host ID of this video.
	*
	* @param hostId the host ID of this video
	*/
	@Override
	public void setHostId(long hostId) {
		_video.setHostId(hostId);
	}

	/**
	* Returns the file size of this video.
	*
	* @return the file size of this video
	*/
	@Override
	public java.lang.String getFileSize() {
		return _video.getFileSize();
	}

	/**
	* Sets the file size of this video.
	*
	* @param fileSize the file size of this video
	*/
	@Override
	public void setFileSize(java.lang.String fileSize) {
		_video.setFileSize(fileSize);
	}

	/**
	* Returns the generation date of this video.
	*
	* @return the generation date of this video
	*/
	@Override
	public java.lang.String getGenerationDate() {
		return _video.getGenerationDate();
	}

	/**
	* Sets the generation date of this video.
	*
	* @param generationDate the generation date of this video
	*/
	@Override
	public void setGenerationDate(java.lang.String generationDate) {
		_video.setGenerationDate(generationDate);
	}

	/**
	* Returns the open access of this video.
	*
	* @return the open access of this video
	*/
	@Override
	public int getOpenAccess() {
		return _video.getOpenAccess();
	}

	/**
	* Sets the open access of this video.
	*
	* @param openAccess the open access of this video
	*/
	@Override
	public void setOpenAccess(int openAccess) {
		_video.setOpenAccess(openAccess);
	}

	/**
	* Returns the download link of this video.
	*
	* @return the download link of this video
	*/
	@Override
	public int getDownloadLink() {
		return _video.getDownloadLink();
	}

	/**
	* Sets the download link of this video.
	*
	* @param downloadLink the download link of this video
	*/
	@Override
	public void setDownloadLink(int downloadLink) {
		_video.setDownloadLink(downloadLink);
	}

	/**
	* Returns the metadata ID of this video.
	*
	* @return the metadata ID of this video
	*/
	@Override
	public long getMetadataId() {
		return _video.getMetadataId();
	}

	/**
	* Sets the metadata ID of this video.
	*
	* @param metadataId the metadata ID of this video
	*/
	@Override
	public void setMetadataId(long metadataId) {
		_video.setMetadataId(metadataId);
	}

	/**
	* Returns the surl of this video.
	*
	* @return the surl of this video
	*/
	@Override
	public java.lang.String getSurl() {
		return _video.getSurl();
	}

	/**
	* Sets the surl of this video.
	*
	* @param surl the surl of this video
	*/
	@Override
	public void setSurl(java.lang.String surl) {
		_video.setSurl(surl);
	}

	/**
	* Returns the hits of this video.
	*
	* @return the hits of this video
	*/
	@Override
	public long getHits() {
		return _video.getHits();
	}

	/**
	* Sets the hits of this video.
	*
	* @param hits the hits of this video
	*/
	@Override
	public void setHits(long hits) {
		_video.setHits(hits);
	}

	/**
	* Returns the upload date of this video.
	*
	* @return the upload date of this video
	*/
	@Override
	public java.util.Date getUploadDate() {
		return _video.getUploadDate();
	}

	/**
	* Sets the upload date of this video.
	*
	* @param uploadDate the upload date of this video
	*/
	@Override
	public void setUploadDate(java.util.Date uploadDate) {
		_video.setUploadDate(uploadDate);
	}

	/**
	* Returns the permitted to segment of this video.
	*
	* @return the permitted to segment of this video
	*/
	@Override
	public int getPermittedToSegment() {
		return _video.getPermittedToSegment();
	}

	/**
	* Sets the permitted to segment of this video.
	*
	* @param permittedToSegment the permitted to segment of this video
	*/
	@Override
	public void setPermittedToSegment(int permittedToSegment) {
		_video.setPermittedToSegment(permittedToSegment);
	}

	/**
	* Returns the root institution ID of this video.
	*
	* @return the root institution ID of this video
	*/
	@Override
	public long getRootInstitutionId() {
		return _video.getRootInstitutionId();
	}

	/**
	* Sets the root institution ID of this video.
	*
	* @param rootInstitutionId the root institution ID of this video
	*/
	@Override
	public void setRootInstitutionId(long rootInstitutionId) {
		_video.setRootInstitutionId(rootInstitutionId);
	}

	/**
	* Returns the citation2go of this video.
	*
	* @return the citation2go of this video
	*/
	@Override
	public int getCitation2go() {
		return _video.getCitation2go();
	}

	/**
	* Sets the citation2go of this video.
	*
	* @param citation2go the citation2go of this video
	*/
	@Override
	public void setCitation2go(int citation2go) {
		_video.setCitation2go(citation2go);
	}

	/**
	* Returns the term ID of this video.
	*
	* @return the term ID of this video
	*/
	@Override
	public long getTermId() {
		return _video.getTermId();
	}

	/**
	* Sets the term ID of this video.
	*
	* @param termId the term ID of this video
	*/
	@Override
	public void setTermId(long termId) {
		_video.setTermId(termId);
	}

	/**
	* Returns the video creator ID of this video.
	*
	* @return the video creator ID of this video
	*/
	@Override
	public long getVideoCreatorId() {
		return _video.getVideoCreatorId();
	}

	/**
	* Sets the video creator ID of this video.
	*
	* @param videoCreatorId the video creator ID of this video
	*/
	@Override
	public void setVideoCreatorId(long videoCreatorId) {
		_video.setVideoCreatorId(videoCreatorId);
	}

	/**
	* Returns the tags of this video.
	*
	* @return the tags of this video
	*/
	@Override
	public java.lang.String getTags() {
		return _video.getTags();
	}

	/**
	* Sets the tags of this video.
	*
	* @param tags the tags of this video
	*/
	@Override
	public void setTags(java.lang.String tags) {
		_video.setTags(tags);
	}

	@Override
	public boolean isNew() {
		return _video.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_video.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _video.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_video.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _video.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _video.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_video.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _video.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_video.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_video.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_video.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoWrapper((Video)_video.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Video video) {
		return _video.compareTo(video);
	}

	@Override
	public int hashCode() {
		return _video.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Video> toCacheModel() {
		return _video.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Video toEscapedModel() {
		return new VideoWrapper(_video.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Video toUnescapedModel() {
		return new VideoWrapper(_video.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _video.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _video.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_video.persist();
	}

	@Override
	public java.lang.String getVttFile() {
		return _video.getVttFile();
	}

	@Override
	public void setVttFile(java.lang.String vttFile) {
		_video.setVttFile(vttFile);
	}

	@Override
	public java.lang.String getMp4RssLink() {
		return _video.getMp4RssLink();
	}

	@Override
	public void setMp4RssLink(java.lang.String mp4RssLink) {
		_video.setMp4RssLink(mp4RssLink);
	}

	@Override
	public java.lang.String getMp3RssLink() {
		return _video.getMp3RssLink();
	}

	@Override
	public void setMp3RssLink(java.lang.String mp3RssLink) {
		_video.setMp3RssLink(mp3RssLink);
	}

	@Override
	public java.lang.String getM4vRssLink() {
		return _video.getM4vRssLink();
	}

	@Override
	public void setM4vRssLink(java.lang.String m4vRssLink) {
		_video.setM4vRssLink(m4vRssLink);
	}

	@Override
	public java.lang.String getM4aRssLink() {
		return _video.getM4aRssLink();
	}

	@Override
	public void setM4aRssLink(java.lang.String m4aRssLink) {
		_video.setM4aRssLink(m4aRssLink);
	}

	@Override
	public java.lang.String getOggRssLink() {
		return _video.getOggRssLink();
	}

	@Override
	public void setOggRssLink(java.lang.String oggRssLink) {
		_video.setOggRssLink(oggRssLink);
	}

	@Override
	public java.lang.String getFlvRssLink() {
		return _video.getFlvRssLink();
	}

	@Override
	public void setFlvRssLink(java.lang.String flvRssLink) {
		_video.setFlvRssLink(flvRssLink);
	}

	@Override
	public java.lang.String getWebmRssLink() {
		return _video.getWebmRssLink();
	}

	@Override
	public void setWebmRssLink(java.lang.String webmRssLink) {
		_video.setWebmRssLink(webmRssLink);
	}

	@Override
	public boolean isHasChapters() {
		return _video.isHasChapters();
	}

	@Override
	public void setHasChapters(boolean hasChapters) {
		_video.setHasChapters(hasChapters);
	}

	@Override
	public boolean isHasComments() {
		return _video.isHasComments();
	}

	@Override
	public void setHasComments(boolean hasComments) {
		_video.setHasComments(hasComments);
	}

	@Override
	public java.lang.String getStreamUrl() {
		return _video.getStreamUrl();
	}

	@Override
	public void setStreamUrl(java.lang.String streamUrl) {
		_video.setStreamUrl(streamUrl);
	}

	@Override
	public java.lang.String getStreamIosUrl() {
		return _video.getStreamIosUrl();
	}

	@Override
	public void setStreamIosUrl(java.lang.String streamIosUrl) {
		_video.setStreamIosUrl(streamIosUrl);
	}

	@Override
	public java.lang.String getStreamAndroidUrl() {
		return _video.getStreamAndroidUrl();
	}

	@Override
	public void setStreamAndroidUrl(java.lang.String streamAndroidUrl) {
		_video.setStreamAndroidUrl(streamAndroidUrl);
	}

	@Override
	public java.lang.String getUrl() {
		return _video.getUrl();
	}

	@Override
	public void setUrl(java.lang.String url) {
		_video.setUrl(url);
	}

	@Override
	public java.lang.String getSecureUrl() {
		return _video.getSecureUrl();
	}

	@Override
	public void setSecureUrl(java.lang.String secureUrl) {
		_video.setSecureUrl(secureUrl);
	}

	@Override
	public java.io.File getMp4File() {
		return _video.getMp4File();
	}

	@Override
	public void setMp4File(java.io.File mp4File) {
		_video.setMp4File(mp4File);
	}

	@Override
	public java.io.File getPdfFile() {
		return _video.getPdfFile();
	}

	@Override
	public void setPdfFile(java.io.File pdfFile) {
		_video.setPdfFile(pdfFile);
	}

	@Override
	public java.io.File getMp3File() {
		return _video.getMp3File();
	}

	@Override
	public void setMp3File(java.io.File mp3File) {
		_video.setMp3File(mp3File);
	}

	@Override
	public java.io.File getM4vFile() {
		return _video.getM4vFile();
	}

	@Override
	public void setM4vFile(java.io.File m4vFile) {
		_video.setM4vFile(m4vFile);
	}

	@Override
	public java.io.File getM4aFile() {
		return _video.getM4aFile();
	}

	@Override
	public void setM4aFile(java.io.File m4aFile) {
		_video.setM4aFile(m4aFile);
	}

	@Override
	public java.lang.String getMp4OpenAccessDownloadLink() {
		return _video.getMp4OpenAccessDownloadLink();
	}

	@Override
	public void setMp4OpenAccessDownloadLink(
		java.lang.String mp4OpenAccessDownloadLink) {
		_video.setMp4OpenAccessDownloadLink(mp4OpenAccessDownloadLink);
	}

	@Override
	public java.lang.String getPdfOpenAccessDownloadLink() {
		return _video.getPdfOpenAccessDownloadLink();
	}

	@Override
	public void setPdfOpenAccessDownloadLink(
		java.lang.String pdfOpenAccessDownloadLink) {
		_video.setPdfOpenAccessDownloadLink(pdfOpenAccessDownloadLink);
	}

	@Override
	public java.lang.String getMp3OpenAccessDownloadLink() {
		return _video.getMp3OpenAccessDownloadLink();
	}

	@Override
	public void setMp3OpenAccessDownloadLink(
		java.lang.String mp3OpenAccessDownloadLink) {
		_video.setMp3OpenAccessDownloadLink(mp3OpenAccessDownloadLink);
	}

	@Override
	public java.lang.String getM4vOpenAccessDownloadLink() {
		return _video.getM4vOpenAccessDownloadLink();
	}

	@Override
	public void setM4vOpenAccessDownloadLink(
		java.lang.String m4vOpenAccessDownloadLink) {
		_video.setM4vOpenAccessDownloadLink(m4vOpenAccessDownloadLink);
	}

	@Override
	public java.lang.String getM4aOpenAccessDownloadLink() {
		return _video.getM4aOpenAccessDownloadLink();
	}

	@Override
	public void setM4aOpenAccessDownloadLink(
		java.lang.String m4aOpenAccessDownloadLink) {
		_video.setM4aOpenAccessDownloadLink(m4aOpenAccessDownloadLink);
	}

	@Override
	public java.lang.String getFlvOpenAccessDownloadLink() {
		return _video.getFlvOpenAccessDownloadLink();
	}

	@Override
	public void setFlvOpenAccessDownloadLink(
		java.lang.String flvOpenAccessDownloadLink) {
		_video.setFlvOpenAccessDownloadLink(flvOpenAccessDownloadLink);
	}

	@Override
	public java.lang.String getOggOpenAccessDownloadLink() {
		return _video.getOggOpenAccessDownloadLink();
	}

	@Override
	public void setOggOpenAccessDownloadLink(
		java.lang.String oggOpenAccessDownloadLink) {
		_video.setOggOpenAccessDownloadLink(oggOpenAccessDownloadLink);
	}

	@Override
	public java.lang.String getWebmOpenAccessDownloadLink() {
		return _video.getWebmOpenAccessDownloadLink();
	}

	@Override
	public void setWebmOpenAccessDownloadLink(
		java.lang.String webmOpenAccessDownloadLink) {
		_video.setWebmOpenAccessDownloadLink(webmOpenAccessDownloadLink);
	}

	@Override
	public java.io.File getFlvFile() {
		return _video.getFlvFile();
	}

	@Override
	public void setFlvFile(java.io.File flvFile) {
		_video.setFlvFile(flvFile);
	}

	@Override
	public java.io.File getOggFile() {
		return _video.getOggFile();
	}

	@Override
	public void setOggFile(java.io.File oggFile) {
		_video.setOggFile(oggFile);
	}

	@Override
	public java.io.File getWebmFile() {
		return _video.getWebmFile();
	}

	@Override
	public void setWebmFile(java.io.File webmFile) {
		_video.setWebmFile(webmFile);
	}

	@Override
	public java.lang.String getDate() {
		return _video.getDate();
	}

	@Override
	public void setDate(java.lang.String date) {
		_video.setDate(date);
	}

	@Override
	public java.lang.String getSimpleDate() {
		return _video.getSimpleDate();
	}

	@Override
	public void setSimpleDate(java.lang.String simpleDate) {
		_video.setSimpleDate(simpleDate);
	}

	@Override
	public java.lang.String getBitrate() {
		return _video.getBitrate();
	}

	@Override
	public void setBitrate(java.lang.String bitrate) {
		_video.setBitrate(bitrate);
	}

	@Override
	public java.lang.String getImage() {
		return _video.getImage();
	}

	@Override
	public void setImage(java.lang.String image) {
		_video.setImage(image);
	}

	@Override
	public java.lang.String getImageSmall() {
		return _video.getImageSmall();
	}

	@Override
	public void setImageSmall(java.lang.String imageSmall) {
		_video.setImageSmall(imageSmall);
	}

	@Override
	public java.lang.String getImageMedium() {
		return _video.getImageMedium();
	}

	@Override
	public void setImageMedium(java.lang.String imageMedium) {
		_video.setImageMedium(imageMedium);
	}

	@Override
	public java.lang.String getShortTitle() {
		return _video.getShortTitle();
	}

	@Override
	public void setShortTitle(java.lang.String shortTitle) {
		_video.setShortTitle(shortTitle);
	}

	@Override
	public java.lang.String getShortName() {
		return _video.getShortName();
	}

	@Override
	public void setShortName(java.lang.String shortName) {
		_video.setShortName(shortName);
	}

	@Override
	public java.lang.String getSPreffix() {
		return _video.getSPreffix();
	}

	@Override
	public java.lang.String getPreffix() {
		return _video.getPreffix();
	}

	@Override
	public java.lang.String getCreators() {
		return _video.getCreators();
	}

	@Override
	public void setCreators(java.lang.String creators) {
		_video.setCreators(creators);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoWrapper)) {
			return false;
		}

		VideoWrapper videoWrapper = (VideoWrapper)obj;

		if (Validator.equals(_video, videoWrapper._video)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Video getWrappedVideo() {
		return _video;
	}

	@Override
	public Video getWrappedModel() {
		return _video;
	}

	@Override
	public void resetOriginalValues() {
		_video.resetOriginalValues();
	}

	private Video _video;
}