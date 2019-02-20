package de.uhh.l2g.plugins.search;

import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.NoSuchCoordinatorException;
import de.uhh.l2g.plugins.model.Coordinator;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.CoordinatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

public class VideoSearchHelper {

	protected static Log LOG = LogFactoryUtil.getLog(VideoSearchHelper.class.getName());

	public static List<Video>getVideo(VideoDisplayTerms displayTerms,int start,int end) throws SystemException{
		boolean adW = displayTerms.isAdvancedSearch();
		boolean iAnO = displayTerms.isAndOperator();
		//
		String cId = displayTerms.getCoordinatorId();
		String pId = displayTerms.getProducerId();
		String lId = displayTerms.getLectureseriesId();
		String kWr = displayTerms.getKeywords();
		//
        List<Video> videoList = getVideoData(adW, iAnO, cId, pId, lId, kWr);
        return ListUtil.subList(videoList, start , end);
	}
	
	public static int getTotalVideoCount(VideoDisplayTerms displayTerms,int start,int end) throws SystemException{
	       return getVideoData(displayTerms.isAdvancedSearch(), displayTerms.isAndOperator(), displayTerms.getCoordinatorId(), displayTerms.getProducerId(), displayTerms.getLectureseriesId(), displayTerms.getKeywords()).size();
	}
	
	public static List<Video>getVideoData(boolean isAdvancedSearch,boolean isAndOperator, String coordinatorId, String producerId, String lectureseriesId, String keywords) throws SystemException {
		List<Video> videoList = Collections.EMPTY_LIST;
		//root institution id from coordinator
		try {
			Long cId = new Long(0);
			String rootInstitutionId ="";
			Coordinator co = CoordinatorLocalServiceUtil.createCoordinator(0);
			try{ 
				cId = new Long (coordinatorId);
				co = CoordinatorLocalServiceUtil.getCoordinator(cId); 
				rootInstitutionId = InstitutionLocalServiceUtil.getInstitution(co.getInstitutionId()).getInstitutionId() + "";
			}catch(Exception nd){};
			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Video.class, "vid", classLoader);
			Junction junction = null;
			junction = RestrictionsFactoryUtil.conjunction(); 
			//
			if (!Validator.isBlank(keywords)) {
				Criterion c1 = PropertyFactoryUtil.forName("vid.title").like("%" + keywords + "%");
				junction.add(c1);
			}
			if (!Validator.isBlank(rootInstitutionId) && !Validator.equals(rootInstitutionId, "0")) {
				Criterion c2 = PropertyFactoryUtil.forName("vid.rootInstitutionId").eq(Long.valueOf(rootInstitutionId));
				junction.add(c2);
			}
			if (Validator.isDigit(producerId) && !Validator.equals(producerId, "0")) {
				Criterion c3 = PropertyFactoryUtil.forName("vid.producerId").eq(Long.valueOf(producerId));
				junction.add(c3);
			}
			if (Validator.isDigit(lectureseriesId) && !Validator.equals(lectureseriesId, "0")) {
				Criterion c4 = PropertyFactoryUtil.forName("vid.lectureseriesId").eq(Long.valueOf(lectureseriesId));
				junction.add(c4);
			}
			//
			dynamicQuery.add(junction);
			//order by 
			dynamicQuery.addOrder(OrderFactoryUtil.desc("vid.videoId"));
			//fire up the query
			videoList = VideoLocalServiceUtil.dynamicQuery(dynamicQuery);
			//
		} catch (Exception e) {
			LOG.warn("can't fetch video list!");
		}
        return videoList;
	}
}