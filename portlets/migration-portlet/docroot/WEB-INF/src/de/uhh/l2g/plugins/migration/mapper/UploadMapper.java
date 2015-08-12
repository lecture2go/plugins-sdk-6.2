package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyUpload;
import de.uhh.l2g.plugins.model.Upload;

public class UploadMapper {
	static final Log log = LogFactoryUtil.getLog(UploadMapper.class);; 
	
	public static Upload mapUpload(LegacyUpload legacyUpload, Upload upload, long companyId) {
		if (legacyUpload == null || upload == null) {
			log.warn("can't execute method with null values - return upload as null value");
			return null;
		}
		upload.setContentLength(legacyUpload.getContentLength());
		upload.setStatus(legacyUpload.getStatus());
		upload.setTimestamp(legacyUpload.getTimestamp());
		upload.setUserId(UserIDMapper.getNewUserId(legacyUpload.getUserId(), companyId));
		upload.setVideoId(legacyUpload.getVideoId());
		return upload;
	} 

}
