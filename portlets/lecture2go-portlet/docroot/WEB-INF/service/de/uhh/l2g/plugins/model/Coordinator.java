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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Coordinator service. Represents a row in the &quot;LG_Coordinator&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see CoordinatorModel
 * @see de.uhh.l2g.plugins.model.impl.CoordinatorImpl
 * @see de.uhh.l2g.plugins.model.impl.CoordinatorModelImpl
 * @generated
 */
public interface Coordinator extends CoordinatorModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.uhh.l2g.plugins.model.impl.CoordinatorImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getLastName();

	public void setLastName(java.lang.String lastName);

	public java.lang.String getFirstName();

	public void setFirstName(java.lang.String firstName);

	public java.lang.String getEmailAddress();

	public void setEmailAddress(java.lang.String emailAddress);

	public java.util.Date getLastLoginDate();

	public void setLastLoginDate(java.util.Date lastLoginDate);
}