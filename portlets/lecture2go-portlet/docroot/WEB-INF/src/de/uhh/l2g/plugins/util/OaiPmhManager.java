package de.uhh.l2g.plugins.util;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.NoSuchOaiRecordException;
import de.uhh.l2g.plugins.model.OaiRecord;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.OaiRecordImpl;
import de.uhh.l2g.plugins.service.OaiRecordLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

/**
 * The OaiPmhManager handles the OAI-PMH-repository
 *
 */
public class OaiPmhManager {

	public OaiPmhManager() {
		
	}
	
	/**
	 * Publishes a video to the OAI-PMH-Repository
	 * 
	 * If an OaiRecord already exists for the video, it will be updated 
	 * @param videoId the id of the video which will be published to the OAI-PMH-repository 
	 */
	public static void publish(Long videoId) {
		if (!checkOaiPmhServiceAllowed()) {
			return;
		}
		// check if an OaiRecord already exists for this videoId
		try {
			OaiRecord oaiRecord = OaiRecordLocalServiceUtil.getByVideo(videoId);
			// handle already existing 
			oaiRecord = fillOaiRecord(oaiRecord, videoId, false);
			OaiRecordLocalServiceUtil.updateOaiRecord(oaiRecord);
		} catch (NoSuchOaiRecordException e) {
			// no record with the video id, create one (this is the normal case
			OaiRecord oaiRecord = new OaiRecordImpl();
			oaiRecord = fillOaiRecord(oaiRecord, videoId, false);
			try {
				OaiRecordLocalServiceUtil.addOaiRecord(oaiRecord);
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Unpublishes a video from the OAI-PMH-Repository 
	 * Sets the "deleted" flag, so those items still remain in the repository
	 * @param videoId the id of the video which will be unpublished from the OAI-PMH-repository
	 */
	public static void unpublish(Long videoId) {
		if (!checkOaiPmhServiceAllowed()) {
			return;
		}
		try {
			// check if an OaiRecord even exists for this videoId
			OaiRecord oaiRecord = OaiRecordLocalServiceUtil.getByVideo(videoId);
			oaiRecord = fillOaiRecord(oaiRecord, videoId, true);
			OaiRecordLocalServiceUtil.updateOaiRecord(oaiRecord);
		} catch (NoSuchOaiRecordException e) {
			// no record with the video id, unpublishing not necessary
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Modifies a OaiRecord 
	 * This will update the datestamp of OAIRecord (If no OAI exists for this video, it will do nothing) 
	 * @param videoId the id of the video whose datestamp will be modified
	 */
	public static void modify(Long videoId) {
		if (!checkOaiPmhServiceAllowed()) {
			return;
		}
		try {
			// check if an OaiRecord even exists for this videoId
			OaiRecord oaiRecord = OaiRecordLocalServiceUtil.getByVideo(videoId);
			// we only need to update the datestamp to the modified time and only if the record is not deleted
			if (!oaiRecord.getDeleted()) {
				oaiRecord.setDatestamp(new Date());
				OaiRecordLocalServiceUtil.updateOaiRecord(oaiRecord);
			}
		} catch (NoSuchOaiRecordException e) {
			// no record with the video id, modifying not necessary
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Modifies all OaiRecords which are linked to the given creator
	 * This should be called when a creator name is changed, so all OaiRecords will be updated accordingly
	 * @param creatorId the creatorId
	 */
	public static void modifyByCreator(Long creatorId) {
		if (!checkOaiPmhServiceAllowed()) {
			return;
		}
		List<OaiRecord> oaiRecords;
		try {
			oaiRecords = OaiRecordLocalServiceUtil.getByCreator(creatorId);
			for (OaiRecord oaiRecord: oaiRecords) {
				modify(oaiRecord.getVideoId());
			}
		} catch (NoSuchOaiRecordException e) {
			// no OaiRecords for this creator, nothing needs to be modified
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Modifies all OaiRecords which are linked to the given category
	 * This should be called when a category name is changed, so all OaiRecords will be updated accordingly
	 * @param categoryId the categoryId
	 */
	public static void modifyByCategory(Long categoryId) {
		if (!checkOaiPmhServiceAllowed()) {
			return;
		}
		List<OaiRecord> oaiRecords;
		try {
			oaiRecords = OaiRecordLocalServiceUtil.getByCategory(categoryId);
			for (OaiRecord oaiRecord: oaiRecords) {
				modify(oaiRecord.getVideoId());
			}
		} catch (NoSuchOaiRecordException e) {
			// no OaiRecords for this category, nothing needs to be modified
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Modifies all OaiRecords which are linked to the given lectureseries
	 * This should be called when a lectureseries was changed, so all OaiRecords will be updated accordingly
	 * @param lectureseriesId the lectureseriesId
	 */
	public static void modifyByLectureseries(Long lectureseriesId) {
		if (!checkOaiPmhServiceAllowed()) {
			return;
		}
		List<OaiRecord> oaiRecords;
		try {
			oaiRecords = OaiRecordLocalServiceUtil.getByLectureseries(lectureseriesId);
			for (OaiRecord oaiRecord: oaiRecords) {
				modify(oaiRecord.getVideoId());
			}
		} catch (NoSuchOaiRecordException e) {
			// no OaiRecords for this category, nothing needs to be modified
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	// a modification on insitution basis may not be relevant to the oai-pmh-repository, so this is not implemented for now
	public static void modifyByInstitution(Long InstitutionId) {
		
	}
	
	/**
	 * This publishes all open access video to the OAI-PMH-repository
	 */
	public static void publishAllOpenAccessVideos() {
		if (!checkOaiPmhServiceAllowed()) {
			return;
		}
		try {
			List<Video> videos = VideoLocalServiceUtil.getByOpenAccess(1);
			for (Video video: videos) {
				publish(video.getVideoId());
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Fills the OaiRecord with the given data
	 * @param oaiRecord the OaiRecord to fill
	 * @param videoId the corresponding videoId
	 * @param deleted flag if the record should be marked as deleted
	 * @return the filled OaiRecord
	 */
	private static OaiRecord fillOaiRecord(OaiRecord oaiRecord, Long videoId, boolean deleted) {
		oaiRecord.setVideoId(videoId);
		String identifierPrefix = PropsUtil.get("lecture2go.oai.pmh.identifierprefix");
		oaiRecord.setIdentifier(identifierPrefix + PropsUtil.get("lecture2go.oaipmh.identifierdelimiter") + videoId);
		oaiRecord.setDatestamp(DateUtil.newDate());
		oaiRecord.setDeleted(deleted);
		return oaiRecord;
	}
	
	/**
	 * Checks if the oai-pmh data updating is allowed via config or not
	 * @return true if service is allowed, false if not
	 */
	private static boolean checkOaiPmhServiceAllowed() {
		return Boolean.parseBoolean(PropsUtil.get("lecture2go.oaipmh.active"));
	}
}
