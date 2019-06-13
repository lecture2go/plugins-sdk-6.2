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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Statistic}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Statistic
 * @generated
 */
public class StatisticWrapper implements Statistic, ModelWrapper<Statistic> {
	public StatisticWrapper(Statistic statistic) {
		_statistic = statistic;
	}

	@Override
	public Class<?> getModelClass() {
		return Statistic.class;
	}

	@Override
	public String getModelClassName() {
		return Statistic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("createDate", getCreateDate());
		attributes.put("publicVideos", getPublicVideos());
		attributes.put("privateVideos", getPrivateVideos());
		attributes.put("autofillRow", getAutofillRow());
		attributes.put("statisticId", getStatisticId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Integer publicVideos = (Integer)attributes.get("publicVideos");

		if (publicVideos != null) {
			setPublicVideos(publicVideos);
		}

		Integer privateVideos = (Integer)attributes.get("privateVideos");

		if (privateVideos != null) {
			setPrivateVideos(privateVideos);
		}

		Integer autofillRow = (Integer)attributes.get("autofillRow");

		if (autofillRow != null) {
			setAutofillRow(autofillRow);
		}

		Long statisticId = (Long)attributes.get("statisticId");

		if (statisticId != null) {
			setStatisticId(statisticId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this statistic.
	*
	* @return the primary key of this statistic
	*/
	@Override
	public long getPrimaryKey() {
		return _statistic.getPrimaryKey();
	}

	/**
	* Sets the primary key of this statistic.
	*
	* @param primaryKey the primary key of this statistic
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statistic.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the create date of this statistic.
	*
	* @return the create date of this statistic
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _statistic.getCreateDate();
	}

	/**
	* Sets the create date of this statistic.
	*
	* @param createDate the create date of this statistic
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_statistic.setCreateDate(createDate);
	}

	/**
	* Returns the public videos of this statistic.
	*
	* @return the public videos of this statistic
	*/
	@Override
	public int getPublicVideos() {
		return _statistic.getPublicVideos();
	}

	/**
	* Sets the public videos of this statistic.
	*
	* @param publicVideos the public videos of this statistic
	*/
	@Override
	public void setPublicVideos(int publicVideos) {
		_statistic.setPublicVideos(publicVideos);
	}

	/**
	* Returns the private videos of this statistic.
	*
	* @return the private videos of this statistic
	*/
	@Override
	public int getPrivateVideos() {
		return _statistic.getPrivateVideos();
	}

	/**
	* Sets the private videos of this statistic.
	*
	* @param privateVideos the private videos of this statistic
	*/
	@Override
	public void setPrivateVideos(int privateVideos) {
		_statistic.setPrivateVideos(privateVideos);
	}

	/**
	* Returns the autofill row of this statistic.
	*
	* @return the autofill row of this statistic
	*/
	@Override
	public int getAutofillRow() {
		return _statistic.getAutofillRow();
	}

	/**
	* Sets the autofill row of this statistic.
	*
	* @param autofillRow the autofill row of this statistic
	*/
	@Override
	public void setAutofillRow(int autofillRow) {
		_statistic.setAutofillRow(autofillRow);
	}

	/**
	* Returns the statistic ID of this statistic.
	*
	* @return the statistic ID of this statistic
	*/
	@Override
	public long getStatisticId() {
		return _statistic.getStatisticId();
	}

	/**
	* Sets the statistic ID of this statistic.
	*
	* @param statisticId the statistic ID of this statistic
	*/
	@Override
	public void setStatisticId(long statisticId) {
		_statistic.setStatisticId(statisticId);
	}

	/**
	* Returns the group ID of this statistic.
	*
	* @return the group ID of this statistic
	*/
	@Override
	public long getGroupId() {
		return _statistic.getGroupId();
	}

	/**
	* Sets the group ID of this statistic.
	*
	* @param groupId the group ID of this statistic
	*/
	@Override
	public void setGroupId(long groupId) {
		_statistic.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this statistic.
	*
	* @return the company ID of this statistic
	*/
	@Override
	public long getCompanyId() {
		return _statistic.getCompanyId();
	}

	/**
	* Sets the company ID of this statistic.
	*
	* @param companyId the company ID of this statistic
	*/
	@Override
	public void setCompanyId(long companyId) {
		_statistic.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this statistic.
	*
	* @return the user ID of this statistic
	*/
	@Override
	public long getUserId() {
		return _statistic.getUserId();
	}

	/**
	* Sets the user ID of this statistic.
	*
	* @param userId the user ID of this statistic
	*/
	@Override
	public void setUserId(long userId) {
		_statistic.setUserId(userId);
	}

	/**
	* Returns the user uuid of this statistic.
	*
	* @return the user uuid of this statistic
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _statistic.getUserUuid();
	}

	/**
	* Sets the user uuid of this statistic.
	*
	* @param userUuid the user uuid of this statistic
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_statistic.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this statistic.
	*
	* @return the user name of this statistic
	*/
	@Override
	public java.lang.String getUserName() {
		return _statistic.getUserName();
	}

	/**
	* Sets the user name of this statistic.
	*
	* @param userName the user name of this statistic
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_statistic.setUserName(userName);
	}

	/**
	* Returns the modified date of this statistic.
	*
	* @return the modified date of this statistic
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _statistic.getModifiedDate();
	}

	/**
	* Sets the modified date of this statistic.
	*
	* @param modifiedDate the modified date of this statistic
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_statistic.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _statistic.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_statistic.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _statistic.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statistic.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _statistic.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _statistic.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_statistic.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _statistic.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_statistic.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_statistic.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_statistic.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StatisticWrapper((Statistic)_statistic.clone());
	}

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Statistic statistic) {
		return _statistic.compareTo(statistic);
	}

	@Override
	public int hashCode() {
		return _statistic.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.model.Statistic> toCacheModel() {
		return _statistic.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.model.Statistic toEscapedModel() {
		return new StatisticWrapper(_statistic.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.model.Statistic toUnescapedModel() {
		return new StatisticWrapper(_statistic.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _statistic.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _statistic.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_statistic.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatisticWrapper)) {
			return false;
		}

		StatisticWrapper statisticWrapper = (StatisticWrapper)obj;

		if (Validator.equals(_statistic, statisticWrapper._statistic)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Statistic getWrappedStatistic() {
		return _statistic;
	}

	@Override
	public Statistic getWrappedModel() {
		return _statistic;
	}

	@Override
	public void resetOriginalValues() {
		_statistic.resetOriginalValues();
	}

	private Statistic _statistic;
}