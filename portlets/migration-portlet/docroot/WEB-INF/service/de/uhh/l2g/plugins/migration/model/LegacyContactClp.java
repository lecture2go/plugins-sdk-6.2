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
import com.liferay.portal.util.PortalUtil;

import de.uhh.l2g.plugins.migration.service.ClpSerializer;
import de.uhh.l2g.plugins.migration.service.LegacyContactLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author unihh
 */
public class LegacyContactClp extends BaseModelImpl<LegacyContact>
	implements LegacyContact {
	public LegacyContactClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyContact.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyContact.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _contactId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContactId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contactId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contactId", getContactId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("accountId", getAccountId());
		attributes.put("parentContactId", getParentContactId());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("prefixId", getPrefixId());
		attributes.put("suffixId", getSuffixId());
		attributes.put("male", getMale());
		attributes.put("birthday", getBirthday());
		attributes.put("smsSn", getSmsSn());
		attributes.put("aimSn", getAimSn());
		attributes.put("facebookSn", getFacebookSn());
		attributes.put("icqSn", getIcqSn());
		attributes.put("jabberSn", getJabberSn());
		attributes.put("msnSn", getMsnSn());
		attributes.put("mySpaceSn", getMySpaceSn());
		attributes.put("skypeSn", getSkypeSn());
		attributes.put("twitterSn", getTwitterSn());
		attributes.put("ymSn", getYmSn());
		attributes.put("employeeStatusId", getEmployeeStatusId());
		attributes.put("employeeNumber", getEmployeeNumber());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("jobClass", getJobClass());
		attributes.put("hoursOfOperation", getHoursOfOperation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long parentContactId = (Long)attributes.get("parentContactId");

		if (parentContactId != null) {
			setParentContactId(parentContactId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Integer prefixId = (Integer)attributes.get("prefixId");

		if (prefixId != null) {
			setPrefixId(prefixId);
		}

		Integer suffixId = (Integer)attributes.get("suffixId");

		if (suffixId != null) {
			setSuffixId(suffixId);
		}

		Boolean male = (Boolean)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String smsSn = (String)attributes.get("smsSn");

		if (smsSn != null) {
			setSmsSn(smsSn);
		}

		String aimSn = (String)attributes.get("aimSn");

		if (aimSn != null) {
			setAimSn(aimSn);
		}

		String facebookSn = (String)attributes.get("facebookSn");

		if (facebookSn != null) {
			setFacebookSn(facebookSn);
		}

		String icqSn = (String)attributes.get("icqSn");

		if (icqSn != null) {
			setIcqSn(icqSn);
		}

		String jabberSn = (String)attributes.get("jabberSn");

		if (jabberSn != null) {
			setJabberSn(jabberSn);
		}

		String msnSn = (String)attributes.get("msnSn");

		if (msnSn != null) {
			setMsnSn(msnSn);
		}

		String mySpaceSn = (String)attributes.get("mySpaceSn");

		if (mySpaceSn != null) {
			setMySpaceSn(mySpaceSn);
		}

		String skypeSn = (String)attributes.get("skypeSn");

		if (skypeSn != null) {
			setSkypeSn(skypeSn);
		}

		String twitterSn = (String)attributes.get("twitterSn");

		if (twitterSn != null) {
			setTwitterSn(twitterSn);
		}

		String ymSn = (String)attributes.get("ymSn");

		if (ymSn != null) {
			setYmSn(ymSn);
		}

		String employeeStatusId = (String)attributes.get("employeeStatusId");

		if (employeeStatusId != null) {
			setEmployeeStatusId(employeeStatusId);
		}

		String employeeNumber = (String)attributes.get("employeeNumber");

		if (employeeNumber != null) {
			setEmployeeNumber(employeeNumber);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String jobClass = (String)attributes.get("jobClass");

		if (jobClass != null) {
			setJobClass(jobClass);
		}

		String hoursOfOperation = (String)attributes.get("hoursOfOperation");

		if (hoursOfOperation != null) {
			setHoursOfOperation(hoursOfOperation);
		}
	}

	@Override
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_contactId = contactId;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setContactId", long.class);

				method.invoke(_legacyContactRemoteModel, contactId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_legacyContactRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_legacyContactRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_legacyContactRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_legacyContactRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_legacyContactRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_accountId = accountId;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountId", long.class);

				method.invoke(_legacyContactRemoteModel, accountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentContactId() {
		return _parentContactId;
	}

	@Override
	public void setParentContactId(long parentContactId) {
		_parentContactId = parentContactId;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setParentContactId", long.class);

				method.invoke(_legacyContactRemoteModel, parentContactId);
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

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_legacyContactRemoteModel, firstName);
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

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setMiddleName", String.class);

				method.invoke(_legacyContactRemoteModel, middleName);
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

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_legacyContactRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPrefixId() {
		return _prefixId;
	}

	@Override
	public void setPrefixId(int prefixId) {
		_prefixId = prefixId;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setPrefixId", int.class);

				method.invoke(_legacyContactRemoteModel, prefixId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSuffixId() {
		return _suffixId;
	}

	@Override
	public void setSuffixId(int suffixId) {
		_suffixId = suffixId;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setSuffixId", int.class);

				method.invoke(_legacyContactRemoteModel, suffixId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMale() {
		return _male;
	}

	@Override
	public boolean isMale() {
		return _male;
	}

	@Override
	public void setMale(boolean male) {
		_male = male;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setMale", boolean.class);

				method.invoke(_legacyContactRemoteModel, male);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBirthday() {
		return _birthday;
	}

	@Override
	public void setBirthday(Date birthday) {
		_birthday = birthday;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setBirthday", Date.class);

				method.invoke(_legacyContactRemoteModel, birthday);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSmsSn() {
		return _smsSn;
	}

	@Override
	public void setSmsSn(String smsSn) {
		_smsSn = smsSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setSmsSn", String.class);

				method.invoke(_legacyContactRemoteModel, smsSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAimSn() {
		return _aimSn;
	}

	@Override
	public void setAimSn(String aimSn) {
		_aimSn = aimSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setAimSn", String.class);

				method.invoke(_legacyContactRemoteModel, aimSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFacebookSn() {
		return _facebookSn;
	}

	@Override
	public void setFacebookSn(String facebookSn) {
		_facebookSn = facebookSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setFacebookSn", String.class);

				method.invoke(_legacyContactRemoteModel, facebookSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIcqSn() {
		return _icqSn;
	}

	@Override
	public void setIcqSn(String icqSn) {
		_icqSn = icqSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setIcqSn", String.class);

				method.invoke(_legacyContactRemoteModel, icqSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJabberSn() {
		return _jabberSn;
	}

	@Override
	public void setJabberSn(String jabberSn) {
		_jabberSn = jabberSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setJabberSn", String.class);

				method.invoke(_legacyContactRemoteModel, jabberSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMsnSn() {
		return _msnSn;
	}

	@Override
	public void setMsnSn(String msnSn) {
		_msnSn = msnSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setMsnSn", String.class);

				method.invoke(_legacyContactRemoteModel, msnSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMySpaceSn() {
		return _mySpaceSn;
	}

	@Override
	public void setMySpaceSn(String mySpaceSn) {
		_mySpaceSn = mySpaceSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setMySpaceSn", String.class);

				method.invoke(_legacyContactRemoteModel, mySpaceSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSkypeSn() {
		return _skypeSn;
	}

	@Override
	public void setSkypeSn(String skypeSn) {
		_skypeSn = skypeSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setSkypeSn", String.class);

				method.invoke(_legacyContactRemoteModel, skypeSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTwitterSn() {
		return _twitterSn;
	}

	@Override
	public void setTwitterSn(String twitterSn) {
		_twitterSn = twitterSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setTwitterSn", String.class);

				method.invoke(_legacyContactRemoteModel, twitterSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYmSn() {
		return _ymSn;
	}

	@Override
	public void setYmSn(String ymSn) {
		_ymSn = ymSn;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setYmSn", String.class);

				method.invoke(_legacyContactRemoteModel, ymSn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployeeStatusId() {
		return _employeeStatusId;
	}

	@Override
	public void setEmployeeStatusId(String employeeStatusId) {
		_employeeStatusId = employeeStatusId;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeStatusId",
						String.class);

				method.invoke(_legacyContactRemoteModel, employeeStatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmployeeNumber() {
		return _employeeNumber;
	}

	@Override
	public void setEmployeeNumber(String employeeNumber) {
		_employeeNumber = employeeNumber;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeNumber",
						String.class);

				method.invoke(_legacyContactRemoteModel, employeeNumber);
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

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitle", String.class);

				method.invoke(_legacyContactRemoteModel, jobTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobClass() {
		return _jobClass;
	}

	@Override
	public void setJobClass(String jobClass) {
		_jobClass = jobClass;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setJobClass", String.class);

				method.invoke(_legacyContactRemoteModel, jobClass);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHoursOfOperation() {
		return _hoursOfOperation;
	}

	@Override
	public void setHoursOfOperation(String hoursOfOperation) {
		_hoursOfOperation = hoursOfOperation;

		if (_legacyContactRemoteModel != null) {
			try {
				Class<?> clazz = _legacyContactRemoteModel.getClass();

				Method method = clazz.getMethod("setHoursOfOperation",
						String.class);

				method.invoke(_legacyContactRemoteModel, hoursOfOperation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLegacyContactRemoteModel() {
		return _legacyContactRemoteModel;
	}

	public void setLegacyContactRemoteModel(
		BaseModel<?> legacyContactRemoteModel) {
		_legacyContactRemoteModel = legacyContactRemoteModel;
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

		Class<?> remoteModelClass = _legacyContactRemoteModel.getClass();

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

		Object returnValue = method.invoke(_legacyContactRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LegacyContactLocalServiceUtil.addLegacyContact(this);
		}
		else {
			LegacyContactLocalServiceUtil.updateLegacyContact(this);
		}
	}

	@Override
	public LegacyContact toEscapedModel() {
		return (LegacyContact)ProxyUtil.newProxyInstance(LegacyContact.class.getClassLoader(),
			new Class[] { LegacyContact.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LegacyContactClp clone = new LegacyContactClp();

		clone.setContactId(getContactId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAccountId(getAccountId());
		clone.setParentContactId(getParentContactId());
		clone.setFirstName(getFirstName());
		clone.setMiddleName(getMiddleName());
		clone.setLastName(getLastName());
		clone.setPrefixId(getPrefixId());
		clone.setSuffixId(getSuffixId());
		clone.setMale(getMale());
		clone.setBirthday(getBirthday());
		clone.setSmsSn(getSmsSn());
		clone.setAimSn(getAimSn());
		clone.setFacebookSn(getFacebookSn());
		clone.setIcqSn(getIcqSn());
		clone.setJabberSn(getJabberSn());
		clone.setMsnSn(getMsnSn());
		clone.setMySpaceSn(getMySpaceSn());
		clone.setSkypeSn(getSkypeSn());
		clone.setTwitterSn(getTwitterSn());
		clone.setYmSn(getYmSn());
		clone.setEmployeeStatusId(getEmployeeStatusId());
		clone.setEmployeeNumber(getEmployeeNumber());
		clone.setJobTitle(getJobTitle());
		clone.setJobClass(getJobClass());
		clone.setHoursOfOperation(getHoursOfOperation());

		return clone;
	}

	@Override
	public int compareTo(LegacyContact legacyContact) {
		long primaryKey = legacyContact.getPrimaryKey();

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

		if (!(obj instanceof LegacyContactClp)) {
			return false;
		}

		LegacyContactClp legacyContact = (LegacyContactClp)obj;

		long primaryKey = legacyContact.getPrimaryKey();

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
		StringBundler sb = new StringBundler(61);

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", accountId=");
		sb.append(getAccountId());
		sb.append(", parentContactId=");
		sb.append(getParentContactId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", prefixId=");
		sb.append(getPrefixId());
		sb.append(", suffixId=");
		sb.append(getSuffixId());
		sb.append(", male=");
		sb.append(getMale());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", smsSn=");
		sb.append(getSmsSn());
		sb.append(", aimSn=");
		sb.append(getAimSn());
		sb.append(", facebookSn=");
		sb.append(getFacebookSn());
		sb.append(", icqSn=");
		sb.append(getIcqSn());
		sb.append(", jabberSn=");
		sb.append(getJabberSn());
		sb.append(", msnSn=");
		sb.append(getMsnSn());
		sb.append(", mySpaceSn=");
		sb.append(getMySpaceSn());
		sb.append(", skypeSn=");
		sb.append(getSkypeSn());
		sb.append(", twitterSn=");
		sb.append(getTwitterSn());
		sb.append(", ymSn=");
		sb.append(getYmSn());
		sb.append(", employeeStatusId=");
		sb.append(getEmployeeStatusId());
		sb.append(", employeeNumber=");
		sb.append(getEmployeeNumber());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append(", jobClass=");
		sb.append(getJobClass());
		sb.append(", hoursOfOperation=");
		sb.append(getHoursOfOperation());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.migration.model.LegacyContact");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountId</column-name><column-value><![CDATA[");
		sb.append(getAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentContactId</column-name><column-value><![CDATA[");
		sb.append(getParentContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prefixId</column-name><column-value><![CDATA[");
		sb.append(getPrefixId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>suffixId</column-name><column-value><![CDATA[");
		sb.append(getSuffixId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>male</column-name><column-value><![CDATA[");
		sb.append(getMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smsSn</column-name><column-value><![CDATA[");
		sb.append(getSmsSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aimSn</column-name><column-value><![CDATA[");
		sb.append(getAimSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebookSn</column-name><column-value><![CDATA[");
		sb.append(getFacebookSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>icqSn</column-name><column-value><![CDATA[");
		sb.append(getIcqSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jabberSn</column-name><column-value><![CDATA[");
		sb.append(getJabberSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>msnSn</column-name><column-value><![CDATA[");
		sb.append(getMsnSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mySpaceSn</column-name><column-value><![CDATA[");
		sb.append(getMySpaceSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skypeSn</column-name><column-value><![CDATA[");
		sb.append(getSkypeSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitterSn</column-name><column-value><![CDATA[");
		sb.append(getTwitterSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ymSn</column-name><column-value><![CDATA[");
		sb.append(getYmSn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeStatusId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeNumber</column-name><column-value><![CDATA[");
		sb.append(getEmployeeNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobClass</column-name><column-value><![CDATA[");
		sb.append(getJobClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursOfOperation</column-name><column-value><![CDATA[");
		sb.append(getHoursOfOperation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _accountId;
	private long _parentContactId;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private int _prefixId;
	private int _suffixId;
	private boolean _male;
	private Date _birthday;
	private String _smsSn;
	private String _aimSn;
	private String _facebookSn;
	private String _icqSn;
	private String _jabberSn;
	private String _msnSn;
	private String _mySpaceSn;
	private String _skypeSn;
	private String _twitterSn;
	private String _ymSn;
	private String _employeeStatusId;
	private String _employeeNumber;
	private String _jobTitle;
	private String _jobClass;
	private String _hoursOfOperation;
	private BaseModel<?> _legacyContactRemoteModel;
	private Class<?> _clpSerializerClass = de.uhh.l2g.plugins.migration.service.ClpSerializer.class;
}