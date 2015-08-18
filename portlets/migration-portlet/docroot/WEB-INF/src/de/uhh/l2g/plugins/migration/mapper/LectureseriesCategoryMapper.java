package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Category;

public class LectureseriesCategoryMapper {
	static final Log log = LogFactoryUtil.getLog(LectureseriesCategoryMapper.class);
	
	public static Lectureseries_Category mapLectureseries_Category(Lectureseries_Category lectureseries_Category,Lectureseries lectureseries , Category category) {
		if (category == null || lectureseries_Category == null) {
			log.warn("can't execute method with null values - return LectureseriesInstitution as null value");
			return null;
		}
		lectureseries_Category.setLectureseriesId(lectureseries.getLectureseriesId());
		lectureseries_Category.setCategoryId(category.getCategoryId());
	 return lectureseries_Category;
	}

}
