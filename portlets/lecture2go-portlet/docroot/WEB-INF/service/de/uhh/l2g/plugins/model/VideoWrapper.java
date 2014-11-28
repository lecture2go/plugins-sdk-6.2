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
		attributes.put("tags", getTags());
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

		String tags = (String)attributes.get("tags");

		if (tags != null) {
			setTags(tags);
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

		Integer hits = (Integer)attributes.get("hits");

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
	public int getHits() {
		return _video.getHits();
	}

	/**
	* Sets the hits of this video.
	*
	* @param hits the hits of this video
	*/
	@Override
	public void setHits(int hits) {
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