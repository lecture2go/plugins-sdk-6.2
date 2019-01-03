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
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import de.uhh.l2g.plugins.service.ClpSerializer;

public class UserSearchHelper {

	protected static Log LOG = LogFactoryUtil.getLog(UserSearchHelper.class.getName());

	public static List<User>getUser(UserDisplayTerms displayTerms,int start,int end) throws SystemException{
		boolean adW = displayTerms.isAdvancedSearch();
		boolean iAnO = displayTerms.isAndOperator();
		//
		String rI = displayTerms.getRoleId();
		String kWr = displayTerms.getKeywords();
		//
        List<User> userList = getUserData(adW, iAnO, rI, kWr);
        return ListUtil.subList(userList, start , end);
	}
	
	public static int getTotalUserCount(UserDisplayTerms displayTerms,int start,int end) throws SystemException{
	       return getUserData(displayTerms.isAdvancedSearch(), displayTerms.isAndOperator(), displayTerms.getRoleId(), displayTerms.getKeywords()).size();
	}
	
	@SuppressWarnings("unchecked")
	public static List<User>getUserData(boolean isAdvancedSearch,boolean isAndOperator, String rId, String keywords) throws SystemException {
		List<User> userList = Collections.EMPTY_LIST;
		try {
			//text search
			if (!Validator.isBlank(keywords)) {
				ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(User.class, "usr", classLoader);
				Junction junction = null;
				junction = RestrictionsFactoryUtil.disjunction();
				//
				Criterion c1 = PropertyFactoryUtil.forName("usr.firstName").like("%" + keywords + "%");
				junction.add(c1);
				//
				Criterion c2 = PropertyFactoryUtil.forName("usr.lastName").like("%" + keywords + "%");
				junction.add(c2);
				//
				Criterion c3 = PropertyFactoryUtil.forName("usr.middleName").like("%" + keywords + "%");
				junction.add(c3);
				//
				Criterion c4 = PropertyFactoryUtil.forName("usr.screenName").like("%" + keywords + "%");
				junction.add(c4);
				//
				Criterion c5 = PropertyFactoryUtil.forName("usr.emailAddress").like("%" + keywords + "%");
				junction.add(c5);
				//
				dynamicQuery.add(junction);
				//order by 
				dynamicQuery.addOrder(OrderFactoryUtil.desc("usr.firstName"));
				//fire up the query
				userList = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
				//
			}
			//role id search
			if (Validator.isDigit(rId) && !rId.equals("0") && Validator.isBlank(keywords)) {
				Long lrId = new Long(rId);
				userList = UserLocalServiceUtil.getRoleUsers(lrId);
			}
			//no parameter chosen
			if ((!Validator.isDigit(rId) || rId.equals("0")) && Validator.isBlank(keywords)) {
				userList = UserLocalServiceUtil.getUsers(1, UserLocalServiceUtil.getUsersCount());
			}
		} catch (Exception e) {
			LOG.warn("can't fetch user list!");
		}
		return userList;
	}
}