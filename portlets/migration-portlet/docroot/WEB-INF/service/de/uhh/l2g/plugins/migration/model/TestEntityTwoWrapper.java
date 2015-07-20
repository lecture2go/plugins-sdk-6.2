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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TestEntityTwo}.
 * </p>
 *
 * @author unihh
 * @see TestEntityTwo
 * @generated
 */
public class TestEntityTwoWrapper implements TestEntityTwo,
	ModelWrapper<TestEntityTwo> {
	public TestEntityTwoWrapper(TestEntityTwo testEntityTwo) {
		_testEntityTwo = testEntityTwo;
	}

	@Override
	public Class<?> getModelClass() {
		return TestEntityTwo.class;
	}

	@Override
	public String getModelClassName() {
		return TestEntityTwo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("plid", getPlid());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long plid = (Long)attributes.get("plid");

		if (plid != null) {
			setPlid(plid);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	/**
	* Returns the primary key of this test entity two.
	*
	* @return the primary key of this test entity two
	*/
	@Override
	public long getPrimaryKey() {
		return _testEntityTwo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this test entity two.
	*
	* @param primaryKey the primary key of this test entity two
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_testEntityTwo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the plid of this test entity two.
	*
	* @return the plid of this test entity two
	*/
	@Override
	public long getPlid() {
		return _testEntityTwo.getPlid();
	}

	/**
	* Sets the plid of this test entity two.
	*
	* @param plid the plid of this test entity two
	*/
	@Override
	public void setPlid(long plid) {
		_testEntityTwo.setPlid(plid);
	}

	/**
	* Returns the group ID of this test entity two.
	*
	* @return the group ID of this test entity two
	*/
	@Override
	public long getGroupId() {
		return _testEntityTwo.getGroupId();
	}

	/**
	* Sets the group ID of this test entity two.
	*
	* @param groupId the group ID of this test entity two
	*/
	@Override
	public void setGroupId(long groupId) {
		_testEntityTwo.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this test entity two.
	*
	* @return the company ID of this test entity two
	*/
	@Override
	public long getCompanyId() {
		return _testEntityTwo.getCompanyId();
	}

	/**
	* Sets the company ID of this test entity two.
	*
	* @param companyId the company ID of this test entity two
	*/
	@Override
	public void setCompanyId(long companyId) {
		_testEntityTwo.setCompanyId(companyId);
	}

	@Override
	public boolean isNew() {
		return _testEntityTwo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_testEntityTwo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _testEntityTwo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_testEntityTwo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _testEntityTwo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _testEntityTwo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_testEntityTwo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _testEntityTwo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_testEntityTwo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_testEntityTwo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_testEntityTwo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TestEntityTwoWrapper((TestEntityTwo)_testEntityTwo.clone());
	}

	@Override
	public int compareTo(
		de.uhh.l2g.plugins.migration.model.TestEntityTwo testEntityTwo) {
		return _testEntityTwo.compareTo(testEntityTwo);
	}

	@Override
	public int hashCode() {
		return _testEntityTwo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<de.uhh.l2g.plugins.migration.model.TestEntityTwo> toCacheModel() {
		return _testEntityTwo.toCacheModel();
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo toEscapedModel() {
		return new TestEntityTwoWrapper(_testEntityTwo.toEscapedModel());
	}

	@Override
	public de.uhh.l2g.plugins.migration.model.TestEntityTwo toUnescapedModel() {
		return new TestEntityTwoWrapper(_testEntityTwo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _testEntityTwo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _testEntityTwo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_testEntityTwo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TestEntityTwoWrapper)) {
			return false;
		}

		TestEntityTwoWrapper testEntityTwoWrapper = (TestEntityTwoWrapper)obj;

		if (Validator.equals(_testEntityTwo, testEntityTwoWrapper._testEntityTwo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TestEntityTwo getWrappedTestEntityTwo() {
		return _testEntityTwo;
	}

	@Override
	public TestEntityTwo getWrappedModel() {
		return _testEntityTwo;
	}

	@Override
	public void resetOriginalValues() {
		_testEntityTwo.resetOriginalValues();
	}

	private TestEntityTwo _testEntityTwo;
}