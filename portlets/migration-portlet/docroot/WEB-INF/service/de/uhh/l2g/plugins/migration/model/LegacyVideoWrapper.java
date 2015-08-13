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

package de.uhh.l2g.plugins.migration.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LegacyVideo}.
 * </p>
 *
 * @author unihh
 * @see LegacyVideo
 * @generated
 */
public class LegacyVideoWrapper implements LegacyVideo,
	ModelWrapper<LegacyVideo> {
	public LegacyVideoWrapper(LegacyVideo legacyVideo) {
		_legacyVideo = legacyVideo;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyVideo.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyVideo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("title", getTitle());
		attributes.put("tags", getTags());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("ownerId", getOwnerId());
		attributes.put("producerId", getProducerId());
		attributes.put("containerFormat", getContainerFormat());
		attributes.put("filename", getFilename());
		attributes.put("resolution", getResolution());
		attributes.put("duration", getDuration());
		attributes.put("hostId", getHostId());
		attributes.put("textId", getTextId());
		attributes.put("fileSize", getFileSize());
		attributes.put("generationDate", getGenerationDate());
		attributes.put("openAccess", getOpenAccess());
		attributes.put("downloadLink", getDownloadLink());
		attributes.put("metadataId", getMetadataId());
		attributes.put("surl", getSurl());
		attributes.put("hits", getHits());
		attributes.put("uploadDate", getUploadDate());
		attributes.put("permittedToSegment", getPermittedToSegment());
		attributes.put("facilityId", getFacilityId());
		attributes.put("citation2go", getCitation2go());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
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

		Long textId = (Long)attributes.get("textId");

		if (textId != null) {
			setTextId(textId);
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

		Long facilityId = (Long)attributes.get("facilityId");

		if (facilityId != null) {
			setFacilityId(facilityId);
		}

		Integer citation2go = (Integer)attributes.get("citation2go");

		if (citation2go != null) {
			setCitation2go(citation2go);
		}
	}

	/**
	* Returns the primary key of this legacy video.
	*
	* @return the primary key of this legacy video
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyVideo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy video.
	*
	* @param primaryKey the primary key of this legacy video
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyVideo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy video.
	*
	* @return the ID of this legacy video
	*/
	@Override
	public long getId() {
		return _legacyVideo.getId();
	}

	/**
	* Sets the ID of this legacy video.
	*
	* @param id the ID of this legacy video
	*/
	@Override
	public void setId(long id) {
		_legacyVideo.setId(id);
	}

	/**
	* Returns the title of this legacy video.
	*
	* @return the title of this legacy video
	*/
	@Override
	public java.lang.String getTitle() {
		return _legacyVideo.getTitle();
	}

	/**
	* Sets the title of this legacy video.
	*
	* @param title the title of this legacy video
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_legacyVideo.setTitle(title);
	}

	/**
	* Returns the tags of this legacy video.
	*
	* @return the tags of this legacy video
	*/
	@Override
	public java.lang.String getTags() {
		return _legacyVideo.getTags();
	}

	/**
	* Sets the tags of this legacy video.
	*
	* @param tags the tags of this legacy video
	*/
	@Override
	public void setTags(java.lang.String tags) {
		_legacyVideo.setTags(tags);
	}

	/**
	* Returns the lectureseries ID of this legacy video.
	*
	* @return the lectureseries ID of this legacy video
	*/
	@Override
	public long getLectureseriesId() {
		return _legacyVideo.getLectureseriesId();
	}

	/**
	* Sets the lectureseries ID of this legacy video.
	*
	* @param lectureseriesId the lectureseries ID of this legacy video
	*/
	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_legacyVideo.setLectureseriesId(lectureseriesId);
	}

	/**
	* Returns the owner ID of this legacy video.
	*
	* @return the owner ID of this legacy video
	*/
	@Override
	public long getOwnerId() {
		return _legacyVideo.getOwnerId();
	}

	/**
	* Sets the owner ID of this legacy video.
	*
	* @param ownerId the owner ID of this legacy video
	*/
	@Override
	public void setOwnerId(long ownerId) {
		_legacyVideo.setOwnerId(ownerId);
	}

	/**
	* Returns the producer ID of this legacy video.
	*
	* @return the producer ID of this legacy video
	*/
	@Override
	public long getProducerId() {
		return _legacyVideo.getProducerId();
	}

	/**
	* Sets the producer ID of this legacy video.
	*
	* @param producerId the producer ID of this legacy video
	*/
	@Override
	public void setProducerId(long producerId) {
		_legacyVideo.setProducerId(producerId);
	}

	/**
	* Returns the container format of this legacy video.
	*
	* @return the container format of this legacy video
	*/
	@Override
	public java.lang.String getContainerFormat() {
		return _legacyVideo.getContainerFormat();
	}

	/**
	* Sets the container format of this legacy video.
	*
	* @param containerFormat the container format of this legacy video
	*/
	@Override
	public void setContainerFormat(java.lang.String containerFormat) {
		_legacyVideo.setContainerFormat(containerFormat);
	}

	/**
	* Returns the filename of this legacy video.
	*
	* @return the filename of this legacy video
	*/
	@Override
	public java.lang.String getFilename() {
		return _legacyVideo.getFilename();
	}

	/**
	* Sets the filename of this legacy video.
	*
	* @param filename the filename of this legacy video
	*/
	@Override
	public void setFilename(java.lang.String filename) {
		_legacyVideo.setFilename(filename);
	}

	/**
	* Returns the resolution of this legacy video.
	*
	* @return the resolution of this legacy video
	*/
	@Override
	public java.lang.String getResolution() {
		return _legacyVideo.getResolution();
	}

	/**
	* Sets the resolution of this legacy video.
	*
	* @param resolution the resolution of this legacy video
	*/
	@Override
	public void setResolution(java.lang.String resolution) {
		_legacyVideo.setResolution(resolution);
	}

	/**
	* Returns the duration of this legacy video.
	*
	* @return the duration of this legacy video
	*/
	@Override
	public java.lang.String getDuration() {
		return _legacyVideo.getDuration();
	}

	/**
	* Sets the duration of this legacy video.
	*
	* @param duration the duration of this legacy video
	*/
	@Override
	public void setDuration(java.lang.String duration) {
		_legacyVideo.setDuration(duration);
	}

	/**
	* Returns the host ID of this legacy video.
	*
	* @return the host ID of this legacy video
	*/
	@Override
	public long getHostId() {
		return _legacyVideo.getHostId();
	}

	/**
	* Sets the host ID of this legacy video.
	*
	* @param hostId the host ID of this legacy video
	*/
	@Override
	public void setHostId(long hostId) {
		_legacyVideo.setHostId(hostId);
	}

	/**
	* Returns the text ID of this legacy video.
	*
	* @return the text ID of this legacy video
	*/
	@Override
	public long getTextId() {
		return _legacyVideo.getTextId();
	}

	/**
	* Sets the text ID of this legacy video.
	*
	* @param textId the text ID of this legacy video
	*/
	@Override
	public void setTextId(long textId) {
		_legacyVideo.setTextId(textId);
	}

	/**
	* Returns the file size of this legacy video.
	*
	* @return the file size of this legacy video
	*/
	@Override
	public java.lang.String getFileSize() {
		return _legacyVideo.getFileSize();
	}

	/**
	* Sets the file size of this legacy video.
	*
	* @param fileSize the file size of this legacy video
	*/
	@Override
	public void setFileSize(java.lang.String fileSize) {
		_legacyVideo.setFileSize(fileSize);
	}

	/**
	* Returns the generation date of this legacy video.
	*
	* @return the generation date of this legacy video
	*/
	@Override
	public java.lang.String getGenerationDate() {
		return _legacyVideo.getGenerationDate();
	}

	/**
	* Sets the generation date of this legacy video.
	*
	* @param generationDate the generation date of this legacy video
	*/
	@Override
	public void setGenerationDate(java.lang.String generationDate) {
		_legacyVideo.setGenerationDate(generationDate);
	}

	/**
	* Returns the open access of this legacy video.
	*
	* @return the open access of this legacy video
	*/
	@Override
	public int getOpenAccess() {
		return _legacyVideo.getOpenAccess();
	}

	/**
	* Sets the open access of this legacy video.
	*
	* @param openAccess the open access of this legacy video
	*/
	@Override
	public void setOpenAccess(int openAccess) {
		_legacyVideo.setOpenAccess(openAccess);
	}

	/**
	* Returns the download link of this legacy video.
	*
	* @return the download link of this legacy video
	*/
	@Override
	public int getDownloadLink() {
		return _legacyVideo.getDownloadLink();
	}

	/**
	* Sets the download link of this legacy video.
	*
	* @param downloadLink the download link of this legacy video
	*/
	@Override
	public void setDownloadLink(int downloadLink) {
		_legacyVideo.setDownloadLink(downloadLink);
	}

	/**
	* Returns the metadata ID of this legacy video.
	*
	* @return the metadata ID of this legacy video
	*/
	@Override
	public long getMetadataId() {
		return _legacyVideo.getMetadataId();
	}

	/**
	* Sets the metadata ID of this legacy video.
	*
	* @param metadataId the metadata ID of this legacy video
	*/
	@Override
	public void setMetadataId(long metadataId) {
		_legacyVideo.setMetadataId(metadataId);
	}

	/**
	* Returns the surl of this legacy video.
	*
	* @return the surl of this legacy video
	*/
	@Override
	public java.lang.String getSurl() {
		return _legacyVideo.getSurl();
	}

	/**
	* Sets the surl of this legacy video.
	*
	* @param surl the surl of this legacy video
	*/
	@Override
	public void setSurl(java.lang.String surl) {
		_legacyVideo.setSurl(surl);
	}

	/**
	* Returns the hits of this legacy video.
	*
	* @return the hits of this legacy video
	*/
	@Override
	public long getHits() {
		return _legacyVideo.getHits();
	}

	/**
	* Sets the hits of this legacy video.
	*
	* @param hits the hits of this legacy video
	*/
	@Override
	public void setHits(long hits) {
		_legacyVideo.setHits(hits);
	}

	/**
	* Returns the upload date of this legacy video.
	*
	* @return the upload date of this legacy video
	*/
	@Override
	public java.util.Date getUploadDate() {
		return _legacyVideo.getUploadDate();
	}

	/**
	* Sets the upload date of this legacy video.
	*
	* @param uploadDate the upload date of this legacy video
	*/
	@Override
	public void setUploadDate(java.util.Date uploadDate) {
		_legacyVideo.setUploadDate(uploadDate);
	}

	/**
	* Returns the permitted to segment of this legacy video.
	*
	* @return the permitted to segment of this legacy video
	*/
	@Override
	public int getPermittedToSegment() {
		return _legacyVideo.getPermittedToSegment();
	}

	/**
	* Sets the permitted to segment of this legacy video.
	*
	* @param permittedToSegment the permitted to segment of this legacy video
	*/
	@Override
	public void setPermittedToSegment(int permittedToSegment) {
		_legacyVideo.setPermittedToSegment(permittedToSegment);
	}

	/**
	* Returns the facility ID of this legacy video.
	*
	* @return the facility ID of this legacy video
	*/
	@Override
	public long getFacilityId() {
		return _legacyVideo.getFacilityId();
	}

	/**
	* Sets the facility ID of this legacy video.
	*
	* @param facilityId the facility ID of this legacy video
	*/
	@Override
	public void setFacilityId(long facilityId) {
		_legacyVideo.setFacilityId(facilityId);
	}

	/**
	* Returns the citation2go of this legacy video.
	*
	* @return the citation2go of this legacy video
	*/
	@Override
	public int getCitation2go() {
		return _legacyVideo.getCitation2go();
	}

	/**
	* Sets the citation2go of this legacy video.
	*
	* @param citation2go the citation2go of this legacy video
	*/
	@Override
	public void setCitation2go(int citation2go) {
		_legacyVideo.setCitation2go(citation2go);
	}

	@Override
	public boolean isNew() {
		return _legacyVideo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyVideo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyVideo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyVideo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyVideo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyVideo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyVideo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyVideo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyVideo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyVideo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyVideo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyVideoWrapper((LegacyVideo)_legacyVideo.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.LegacyVideo legacyVideo) {
		return _legacyVideo.compareTo(legacyVideo);
	}

	@Override
	public int hashCode() {
		return _legacyVideo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.LegacyVideo> toCacheModel() {
		return _legacyVideo.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyVideo toEscapedModel() {
		return new LegacyVideoWrapper(_legacyVideo.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.LegacyVideo toUnescapedModel() {
		return new LegacyVideoWrapper(_legacyVideo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyVideo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyVideo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyVideo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyVideoWrapper)) {
			return false;
		}

		LegacyVideoWrapper legacyVideoWrapper = (LegacyVideoWrapper)obj;

		if (Validator.equals(_legacyVideo, legacyVideoWrapper._legacyVideo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyVideo getWrappedLegacyVideo() {
		return _legacyVideo;
	}

	@Override
	public LegacyVideo getWrappedModel() {
		return _legacyVideo;
	}

	@Override
	public void resetOriginalValues() {
		_legacyVideo.resetOriginalValues();
	}

	private LegacyVideo _legacyVideo;
}