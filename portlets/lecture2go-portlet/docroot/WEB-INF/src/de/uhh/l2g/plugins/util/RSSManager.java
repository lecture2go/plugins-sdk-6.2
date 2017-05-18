package de.uhh.l2g.plugins.util;

/***************************************************************************
 * The Lecture2Go software is based on the liferay portal 6.1.1 
 * <http://www.liferay.com>
 * 
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source 
 * platform for media management and distribution. Our goal is to 
 * support the free access to knowledge because this is a component 
 * of each democratic society. The open source software is aimed at 
 * academic institutions and has to strengthen the blended learning.
 * 
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 * 
 * @Autor Lecture2Go Team
 * @Version 1.0
 * @Contact lecture2go-open-source@uni-hamburg.de
 *  
 * Copyright (c) 2013 University of Hamburg / Computer and Data Center (RRZ)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 ***************************************************************************/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.SimpleTimeZone;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_InstitutionLocalServiceUtil;


/**
 * The Class RSSManager.
 */
public class RSSManager {

	/** The title. */
	private String title = "";

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** The description. */
	private String description = "";

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** The language. */
	private String language = "";

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 *
	 * @param language the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/** The pub date. */
	private String pubDate = "";

	/**
	 * Gets the pub date.
	 *
	 * @return the pub date
	 */
	public String getPubDate() {
		return pubDate;
	}

	/**
	 * Sets the pub date.
	 *
	 * @param pubDate the new pub date
	 */
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	/** The last build date. */
	private String lastBuildDate = "";

	/**
	 * Gets the last build date.
	 *
	 * @return the last build date
	 */
	public String getLastBuildDate() {
		return lastBuildDate;
	}

	/**
	 * Sets the last build date.
	 *
	 * @param lastBuildDate the new last build date
	 */
	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	/** The image title. */
	private String imageTitle = "";

	/**
	 * Gets the image title.
	 *
	 * @return the image title
	 */
	public String getImageTitle() {
		return imageTitle;
	}

	/**
	 * Sets the image title.
	 *
	 * @param imageTitle the new image title
	 */
	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}

	/**
	 * Generate item.
	 */
	public void generateItem() {
	}

	/**
	 * Delete rss.
	 *
	 * @param name the name
	 */
	public void deleteRss(String name) {
	}

	/**
	 * Creates the rss file.
	 *
	 * @param videoList the video list
	 * @param type the type
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public void createRssFile(List<Video> videoList, String type) throws IOException, PortalException, SystemException {
		Log LOG = LogFactoryUtil.getLog(RSSManager.class.getName());
		try {
			String imageLink = PropsUtil.get("lecture2go.web.home") + PropsUtil.get("lecture2go.theme.root.path") + "/" + "images" + "/" + "l2go" + "/" + "itunesu" + "/" + "logo.jpg";

			Date date = new Date();
			String[] dateString = date.toString().split(" ");
			String pubDate = dateString[0] + " , " + dateString[2] + " " + dateString[1] + " " + dateString[5] + " " + dateString[3] + " +2000";

			File imageF = new File(PropsUtil.get("lecture2go.web.home")+"/lecture2go-portlet/img/l2go_logo_transp.png");
			if (imageF.isFile()) imageLink = PropsUtil.get("lecture2go.web.home")+"/lecture2go-portlet/img/l2go_logo_transp.png";

			String text = "<?xml version='1.0' encoding='ISO-8859-1'?> \n";
			text += "<rss xmlns:itunes='http://www.itunes.com/dtds/podcast-1.0.dtd' xmlns:itunesu='http://www.itunesu.com/feed' version='2.0'>  \n";
			text += "<channel> \n";
			text += "<title>" + title + "</title> \n";
			text += "<link>" + PropsUtil.get("lecture2go.web.home") + "</link> \n";
			text += "<description>" + description + "</description> \n";
			text += "<language>" + language + "</language> \n";
			// here iTunes tags
			text += "<copyright>&#x2117; &amp; &#xA9; 2010 University of Hamburg Lecture2Go</copyright> \n";
			text += "<itunes:author>University of Hamburg - Lecture2Go</itunes:author> \n";
			text += "<itunes:summary>The University of Hamburg offers a steadily growing portion of its lectures online and similar to a take-away. For further information and more video lectures visit the central media platform of the University of Hamburg at http://lecture2go.uni-hamburg.de!</itunes:summary> \n";
			text += "<itunes:image href='" + imageLink + "' /> \n";
			// here iTunes tags end
			text += "<pubDate>" + pubDate + "</pubDate> \n";
			text += "<lastBuildDate>" + pubDate + "</lastBuildDate> \n";
			text += "<image> \n";
			text += "<title>" + imageTitle + "</title> \n";
			text += "<link>" + imageLink + "</link> \n";
			text += "<url>" + PropsUtil.get("lecture2go.web.home")+"/lecture2go-portlet/img/l2go_logo_transp.png" + "</url> \n";
			text += "</image> \n \n";

			try {
				// add item to the feed
				ListIterator<Video> it = videoList.listIterator();
				while (it.hasNext()) {
					String link = null;
					Video v = VideoLocalServiceUtil.getFullVideo(it.next().getVideoId());//gets the full object
					Host objectHost = HostLocalServiceUtil.getHost(v.getHostId());
					Producer objectProducer = ProducerLocalServiceUtil.getProducer(v.getProducerId());

					link = PropsUtil.get("lecture2go.web.home")+"/l2go/-/get/v/"+v.getVideoId();

					String title = v.getTitle().trim();

					title = stringToIsoString(title);

					title = title.replace("<", "&lt;");
					title = title.replace(">", "&gt;");
					title = title.replace("&", "&amp;");
					title = title.replace("\"", "&quot;");
					title = title.replace("'", "&apos;");
					title = title.replace("?", "-");

					String d = parseGMTDate(v.getDate());
					String duration = "";

					try {
						duration = v.getDuration().split(":")[0] + ":" + v.getDuration().split(":")[1] + ":" + v.getDuration().split(":")[2].split(".")[0];
					} catch (Exception e) {
						duration = "";
					}

					text += "<item>\n";
					text += "<title>" + title + "</title>\n";

					// TODO here iTunes tags
					String creator = "";	
					creator = stringToIsoString(creator);

					text += "<itunes:author>" + creator + "</itunes:author> \n";
					text += "<itunes:summary>" + link + "</itunes:summary> \n";
					text += "<itunes:duration>" + duration + "</itunes:duration> \n";
					text += "<itunes:image>" + imageLink + "</itunes:image> \n";
					// here iTunes tags end

					text += "<link>" + link + "</link>\n";
					if (v.getDownloadLink()==1) {
						for (String mf : FileManager.MEDIA_FORMATS) {
							String mfFile = PropsUtil.get("lecture2go.media.repository") + "/" + objectHost.getServerRoot() + "/" + objectProducer.getHomeDir() + "/" + v.getPreffix() +"."+ mf;
							File mfM = new File(mfFile);
							if (mfM.isFile() && type.equals("mp4")) text += "<enclosure url='" + PropsUtil.get("lecture2go.downloadserver.web.root")+"/"+PropsUtil.get("lecture2go.symboliclinks.repository.name")+"/"+v.getPreffix() + ".mp4' type='video/mp4'/>\n";
							if (mfM.isFile() && type.equals("mp3")) text += "<enclosure url='" + PropsUtil.get("lecture2go.downloadserver.web.root")+"/"+PropsUtil.get("lecture2go.symboliclinks.repository.name")+"/"+v.getPreffix() + ".mp3' type='video/mp3'/>\n";
							if (mfM.isFile() && type.equals("m4a")) text += "<enclosure url='" + PropsUtil.get("lecture2go.downloadserver.web.root")+"/"+PropsUtil.get("lecture2go.symboliclinks.repository.name")+"/"+v.getPreffix() + ".m4a' type='video/m4a'/>\n";
							if (mfM.isFile() && type.equals("m4v")) text += "<enclosure url='" + PropsUtil.get("lecture2go.downloadserver.web.root")+"/"+PropsUtil.get("lecture2go.symboliclinks.repository.name")+"/"+v.getPreffix() + ".m4v' type='video/m4v'/>\n";
							if (mfM.isFile() && type.equals("ogg")) text += "<enclosure url='" + PropsUtil.get("lecture2go.downloadserver.web.root")+"/"+PropsUtil.get("lecture2go.symboliclinks.repository.name")+"/"+v.getPreffix() + ".ogg' type='video/ogg'/>\n";
							if (mfM.isFile() && type.equals("webm")) text += "<enclosure url='" + PropsUtil.get("lecture2go.downloadserver.web.root")+"/"+PropsUtil.get("lecture2go.symboliclinks.repository.name")+"/"+v.getPreffix() + ".webm' type='video/webm'/>\n";
							if (mfM.isFile() && type.equals("flv")) text += "<enclosure url='" + PropsUtil.get("lecture2go.downloadserver.web.root")+"/"+PropsUtil.get("lecture2go.symboliclinks.repository.name")+"/"+v.getPreffix() + ".flv' type='video/flv'/>\n";
							if (mfM.isFile() && type.equals("pdf")) text += "<enclosure url='" + PropsUtil.get("lecture2go.downloadserver.web.root")+"/"+PropsUtil.get("lecture2go.symboliclinks.repository.name")+"/"+v.getPreffix() + ".pdf' type='video/pdf'/>\n";
						}
					}
					text += "<pubDate>" + d + "</pubDate>\n";
					text += "<guid>" + link + "</guid>\n";
					text += "</item>\n\n";
				}
			} catch (NullPointerException npe) {
			}

			text += "</channel>\n";
			text += "</rss> \n";
			
			File rrsDirectory = new File(System.getProperty("catalina.base") + "/" + "webapps" + "/" + "rss" + "/" );
			if(!rrsDirectory.exists())rrsDirectory.mkdir();
			
			String dateiName = rrsDirectory + "/" + rssFilename;
			FileOutputStream schreibeStrom = new FileOutputStream(dateiName);

			for (int i = 0; i < text.length(); i++) {
				schreibeStrom.write((byte) text.charAt(i));
			}
			schreibeStrom.close();
		} catch (NullPointerException npe) {
			LOG.error("RSS FAILED !");
		}
	}

	/**
	 * String to iso string.
	 *
	 * @param text the text
	 * @return the string
	 */
	private String stringToIsoString(String text) {
		try {
			// Wandelt den Text in ein ISO byte-Array
			byte[] encoded = text.getBytes("ISO-8859-1");

			// Wandelt das byte-Array in einen String
			text = "";
			for (int i = 0; i < encoded.length; i++) {
				text = text + (char) toUnsignedInt(encoded[i]);
			}

			return text;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * To unsigned int.
	 *
	 * @param value the value
	 * @return the int
	 */
	private int toUnsignedInt(byte value) {
		return (value & 0x7F) + (value < 0 ? 128 : 0);
	}

	/**
	 * Encode.
	 *
	 * @param text the text
	 * @param encType the enc type
	 * @return the string
	 */
	public String encode(String text, String encType) {
		String ret = null;
		try {
			String str = text;
			// Copy the contents of the String to a byte array using the ASCII
			// encoding.
			byte[] arr = str.getBytes(encType);
			// Create a new String using the contents of the byte array.
			String newStr = new String(arr);
			ret = newStr;
		} catch (Exception ex) {
		}
		return ret;
	}

	/**
	 * Parses the gmt date.
	 *
	 * @param l2goDate the l2go date
	 * @return the string
	 */
	public String parseGMTDate(String l2goDate) {

		Date ret = null;
		java.text.SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy - HH:mm");
		java.util.Calendar cal = Calendar.getInstance(new SimpleTimeZone(0, "GTM"));
		format.setCalendar(cal);
		try {
			ret = format.parse(l2goDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
			ret = null;
		}
		String[] dt = ret.toString().split(" ");
		String s = dt[0] + ", " + dt[2] + " " + dt[1] + " " + dt[5] + " " + dt[3] + " +0200";
		return s;
	}

	/** The rss filename. */
	private String rssFilename = "";

	/**
	 * Gets the rss filename.
	 *
	 * @return the rss filename
	 */
	public String getRssFilename() {
		return rssFilename;
	}

	/**
	 * Sets the rss filename.
	 *
	 * @param rssFilename the new rss filename
	 */
	public void setRssFilename(String rssFilename) {
		this.rssFilename = rssFilename;
	}

	/** The rss inhalt. */
	private String rssInhalt = "";

	/**
	 * Gets the rss inhalt.
	 *
	 * @return the rss inhalt
	 */
	public String getRssInhalt() {
		return rssInhalt;
	}

	/**
	 * Checks if is konferenz video.
	 *
	 * @param id the id
	 * @return true, if is konferenz video
	 */
	public boolean isKonferenzVideo(Long videoId) {
		boolean retur = false;
		List<Video_Institution> vi = Video_InstitutionLocalServiceUtil.getByVideo(videoId);
		ListIterator<Video_Institution> le = vi.listIterator();
		while (le.hasNext()) {
			Institution inst = new InstitutionImpl();
			try {
				inst = InstitutionLocalServiceUtil.getInstitution(le.next().getInstitutionId());
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
			if (inst.getTyp().equals("tree2")) retur = true;
		}
		return retur;
	}

	/**
	 * Sets the rss inhalt.
	 *
	 * @param rssInhalt the new rss inhalt
	 */
	public void setRssInhalt(String rssInhalt) {
		this.rssInhalt = rssInhalt;
	}

	/**
	 * Instantiates a new rSS manager.
	 */
	public RSSManager() {
		//
	}

}

