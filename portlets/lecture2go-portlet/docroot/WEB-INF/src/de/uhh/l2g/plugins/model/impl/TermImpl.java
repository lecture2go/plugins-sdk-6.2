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

/**
 * The extended model implementation for the Term service. Represents a row in the &quot;LG_Term&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.model.Term} interface.
 * </p>
 *
 * @author Iavor Sturm
 */
public class TermImpl extends TermBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a term model instance should use the {@link de.uhh.l2g.plugins.model.Term} interface instead.
	 */
	private String fullName;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	/**
	 * @return the full termName (prefix + year)
	 */
	public String getTermName() {
		String termName = this.getPrefix() + " " + this.getYear();
		// the termName is trimmed, so an empty term is returned as an empty string (no spaces)
		termName = termName.trim();
		return termName;
	}
	
}