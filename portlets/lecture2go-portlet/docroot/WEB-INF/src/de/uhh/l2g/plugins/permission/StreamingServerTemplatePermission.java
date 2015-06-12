package de.uhh.l2g.plugins.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import de.uhh.l2g.plugins.model.StreamingServerTemplate;
import de.uhh.l2g.plugins.service.StreamingServerTemplateLocalServiceUtil;

public class StreamingServerTemplatePermission {
    public static void check(PermissionChecker permissionChecker,
            long streamingServerTemplateId, String actionId) throws PortalException,
            SystemException {

        if (!contains(permissionChecker, streamingServerTemplateId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker,
            long streamingServerTemplateId, String actionId) throws PortalException,
            SystemException {

        StreamingServerTemplate streamingServerTemplate = StreamingServerTemplateLocalServiceUtil
                .getStreamingServerTemplate(streamingServerTemplateId);

        return permissionChecker
                .hasPermission(streamingServerTemplate.getGroupId(),
                        StreamingServerTemplate.class.getName(), streamingServerTemplate.getStreamingServerTemplateId(),
                        actionId);

    }
}
