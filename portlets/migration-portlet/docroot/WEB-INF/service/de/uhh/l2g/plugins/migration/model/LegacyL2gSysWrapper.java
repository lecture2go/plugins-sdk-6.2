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
 * This class is a wrapper for {@link LegacyL2gSys}.
 * </p>
 *
 * @author unihh
 * @see LegacyL2gSys
 * @generated
 */
public class LegacyL2gSysWrapper implements LegacyL2gSys,
	ModelWrapper<LegacyL2gSys> {
	public LegacyL2gSysWrapper(LegacyL2gSys legacyL2gSys) {
		_legacyL2gSys = legacyL2gSys;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyL2gSys.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyL2gSys.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("version", getVersion());
		attributes.put("setupwizard", getSetupwizard());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Integer setupwizard = (Integer)attributes.get("setupwizard");

		if (setupwizard != null) {
			setSetupwizard(setupwizard);
		}
	}

	/**
	* Returns the primary key of this legacy l2g sys.
	*
	* @return the primary key of this legacy l2g sys
	*/
	@Override
	public int getPrimaryKey() {
		return _legacyL2gSys.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy l2g sys.
	*
	* @param primaryKey the primary key of this legacy l2g sys
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_legacyL2gSys.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy l2g sys.
	*
	* @return the ID of this legacy l2g sys
	*/
	@Override
	public int getId() {
		return _legacyL2gSys.getId();
	}

	/**
	* Sets the ID of this legacy l2g sys.
	*
	* @param id the ID of this legacy l2g sys
	*/
	@Override
	public void setId(int id) {
		_legacyL2gSys.setId(id);
	}

	/**
	* Returns the version of this legacy l2g sys.
	*
	* @return the version of this legacy l2g sys
	*/
	@Override
	public java.lang.String getVersion() {
		return _legacyL2gSys.getVersion();
	}

	/**
	* Sets the version of this legacy l2g sys.
	*
	* @param version the version of this legacy l2g sys
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_legacyL2gSys.setVersion(version);
	}

	/**
	* Returns the setupwizard of this legacy l2g sys.
	*
	* @return the setupwizard of this legacy l2g sys
	*/
	@Override
	public int getSetupwizard() {
		return _legacyL2gSys.getSetupwizard();
	}

	/**
	* Sets the setupwizard of this legacy l2g sys.
	*
	* @param setupwizard the setupwizard of this legacy l2g sys
	*/
	@Override
	public void setSetupwizard(int setupwizard) {
		_legacyL2gSys.setSetupwizard(setupwizard);
	}

	@Override
	public boolean isNew() {
		return _legacyL2gSys.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyL2gSys.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyL2gSys.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyL2gSys.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyL2gSys.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyL2gSys.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyL2gSys.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyL2gSys.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyL2gSys.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyL2gSys.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyL2gSys.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyL2gSysWrapper((LegacyL2gSys)_legacyL2gSys.clone());
	}

	@Override
	public int compareTo(LegacyL2gSys legacyL2gSys) {
		return _legacyL2gSys.compareTo(legacyL2gSys);
	}

	@Override
	public int hashCode() {
		return _legacyL2gSys.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacyL2gSys> toCacheModel() {
		return _legacyL2gSys.toCacheModel();
	}

	@Override
	public LegacyL2gSys toEscapedModel() {
		return new LegacyL2gSysWrapper(_legacyL2gSys.toEscapedModel());
	}

	@Override
	public LegacyL2gSys toUnescapedModel() {
		return new LegacyL2gSysWrapper(_legacyL2gSys.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyL2gSys.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyL2gSys.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyL2gSys.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyL2gSysWrapper)) {
			return false;
		}

		LegacyL2gSysWrapper legacyL2gSysWrapper = (LegacyL2gSysWrapper)obj;

		if (Validator.equals(_legacyL2gSys, legacyL2gSysWrapper._legacyL2gSys)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyL2gSys getWrappedLegacyL2gSys() {
		return _legacyL2gSys;
	}

	@Override
	public LegacyL2gSys getWrappedModel() {
		return _legacyL2gSys;
	}

	@Override
	public void resetOriginalValues() {
		_legacyL2gSys.resetOriginalValues();
	}

	private LegacyL2gSys _legacyL2gSys;
}