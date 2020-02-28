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
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class LectureseriesClp extends BaseModelImpl<Lectureseries>
	implements Lectureseries {
	public LectureseriesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Lectureseries.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _lectureseriesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLectureseriesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lectureseriesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("number", getNumber());
		attributes.put("eventType", getEventType());
		attributes.put("categoryId", getCategoryId());
		attributes.put("name", getName());
		attributes.put("shortDesc", getShortDesc());
		attributes.put("termId", getTermId());
		attributes.put("language", getLanguage());
		attributes.put("facultyName", getFacultyName());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("password", getPassword());
		attributes.put("approved", getApproved());
		attributes.put("longDesc", getLongDesc());
		attributes.put("latestOpenAccessVideoId", getLatestOpenAccessVideoId());
		attributes.put("latestVideoUploadDate", getLatestVideoUploadDate());
		attributes.put("latestVideoGenerationDate",
			getLatestVideoGenerationDate());
		attributes.put("videoSort", getVideoSort());
		attributes.put("USID", getUSID());
		attributes.put("previewVideoId", getPreviewVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDesc = (String)attributes.get("shortDesc");

		if (shortDesc != null) {
			setShortDesc(shortDesc);
		}

		Long termId = (Long)attributes.get("termId");

		if (termId != null) {
			setTermId(termId);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String facultyName = (String)attributes.get("facultyName");

		if (facultyName != null) {
			setFacultyName(facultyName);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Integer approved = (Integer)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}

		String longDesc = (String)attributes.get("longDesc");

		if (longDesc != null) {
			setLongDesc(longDesc);
		}

		Long latestOpenAccessVideoId = (Long)attributes.get(
				"latestOpenAccessVideoId");

		if (latestOpenAccessVideoId != null) {
			setLatestOpenAccessVideoId(latestOpenAccessVideoId);
		}

		Date latestVideoUploadDate = (Date)attributes.get(
				"latestVideoUploadDate");

		if (latestVideoUploadDate != null) {
			setLatestVideoUploadDate(latestVideoUploadDate);
		}

		String latestVideoGenerationDate = (String)attributes.get(
				"latestVideoGenerationDate");

		if (latestVideoGenerationDate != null) {
			setLatestVideoGenerationDate(latestVideoGenerationDate);
		}

		Integer videoSort = (Integer)attributes.get("videoSort");

		if (videoSort != null) {
			setVideoSort(videoSort);
		}

		String USID = (String)attributes.get("USID");

		if (USID != null) {
			setUSID(USID);
		}

		Long previewVideoId = (Long)attributes.get("previewVideoId");

		if (previewVideoId != null) {
			setPreviewVideoId(previewVideoId);
		}
	}

	@Override
	public String getNumber() {
		return _number;
	}

	@Override
	public void setNumber(String number) {
		_number = number;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setNumber", String.class);

				method.invoke(_lectureseriesRemoteModel, number);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventType() {
		return _eventType;
	}

	@Override
	public void setEventType(String eventType) {
		_eventType = eventType;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setEventType", String.class);

				method.invoke(_lectureseriesRemoteModel, eventType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_lectureseriesRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_lectureseriesRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortDesc() {
		return _shortDesc;
	}

	@Override
	public void setShortDesc(String shortDesc) {
		_shortDesc = shortDesc;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setShortDesc", String.class);

				method.invoke(_lectureseriesRemoteModel, shortDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTermId() {
		return _termId;
	}

	@Override
	public void setTermId(long termId) {
		_termId = termId;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setTermId", long.class);

				method.invoke(_lectureseriesRemoteModel, termId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguage() {
		return _language;
	}

	@Override
	public void setLanguage(String language) {
		_language = language;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguage", String.class);

				method.invoke(_lectureseriesRemoteModel, language);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFacultyName() {
		return _facultyName;
	}

	@Override
	public void setFacultyName(String facultyName) {
		_facultyName = facultyName;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setFacultyName", String.class);

				method.invoke(_lectureseriesRemoteModel, facultyName);
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

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLectureseriesId", long.class);

				method.invoke(_lectureseriesRemoteModel, lectureseriesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassword() {
		return _password;
	}

	@Override
	public void setPassword(String password) {
		_password = password;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setPassword", String.class);

				method.invoke(_lectureseriesRemoteModel, password);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getApproved() {
		return _approved;
	}

	@Override
	public void setApproved(int approved) {
		_approved = approved;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setApproved", int.class);

				method.invoke(_lectureseriesRemoteModel, approved);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongDesc() {
		return _longDesc;
	}

	@Override
	public void setLongDesc(String longDesc) {
		_longDesc = longDesc;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLongDesc", String.class);

				method.invoke(_lectureseriesRemoteModel, longDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLatestOpenAccessVideoId() {
		return _latestOpenAccessVideoId;
	}

	@Override
	public void setLatestOpenAccessVideoId(long latestOpenAccessVideoId) {
		_latestOpenAccessVideoId = latestOpenAccessVideoId;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLatestOpenAccessVideoId",
						long.class);

				method.invoke(_lectureseriesRemoteModel, latestOpenAccessVideoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLatestVideoUploadDate() {
		return _latestVideoUploadDate;
	}

	@Override
	public void setLatestVideoUploadDate(Date latestVideoUploadDate) {
		_latestVideoUploadDate = latestVideoUploadDate;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLatestVideoUploadDate",
						Date.class);

				method.invoke(_lectureseriesRemoteModel, latestVideoUploadDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLatestVideoGenerationDate() {
		return _latestVideoGenerationDate;
	}

	@Override
	public void setLatestVideoGenerationDate(String latestVideoGenerationDate) {
		_latestVideoGenerationDate = latestVideoGenerationDate;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setLatestVideoGenerationDate",
						String.class);

				method.invoke(_lectureseriesRemoteModel,
					latestVideoGenerationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getVideoSort() {
		return _videoSort;
	}

	@Override
	public void setVideoSort(int videoSort) {
		_videoSort = videoSort;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoSort", int.class);

				method.invoke(_lectureseriesRemoteModel, videoSort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUSID() {
		return _USID;
	}

	@Override
	public void setUSID(String USID) {
		_USID = USID;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setUSID", String.class);

				method.invoke(_lectureseriesRemoteModel, USID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPreviewVideoId() {
		return _previewVideoId;
	}

	@Override
	public void setPreviewVideoId(long previewVideoId) {
		_previewVideoId = previewVideoId;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setPreviewVideoId", long.class);

				method.invoke(_lectureseriesRemoteModel, previewVideoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberOfOpenAccessVideos() {
		try {
			String methodName = "getNumberOfOpenAccessVideos";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getOpenAccessURI() {
		try {
			String methodName = "getOpenAccessURI";

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
	public java.lang.String getType() {
		try {
			String methodName = "getType";

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
	public void setType(java.lang.String type) {
		try {
			String methodName = "setType";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { type };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public int getNumberOfVideos() {
		try {
			String methodName = "getNumberOfVideos";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Integer returnObj = (Integer)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getClosedAccessURI() {
		try {
			String methodName = "getClosedAccessURI";

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

	public BaseModel<?> getLectureseriesRemoteModel() {
		return _lectureseriesRemoteModel;
	}

	public void setLectureseriesRemoteModel(
		BaseModel<?> lectureseriesRemoteModel) {
		_lectureseriesRemoteModel = lectureseriesRemoteModel;
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

		Class<?> remoteModelClass = _lectureseriesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_lectureseriesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LectureseriesLocalServiceUtil.addLectureseries(this);
		}
		else {
			LectureseriesLocalServiceUtil.updateLectureseries(this);
		}
	}

	@Override
	public Lectureseries toEscapedModel() {
		return (Lectureseries)ProxyUtil.newProxyInstance(Lectureseries.class.getClassLoader(),
			new Class[] { Lectureseries.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LectureseriesClp clone = new LectureseriesClp();

		clone.setNumber(getNumber());
		clone.setEventType(getEventType());
		clone.setCategoryId(getCategoryId());
		clone.setName(getName());
		clone.setShortDesc(getShortDesc());
		clone.setTermId(getTermId());
		clone.setLanguage(getLanguage());
		clone.setFacultyName(getFacultyName());
		clone.setLectureseriesId(getLectureseriesId());
		clone.setPassword(getPassword());
		clone.setApproved(getApproved());
		clone.setLongDesc(getLongDesc());
		clone.setLatestOpenAccessVideoId(getLatestOpenAccessVideoId());
		clone.setLatestVideoUploadDate(getLatestVideoUploadDate());
		clone.setLatestVideoGenerationDate(getLatestVideoGenerationDate());
		clone.setVideoSort(getVideoSort());
		clone.setUSID(getUSID());
		clone.setPreviewVideoId(getPreviewVideoId());

		return clone;
	}

	@Override
	public int compareTo(Lectureseries lectureseries) {
		int value = 0;

		value = getName().compareTo(lectureseries.getName());

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

		if (!(obj instanceof LectureseriesClp)) {
			return false;
		}

		LectureseriesClp lectureseries = (LectureseriesClp)obj;

		long primaryKey = lectureseries.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{number=");
		sb.append(getNumber());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", shortDesc=");
		sb.append(getShortDesc());
		sb.append(", termId=");
		sb.append(getTermId());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", facultyName=");
		sb.append(getFacultyName());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append(", longDesc=");
		sb.append(getLongDesc());
		sb.append(", latestOpenAccessVideoId=");
		sb.append(getLatestOpenAccessVideoId());
		sb.append(", latestVideoUploadDate=");
		sb.append(getLatestVideoUploadDate());
		sb.append(", latestVideoGenerationDate=");
		sb.append(getLatestVideoGenerationDate());
		sb.append(", videoSort=");
		sb.append(getVideoSort());
		sb.append(", USID=");
		sb.append(getUSID());
		sb.append(", previewVideoId=");
		sb.append(getPreviewVideoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Lectureseries");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>number</column-name><column-value><![CDATA[");
		sb.append(getNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortDesc</column-name><column-value><![CDATA[");
		sb.append(getShortDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termId</column-name><column-value><![CDATA[");
		sb.append(getTermId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>language</column-name><column-value><![CDATA[");
		sb.append(getLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facultyName</column-name><column-value><![CDATA[");
		sb.append(getFacultyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved</column-name><column-value><![CDATA[");
		sb.append(getApproved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longDesc</column-name><column-value><![CDATA[");
		sb.append(getLongDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latestOpenAccessVideoId</column-name><column-value><![CDATA[");
		sb.append(getLatestOpenAccessVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latestVideoUploadDate</column-name><column-value><![CDATA[");
		sb.append(getLatestVideoUploadDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latestVideoGenerationDate</column-name><column-value><![CDATA[");
		sb.append(getLatestVideoGenerationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoSort</column-name><column-value><![CDATA[");
		sb.append(getVideoSort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>USID</column-name><column-value><![CDATA[");
		sb.append(getUSID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previewVideoId</column-name><column-value><![CDATA[");
		sb.append(getPreviewVideoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _number;
	private String _eventType;
	private long _categoryId;
	private String _name;
	private String _shortDesc;
	private long _termId;
	private String _language;
	private String _facultyName;
	private long _lectureseriesId;
	private String _password;
	private int _approved;
	private String _longDesc;
	private long _latestOpenAccessVideoId;
	private Date _latestVideoUploadDate;
	private String _latestVideoGenerationDate;
	private int _videoSort;
	private String _USID;
	private long _previewVideoId;
	private BaseModel<?> _lectureseriesRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}