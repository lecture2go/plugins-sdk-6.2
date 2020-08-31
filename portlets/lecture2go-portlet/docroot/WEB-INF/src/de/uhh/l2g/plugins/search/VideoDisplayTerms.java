package de.uhh.l2g.plugins.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class VideoDisplayTerms extends DisplayTerms {

	private String producerId;
	private String coordinatorId;
	private String lectureseriesId;

	public VideoDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		coordinatorId = ParamUtil.getString(portletRequest, "coordinatorId", "");
		producerId = ParamUtil.getString(portletRequest, "producerId", "");
		lectureseriesId = ParamUtil.getString(portletRequest, "lectureseriesId", "");
	}
	
	public String getCoordinatorId() {
		return coordinatorId;
	}

	public void setCoordinatorId(String coordinatorId) {
		this.coordinatorId = coordinatorId;
	}

	public String getProducerId() {
		return producerId;
	}

	public void setProducerId(String producerId) {
		this.producerId = producerId;
	}
	
	public String getLectureseriesId() {
		return lectureseriesId;
	}
	
	public void setLectureseriesId(String lectureseriesId) {
		this.lectureseriesId = lectureseriesId;
	}
	
}
