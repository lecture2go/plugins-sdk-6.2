package de.uhh.l2g.plugins.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Statistic;

public class StatisticFinderImpl extends BasePersistenceImpl<Statistic> implements StatisticFinder {

	public static final String CREATE_VIDEO_STATISTIC_VIEW = StatisticFinder.class.getName() + ".createVideoStatisticView";
	public static final String REMOVE_VIDEO_STATISTIC_TABLE = StatisticFinder.class.getName() + ".removeVideoStatisticTable";
	public static final String ADD_NEW_STATISTIC_ENTRY = StatisticFinder.class.getName() + ".addNewStatisticEntry";

	/**
	 * WARNING: As Custom Query is restricted executeQuery() 
	 * this methods uses Core DB functionality of Liferay 
	 */
	public int createVideoStatisticView() {
		Session session = null;
		int out = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(CREATE_VIDEO_STATISTIC_VIEW);

			DB db = DBFactoryUtil.getDB();
			//This requires to use executeUpdate instead of executeQuery
			db.runSQL(sql);
			
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

	/**
	 * WARNING: As Custom Query is restricted executeQuery() 
	 * this methods uses Core DB functionality of Liferay 
	 */
	public int removeVideoStatisticTable() {
		Session session = null;
		int out = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(REMOVE_VIDEO_STATISTIC_TABLE);
			
			DB db = DBFactoryUtil.getDB();
			//This requires to use executeUpdate instead of executeQuery
			db.runSQL(sql);
			
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
