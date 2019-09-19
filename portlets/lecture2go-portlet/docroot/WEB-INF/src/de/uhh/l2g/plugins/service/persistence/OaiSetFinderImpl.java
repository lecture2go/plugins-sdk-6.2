package de.uhh.l2g.plugins.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.OaiRecord;
import de.uhh.l2g.plugins.model.OaiSet;
import de.uhh.l2g.plugins.model.impl.OaiSetImpl;
 

public class OaiSetFinderImpl extends BasePersistenceImpl<OaiRecord> implements OaiSetFinder {
	public static final String FIND_BY_OAI_RECORD = OaiSetFinder.class.getName() + ".findByOaiRecord";
	
	public List<OaiSet> findByOaiRecord(long oaiRecord) {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_OAI_RECORD);
			SQLQuery q = session.createSQLQuery(sql);
            q.addEntity("OaiSet",OaiSetImpl.class);
            q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(oaiRecord);
			
			List <OaiSet> sl =  (List<OaiSet>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return sl;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}

}
