package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Category;


public class CategoryMapper {
	static final Log log = LogFactoryUtil.getLog(CategoryMapper.class);; 
	
	public static Category mapCategory(Category category, String name, String languageId, String  translation, long parentId) {
		if (category == null) {
			log.warn("can't execute method with null values - return video as null value");
			return null;
		}
		category.setName(name);
		category.setLanguageId(languageId);
		category.setTranslation(translation);
		category.setParentId(parentId);
		return category;
	} 


}
