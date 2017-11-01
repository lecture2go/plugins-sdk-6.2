/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.service.base;

import de.uhh.l2g.plugins.service.Institution_HostLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class Institution_HostLocalServiceClpInvoker {
	public Institution_HostLocalServiceClpInvoker() {
		_methodName0 = "addInstitution_Host";

		_methodParameterTypes0 = new String[] {
				"de.uhh.l2g.plugins.model.Institution_Host"
			};

		_methodName1 = "createInstitution_Host";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteInstitution_Host";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteInstitution_Host";

		_methodParameterTypes3 = new String[] {
				"de.uhh.l2g.plugins.model.Institution_Host"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchInstitution_Host";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getInstitution_Host";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getInstitution_Hosts";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getInstitution_HostsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateInstitution_Host";

		_methodParameterTypes15 = new String[] {
				"de.uhh.l2g.plugins.model.Institution_Host"
			};

<<<<<<< HEAD
		_methodName162 = "getBeanIdentifier";
=======
		_methodName166 = "getBeanIdentifier";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes162 = new String[] {  };
=======
		_methodParameterTypes166 = new String[] {  };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName163 = "setBeanIdentifier";
=======
		_methodName167 = "setBeanIdentifier";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes163 = new String[] { "java.lang.String" };
=======
		_methodParameterTypes167 = new String[] { "java.lang.String" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName168 = "getByGroupId";
=======
		_methodName172 = "getByGroupId";

		_methodParameterTypes172 = new String[] { "long" };

		_methodName173 = "getByInstitutionId";

		_methodParameterTypes173 = new String[] { "long" };

		_methodName174 = "getByInstitution";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes174 = new String[] { "long" };

<<<<<<< HEAD
		_methodName169 = "getByInstitutionId";
=======
		_methodName175 = "getByGroupIdAndInstitutionId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes169 = new String[] { "long" };
=======
		_methodParameterTypes175 = new String[] { "long", "long", "long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName170 = "getByInstitution";

		_methodParameterTypes170 = new String[] { "long" };

		_methodName171 = "getByGroupIdAndInstitutionId";

		_methodParameterTypes171 = new String[] { "long", "long", "long" };

		_methodName172 = "getLinkByGroupIdAndInstitutionId";

		_methodParameterTypes172 = new String[] { "long", "long" };

		_methodName173 = "getByGroupIdAndHostId";

		_methodParameterTypes173 = new String[] { "long", "long" };

		_methodName174 = "getListByGroupIdAndHostId";

		_methodParameterTypes174 = new String[] { "long", "long" };

		_methodName175 = "getByGroupIdAndHostIdCount";
=======
		_methodName176 = "getLinkByGroupIdAndInstitutionId";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes175 = new String[] { "long", "long" };

<<<<<<< HEAD
		_methodName176 = "getListByGroupIdAndInstitutionId";
=======
		_methodName177 = "getByGroupIdAndHostId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes176 = new String[] { "long", "long", "long" };
=======
		_methodParameterTypes177 = new String[] { "long", "long" };

		_methodName178 = "getListByGroupIdAndHostId";

		_methodParameterTypes178 = new String[] { "long", "long" };

		_methodName179 = "getByGroupIdAndHostIdCount";

		_methodParameterTypes179 = new String[] { "long", "long" };

		_methodName180 = "getListByGroupIdAndInstitutionId";

		_methodParameterTypes180 = new String[] { "long", "long", "long" };

		_methodName182 = "getDefaultInstitutionHostId";

		_methodParameterTypes182 = new String[] { "long", "long" };

		_methodName183 = "addDefaultInstitutionHost";

		_methodParameterTypes183 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName178 = "getDefaultInstitutionHostId";
=======
		_methodName184 = "addEntry";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes178 = new String[] { "long", "long" };
=======
		_methodParameterTypes184 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName179 = "addDefaultInstitutionHost";
=======
		_methodName185 = "updateEntry";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes185 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName180 = "addEntry";
=======
		_methodName186 = "deleteLinkById";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes180 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName181 = "updateEntry";

		_methodParameterTypes181 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName182 = "deleteLinkById";

		_methodParameterTypes182 = new String[] {
=======
		_methodParameterTypes186 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"long", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName183 = "deleteLinkByInstitution";
=======
		_methodName187 = "deleteLinkByInstitution";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes183 = new String[] {
=======
		_methodParameterTypes187 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"de.uhh.l2g.plugins.model.Institution", "long", "long"
			};

<<<<<<< HEAD
		_methodName184 = "updateCounter";
=======
		_methodName188 = "updateCounter";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes184 = new String[] {  };
=======
		_methodParameterTypes188 = new String[] {  };
>>>>>>> refs/remotes/l2go@github/master
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return Institution_HostLocalServiceUtil.addInstitution_Host((de.uhh.l2g.plugins.model.Institution_Host)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return Institution_HostLocalServiceUtil.createInstitution_Host(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return Institution_HostLocalServiceUtil.deleteInstitution_Host(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return Institution_HostLocalServiceUtil.deleteInstitution_Host((de.uhh.l2g.plugins.model.Institution_Host)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return Institution_HostLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return Institution_HostLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return Institution_HostLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return Institution_HostLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return Institution_HostLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return Institution_HostLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return Institution_HostLocalServiceUtil.fetchInstitution_Host(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getInstitution_Host(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getInstitution_Hosts(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getInstitution_HostsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return Institution_HostLocalServiceUtil.updateInstitution_Host((de.uhh.l2g.plugins.model.Institution_Host)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
=======
		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return Institution_HostLocalServiceUtil.getBeanIdentifier();
		}

<<<<<<< HEAD
		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
=======
		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			Institution_HostLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getByInstitutionId(((Long)arguments[0]).longValue());
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getByInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getByGroupIdAndInstitutionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

=======
>>>>>>> refs/remotes/l2go@github/master
		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
<<<<<<< HEAD
			return Institution_HostLocalServiceUtil.getLinkByGroupIdAndInstitutionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
=======
			return Institution_HostLocalServiceUtil.getByGroupId(((Long)arguments[0]).longValue());
>>>>>>> refs/remotes/l2go@github/master
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
<<<<<<< HEAD
			return Institution_HostLocalServiceUtil.getByGroupIdAndHostId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
=======
			return Institution_HostLocalServiceUtil.getByInstitutionId(((Long)arguments[0]).longValue());
>>>>>>> refs/remotes/l2go@github/master
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
<<<<<<< HEAD
			return Institution_HostLocalServiceUtil.getListByGroupIdAndHostId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getByGroupIdAndHostIdCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getListByGroupIdAndInstitutionId(((Long)arguments[0]).longValue(),
=======
			return Institution_HostLocalServiceUtil.getByInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getByGroupIdAndInstitutionId(((Long)arguments[0]).longValue(),
>>>>>>> refs/remotes/l2go@github/master
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getDefaultInstitutionHostId(((Long)arguments[0]).longValue(),
=======
		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getLinkByGroupIdAndInstitutionId(((Long)arguments[0]).longValue(),
>>>>>>> refs/remotes/l2go@github/master
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
=======
		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getByGroupIdAndHostId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getListByGroupIdAndHostId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

>>>>>>> refs/remotes/l2go@github/master
		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
<<<<<<< HEAD
			return Institution_HostLocalServiceUtil.addDefaultInstitutionHost(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
=======
			return Institution_HostLocalServiceUtil.getByGroupIdAndHostIdCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
>>>>>>> refs/remotes/l2go@github/master
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
<<<<<<< HEAD
			return Institution_HostLocalServiceUtil.addEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return Institution_HostLocalServiceUtil.updateEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return Institution_HostLocalServiceUtil.deleteLinkById(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return Institution_HostLocalServiceUtil.deleteLinkByInstitution((de.uhh.l2g.plugins.model.Institution)arguments[0],
=======
			return Institution_HostLocalServiceUtil.getListByGroupIdAndInstitutionId(((Long)arguments[0]).longValue(),
>>>>>>> refs/remotes/l2go@github/master
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

<<<<<<< HEAD
		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
=======
		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return Institution_HostLocalServiceUtil.getDefaultInstitutionHostId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return Institution_HostLocalServiceUtil.addDefaultInstitutionHost(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return Institution_HostLocalServiceUtil.addEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return Institution_HostLocalServiceUtil.updateEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return Institution_HostLocalServiceUtil.deleteLinkById(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return Institution_HostLocalServiceUtil.deleteLinkByInstitution((de.uhh.l2g.plugins.model.Institution)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return Institution_HostLocalServiceUtil.updateCounter();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
<<<<<<< HEAD
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName168;
	private String[] _methodParameterTypes168;
	private String _methodName169;
	private String[] _methodParameterTypes169;
	private String _methodName170;
	private String[] _methodParameterTypes170;
	private String _methodName171;
	private String[] _methodParameterTypes171;
=======
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
>>>>>>> refs/remotes/l2go@github/master
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName173;
	private String[] _methodParameterTypes173;
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
<<<<<<< HEAD
=======
	private String _methodName185;
	private String[] _methodParameterTypes185;
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
>>>>>>> refs/remotes/l2go@github/master
}