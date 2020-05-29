package de.uhh.l2g.plugins.util;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.service.ServiceContext;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;

/**
 * This scheduler deletes partial files from aborted chunked uploads
 */
public final class DeleteAbortedChunkedUploadsScheduler extends PortletScheduler implements MessageListener {

	private static final long serialVersionUID = 1L;
	private static final String chunkedUploadFileExtension = "chunk";
	
    public DeleteAbortedChunkedUploadsScheduler(){
    	super();
    	LOG = LogFactoryUtil.getLog(DeleteAbortedChunkedUploadsScheduler.class.getName());
    }
    
	public DeleteAbortedChunkedUploadsScheduler(String schedulerClassName, ServiceContext serviceContext) {
		super(DeleteAbortedChunkedUploadsScheduler.class.getName(), serviceContext);
	    this.schedulerClassName = DeleteAbortedChunkedUploadsScheduler.class.getName();
	    LOG = LogFactoryUtil.getLog(this.schedulerClassName);
	}
	
	@Override
    public void receive(Message message) throws MessageListenerException {
		//uncomment for further debug messages
		//super.receive(message);
		LOG.info("DeleteAbortedChunkedUploadsScheduler Scheduler running "+message.getValues().get(SchedulerEngine.JOB_NAME).toString()+"...");
		
		//Do Job
		try {
			DeleteAbortedChunkedUploadsScheduler.deleteAbortedChunkedUploads();
			LOG.info("DeleteAbortedChunkedUploadsScheduler Scheduler finished.");
		} catch (IOException e) {
			LOG.info("DeleteAbortedChunkedUploadsScheduler Scheduler failed.");
		}
    }	
	
	/**
	 * Deletes chunks from aborted uploads which are older than a specific threshold
	 * Checks all subfolders of the media repository for files with the ending ".chunk"
	 */
	private static void deleteAbortedChunkedUploads() throws IOException {
		Path path = Paths.get(PropsUtil.get("lecture2go.media.repository"));
		final long threshold = 24*60*60*1000; // 24 hours, do not delete files newer than that
		final long nowInMillis = new Date().getTime();

		// delete files recursively in the media repository
		Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if(!attrs.isDirectory() && FilenameUtils.isExtension(file.toString(), chunkedUploadFileExtension)){
					boolean isOlderThanThreshold = (nowInMillis - attrs.lastModifiedTime().toMillis()) > threshold;
			 		if (isOlderThanThreshold) {
			 			// double check if the file which should be deleted, is really not a file we need
			 			for (String extension: FileManager.MEDIA_FORMATS) {     
			 				if (FilenameUtils.isExtension(file.toString(), extension)) {
			 				    return FileVisitResult.CONTINUE;
			 				}
			 			}
			 				
		 				try {
				 			Files.delete(file);
			 		        LOG.info("Aborted upload chunk: " + file + " was deleted.");
			 			} catch(IOException e) {
			 		        LOG.error("Deletion of " + file + " was not possible.");
			 			}			 			
			 		}
				}
			    return FileVisitResult.CONTINUE;
			}
		});
	}

	public void start() {
        super.schedule();
        LOG.info("DeleteAbortedChunkedUploadsScheduler Scheduler start.");
	}
	
	public void stop() {
		super.unschedule();
		LOG.info("DeleteAbortedChunkedUploadsScheduler Scheduler stop.");
	}

	public void init(String schedulerClassName, ServiceContext serviceContext) {
        super.initScheduler(schedulerClassName,serviceContext);
	}

}