package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Term;


public class TermMapper {
	static final Log log = LogFactoryUtil.getLog(TermMapper.class);; 
	
	public static Term mapTerm(Term term, long parentId, String languageId, String prefix, String year, String translation) {
		if (term == null) {
			log.warn("can't execute method with null values - return term as null value");
			return null;
		}
		term.setParentId(parentId);
		term.setLanguageId(languageId);
		term.setPrefix(prefix);
		term.setYear(year);
		term.setTranslation(translation);
		return term;
	}



}
