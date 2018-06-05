package de.uhh.l2g.plugins.service.persistence;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	public static final String GET_ALL_STATISTICS = StatisticFinder.class.getName() + ".getAllStatistics";

	public JSONObject findAllStatistics ()  {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ALL_STATISTICS);
			SQLQuery q = session.createSQLQuery(sql);
			@SuppressWarnings("unchecked")
			List <Object[]> sl =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assemble(sl);
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

	private JSONObject assemble(List<Object[]> objectList) throws JSONException{
		JSONArray ja = new JSONArray();
		JSONObject mainObj = new JSONObject();
		for (Object[] obj: objectList){
			JSONObject jo = new JSONObject();
			jo.put("public", obj[0]);
			jo.put("private", obj[1]);
			jo.put("total", obj[2]);
			jo.put("date", obj[3]);
			jo.put("timespan", obj[4]);
			jo.put("publicDiff", obj[5]);
			jo.put("privateDiff", obj[6]);
			jo.put("totalDiff", obj[7]);
			ja.put(jo);
		}
		mainObj.put("statistic", ja);
		return mainObj;
	}
	
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
				//e.printStackTrace();
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
				//e.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return out;
	}


}
