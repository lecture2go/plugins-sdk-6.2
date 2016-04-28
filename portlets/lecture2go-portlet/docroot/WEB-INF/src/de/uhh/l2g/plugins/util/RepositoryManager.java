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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ***************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.NoPropertyException;
import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;


public class RepositoryManager {
	
	private static final Log LOG = LogFactoryUtil.getLog(RepositoryManager.class.getName());
	//get runtime
	/** The run cmd. */
	static Runtime runCmd = Runtime.getRuntime();
	
    public static final String SYS_ROOT = "vh_0000";
    public static final String SYS_SERVER = "localhost";
    public static final String SYS_PROTOCOL = "http";
    public static final int SYS_PORT = 80;
	
	/**
	 * Creates the folder.
	 *
	 * @param path the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws PortalException 
	 */
	public static void createFolder(String path) throws IOException{
		File folder = new File(path);
		String shell = GetterUtil.getString(PropsUtil.get("lecture2go.shell.bin"));
		String OS = System.getProperty("os.name");
		if (!OS.startsWith("Windows")){
			if (shell == null) {
				folder.mkdirs();
				LOG.error("Shell not configured! Check paramter lecture2go.shell.bin in your portal properties");
			}
			else {
				if(folder.mkdirs()){}
					String[] cmdArray = {shell, "-cr", "chown nobody " + folder.getAbsolutePath() };
					runCmd.exec(cmdArray);
					String[] cmdArray1 = {shell, "-cr", "chown nobody:nobody " + folder.getAbsolutePath() };
					runCmd.exec(cmdArray1);
					String[] cmdArray2 =  {shell, "-cr", "chmod 701 " + folder.getAbsolutePath() };
					runCmd.exec(cmdArray2);
				}
			}
		else{
			folder.mkdirs();
			LOG.warn("Security settings not supported by operating System");
		}
		
	}
	
	/**
	 * Creates repository and folders if none is existing.
	 *
	 * @param host
	 * @param producer
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void createRepository(long groupId) throws IOException{
		File mediaRep = new File(PropsUtil.get("lecture2go.media.repository"));
		if(!mediaRep.isDirectory()){
			createFolder(PropsUtil.get("lecture2go.media.repository")); //media repository 
			createFolder(PropsUtil.get("lecture2go.images.system.path")); //image subfolder
			createFolder(PropsUtil.get("lecture2go.media.repository")+"/abo"); //abo
			//createForlder(PropsUtil.get("lecture2go.media.repository")+"/chapters"); //chapters?
			createFolder(PropsUtil.get("lecture2go.security.folder")); //security
			createVHosts(groupId);
			symlinkToImagesHome();
			symlinkToAboHome();
		}
	}
	
	
	/**
	 * Test if repository and all required subfolders exist.
	 *
	 * @return true, if successful
	 */
	public static boolean repositoryExists(){
		boolean exists = false;

		File mediaRep = new File(PropsUtil.get("lecture2go.media.repository"));
		
		File aboRep = new File(PropsUtil.get("lecture2go.media.repository")+"/abo");
		File imagesRep = new File(PropsUtil.get("lecture2go.images.system.path"));
		File securityRep = new File(PropsUtil.get("lecture2go.security.folder"));
		
		if(mediaRep.isDirectory() && aboRep.isDirectory() && imagesRep.isDirectory() && securityRep.isDirectory())exists = true;
		
		return exists;
	}
	
	/**
	 * Symlink to abo home.
	 */
	public static void symlinkToAboHome(){
		File aboFolder = new File(PropsUtil.get("lecture2go.media.repository") + "/" + "abo");
		if (aboFolder.exists()) {
			String cmd = "ln -s " + aboFolder.getAbsolutePath() + " " + System.getProperty("catalina.base") + "/" + "webapps" + "/" + "abo";
			try { runCmd.exec(cmd); } catch (IOException e) {}
		}		
	}

	/**
	 * Symlink to images home.
	 */
	public static void symlinkToImagesHome(){
		File imgFolder = new File(PropsUtil.get("lecture2go.images.system.path"));
		if (imgFolder.exists()) {
			String cmd = "ln -s " + imgFolder.getAbsolutePath() + " " + System.getProperty("catalina.base") + "/" + "webapps" + "/" + "images";
			try { runCmd.exec(cmd); } catch (IOException e) {}
		}		
	}
	
	/**
	 * Symlink to user home.
	 *
	 * @param host the host
	 * @param producer the producer
	 */
	public static void symlinkToUserHome(Host host, Producer producer){
		File folder = new File(PropsUtil.get("lecture2go.media.repository") + "/" + host.getServerRoot() + "/" + producer.getHomeDir() + "/");
		File httpFolder = new File(PropsUtil.get("lecture2go.httpstreaming.video.repository") + "/" + producer.getInstitutionId() + "l2g" + producer.getHomeDir());
		if (!httpFolder.exists()) {
			String cmd = "ln -s " + folder.getAbsolutePath() + " " + httpFolder.getAbsolutePath();
			try { runCmd.exec(cmd); } catch (IOException e) {}
		}		
	}

	/**
	 * Creates all vhosts according to database record.
	 *
	 * @param groupId - the scope of host records to be considered
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void createVHosts(long groupId) throws IOException{
		List<Host> hosts;

		//create httpstreaming.video.repository i.e. default folder
		createFolder(PropsUtil.get("lecture2go.httpstreaming.video.repository"));
		
		//retrieving hosts should only fail if default Host has not been generated yet
		try {
			hosts = HostLocalServiceUtil.getByGroupId(groupId);
		
			//then directories
			for (Host h : hosts) {
				//test if producers exist, before writing directory
				if ( ProducerLocalServiceUtil.getProducersByHostIdCount(h.getHostId()) > 0) {
					
					List<Producer> producers = ProducerLocalServiceUtil.getProducersByHostId(h.getHostId());
					//create host
					createFolder(PropsUtil.get("lecture2go.media.repository")+"/"+h.getServerRoot());
					//and user directories 
					for (Producer p : producers) {
						createFolder(PropsUtil.get("lecture2go.media.repository")+"/"+h.getServerRoot()+"/"+p.getHomeDir());
						//create symbolic link to required directory
						symlinkToUserHome(h, p);
					}
				}
		}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Prepare directory name by extending server Root prefix with id.
	 * 
	 * Does not distinguish default directory for multi site/company yet
	 * 
	 * @param hostId
	 * @return the directory name
	 */
	public static String prepareServerRoot(long hostId){
		String base = GetterUtil.getString(PropsUtil.get("lecture2go.default.serverRoot"),SYS_ROOT);
		if (base == null || base.isEmpty()) return "";
		
		String[] segs = base.split(Pattern.quote( "_" ) );

		String prefix = segs[0];
		int positions = segs[1].length();
		if (positions<1) positions = 4; //default
		
		String numbering = "";
		int id = (int) hostId;
		if (id < Math.pow(10,positions)){
			for (int i = 1; i <= positions; i++){
				numbering = numbering+String.valueOf((int)Math.floor(id/(Math.pow(10,positions-i))));
				id = (int) (id % (Math.pow(10,positions-i)));
				LOG.debug(numbering);
			}
			return prefix+"_"+numbering;
		}
		else return "";
		
	}
	
	/**
	 * Retrieve highest Folder Id from repository
	 * 
	 * @return maximum folder id
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static long getMaximumRealServerRootId() throws SystemException, PortalException{
		
		//Retrieve maximum host id (highest existing folder name must end with larger)	
		Counter hcounter = CounterLocalServiceUtil.getCounter(Host.class.getName());
		long hId =  hcounter.getCurrentId();    //directory numbering will overflow for large values...
		String curRootDir = prepareServerRoot(hId);
		if (PropsUtil.get("lecture2go.media.repository").isEmpty()){ 
			LOG.error("Portal Property lecture2go.media.repository not set. This property is required before instalation!");
			throw new NoPropertyException();
		}
		File folder = new File(PropsUtil.get("lecture2go.media.repository")+"/"+curRootDir);
		while(folder.isDirectory()){
			hId++;
			curRootDir = prepareServerRoot(hId);
			folder = new File(PropsUtil.get("lecture2go.media.repository")+"/"+curRootDir);
		}
		return hId-1;
			
	}


	
	

}
