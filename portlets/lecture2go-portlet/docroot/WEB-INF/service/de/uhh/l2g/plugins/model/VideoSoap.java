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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
public class VideoSoap implements Serializable {
	public static VideoSoap toSoapModel(Video model) {
		VideoSoap soapModel = new VideoSoap();

		soapModel.setVideoId(model.getVideoId());
		soapModel.setTitle(model.getTitle());
		soapModel.setLectureseriesId(model.getLectureseriesId());
		soapModel.setProducerId(model.getProducerId());
		soapModel.setContainerFormat(model.getContainerFormat());
		soapModel.setFilename(model.getFilename());
		soapModel.setResolution(model.getResolution());
		soapModel.setDuration(model.getDuration());
		soapModel.setHostId(model.getHostId());
		soapModel.setFileSize(model.getFileSize());
		soapModel.setGenerationDate(model.getGenerationDate());
		soapModel.setOpenAccess(model.getOpenAccess());
		soapModel.setDownloadLink(model.getDownloadLink());
		soapModel.setMetadataId(model.getMetadataId());
		soapModel.setSurl(model.getSurl());
		soapModel.setHits(model.getHits());
		soapModel.setUploadDate(model.getUploadDate());
		soapModel.setPermittedToSegment(model.getPermittedToSegment());
		soapModel.setRootInstitutionId(model.getRootInstitutionId());
		soapModel.setCitation2go(model.getCitation2go());
		soapModel.setTermId(model.getTermId());
		soapModel.setVideoCreatorId(model.getVideoCreatorId());

		return soapModel;
	}

	public static VideoSoap[] toSoapModels(Video[] models) {
		VideoSoap[] soapModels = new VideoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoSoap[][] toSoapModels(Video[][] models) {
		VideoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoSoap[] toSoapModels(List<Video> models) {
		List<VideoSoap> soapModels = new ArrayList<VideoSoap>(models.size());

		for (Video model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoSoap[soapModels.size()]);
	}

	public VideoSoap() {
	}

	public long getPrimaryKey() {
		return _videoId;
	}

	public void setPrimaryKey(long pk) {
		setVideoId(pk);
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;
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

	public long getRootInstitutionId() {
		return _rootInstitutionId;
	}

	public void setRootInstitutionId(long rootInstitutionId) {
		_rootInstitutionId = rootInstitutionId;
	}

	public int getCitation2go() {
		return _citation2go;
	}

	public void setCitation2go(int citation2go) {
		_citation2go = citation2go;
	}

	public long getTermId() {
		return _termId;
	}

	public void setTermId(long termId) {
		_termId = termId;
	}

	public long getVideoCreatorId() {
		return _videoCreatorId;
	}

	public void setVideoCreatorId(long videoCreatorId) {
		_videoCreatorId = videoCreatorId;
	}

	private long _videoId;
	private String _title;
	private long _lectureseriesId;
	private long _producerId;
	private String _containerFormat;
	private String _filename;
	private String _resolution;
	private String _duration;
	private long _hostId;
	private String _fileSize;
	private String _generationDate;
	private int _openAccess;
	private int _downloadLink;
	private long _metadataId;
	private String _surl;
	private long _hits;
	private Date _uploadDate;
	private int _permittedToSegment;
	private long _rootInstitutionId;
	private int _citation2go;
	private long _termId;
	private long _videoCreatorId;
}