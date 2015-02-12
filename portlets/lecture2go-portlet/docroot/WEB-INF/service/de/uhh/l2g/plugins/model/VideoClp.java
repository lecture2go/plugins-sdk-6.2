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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class VideoClp extends BaseModelImpl<Video> implements Video {
	public VideoClp() {
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
	public long getPrimaryKey() {
		return _videoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
	}

	@Override
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_videoId = videoId;

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoId", long.class);

				method.invoke(_videoRemoteModel, videoId);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_videoRemoteModel, title);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setTags", String.class);

				method.invoke(_videoRemoteModel, tags);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_videoRemoteModel, lectureseriesId);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setProducerId", long.class);

				method.invoke(_videoRemoteModel, producerId);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setContainerFormat",
						String.class);

				method.invoke(_videoRemoteModel, containerFormat);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setFilename", String.class);

				method.invoke(_videoRemoteModel, filename);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setResolution", String.class);

				method.invoke(_videoRemoteModel, resolution);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", String.class);

				method.invoke(_videoRemoteModel, duration);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setHostId", long.class);

				method.invoke(_videoRemoteModel, hostId);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setFileSize", String.class);

				method.invoke(_videoRemoteModel, fileSize);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setGenerationDate",
						String.class);

				method.invoke(_videoRemoteModel, generationDate);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setOpenAccess", int.class);

				method.invoke(_videoRemoteModel, openAccess);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setDownloadLink", int.class);

				method.invoke(_videoRemoteModel, downloadLink);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadataId", long.class);

				method.invoke(_videoRemoteModel, metadataId);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setSurl", String.class);

				method.invoke(_videoRemoteModel, surl);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setHits", long.class);

				method.invoke(_videoRemoteModel, hits);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadDate", Date.class);

				method.invoke(_videoRemoteModel, uploadDate);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setPermittedToSegment",
						int.class);

				method.invoke(_videoRemoteModel, permittedToSegment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRootInstitutionId() {
		return _rootInstitutionId;
	}

	@Override
	public void setRootInstitutionId(long rootInstitutionId) {
		_rootInstitutionId = rootInstitutionId;

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setRootInstitutionId",
						long.class);

				method.invoke(_videoRemoteModel, rootInstitutionId);
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

		if (_videoRemoteModel != null) {
			try {
				Class<?> clazz = _videoRemoteModel.getClass();

				Method method = clazz.getMethod("setCitation2go", int.class);

				method.invoke(_videoRemoteModel, citation2go);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setImageMedium(java.lang.String imageMedium) {
		try {
			String methodName = "setImageMedium";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { imageMedium };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getShortTitle() {
		try {
			String methodName = "getShortTitle";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getPreffix() {
		try {
			String methodName = "getPreffix";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isHasComments() {
		try {
			String methodName = "isHasComments";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getUrl() {
		try {
			String methodName = "getUrl";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStreamUrl() {
		try {
			String methodName = "getStreamUrl";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getImageMedium() {
		try {
			String methodName = "getImageMedium";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setImage(java.lang.String image) {
		try {
			String methodName = "setImage";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { image };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getImageSmall() {
		try {
			String methodName = "getImageSmall";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setOggFile(java.io.File oggFile) {
		try {
			String methodName = "setOggFile";

			Class<?>[] parameterTypes = new Class<?>[] { java.io.File.class };

			Object[] parameterValues = new Object[] { oggFile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSimpleDate(java.lang.String simpleDate) {
		try {
			String methodName = "setSimpleDate";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { simpleDate };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.io.File getM4aFile() {
		try {
			String methodName = "getM4aFile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.io.File returnObj = (java.io.File)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPdfFile(java.io.File pdfFile) {
		try {
			String methodName = "setPdfFile";

			Class<?>[] parameterTypes = new Class<?>[] { java.io.File.class };

			Object[] parameterValues = new Object[] { pdfFile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.io.File getMp4File() {
		try {
			String methodName = "getMp4File";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.io.File returnObj = (java.io.File)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setM4aFile(java.io.File m4aFile) {
		try {
			String methodName = "setM4aFile";

			Class<?>[] parameterTypes = new Class<?>[] { java.io.File.class };

			Object[] parameterValues = new Object[] { m4aFile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getDate() {
		try {
			String methodName = "getDate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setM4vFile(java.io.File m4vFile) {
		try {
			String methodName = "setM4vFile";

			Class<?>[] parameterTypes = new Class<?>[] { java.io.File.class };

			Object[] parameterValues = new Object[] { m4vFile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSecureUrl(java.lang.String secureUrl) {
		try {
			String methodName = "setSecureUrl";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { secureUrl };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setShortName(java.lang.String shortName) {
		try {
			String methodName = "setShortName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { shortName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setMp4File(java.io.File mp4File) {
		try {
			String methodName = "setMp4File";

			Class<?>[] parameterTypes = new Class<?>[] { java.io.File.class };

			Object[] parameterValues = new Object[] { mp4File };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.io.File getMp3File() {
		try {
			String methodName = "getMp3File";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.io.File returnObj = (java.io.File)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isHasChapters() {
		try {
			String methodName = "isHasChapters";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setUrl(java.lang.String url) {
		try {
			String methodName = "setUrl";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { url };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStreamAndroidUrl(java.lang.String streamAndroidUrl) {
		try {
			String methodName = "setStreamAndroidUrl";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { streamAndroidUrl };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setWebmFile(java.io.File webmFile) {
		try {
			String methodName = "setWebmFile";

			Class<?>[] parameterTypes = new Class<?>[] { java.io.File.class };

			Object[] parameterValues = new Object[] { webmFile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSPreffix() {
		try {
			String methodName = "getSPreffix";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getBitrate() {
		try {
			String methodName = "getBitrate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setShortTitle(java.lang.String shortTitle) {
		try {
			String methodName = "setShortTitle";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { shortTitle };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setMp3File(java.io.File mp3File) {
		try {
			String methodName = "setMp3File";

			Class<?>[] parameterTypes = new Class<?>[] { java.io.File.class };

			Object[] parameterValues = new Object[] { mp3File };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStreamUrl(java.lang.String streamUrl) {
		try {
			String methodName = "setStreamUrl";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { streamUrl };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSimpleDate() {
		try {
			String methodName = "getSimpleDate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStreamAndroidUrl() {
		try {
			String methodName = "getStreamAndroidUrl";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setDate(java.lang.String date) {
		try {
			String methodName = "setDate";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { date };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getImage() {
		try {
			String methodName = "getImage";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setBitrate(java.lang.String bitrate) {
		try {
			String methodName = "setBitrate";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { bitrate };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setImageSmall(java.lang.String imageSmall) {
		try {
			String methodName = "setImageSmall";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { imageSmall };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setHasChapters(boolean hasChapters) {
		try {
			String methodName = "setHasChapters";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { hasChapters };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSecureUrl() {
		try {
			String methodName = "getSecureUrl";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.io.File getWebmFile() {
		try {
			String methodName = "getWebmFile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.io.File returnObj = (java.io.File)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStreamIosUrl() {
		try {
			String methodName = "getStreamIosUrl";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setHasComments(boolean hasComments) {
		try {
			String methodName = "setHasComments";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { hasComments };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.io.File getM4vFile() {
		try {
			String methodName = "getM4vFile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.io.File returnObj = (java.io.File)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.io.File getOggFile() {
		try {
			String methodName = "getOggFile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.io.File returnObj = (java.io.File)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getShortName() {
		try {
			String methodName = "getShortName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.io.File getFlvFile() {
		try {
			String methodName = "getFlvFile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.io.File returnObj = (java.io.File)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setFlvFile(java.io.File flvFile) {
		try {
			String methodName = "setFlvFile";

			Class<?>[] parameterTypes = new Class<?>[] { java.io.File.class };

			Object[] parameterValues = new Object[] { flvFile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStreamIosUrl(java.lang.String streamIosUrl) {
		try {
			String methodName = "setStreamIosUrl";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { streamIosUrl };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.io.File getPdfFile() {
		try {
			String methodName = "getPdfFile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.io.File returnObj = (java.io.File)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getVideoRemoteModel() {
		return _videoRemoteModel;
	}

	public void setVideoRemoteModel(BaseModel<?> videoRemoteModel) {
		_videoRemoteModel = videoRemoteModel;
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

		Class<?> remoteModelClass = _videoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_videoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoLocalServiceUtil.addVideo(this);
		}
		else {
			VideoLocalServiceUtil.updateVideo(this);
		}
	}

	@Override
	public Video toEscapedModel() {
		return (Video)ProxyUtil.newProxyInstance(Video.class.getClassLoader(),
			new Class[] { Video.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoClp clone = new VideoClp();

		clone.setVideoId(getVideoId());
		clone.setTitle(getTitle());
		clone.setTags(getTags());
		clone.setLectureseriesId(getLectureseriesId());
		clone.setProducerId(getProducerId());
		clone.setContainerFormat(getContainerFormat());
		clone.setFilename(getFilename());
		clone.setResolution(getResolution());
		clone.setDuration(getDuration());
		clone.setHostId(getHostId());
		clone.setFileSize(getFileSize());
		clone.setGenerationDate(getGenerationDate());
		clone.setOpenAccess(getOpenAccess());
		clone.setDownloadLink(getDownloadLink());
		clone.setMetadataId(getMetadataId());
		clone.setSurl(getSurl());
		clone.setHits(getHits());
		clone.setUploadDate(getUploadDate());
		clone.setPermittedToSegment(getPermittedToSegment());
		clone.setRootInstitutionId(getRootInstitutionId());
		clone.setCitation2go(getCitation2go());

		return clone;
	}

	@Override
	public int compareTo(Video video) {
		int value = 0;

		if (getVideoId() < video.getVideoId()) {
			value = -1;
		}
		else if (getVideoId() > video.getVideoId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoClp)) {
			return false;
		}

		VideoClp video = (VideoClp)obj;

		long primaryKey = video.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{videoId=");
		sb.append(getVideoId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", tags=");
		sb.append(getTags());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
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
		sb.append(", rootInstitutionId=");
		sb.append(getRootInstitutionId());
		sb.append(", citation2go=");
		sb.append(getCitation2go());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Video");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
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
			"<column><column-name>rootInstitutionId</column-name><column-value><![CDATA[");
		sb.append(getRootInstitutionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>citation2go</column-name><column-value><![CDATA[");
		sb.append(getCitation2go());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoId;
	private String _title;
	private String _tags;
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
	private BaseModel<?> _videoRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}