package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.migration.model.LegacyHost;
import de.uhh.l2g.plugins.model.Host;

public class HostMapper {
	static final Log log = LogFactoryUtil.getLog(HostMapper.class);
		
	public static Host mapHost(LegacyHost legacyHost, Host host,  long groupId, long companyId) {
		if (legacyHost == null || host == null) {
			log.warn("can't execute method with null values - return host as null value");
			return null;
		}
		host.setGroupId(groupId);
		host.setCompanyId(companyId);
		host.setName(legacyHost.getName());
		host.setPort(legacyHost.getPort());
		host.setProtocol(legacyHost.getProtokoll());
		host.setServerRoot(legacyHost.getServerRoot());
		host.setStreamer(legacyHost.getStreamer());
	return host;
	}
}
