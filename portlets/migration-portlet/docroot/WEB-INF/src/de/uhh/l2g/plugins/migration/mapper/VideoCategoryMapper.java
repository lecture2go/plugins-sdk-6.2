package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Video_Category;


public class VideoCategoryMapper {
	static final Log log = LogFactoryUtil.getLog(VideoCategoryMapper.class);; 
	
	public static Video_Category mapVideoCategory(Video_Category video_category,long videoId, long categoryId) {
		if (video_category == null) {
			log.warn("can't execute method with null values - return video as null value");
			return null;
		}
		video_category.setVideoId(videoId);
		video_category.setCategoryId(categoryId);
		return video_category;
	} 


}
