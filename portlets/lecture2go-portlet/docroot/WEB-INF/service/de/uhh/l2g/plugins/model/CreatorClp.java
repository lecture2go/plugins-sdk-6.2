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
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Iavor Sturm
 */
public class CreatorClp extends BaseModelImpl<Creator> implements Creator {
	public CreatorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Creator.class;
	}

	@Override
	public String getModelClassName() {
		return Creator.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _creatorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCreatorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _creatorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("creatorId", getCreatorId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("middleName", getMiddleName());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("gender", getGender());
		attributes.put("fullName", getFullName());
		attributes.put("affiliation", getAffiliation());
		attributes.put("orcidId", getOrcidId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long creatorId = (Long)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String affiliation = (String)attributes.get("affiliation");

		if (affiliation != null) {
			setAffiliation(affiliation);
		}

		String orcidId = (String)attributes.get("orcidId");

		if (orcidId != null) {
			setOrcidId(orcidId);
		}
	}

	@Override
	public long getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(long creatorId) {
		_creatorId = creatorId;

		if (_creatorRemoteModel != null) {
			try {
				Class<?> clazz = _creatorRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", long.class);

				method.invoke(_creatorRemoteModel, creatorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_creatorRemoteModel != null) {
			try {
				Class<?> clazz = _creatorRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_creatorRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_creatorRemoteModel != null) {
			try {
				Class<?> clazz = _creatorRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_creatorRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMiddleName() {
		return _middleName;
	}

	@Override
	public void setMiddleName(String middleName) {
		_middleName = middleName;

		if (_creatorRemoteModel != null) {
			try {
				Class<?> clazz = _creatorRemoteModel.getClass();

				Method method = clazz.getMethod("setMiddleName", String.class);

				method.invoke(_creatorRemoteModel, middleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobTitle() {
		return _jobTitle;
	}

	@Override
	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;

		if (_creatorRemoteModel != null) {
			try {
				Class<?> clazz = _creatorRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitle", String.class);

				method.invoke(_creatorRemoteModel, jobTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGender() {
		return _gender;
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;

		if (_creatorRemoteModel != null) {
			try {
				Class<?> clazz = _creatorRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", String.class);

				method.invoke(_creatorRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFullName() {
		return _fullName;
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;

		if (_creatorRemoteModel != null) {
			try {
				Class<?> clazz = _creatorRemoteModel.getClass();

				Method method = clazz.getMethod("setFullName", String.class);

				method.invoke(_creatorRemoteModel, fullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAffiliation() {
		return _affiliation;
	}

	@Override
	public void setAffiliation(String affiliation) {
		_affiliation = affiliation;

		if (_creatorRemoteModel != null) {
			try {
				Class<?> clazz = _creatorRemoteModel.getClass();

				Method method = clazz.getMethod("setAffiliation", String.class);

				method.invoke(_creatorRemoteModel, affiliation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrcidId() {
		return _orcidId;
	}

	@Override
	public void setOrcidId(String orcidId) {
		_orcidId = orcidId;

		if (_creatorRemoteModel != null) {
			try {
				Class<?> clazz = _creatorRemoteModel.getClass();

				Method method = clazz.getMethod("setOrcidId", String.class);

				method.invoke(_creatorRemoteModel, orcidId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCreatorRemoteModel() {
		return _creatorRemoteModel;
	}

	public void setCreatorRemoteModel(BaseModel<?> creatorRemoteModel) {
		_creatorRemoteModel = creatorRemoteModel;
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

		Class<?> remoteModelClass = _creatorRemoteModel.getClass();

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

		Object returnValue = method.invoke(_creatorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CreatorLocalServiceUtil.addCreator(this);
		}
		else {
			CreatorLocalServiceUtil.updateCreator(this);
		}
	}

	@Override
	public Creator toEscapedModel() {
		return (Creator)ProxyUtil.newProxyInstance(Creator.class.getClassLoader(),
			new Class[] { Creator.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CreatorClp clone = new CreatorClp();

		clone.setCreatorId(getCreatorId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setMiddleName(getMiddleName());
		clone.setJobTitle(getJobTitle());
		clone.setGender(getGender());
		clone.setFullName(getFullName());
		clone.setAffiliation(getAffiliation());
		clone.setOrcidId(getOrcidId());

		return clone;
	}

	@Override
	public int compareTo(Creator creator) {
		int value = 0;

		value = getLastName().compareTo(creator.getLastName());

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

		if (!(obj instanceof CreatorClp)) {
			return false;
		}

		CreatorClp creator = (CreatorClp)obj;

		long primaryKey = creator.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{creatorId=");
		sb.append(getCreatorId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", affiliation=");
		sb.append(getAffiliation());
		sb.append(", orcidId=");
		sb.append(getOrcidId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Creator");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>creatorId</column-name><column-value><![CDATA[");
		sb.append(getCreatorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>affiliation</column-name><column-value><![CDATA[");
		sb.append(getAffiliation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orcidId</column-name><column-value><![CDATA[");
		sb.append(getOrcidId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _creatorId;
	private String _firstName;
	private String _lastName;
	private String _middleName;
	private String _jobTitle;
	private String _gender;
	private String _fullName;
	private String _affiliation;
	private String _orcidId;
	private BaseModel<?> _creatorRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.service.ClpSerializer.class;
}