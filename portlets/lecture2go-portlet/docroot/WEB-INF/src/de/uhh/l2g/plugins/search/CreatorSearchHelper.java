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

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.service.ClpSerializer;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;

public class CreatorSearchHelper {

	protected static Log LOG = LogFactoryUtil.getLog(CreatorSearchHelper.class.getName());

	public static List<Creator> getCreator(CreatorDisplayTerms displayTerms,int start,int end) throws SystemException{
		boolean adW = displayTerms.isAdvancedSearch();
		boolean iAnO = displayTerms.isAndOperator();
		//
		String kWr = displayTerms.getKeywords();
		//
        List<Creator> creatorsList = getCreatorData(adW, iAnO, kWr);
        return ListUtil.subList(creatorsList, start , end);
	}
	
	public static int getTotalCreatorCount	(CreatorDisplayTerms displayTerms,int start,int end) throws SystemException{
	       return getCreatorData(displayTerms.isAdvancedSearch(), displayTerms.isAndOperator(), displayTerms.getKeywords()).size();
	}
	
	public static List<Creator>getCreatorData(boolean isAdvancedSearch,boolean isAndOperator, String keywords) throws SystemException {
		List<Creator> creatorList = Collections.EMPTY_LIST;
		try {
			//text search
			if (!Validator.isBlank(keywords)) {
				ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Creator.class, "creat", classLoader);
				Junction junction = null;
				junction = RestrictionsFactoryUtil.disjunction();
				//
				String[] kwordsSplit = keywords.split(" ");
				for (String str: kwordsSplit) {           
					if(!str.isEmpty()){
						Criterion c1 = PropertyFactoryUtil.forName("creat.firstName").like("%" + str + "%");
						junction.add(c1);
						//
						Criterion c2 = PropertyFactoryUtil.forName("creat.lastName").like("%" + str + "%");
						junction.add(c2);
						//
						Criterion c3 = PropertyFactoryUtil.forName("creat.middleName").like("%" + str + "%");
						junction.add(c3);
						//
						Criterion c4 = PropertyFactoryUtil.forName("creat.jobTitle").like("%" + str + "%");
						junction.add(c4);
						//
						Criterion c5 = PropertyFactoryUtil.forName("creat.fullName").like("%" + str + "%");
						junction.add(c5);
					}
				}
				dynamicQuery.add(junction);
				//order by 
				dynamicQuery.addOrder(OrderFactoryUtil.desc("creat.firstName"));
				//fire up the query
				creatorList = CreatorLocalServiceUtil.dynamicQuery(dynamicQuery);
			}else{
				creatorList = CreatorLocalServiceUtil.getAllCreators();
			}
		} catch (Exception e) {
			LOG.warn("can't fetch creator list!");
		}
        return creatorList;
	}
}