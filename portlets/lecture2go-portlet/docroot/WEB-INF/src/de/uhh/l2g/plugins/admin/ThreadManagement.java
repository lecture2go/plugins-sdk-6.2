package de.uhh.l2g.plugins.admin;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import de.uhh.l2g.plugins.model.Host;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.Institution_Host;
import de.uhh.l2g.plugins.service.HostLocalServiceUtil;
import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;
import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;
import de.uhh.l2g.plugins.util.PermissionManager;
import de.uhh.l2g.plugins.util.StatisticsScheduler;
import de.uhh.l2g.plugins.util.ThreadManager;

public class ThreadManagement extends MVCPortlet {


	/**Set default permissions (assumes fixed and unique role names)
	 * 
	 * @param pm - PermissionManager 
	 * @throws PortalException 
	 * @throws SystemException 
	 */
	private void setDefaultPermissions(PermissionManager pm) throws SystemException, PortalException{
		

	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

		
		StatisticsScheduler scheduler = new StatisticsScheduler(StatisticsScheduler.class.getName());
		
	/*	  try {
		    	scheduler.killAll();
		    	
			} catch (Exception e) {
				e.printStackTrace();
			} */
	 try {
	    	scheduler.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
     
	    try {
	    	scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();
		}  

	}
	
	public void init() throws PortletException{
	
		super.init();
		
		/*Drop table LG_VideoStatistics and initialize view
		 * 
		 * CREATE 
VIEW `LG_VideoStatisticView` AS
    SELECT 
        (TO_DAYS(NOW()) - TO_DAYS(`LG_Statistics`.`createDate`)) AS `videoStatisticId`,
        (SELECT 
                (CASE (TO_DAYS(NOW()) - TO_DAYS(`LG_Statistics`.`createDate`))
                        WHEN 0 THEN 'TODAY'
                        WHEN (TO_DAYS(NOW()) - TO_DAYS((NOW() - INTERVAL 1 DAY))) THEN 'DAY'
                        WHEN (TO_DAYS(NOW()) - TO_DAYS((NOW() - INTERVAL 1 WEEK))) THEN 'WEEK'
                        WHEN (TO_DAYS(NOW()) - TO_DAYS((NOW() - INTERVAL 1 MONTH))) THEN 'MONTH'
                        WHEN (TO_DAYS(NOW()) - TO_DAYS((NOW() - INTERVAL 6 MONTH))) THEN 'HALF YEAR'
                        WHEN (TO_DAYS(NOW()) - TO_DAYS((NOW() - INTERVAL 1 YEAR))) THEN 'YEAR'
                        ELSE ''
                    END)
            ) AS `intervalName`,
        MAX(`LG_Statistics`.`createDate`) AS `compareDate`,
        (SELECT 
                `s1`.`publicVideos`
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `publicVideos`,
        (SELECT 
                `s1`.`privateVideos`
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `privateVideos`,
        (SELECT 
                (`s1`.`privateVideos` + `s1`.`publicVideos`)
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `totalVideos`,
        (SELECT 
                TRUNCATE((ROUND((`s1`.`publicVideos` / (`s1`.`privateVideos` + `s1`.`publicVideos`)),
                                2) * 100),
                        0)
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `pubPercent`,
        (SELECT 
                TRUNCATE((ROUND((`s1`.`privateVideos` / (`s1`.`privateVideos` + `s1`.`publicVideos`)),
                                2) * 100),
                        0)
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `privPercent`,
        NOW() AS `createDate`,
        NOW() AS `modifiedDate`,
        (SELECT 
                COUNT(0)
            FROM
                `LG_Video`
            WHERE
                ((`LG_Video`.`openAccess` = 1)
                    AND (`LG_Video`.`filename` IS NOT NULL))) AS `currentPublic`,
        (SELECT 
                COUNT(0)
            FROM
                `LG_Video`
            WHERE
                ((`LG_Video`.`openAccess` = 0)
                    AND (`LG_Video`.`filename` IS NOT NULL))) AS `currentPrivate`,
        (SELECT 
                COUNT(0)
            FROM
                `LG_Video`
            WHERE
                ((1 = 1)
                    AND (`LG_Video`.`filename` IS NOT NULL))) AS `currentTotal`,
        (SELECT 
                TRUNCATE((ROUND((`currentPublic` / (`currentPrivate` + `currentPublic`)),
                                2) * 100),
                        0)
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `curPubPercent`,
        (SELECT 
                TRUNCATE((ROUND((`currentPrivate` / (`currentPrivate` + `currentPublic`)),
                                2) * 100),
                        0)
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `curPrivPercent`,
        (SELECT 
                (`currentPublic` - `s1`.`publicVideos`)
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `publicDiff`,
        (SELECT 
                (`currentPrivate` - `s1`.`privateVideos`)
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `privateDiff`,
        (SELECT 
                (`currentTotal` - (`s1`.`privateVideos` + `s1`.`publicVideos`))
            FROM
                `LG_Statistics` `s1`
            WHERE
                (((TO_DAYS(NOW()) - TO_DAYS(`s1`.`createDate`)) = `videoStatisticId`)
                    AND (`s1`.`createDate` = MAX(`LG_Statistics`.`createDate`)))) AS `totalDiff`
    FROM
        `LG_Statistics`
    WHERE
        (TO_DAYS(NOW()) - TO_DAYS(`LG_Statistics`.`createDate`)) IN (SELECT 
                `LG_Statistics`.`statisticsId`
            FROM
                `LG_Statistics`
            WHERE
                (`LG_Statistics`.`statisticsId` <= 366)
            ORDER BY `LG_Statistics`.`statisticsId`)
    GROUP BY (TO_DAYS(NOW()) - TO_DAYS(`LG_Statistics`.`createDate`)) DESC
    ORDER BY `LG_Statistics`.`createDate` DESC
		 */
	}
	
	public void destroy(){
		super.destroy();
		
	}
	
}

	