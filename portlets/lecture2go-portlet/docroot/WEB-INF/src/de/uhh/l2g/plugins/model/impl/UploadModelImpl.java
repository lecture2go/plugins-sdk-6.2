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

package de.uhh.l2g.plugins.model.impl;

import java.io.Serializable;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.uhh.l2g.plugins.model.Upload;
import de.uhh.l2g.plugins.model.UploadModel;

/**
 * The base model implementation for the Upload service. Represents a row in the &quot;LG_Upload&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.uhh.l2g.plugins.model.UploadModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UploadImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see UploadImpl
 * @see de.uhh.l2g.plugins.model.Upload
 * @see de.uhh.l2g.plugins.model.UploadModel
 * @generated
 */
public class UploadModelImpl extends BaseModelImpl<Upload>
	implements UploadModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a upload model instance should use the {@link de.uhh.l2g.plugins.model.Upload} interface instead.
	 */
	public static final String TABLE_NAME = "LG_Upload";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uploadId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "contentLength", Types.BIGINT },
			{ "timestamp", Types.TIMESTAMP },
			{ "status", Types.INTEGER },
			{ "videoId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table LG_Upload (uploadId LONG not null primary key,userId LONG,contentLength LONG,timestamp DATE null,status INTEGER,videoId LONG)";
	public static final String TABLE_SQL_DROP = "drop table LG_Upload";
	public static final String ORDER_BY_JPQL = " ORDER BY upload.uploadId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LG_Upload.uploadId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Upload"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Upload"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Upload"),
			true);
	public static long VIDEOID_COLUMN_BITMASK = 1L;
	public static long UPLOADID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.model.Upload"));

	public UploadModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _uploadId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUploadId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _uploadId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Upload.class;
	}

	@Override
	public String getModelClassName() {
		return Upload.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uploadId", getUploadId());
		attributes.put("userId", getUserId());
		attributes.put("contentLength", getContentLength());
		attributes.put("timestamp", getTimestamp());
		attributes.put("status", getStatus());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uploadId = (Long)attributes.get("uploadId");

		if (uploadId != null) {
			setUploadId(uploadId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long contentLength = (Long)attributes.get("contentLength");

		if (contentLength != null) {
			setContentLength(contentLength);
		}

		Date timestamp = (Date)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	@Override
	public long getUploadId() {
		return _uploadId;
	}

	@Override
	public void setUploadId(long uploadId) {
		_uploadId = uploadId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getContentLength() {
		return _contentLength;
	}

	@Override
	public void setContentLength(long contentLength) {
		_contentLength = contentLength;
	}

	@Override
	public Date getTimestamp() {
		return _timestamp;
	}

	@Override
	public void setTimestamp(Date timestamp) {
		_timestamp = timestamp;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_columnBitmask |= VIDEOID_COLUMN_BITMASK;

		if (!_setOriginalVideoId) {
			_setOriginalVideoId = true;

			_originalVideoId = _videoId;
		}

		_videoId = videoId;
	}

	public long getOriginalVideoId() {
		return _originalVideoId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Upload.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Upload toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Upload)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UploadImpl uploadImpl = new UploadImpl();

		uploadImpl.setUploadId(getUploadId());
		uploadImpl.setUserId(getUserId());
		uploadImpl.setContentLength(getContentLength());
		uploadImpl.setTimestamp(getTimestamp());
		uploadImpl.setStatus(getStatus());
		uploadImpl.setVideoId(getVideoId());

		uploadImpl.resetOriginalValues();

		return uploadImpl;
	}

	@Override
	public int compareTo(Upload upload) {
		long primaryKey = upload.getPrimaryKey();

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

		if (!(obj instanceof Upload)) {
			return false;
		}

		Upload upload = (Upload)obj;

		long primaryKey = upload.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		UploadModelImpl uploadModelImpl = this;

		uploadModelImpl._originalVideoId = uploadModelImpl._videoId;

		uploadModelImpl._setOriginalVideoId = false;

		uploadModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Upload> toCacheModel() {
		UploadCacheModel uploadCacheModel = new UploadCacheModel();

		uploadCacheModel.uploadId = getUploadId();

		uploadCacheModel.userId = getUserId();

		uploadCacheModel.contentLength = getContentLength();

		Date timestamp = getTimestamp();

		if (timestamp != null) {
			uploadCacheModel.timestamp = timestamp.getTime();
		}
		else {
			uploadCacheModel.timestamp = Long.MIN_VALUE;
		}

		uploadCacheModel.status = getStatus();

		uploadCacheModel.videoId = getVideoId();

		return uploadCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uploadId=");
		sb.append(getUploadId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", contentLength=");
		sb.append(getContentLength());
		sb.append(", timestamp=");
		sb.append(getTimestamp());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Upload");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uploadId</column-name><column-value><![CDATA[");
		sb.append(getUploadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentLength</column-name><column-value><![CDATA[");
		sb.append(getContentLength());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timestamp</column-name><column-value><![CDATA[");
		sb.append(getTimestamp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Upload.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Upload.class };
	private long _uploadId;
	private long _userId;
	private String _userUuid;
	private long _contentLength;
	private Date _timestamp;
	private int _status;
	private long _videoId;
	private long _originalVideoId;
	private boolean _setOriginalVideoId;
	private long _columnBitmask;
	private Upload _escapedModel;
}