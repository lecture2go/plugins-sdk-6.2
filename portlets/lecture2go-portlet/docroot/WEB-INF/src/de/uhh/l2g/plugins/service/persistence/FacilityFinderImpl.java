package de.uhh.l2g.plugins.service.persistence;

import java.util.List;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.uhh.l2g.plugins.model.Facility;
import de.uhh.l2g.plugins.model.impl.FacilityImpl;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class FacilityFinderImpl extends BasePersistenceImpl<Facility> implements FacilityFinder {

	public List<Facility> findAllSortedAsTree(int begin, int end) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_ALL_SORTED_AS_TREE);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("Facility_Facility", FacilityImpl.class);
			return (List<Facility>) QueryUtil.list(q, getDialect(), begin, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<Facility> findAll(int begin, int end) {
		Session session = null;
		try {
			session =  openSession();
			String sql = CustomSQLUtil.get(FIND_ALL);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("Facility_Facility", FacilityImpl.class);
			return (List<Facility>) QueryUtil.list(q, getDialect(), begin, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public static final String FIND_ALL_SORTED_AS_TREE = FacilityFinder.class.getName() + ".findAllSortedAsTree";
	public static final String FIND_ALL = FacilityFinder.class.getName() + ".findAll";

}
