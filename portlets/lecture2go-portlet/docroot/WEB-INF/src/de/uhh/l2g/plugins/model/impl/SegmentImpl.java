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

package de.uhh.l2g.plugins.model.impl;

/**
 * The extended model implementation for the Segment service. Represents a row in the &quot;LG_Segment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.model.Segment} interface.
 * </p>
 *
 * @author Iavor Sturm
 */
@SuppressWarnings("serial")
public class SegmentImpl extends SegmentBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a segment model instance should use the {@link de.uhh.l2g.plugins.model.Segment} interface instead.
	 */

	private long previusSegmentId;
	
	public long getPreviusSegmentId() {
		return previusSegmentId;
	}

	public void setPreviusSegmentId(long previusSegmentId) {
		this.previusSegmentId = previusSegmentId;
	}

	private int seconds;
	
	private int number;
	
	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public SegmentImpl() {
	}

}