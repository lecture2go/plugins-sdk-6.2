package de.uhh.l2g.plugins.servlets.oai;

import java.util.ArrayList;
import java.util.List;

import org.dspace.xoai.dataprovider.handlers.results.ListSetsResult;
import org.dspace.xoai.dataprovider.repository.SetRepository;

import com.liferay.portal.kernel.exception.SystemException;

import de.uhh.l2g.plugins.model.OaiSet;
import de.uhh.l2g.plugins.service.OaiSetLocalServiceUtil;

import org.dspace.xoai.dataprovider.model.Set;

/**
 * The set repository which handles sets
 */
public class L2GoSetRepository implements SetRepository {
    private boolean supportSets = true;
    private List<Set> sets = new ArrayList<Set>();
	
	public L2GoSetRepository() {
		try {
			List<OaiSet> oaiSets = OaiSetLocalServiceUtil.getAll();
			for (OaiSet oaiSet: oaiSets) {
				this.withSet(oaiSet.getSetName(), oaiSet.getSetSpec());
			}
		} catch (SystemException e) {
			// no sets, do nothing, the list stays empty
		}
	}
	
    public L2GoSetRepository doesNotSupportSets() {
        this.supportSets = false;
        return this;
    }
    
    public L2GoSetRepository withSet(String name, String spec) {
        this.sets.add(new Set(spec).withName(name));
        return this;
    }

	@Override
	public boolean supportSets() {
        return supportSets;
	}

	@Override
	public ListSetsResult retrieveSets(int offset, int length) {
        return new ListSetsResult(offset + length < this.sets.size(), this.sets.subList(offset, Math.min(offset + length, sets.size())));
	}

	@Override
	public boolean exists(String setSpec) {
		for (Set s : this.sets)
			if (s.getSpec().equals(setSpec))
				return true;
		return false;
	}

}
