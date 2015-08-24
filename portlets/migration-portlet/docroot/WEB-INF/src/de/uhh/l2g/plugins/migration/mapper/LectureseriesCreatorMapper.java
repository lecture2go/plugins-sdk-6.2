package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;


public class LectureseriesCreatorMapper {
	static final Log log = LogFactoryUtil.getLog(LectureseriesCreatorMapper.class);; 
	
	public static Lectureseries_Creator map(Lectureseries_Creator lectureseries_creator,Lectureseries Lectureseries, Creator creator) {
		if (lectureseries_creator == null) {
			log.warn("can't execute method with null values - return Lectureseries_Creator as null value");
			return null;
		}
		lectureseries_creator.setLectureseriesId(Lectureseries.getLectureseriesId());	
		lectureseries_creator.setCreatorId(creator.getCreatorId());
		return lectureseries_creator;
	} 


}
