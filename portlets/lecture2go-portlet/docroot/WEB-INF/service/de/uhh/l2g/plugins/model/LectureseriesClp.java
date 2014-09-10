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
		attributes.put("eventCategory", getEventCategory());
		attributes.put("name", getName());
		attributes.put("shortDesc", getShortDesc());
		attributes.put("semesterName", getSemesterName());
		attributes.put("language", getLanguage());
		attributes.put("facultyName", getFacultyName());
		attributes.put("instructorsString", getInstructorsString());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("password", getPassword());
		attributes.put("approved", getApproved());
		attributes.put("longDesc", getLongDesc());

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

		String eventCategory = (String)attributes.get("eventCategory");

		if (eventCategory != null) {
			setEventCategory(eventCategory);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortDesc = (String)attributes.get("shortDesc");

		if (shortDesc != null) {
			setShortDesc(shortDesc);
		}

		String semesterName = (String)attributes.get("semesterName");

		if (semesterName != null) {
			setSemesterName(semesterName);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String facultyName = (String)attributes.get("facultyName");

		if (facultyName != null) {
			setFacultyName(facultyName);
		}

		String instructorsString = (String)attributes.get("instructorsString");

		if (instructorsString != null) {
			setInstructorsString(instructorsString);
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
	public String getEventCategory() {
		return _eventCategory;
	}

	@Override
	public void setEventCategory(String eventCategory) {
		_eventCategory = eventCategory;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setEventCategory", String.class);

				method.invoke(_lectureseriesRemoteModel, eventCategory);
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
	public String getSemesterName() {
		return _semesterName;
	}

	@Override
	public void setSemesterName(String semesterName) {
		_semesterName = semesterName;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setSemesterName", String.class);

				method.invoke(_lectureseriesRemoteModel, semesterName);
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
	public String getInstructorsString() {
		return _instructorsString;
	}

	@Override
	public void setInstructorsString(String instructorsString) {
		_instructorsString = instructorsString;

		if (_lectureseriesRemoteModel != null) {
			try {
				Class<?> clazz = _lectureseriesRemoteModel.getClass();

				Method method = clazz.getMethod("setInstructorsString",
						String.class);

				method.invoke(_lectureseriesRemoteModel, instructorsString);
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
		clone.setEventCategory(getEventCategory());
		clone.setName(getName());
		clone.setShortDesc(getShortDesc());
		clone.setSemesterName(getSemesterName());
		clone.setLanguage(getLanguage());
		clone.setFacultyName(getFacultyName());
		clone.setInstructorsString(getInstructorsString());
		clone.setLectureseriesId(getLectureseriesId());
		clone.setPassword(getPassword());
		clone.setApproved(getApproved());
		clone.setLongDesc(getLongDesc());

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

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{number=");
		sb.append(getNumber());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", eventCategory=");
		sb.append(getEventCategory());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", shortDesc=");
		sb.append(getShortDesc());
		sb.append(", semesterName=");
		sb.append(getSemesterName());
		sb.append(", language=");
		sb.append(getLanguage());
		sb.append(", facultyName=");
		sb.append(getFacultyName());
		sb.append(", instructorsString=");
		sb.append(getInstructorsString());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", approved=");
		sb.append(getApproved());
		sb.append(", longDesc=");
		sb.append(getLongDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

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
			"<column><column-name>eventCategory</column-name><column-value><![CDATA[");
		sb.append(getEventCategory());
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
			"<column><column-name>semesterName</column-name><column-value><![CDATA[");
		sb.append(getSemesterName());
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
			"<column><column-name>instructorsString</column-name><column-value><![CDATA[");
		sb.append(getInstructorsString());
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

		sb.append("</model>");

		return sb.toString();
	}

	private String _number;
	private String _eventType;
	private String _eventCategory;
	private String _name;
	private String _shortDesc;
	private String _semesterName;
	private String _language;
	private String _facultyName;
	private String _instructorsString;
	private long _lectureseriesId;
	private String _password;
	private int _approved;
	private String _longDesc;
	private BaseModel<?> _lectureseriesRemoteModel;
}