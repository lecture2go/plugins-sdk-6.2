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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.model.Producer;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;


public class RepositoryManager {
	
	//get runtime
	/** The run cmd. */
	static Runtime runCmd = Runtime.getRuntime();
	
	/**
	 * Creates the folder.
	 *
	 * @param path the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void createForlder(String path) throws IOException{
		File folder = new File(path);
		if(folder.mkdirs()){
			String[] cmdArray = {PropsUtil.get("lecture2go.shell.bin"), "-cr", "chown nobody " + folder.getAbsolutePath() };
			runCmd.exec(cmdArray);
			String[] cmdArray1 = { PropsUtil.get("lecture2go.shell.bin"), "-cr", "chown nobody:nobody " + folder.getAbsolutePath() };
			runCmd.exec(cmdArray1);
			String[] cmdArray2 = { PropsUtil.get("lecture2go.shell.bin"), "-cr", "chmod 701 " + folder.getAbsolutePath() };
			runCmd.exec(cmdArray2);
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
			createForlder(PropsUtil.get("lecture2go.media.repository")); //media repository 
			createForlder(PropsUtil.get("lecture2go.images.system.path")); //image subfolder
			createForlder(PropsUtil.get("lecture2go.media.repository")+"/abo"); //abo
			//createForlder(PropsUtil.get("lecture2go.media.repository")+"/chapters"); //chapters?
			createForlder(PropsUtil.get("lecture2go.security.folder")); //security
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
	 * Creates vhosts according to database.
	 *
	 * @param host
	 * @param producer
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void createVHosts(long groupId) throws IOException{
		List<Host> hosts;

		//create httpstreaming.video.repository i.e. default folder
		createForlder(PropsUtil.get("lecture2go.httpstreaming.video.repository"));
		
		//retrieving hosts should only fail if default Host has not been generated yet
		try {
			hosts = HostLocalServiceUtil.getByGroupId(groupId);
		
			//then directories
			for (Host h : hosts) {
				//test if producers exist, before writing directory
				if ( ProducerLocalServiceUtil.getProducersByHostIdCount(h.getHostId()) > 0) {
					
					List<Producer> producers = ProducerLocalServiceUtil.getProducersByHostId(h.getHostId());
					//create host
					createForlder(PropsUtil.get("lecture2go.media.repository")+"/"+h.getServerRoot());
					//and user directories 
					for (Producer p : producers) {
						createForlder(PropsUtil.get("lecture2go.media.repository")+"/"+h.getServerRoot()+"/"+p.getHomeDir());
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
	
	

}