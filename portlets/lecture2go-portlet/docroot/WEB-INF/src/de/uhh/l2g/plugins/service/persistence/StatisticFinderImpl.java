package de.uhh.l2g.plugins.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Statistic;
import de.uhh.l2g.plugins.model.impl.StatisticImpl;

public class StatisticFinderImpl extends BasePersistenceImpl<Statistic> implements StatisticFinder {

	public static final String CREATE_VIDEO_STATISTIC_VIEW = StatisticFinder.class.getName() + ".createVideoStatisticView";
	public static final String REMOVE_VIDEO_STATISTIC_TABLE = StatisticFinder.class.getName() + ".removeVideoStatisticTable";

	public int createVideoStatisticView() {
		Session session = null;
		int out = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(CREATE_VIDEO_STATISTIC_VIEW);
			SQLQuery q = session.createSQLQuery(sql);
			
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			Iterator<?> itr = q.list().iterator();

	        if (itr.hasNext()) {
	          Integer count = (Integer)itr.next();

	          if (count != null) {
	            return count.intValue();
	          }
	        }

	        return out;
	      } catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return out;
	}

	public int removeVideoStatisticTable() {
		Session session = null;
		int out = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(REMOVE_VIDEO_STATISTIC_TABLE);
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			Iterator<?> itr = q.list().iterator();

	        if (itr.hasNext()) {
	          Integer count = (Integer)itr.next();

	          if (count != null) {
	            return count.intValue();
	          }
	        }

	        return out;
	      } catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return out;
	}


}
