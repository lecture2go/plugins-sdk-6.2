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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.uhh.l2g.plugins.migration.service.ClpSerializer;
import de.uhh.l2g.plugins.migration.service.LegacyVideoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyVideoClp extends BaseModelImpl<LegacyVideo>
	implements LegacyVideo {
	public LegacyVideoClp() {
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
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_legacyVideoRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_legacyVideoRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTags() {
		return _tags;
	}

	@Override
	public void setTags(String tags) {
		_tags = tags;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setTags", String.class);

				method.invoke(_legacyVideoRemoteModel, tags);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_lectureseriesId = lectureseriesId;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_legacyVideoRemoteModel, lectureseriesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOwnerId() {
		return _ownerId;
	}

	@Override
	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerId", long.class);

				method.invoke(_legacyVideoRemoteModel, ownerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProducerId() {
		return _producerId;
	}

	@Override
	public void setProducerId(long producerId) {
		_producerId = producerId;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setProducerId", long.class);

				method.invoke(_legacyVideoRemoteModel, producerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContainerFormat() {
		return _containerFormat;
	}

	@Override
	public void setContainerFormat(String containerFormat) {
		_containerFormat = containerFormat;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setContainerFormat",
						String.class);

				method.invoke(_legacyVideoRemoteModel, containerFormat);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFilename() {
		return _filename;
	}

	@Override
	public void setFilename(String filename) {
		_filename = filename;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setFilename", String.class);

				method.invoke(_legacyVideoRemoteModel, filename);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResolution() {
		return _resolution;
	}

	@Override
	public void setResolution(String resolution) {
		_resolution = resolution;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setResolution", String.class);

				method.invoke(_legacyVideoRemoteModel, resolution);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuration() {
		return _duration;
	}

	@Override
	public void setDuration(String duration) {
		_duration = duration;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", String.class);

				method.invoke(_legacyVideoRemoteModel, duration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHostId() {
		return _hostId;
	}

	@Override
	public void setHostId(long hostId) {
		_hostId = hostId;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setHostId", long.class);

				method.invoke(_legacyVideoRemoteModel, hostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTextId() {
		return _textId;
	}

	@Override
	public void setTextId(long textId) {
		_textId = textId;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setTextId", long.class);

				method.invoke(_legacyVideoRemoteModel, textId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileSize() {
		return _fileSize;
	}

	@Override
	public void setFileSize(String fileSize) {
		_fileSize = fileSize;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setFileSize", String.class);

				method.invoke(_legacyVideoRemoteModel, fileSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGenerationDate() {
		return _generationDate;
	}

	@Override
	public void setGenerationDate(String generationDate) {
		_generationDate = generationDate;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setGenerationDate",
						String.class);

				method.invoke(_legacyVideoRemoteModel, generationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOpenAccess() {
		return _openAccess;
	}

	@Override
	public void setOpenAccess(int openAccess) {
		_openAccess = openAccess;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setOpenAccess", int.class);

				method.invoke(_legacyVideoRemoteModel, openAccess);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDownloadLink() {
		return _downloadLink;
	}

	@Override
	public void setDownloadLink(int downloadLink) {
		_downloadLink = downloadLink;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setDownloadLink", int.class);

				method.invoke(_legacyVideoRemoteModel, downloadLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMetadataId() {
		return _metadataId;
	}

	@Override
	public void setMetadataId(long metadataId) {
		_metadataId = metadataId;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataId", long.class);

				method.invoke(_legacyVideoRemoteModel, metadataId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSurl() {
		return _surl;
	}

	@Override
	public void setSurl(String surl) {
		_surl = surl;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setSurl", String.class);

				method.invoke(_legacyVideoRemoteModel, surl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHits() {
		return _hits;
	}

	@Override
	public void setHits(long hits) {
		_hits = hits;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setHits", long.class);

				method.invoke(_legacyVideoRemoteModel, hits);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUploadDate() {
		return _uploadDate;
	}

	@Override
	public void setUploadDate(Date uploadDate) {
		_uploadDate = uploadDate;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadDate", Date.class);

				method.invoke(_legacyVideoRemoteModel, uploadDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPermittedToSegment() {
		return _permittedToSegment;
	}

	@Override
	public void setPermittedToSegment(int permittedToSegment) {
		_permittedToSegment = permittedToSegment;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setPermittedToSegment",
						int.class);

				method.invoke(_legacyVideoRemoteModel, permittedToSegment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFacilityId() {
		return _facilityId;
	}

	@Override
	public void setFacilityId(long facilityId) {
		_facilityId = facilityId;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setFacilityId", long.class);

				method.invoke(_legacyVideoRemoteModel, facilityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCitation2go() {
		return _citation2go;
	}

	@Override
	public void setCitation2go(int citation2go) {
		_citation2go = citation2go;

		if (_legacyVideoRemoteModel != null) {
			try {
				Class<?> clazz = _legacyVideoRemoteModel.getClass();

				Method method = clazz.getMethod("setCitation2go", int.class);

				method.invoke(_legacyVideoRemoteModel, citation2go);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyVideoRemoteModel() {
		return _legacyVideoRemoteModel;
	}

	public void setLegacyVideoRemoteModel(BaseModel<?> legacyVideoRemoteModel) {
		_legacyVideoRemoteModel = legacyVideoRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _legacyVideoRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_legacyVideoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyVideoLocalServiceUtil.addLegacyVideo(this);
		}
		else {
			LegacyVideoLocalServiceUtil.updateLegacyVideo(this);
		}
	}

	@Override
	public LegacyVideo toEscapedModel() {
		return (LegacyVideo)ProxyUtil.newProxyInstance(LegacyVideo.class.getClassLoader(),
			new Class[] { LegacyVideo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyVideoClp clone = new LegacyVideoClp();

		clone.setId(getId());
		clone.setTitle(getTitle());
		clone.setTags(getTags());
		clone.setLectureseriesId(getLectureseriesId());
		clone.setOwnerId(getOwnerId());
		clone.setProducerId(getProducerId());
		clone.setContainerFormat(getContainerFormat());
		clone.setFilename(getFilename());
		clone.setResolution(getResolution());
		clone.setDuration(getDuration());
		clone.setHostId(getHostId());
		clone.setTextId(getTextId());
		clone.setFileSize(getFileSize());
		clone.setGenerationDate(getGenerationDate());
		clone.setOpenAccess(getOpenAccess());
		clone.setDownloadLink(getDownloadLink());
		clone.setMetadataId(getMetadataId());
		clone.setSurl(getSurl());
		clone.setHits(getHits());
		clone.setUploadDate(getUploadDate());
		clone.setPermittedToSegment(getPermittedToSegment());
		clone.setFacilityId(getFacilityId());
		clone.setCitation2go(getCitation2go());

		return clone;
	}

	@Override
	public int compareTo(LegacyVideo legacyVideo) {
		long primaryKey = legacyVideo.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyVideoClp)) {
			return false;
		}

		LegacyVideoClp legacyVideo = (LegacyVideoClp)obj;

		long primaryKey = legacyVideo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", tags=");
		sb.append(getTags());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", producerId=");
		sb.append(getProducerId());
		sb.append(", containerFormat=");
		sb.append(getContainerFormat());
		sb.append(", filename=");
		sb.append(getFilename());
		sb.append(", resolution=");
		sb.append(getResolution());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", hostId=");
		sb.append(getHostId());
		sb.append(", textId=");
		sb.append(getTextId());
		sb.append(", fileSize=");
		sb.append(getFileSize());
		sb.append(", generationDate=");
		sb.append(getGenerationDate());
		sb.append(", openAccess=");
		sb.append(getOpenAccess());
		sb.append(", downloadLink=");
		sb.append(getDownloadLink());
		sb.append(", metadataId=");
		sb.append(getMetadataId());
		sb.append(", surl=");
		sb.append(getSurl());
		sb.append(", hits=");
		sb.append(getHits());
		sb.append(", uploadDate=");
		sb.append(getUploadDate());
		sb.append(", permittedToSegment=");
		sb.append(getPermittedToSegment());
		sb.append(", facilityId=");
		sb.append(getFacilityId());
		sb.append(", citation2go=");
		sb.append(getCitation2go());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyVideo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tags</column-name><column-value><![CDATA[");
		sb.append(getTags());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producerId</column-name><column-value><![CDATA[");
		sb.append(getProducerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>containerFormat</column-name><column-value><![CDATA[");
		sb.append(getContainerFormat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>filename</column-name><column-value><![CDATA[");
		sb.append(getFilename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resolution</column-name><column-value><![CDATA[");
		sb.append(getResolution());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hostId</column-name><column-value><![CDATA[");
		sb.append(getHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>textId</column-name><column-value><![CDATA[");
		sb.append(getTextId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileSize</column-name><column-value><![CDATA[");
		sb.append(getFileSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>generationDate</column-name><column-value><![CDATA[");
		sb.append(getGenerationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openAccess</column-name><column-value><![CDATA[");
		sb.append(getOpenAccess());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>downloadLink</column-name><column-value><![CDATA[");
		sb.append(getDownloadLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataId</column-name><column-value><![CDATA[");
		sb.append(getMetadataId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surl</column-name><column-value><![CDATA[");
		sb.append(getSurl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hits</column-name><column-value><![CDATA[");
		sb.append(getHits());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uploadDate</column-name><column-value><![CDATA[");
		sb.append(getUploadDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permittedToSegment</column-name><column-value><![CDATA[");
		sb.append(getPermittedToSegment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facilityId</column-name><column-value><![CDATA[");
		sb.append(getFacilityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citation2go</column-name><column-value><![CDATA[");
		sb.append(getCitation2go());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _legacyVideoRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}