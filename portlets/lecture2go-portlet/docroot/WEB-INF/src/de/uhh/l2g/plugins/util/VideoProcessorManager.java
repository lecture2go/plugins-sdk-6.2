package de.uhh.l2g.plugins.util;

import java.io.BufferedReader;
import java.io.IOException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

public class VideoProcessorManager {
	protected static Log LOG = LogFactoryUtil.getLog(VideoProcessorManager.class.getName());

	
	/**
	 * Starts a video conversion for the video with the given id
	 * @param videoId the id of the video which will be converted
	 */
	public static boolean startVideoConversion(Long videoId) {
		if (PropsUtil.contains("lecture2go.videoprocessing.provider")) {
			String videoConversionUrl = PropsUtil.get("lecture2go.videoprocessing.provider.videoconversion");

			try {
				// create json object with the necessary informations for the videoprocessor
				JSONObject jo = JSONFactoryUtil.createJSONObject();
				// the video id
				jo.put("sourceId", videoId);
				
				// set the complete path to the file
				Video video = VideoLocalServiceUtil.getVideo(videoId);
				String folder = PropsUtil.get("lecture2go.media.repository")+"/"+HostLocalServiceUtil.getByHostId(video.getHostId()).getServerRoot()+"/"+ProducerLocalServiceUtil.getProducer(video.getProducerId()).getHomeDir()+"/";
				String filePath;
				if(video.getOpenAccess()==1){
					filePath = folder + video.getFilename();
				}else{
					filePath = folder + video.getSecureFilename();
				}
				jo.put("sourceFilePath", filePath);
			
				// set whether a smil file should be created
				jo.put("createSmil", true);
				
				// send POST request to video processor
				try {
					HttpManager httpManager = new HttpManager();
					httpManager.setUrl(videoConversionUrl);
					if (PropsUtil.contains("lecture2go.videoprocessing.basicauth.user") && PropsUtil.contains("lecture2go.videoprocessing.basicauth.pass")) {
						httpManager.setUser(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.user"));
						httpManager.setPass(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.pass"));
					}
					HttpURLConnection conn = httpManager.sendPost(jo);
					httpManager.close();
					
					// check response
					int responseCode = conn.getResponseCode();
					if (responseCode == 201) {
						return true;
					} else {
						LOG.error("Failed starting a new video conversion of video with id: " + videoId + ". Responsecode: " + responseCode); 
						return false;
					}
				} catch (IOException e) {
					LOG.error("Failed connecting to videoprocessor to start a new video conversion of video with id: " + videoId); 
					//e.printStackTrace();
					return false;
				}
			} catch (SystemException e) {
				//e.printStackTrace();
				return false;
			} catch (PortalException e) {
				//e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	
	/**
	 * Starts a video conversion for the video with the given id
	 * @param videoId the id of the video which will be converted
	 */
	//public static boolean startVideoConversion(Long videoId, String workflow, HashMap<String, String> workflowProperties) {
	public static boolean startVideoConversion(Long videoId, String workflow, String captionUrl, String layout) {
		if (PropsUtil.contains("lecture2go.videoprocessing.provider")) {
			String videoConversionUrl = PropsUtil.get("lecture2go.videoprocessing.provider.videoconversion");

			try {
				// create json object with the necessary informations for the videoprocessor
				JSONObject jo = JSONFactoryUtil.createJSONObject();
				// the video id
				jo.put("sourceId", videoId);
				
				// the workflow
				jo.put("workflow", workflow);
				
				jo.put("captionUrl", captionUrl);
				jo.put("layout", layout);

				
				// an arbitrary number workflow properties
				/*if (!workflowProperties.isEmpty()) {
					JSONObject jsonWorkflowProperties = JSONFactoryUtil.createJSONObject();
					for (Map.Entry<String, String> workflowProperty : workflowProperties.entrySet()) {
						jsonWorkflowProperties.put(workflowProperty.getKey(), workflowProperty.getValue());
					}
					jo.put("workflowProperties", jsonWorkflowProperties);
				}*/
				
				// set the complete path to the file
				Video video = VideoLocalServiceUtil.getVideo(videoId);
				String folder = PropsUtil.get("lecture2go.media.repository")+"/"+HostLocalServiceUtil.getByHostId(video.getHostId()).getServerRoot()+"/"+ProducerLocalServiceUtil.getProducer(video.getProducerId()).getHomeDir()+"/";
				String filePath;
				if(video.getOpenAccess()==1){
					filePath = folder + video.getFilename();
				}else{
					filePath = folder + video.getSecureFilename();
				}
				jo.put("sourceFilePath", filePath);
			
				// set whether a smil file should be created
				jo.put("createSmil", true);
				
				// send POST request to video processor
				try {
					HttpManager httpManager = new HttpManager();
					httpManager.setUrl(videoConversionUrl);
					if (PropsUtil.contains("lecture2go.videoprocessing.basicauth.user") && PropsUtil.contains("lecture2go.videoprocessing.basicauth.pass")) {
						httpManager.setUser(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.user"));
						httpManager.setPass(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.pass"));
					}
					HttpURLConnection conn = httpManager.sendPost(jo);
					httpManager.close();
					
					// check response
					int responseCode = conn.getResponseCode();
					if (responseCode == 201) {
						return true;
					} else {
						LOG.error("Failed starting a new video conversion of video with id: " + videoId + ". Responsecode: " + responseCode); 
						return false;
					}
				} catch (IOException e) {
					LOG.error("Failed connecting to videoprocessor to start a new video conversion of video with id: " + videoId); 
					//e.printStackTrace();
					return false;
				}
			} catch (SystemException e) {
				//e.printStackTrace();
				return false;
			} catch (PortalException e) {
				//e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Renames the files of a video conversion for the video with the given id
	 * @param videoId the id of the video whose files will be renamed
	 */
	public static void renameFileOfVideoConversion(Long videoId, String filename) {
		if (PropsUtil.contains("lecture2go.videoprocessing.provider")) {
	
			String videoConversionUrl = PropsUtil.get("lecture2go.videoprocessing.provider.videoconversion") + "/sourceid/" + String.valueOf(videoId) + "/filename";
			// create json object with current (non-open access) filename
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			jo.put("sourceFileName", filename);
			// send PUT request to video processor
			try {
				HttpManager httpManager = new HttpManager();
				httpManager.setUrl(videoConversionUrl);
				if (PropsUtil.contains("lecture2go.videoprocessing.basicauth.user") && PropsUtil.contains("lecture2go.videoprocessing.basicauth.pass")) {
					httpManager.setUser(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.user"));
					httpManager.setPass(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.pass"));
				}
				HttpURLConnection conn = httpManager.sendPut(jo);
				httpManager.close();
				
				// check response
				int responseCode = conn.getResponseCode();
				if (responseCode != 200) {
					LOG.error("Failed renaming the files of a video conversion of video with id: " + videoId + ". Responsecode: " + responseCode); 
				}
			} catch (IOException e) {
				LOG.error("Failed connecting to videoprocessor to rename the files of the video conversion of video with id: " + videoId); 
				//e.printStackTrace();
			}
		}
	}

	/**
	 * Deletes the files of a video conversion for the video with the given id
	 * @param videoId the id of the video whose files will be deleted
	 */
	public static boolean deleteVideoConversion(Long videoId) {
		if (PropsUtil.contains("lecture2go.videoprocessing.provider")) {
			String videoConversionUrl = PropsUtil.get("lecture2go.videoprocessing.provider.videoconversion") + "/sourceid/" + String.valueOf(videoId);
			// send DELETE request to video processor
			try {
				HttpManager httpManager = new HttpManager();
				httpManager.setUrl(videoConversionUrl);
				if (PropsUtil.contains("lecture2go.videoprocessing.basicauth.user") && PropsUtil.contains("lecture2go.videoprocessing.basicauth.pass")) {
					httpManager.setUser(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.user"));
					httpManager.setPass(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.pass"));
				}
				HttpURLConnection conn = httpManager.sendDelete();
				httpManager.close();
				
				// check response
				int responseCode = conn.getResponseCode();
				if (responseCode == 200) {
					return true;
				} else {
					LOG.error("Failed deleting the files of a video conversion of video with id: " + videoId + ". Responsecode: " + responseCode); 
					return false;
				}
			} catch (IOException e) {
				LOG.error("Failed connecting to videoprocessor to delete the files of the video conversion of video with id: " + videoId); 
				//e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Gets video conversion status of a video conversion for the video with the given id
	 * @param videoId the id of the video whose info will be retrieved
	 * @return the exact status returned by the videoconversion provider
	 */
	public static String getVideoConversionStatusForVideoId(Long videoId) {
		String status = "";
		if (PropsUtil.contains("lecture2go.videoprocessing.provider")) {
			String videoConversionUrl = PropsUtil.get("lecture2go.videoprocessing.provider.videoconversion") + "/sourceid/" + String.valueOf(videoId);
			// send GET request to video processor to check 
			try {
				HttpManager httpManager = new HttpManager();
				httpManager.setUrl(videoConversionUrl);
				if (PropsUtil.contains("lecture2go.videoprocessing.basicauth.user") && PropsUtil.contains("lecture2go.videoprocessing.basicauth.pass")) {
					httpManager.setUser(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.user"));
					httpManager.setPass(PropsUtil.get("lecture2go.videoprocessing.provider.basicauth.pass"));
				}
				HttpURLConnection conn = httpManager.sendGet();
				httpManager.close();
			
				// videoprocessor return status 200 ok, if a given video id was processed
				int responseCode = conn.getResponseCode();
				if (responseCode == 200) {
					BufferedReader in = new BufferedReader(
					        new InputStreamReader(conn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					JSONObject jsonResponse = JSONFactoryUtil.createJSONObject(response.toString());
					
					// get the conversion status
					status = jsonResponse.getString("status");	
				} else {
					LOG.error("Failed getting the info of a video conversion of video with id: " + videoId + ". Responsecode: " + responseCode); 
				}
			} catch (IOException e) {
				LOG.error("Failed connecting to videoprocessor to get status of video with id: " + videoId); 
			} catch (JSONException e) {
				LOG.error("Failed reading json from videoprocessor for video with id: " + videoId); 
			}
		}
		return status;
	}
	
	/**
	 * Returns a simple status: Error, Running, Finished
	 * @param videoId the id of the video
	 * @return the simple status
	 */
	public static String getSimpleVideoConversionStatusForVideoId(Long videoId) {
		String complexStatus = getVideoConversionStatusForVideoId(videoId);
		
		// return empty value if complexStatus is empty
		if (complexStatus.isEmpty()) {
			return "";
		}
		
		// otherwise translate the complex status to the simple status
		String simpleStatus = "";
		if (complexStatus.startsWith("ERROR")) {
			// all ERROR_* status codes are translated to ERROR
			simpleStatus = "ERROR";
		} else if (complexStatus.equals("FINISHED")) {
			// FINISHED status code stays FINISHED status code
			simpleStatus = complexStatus;
		} else if (complexStatus.equals("DELETED")) { 
			// DELETED status code translates to empty String, as it is handled like the Processing didn't exist
			simpleStatus = "";
		} else {
			// all other codes are translated to RUNNING
			simpleStatus = "RUNNING";
		}
		return simpleStatus;
	}	
}
