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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author unihh
 * @generated
 */
public class LegacyVideoSoap implements Serializable {
	public static LegacyVideoSoap toSoapModel(LegacyVideo model) {
		LegacyVideoSoap soapModel = new LegacyVideoSoap();

		soapModel.setId(model.getId());
		soapModel.setTitle(model.getTitle());
		soapModel.setTags(model.getTags());
		soapModel.setLectureseriesId(model.getLectureseriesId());
		soapModel.setOwnerId(model.getOwnerId());
		soapModel.setProducerId(model.getProducerId());
		soapModel.setContainerFormat(model.getContainerFormat());
		soapModel.setFilename(model.getFilename());
		soapModel.setResolution(model.getResolution());
		soapModel.setDuration(model.getDuration());
		soapModel.setHostId(model.getHostId());
		soapModel.setTextId(model.getTextId());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setGenerationDate(model.getGenerationDate());
		soapModel.setOpenAccess(model.getOpenAccess());
		soapModel.setDownloadLink(model.getDownloadLink());
		soapModel.setMetadataId(model.getMetadataId());
		soapModel.setSurl(model.getSurl());
		soapModel.setHits(model.getHits());
		soapModel.setUploadDate(model.getUploadDate());
		soapModel.setPermittedToSegment(model.getPermittedToSegment());
		soapModel.setFacilityId(model.getFacilityId());
		soapModel.setCitation2go(model.getCitation2go());

		return soapModel;
	}

	public static LegacyVideoSoap[] toSoapModels(LegacyVideo[] models) {
		LegacyVideoSoap[] soapModels = new LegacyVideoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LegacyVideoSoap[][] toSoapModels(LegacyVideo[][] models) {
		LegacyVideoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LegacyVideoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LegacyVideoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LegacyVideoSoap[] toSoapModels(List<LegacyVideo> models) {
		List<LegacyVideoSoap> soapModels = new ArrayList<LegacyVideoSoap>(models.size());

		for (LegacyVideo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LegacyVideoSoap[soapModels.size()]);
	}

	public LegacyVideoSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getTags() {
		return _tags;
	}

	public void setTags(String tags) {
		_tags = tags;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
	}

	public long getOwnerId() {
		return _ownerId;
	}

	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;
	}

	public long getProducerId() {
		return _producerId;
	}

	public void setProducerId(long producerId) {
		_producerId = producerId;
	}

	public String getContainerFormat() {
		return _containerFormat;
	}

	public void setContainerFormat(String containerFormat) {
		_containerFormat = containerFormat;
	}

	public String getFilename() {
		return _filename;
	}

	public void setFilename(String filename) {
		_filename = filename;
	}

	public String getResolution() {
		return _resolution;
	}

	public void setResolution(String resolution) {
		_resolution = resolution;
	}

	public String getDuration() {
		return _duration;
	}

	public void setDuration(String duration) {
		_duration = duration;
	}

	public long getHostId() {
		return _hostId;
	}

	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	public long getTextId() {
		return _textId;
	}

	public void setTextId(long textId) {
		_textId = textId;
	}

	public String getFileSize() {
		return _fileSize;
	}

	public void setFileSize(String fileSize) {
		_fileSize = fileSize;
	}

	public String getGenerationDate() {
		return _generationDate;
	}

	public void setGenerationDate(String generationDate) {
		_generationDate = generationDate;
	}

	public int getOpenAccess() {
		return _openAccess;
	}

	public void setOpenAccess(int openAccess) {
		_openAccess = openAccess;
	}

	public int getDownloadLink() {
		return _downloadLink;
	}

	public void setDownloadLink(int downloadLink) {
		_downloadLink = downloadLink;
	}

	public long getMetadataId() {
		return _metadataId;
	}

	public void setMetadataId(long metadataId) {
		_metadataId = metadataId;
	}

	public String getSurl() {
		return _surl;
	}

	public void setSurl(String surl) {
		_surl = surl;
	}

	public long getHits() {
		return _hits;
	}

	public void setHits(long hits) {
		_hits = hits;
	}

	public Date getUploadDate() {
		return _uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		_uploadDate = uploadDate;
	}

	public int getPermittedToSegment() {
		return _permittedToSegment;
	}

	public void setPermittedToSegment(int permittedToSegment) {
		_permittedToSegment = permittedToSegment;
	}

	public long getFacilityId() {
		return _facilityId;
	}

	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;
	}

	public int getCitation2go() {
		return _citation2go;
	}

	public void setCitation2go(int citation2go) {
		_citation2go = citation2go;
	}

	private long _id;
	private String _title;
	private String _tags;
	private long _lectureseriesId;
	private long _ownerId;
	private long _producerId;
	private String _containerFormat;
	private String _filename;
	private String _resolution;
	private String _duration;
	private long _hostId;
	private long _textId;
	private String _fileSize;
	private String _generationDate;
	private int _openAccess;
	private int _downloadLink;
	private long _metadataId;
	private String _surl;
	private long _hits;
	private Date _uploadDate;
	private int _permittedToSegment;
	private long _facilityId;
	private int _citation2go;
}