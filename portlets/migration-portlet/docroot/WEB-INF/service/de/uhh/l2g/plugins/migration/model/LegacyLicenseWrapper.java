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
 * This class is a wrapper for {@link LegacyLicense}.
 * </p>
 *
 * @author unihh
 * @see LegacyLicense
 * @generated
 */
public class LegacyLicenseWrapper implements LegacyLicense,
	ModelWrapper<LegacyLicense> {
	public LegacyLicenseWrapper(LegacyLicense legacyLicense) {
		_legacyLicense = legacyLicense;
	}

	@Override
	public Class<?> getModelClass() {
		return LegacyLicense.class;
	}

	@Override
	public String getModelClassName() {
		return LegacyLicense.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("videoId", getVideoId());
		attributes.put("ccby", getCcby());
		attributes.put("ccbybc", getCcbybc());
		attributes.put("ccbyncnd", getCcbyncnd());
		attributes.put("ccbyncsa", getCcbyncsa());
		attributes.put("ccbysa", getCcbysa());
		attributes.put("ccbync", getCcbync());
		attributes.put("l2go", getL2go());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Integer ccby = (Integer)attributes.get("ccby");

		if (ccby != null) {
			setCcby(ccby);
		}

		Integer ccbybc = (Integer)attributes.get("ccbybc");

		if (ccbybc != null) {
			setCcbybc(ccbybc);
		}

		Integer ccbyncnd = (Integer)attributes.get("ccbyncnd");

		if (ccbyncnd != null) {
			setCcbyncnd(ccbyncnd);
		}

		Integer ccbyncsa = (Integer)attributes.get("ccbyncsa");

		if (ccbyncsa != null) {
			setCcbyncsa(ccbyncsa);
		}

		Integer ccbysa = (Integer)attributes.get("ccbysa");

		if (ccbysa != null) {
			setCcbysa(ccbysa);
		}

		Integer ccbync = (Integer)attributes.get("ccbync");

		if (ccbync != null) {
			setCcbync(ccbync);
		}

		Integer l2go = (Integer)attributes.get("l2go");

		if (l2go != null) {
			setL2go(l2go);
		}
	}

	/**
	* Returns the primary key of this legacy license.
	*
	* @return the primary key of this legacy license
	*/
	@Override
	public long getPrimaryKey() {
		return _legacyLicense.getPrimaryKey();
	}

	/**
	* Sets the primary key of this legacy license.
	*
	* @param primaryKey the primary key of this legacy license
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_legacyLicense.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this legacy license.
	*
	* @return the ID of this legacy license
	*/
	@Override
	public long getId() {
		return _legacyLicense.getId();
	}

	/**
	* Sets the ID of this legacy license.
	*
	* @param id the ID of this legacy license
	*/
	@Override
	public void setId(long id) {
		_legacyLicense.setId(id);
	}

	/**
	* Returns the video ID of this legacy license.
	*
	* @return the video ID of this legacy license
	*/
	@Override
	public long getVideoId() {
		return _legacyLicense.getVideoId();
	}

	/**
	* Sets the video ID of this legacy license.
	*
	* @param videoId the video ID of this legacy license
	*/
	@Override
	public void setVideoId(long videoId) {
		_legacyLicense.setVideoId(videoId);
	}

	/**
	* Returns the ccby of this legacy license.
	*
	* @return the ccby of this legacy license
	*/
	@Override
	public int getCcby() {
		return _legacyLicense.getCcby();
	}

	/**
	* Sets the ccby of this legacy license.
	*
	* @param ccby the ccby of this legacy license
	*/
	@Override
	public void setCcby(int ccby) {
		_legacyLicense.setCcby(ccby);
	}

	/**
	* Returns the ccbybc of this legacy license.
	*
	* @return the ccbybc of this legacy license
	*/
	@Override
	public int getCcbybc() {
		return _legacyLicense.getCcbybc();
	}

	/**
	* Sets the ccbybc of this legacy license.
	*
	* @param ccbybc the ccbybc of this legacy license
	*/
	@Override
	public void setCcbybc(int ccbybc) {
		_legacyLicense.setCcbybc(ccbybc);
	}

	/**
	* Returns the ccbyncnd of this legacy license.
	*
	* @return the ccbyncnd of this legacy license
	*/
	@Override
	public int getCcbyncnd() {
		return _legacyLicense.getCcbyncnd();
	}

	/**
	* Sets the ccbyncnd of this legacy license.
	*
	* @param ccbyncnd the ccbyncnd of this legacy license
	*/
	@Override
	public void setCcbyncnd(int ccbyncnd) {
		_legacyLicense.setCcbyncnd(ccbyncnd);
	}

	/**
	* Returns the ccbyncsa of this legacy license.
	*
	* @return the ccbyncsa of this legacy license
	*/
	@Override
	public int getCcbyncsa() {
		return _legacyLicense.getCcbyncsa();
	}

	/**
	* Sets the ccbyncsa of this legacy license.
	*
	* @param ccbyncsa the ccbyncsa of this legacy license
	*/
	@Override
	public void setCcbyncsa(int ccbyncsa) {
		_legacyLicense.setCcbyncsa(ccbyncsa);
	}

	/**
	* Returns the ccbysa of this legacy license.
	*
	* @return the ccbysa of this legacy license
	*/
	@Override
	public int getCcbysa() {
		return _legacyLicense.getCcbysa();
	}

	/**
	* Sets the ccbysa of this legacy license.
	*
	* @param ccbysa the ccbysa of this legacy license
	*/
	@Override
	public void setCcbysa(int ccbysa) {
		_legacyLicense.setCcbysa(ccbysa);
	}

	/**
	* Returns the ccbync of this legacy license.
	*
	* @return the ccbync of this legacy license
	*/
	@Override
	public int getCcbync() {
		return _legacyLicense.getCcbync();
	}

	/**
	* Sets the ccbync of this legacy license.
	*
	* @param ccbync the ccbync of this legacy license
	*/
	@Override
	public void setCcbync(int ccbync) {
		_legacyLicense.setCcbync(ccbync);
	}

	/**
	* Returns the l2go of this legacy license.
	*
	* @return the l2go of this legacy license
	*/
	@Override
	public int getL2go() {
		return _legacyLicense.getL2go();
	}

	/**
	* Sets the l2go of this legacy license.
	*
	* @param l2go the l2go of this legacy license
	*/
	@Override
	public void setL2go(int l2go) {
		_legacyLicense.setL2go(l2go);
	}

	@Override
	public boolean isNew() {
		return _legacyLicense.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_legacyLicense.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _legacyLicense.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_legacyLicense.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _legacyLicense.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _legacyLicense.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_legacyLicense.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _legacyLicense.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_legacyLicense.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_legacyLicense.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_legacyLicense.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LegacyLicenseWrapper((LegacyLicense)_legacyLicense.clone());
	}

	@Override
	public int compareTo(LegacyLicense legacyLicense) {
		return _legacyLicense.compareTo(legacyLicense);
	}

	@Override
	public int hashCode() {
		return _legacyLicense.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<LegacyLicense> toCacheModel() {
		return _legacyLicense.toCacheModel();
	}

	@Override
	public LegacyLicense toEscapedModel() {
		return new LegacyLicenseWrapper(_legacyLicense.toEscapedModel());
	}

	@Override
	public LegacyLicense toUnescapedModel() {
		return new LegacyLicenseWrapper(_legacyLicense.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _legacyLicense.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _legacyLicense.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_legacyLicense.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LegacyLicenseWrapper)) {
			return false;
		}

		LegacyLicenseWrapper legacyLicenseWrapper = (LegacyLicenseWrapper)obj;

		if (Validator.equals(_legacyLicense, legacyLicenseWrapper._legacyLicense)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LegacyLicense getWrappedLegacyLicense() {
		return _legacyLicense;
	}

	@Override
	public LegacyLicense getWrappedModel() {
		return _legacyLicense;
	}

	@Override
	public void resetOriginalValues() {
		_legacyLicense.resetOriginalValues();
	}

	private LegacyLicense _legacyLicense;
}