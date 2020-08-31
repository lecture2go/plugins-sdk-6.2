package de.uhh.l2g.plugins.service.persistence;

import java.util.Date;
import java.util.Iterator;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import de.uhh.l2g.plugins.service.persistence.OaiRecordFinder;
import de.uhh.l2g.plugins.NoSuchOaiRecordException;
import de.uhh.l2g.plugins.model.OaiRecord;

public class OaiRecordFinderImpl extends BasePersistenceImpl<OaiRecord> implements OaiRecordFinder {
	public static final String FIND_EARLIEST_DATESTAMP = OaiRecordFinder.class.getName() + ".findEarliestDatestamp";

	public Date findEarliestDatestamp() {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_EARLIEST_DATESTAMP);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("earliestDatestamp", Type.TIMESTAMP);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			return (Date) q.uniqueResult();
		} catch (Exception e) {
			
		} finally {
			closeSession(session);
		}
		return null;
	}
}
