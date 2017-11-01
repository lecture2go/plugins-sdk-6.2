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

import de.uhh.l2g.plugins.service.InstitutionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class InstitutionLocalServiceClpInvoker {
	public InstitutionLocalServiceClpInvoker() {
		_methodName0 = "addInstitution";

		_methodParameterTypes0 = new String[] {
				"de.uhh.l2g.plugins.model.Institution"
			};

		_methodName1 = "createInstitution";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteInstitution";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteInstitution";

		_methodParameterTypes3 = new String[] {
				"de.uhh.l2g.plugins.model.Institution"
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

		_methodName10 = "fetchInstitution";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getInstitution";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getInstitutions";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getInstitutionsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateInstitution";

		_methodParameterTypes15 = new String[] {
				"de.uhh.l2g.plugins.model.Institution"
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
		_methodName168 = "getById";
=======
		_methodName172 = "getById";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes168 = new String[] { "long" };
=======
		_methodParameterTypes172 = new String[] { "long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName169 = "getByGroupId";
=======
		_methodName173 = "getByGroupId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes169 = new String[] { "long" };
=======
		_methodParameterTypes173 = new String[] { "long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName170 = "getRootInstitutionsByOpenAccessVideos";
=======
		_methodName174 = "getRootInstitutionsByOpenAccessVideos";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes170 = new String[] {  };
=======
		_methodParameterTypes174 = new String[] {  };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName171 = "getByGroupIdAndId";
=======
		_methodName175 = "getByGroupIdAndId";

		_methodParameterTypes175 = new String[] { "long", "long" };

		_methodName176 = "getRootByGroupId";

		_methodParameterTypes176 = new String[] { "long", "long" };

		_methodName177 = "getByGroupIdAndParent";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes177 = new String[] { "long", "long" };

<<<<<<< HEAD
		_methodName172 = "getRootByGroupId";
=======
		_methodName178 = "getByGroupIdAndParent";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes172 = new String[] { "long", "long" };
=======
		_methodParameterTypes178 = new String[] { "long", "long", "int", "int" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName173 = "getByGroupIdAndParent";
=======
		_methodName179 = "getByGroupIdAndParentCount";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes179 = new String[] { "long", "long" };

<<<<<<< HEAD
		_methodName174 = "getByGroupIdAndParent";
=======
		_methodName180 = "getByParentId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes174 = new String[] { "long", "long", "int", "int" };
=======
		_methodParameterTypes180 = new String[] { "long", "java.lang.String" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName175 = "getByGroupIdAndParentCount";
=======
		_methodName181 = "getRoot";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes175 = new String[] { "long", "long" };
=======
		_methodParameterTypes181 = new String[] { "long", "long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName176 = "getByParentId";
=======
		_methodName182 = "getByParentId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes176 = new String[] { "long", "java.lang.String" };
=======
		_methodParameterTypes182 = new String[] { "long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName177 = "getRoot";
=======
		_methodName183 = "getByParent";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes177 = new String[] { "long", "long" };
=======
		_methodParameterTypes183 = new String[] { "long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName178 = "getByParentId";
=======
		_methodName184 = "getByLevel";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes178 = new String[] { "long" };
=======
		_methodParameterTypes184 = new String[] { "int" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName179 = "getByParent";
=======
		_methodName185 = "getByLectureseriesId";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes185 = new String[] { "long", "int", "int" };

<<<<<<< HEAD
		_methodName180 = "getByLevel";
=======
		_methodName186 = "getAllSortedAsTree";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes180 = new String[] { "int" };
=======
		_methodParameterTypes186 = new String[] { "int", "int" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName181 = "getByLectureseriesId";
=======
		_methodName187 = "getMaxSortByParentId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes181 = new String[] { "long", "int", "int" };

		_methodName182 = "getAllSortedAsTree";

		_methodParameterTypes182 = new String[] { "int", "int" };

		_methodName183 = "getMaxSortByParentId";

		_methodParameterTypes183 = new String[] { "long" };

		_methodName184 = "getLockingElements";

		_methodParameterTypes184 = new String[] { "long" };

		_methodName185 = "getInstitutionsFromLectureseriesIdsAndVideoIds";

		_methodParameterTypes185 = new String[] {
=======
		_methodParameterTypes187 = new String[] { "long" };

		_methodName188 = "getLockingElements";

		_methodParameterTypes188 = new String[] { "long" };

		_methodName189 = "getInstitutionsFromLectureseriesIdsAndVideoIds";

		_methodParameterTypes189 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"java.util.ArrayList", "java.util.ArrayList"
			};

<<<<<<< HEAD
		_methodName186 = "getInstitutionsFromLectureseriesIdsAndVideoIds";
=======
		_methodName190 = "getInstitutionsFromLectureseriesIdsAndVideoIds";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes186 = new String[] {
=======
		_methodParameterTypes190 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"java.util.ArrayList", "java.util.ArrayList", "java.lang.Long"
			};

<<<<<<< HEAD
		_methodName193 = "getDefaultInstitutionId";
=======
		_methodName197 = "getDefaultInstitutionId";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes193 = new String[] { "long", "long" };
=======
		_methodParameterTypes197 = new String[] { "long", "long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName194 = "addDefaultInstitution";
=======
		_methodName198 = "addDefaultInstitution";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes194 = new String[] {
=======
		_methodParameterTypes198 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName195 = "addInstitution";
=======
		_methodName199 = "addInstitution";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes195 = new String[] {
=======
		_methodParameterTypes199 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"java.lang.String", "long", "long", "int",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName196 = "updateInstitution";
=======
		_methodName200 = "updateInstitution";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes196 = new String[] {
=======
		_methodParameterTypes200 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"long", "java.lang.String", "int",
				"com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName197 = "deleteInstitution";
=======
		_methodName201 = "deleteInstitution";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes197 = new String[] {
=======
		_methodParameterTypes201 = new String[] {
>>>>>>> refs/remotes/l2go@github/master
				"long", "com.liferay.portal.service.ServiceContext"
			};

<<<<<<< HEAD
		_methodName198 = "updateCounter";
=======
		_methodName202 = "updateCounter";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes198 = new String[] {  };
=======
		_methodParameterTypes202 = new String[] {  };
>>>>>>> refs/remotes/l2go@github/master
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return InstitutionLocalServiceUtil.addInstitution((de.uhh.l2g.plugins.model.Institution)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return InstitutionLocalServiceUtil.createInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return InstitutionLocalServiceUtil.deleteInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return InstitutionLocalServiceUtil.deleteInstitution((de.uhh.l2g.plugins.model.Institution)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return InstitutionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return InstitutionLocalServiceUtil.fetchInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return InstitutionLocalServiceUtil.getInstitution(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return InstitutionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return InstitutionLocalServiceUtil.getInstitutions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return InstitutionLocalServiceUtil.getInstitutionsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return InstitutionLocalServiceUtil.updateInstitution((de.uhh.l2g.plugins.model.Institution)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
=======
		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getBeanIdentifier();
		}

<<<<<<< HEAD
		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
=======
		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			InstitutionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return InstitutionLocalServiceUtil.getById(((Long)arguments[0]).longValue());
=======
		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return InstitutionLocalServiceUtil.getById(((Long)arguments[0]).longValue());
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return InstitutionLocalServiceUtil.getRootInstitutionsByOpenAccessVideos();
>>>>>>> refs/remotes/l2go@github/master
		}

<<<<<<< HEAD
		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByGroupId(((Long)arguments[0]).longValue());
=======
		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByGroupIdAndId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
>>>>>>> refs/remotes/l2go@github/master
		}

<<<<<<< HEAD
		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return InstitutionLocalServiceUtil.getRootInstitutionsByOpenAccessVideos();
=======
		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return InstitutionLocalServiceUtil.getRootByGroupId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
>>>>>>> refs/remotes/l2go@github/master
		}

<<<<<<< HEAD
		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByGroupIdAndId(((Long)arguments[0]).longValue(),
=======
		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByGroupIdAndParent(((Long)arguments[0]).longValue(),
>>>>>>> refs/remotes/l2go@github/master
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return InstitutionLocalServiceUtil.getRootByGroupId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByGroupIdAndParent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
=======
		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getByGroupIdAndParent(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

<<<<<<< HEAD
		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
=======
		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getByGroupIdAndParentCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
=======
		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getByParentId(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return InstitutionLocalServiceUtil.getRoot(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByParentId(((Long)arguments[0]).longValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
=======
		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return InstitutionLocalServiceUtil.getRoot(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return InstitutionLocalServiceUtil.getByParentId(((Long)arguments[0]).longValue());
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getByParent(((Long)arguments[0]).longValue());
		}

<<<<<<< HEAD
		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
=======
		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getByLevel(((Integer)arguments[0]).intValue());
		}

<<<<<<< HEAD
		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
=======
		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getByLectureseriesId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

<<<<<<< HEAD
		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
=======
		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getAllSortedAsTree(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

<<<<<<< HEAD
		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
=======
		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getMaxSortByParentId(((Long)arguments[0]).longValue());
		}

<<<<<<< HEAD
		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
=======
		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getLockingElements(((Long)arguments[0]).longValue());
		}

<<<<<<< HEAD
		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
=======
		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds((java.util.ArrayList<java.lang.Long>)arguments[0],
				(java.util.ArrayList<java.lang.Long>)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
=======
		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getInstitutionsFromLectureseriesIdsAndVideoIds((java.util.ArrayList<java.lang.Long>)arguments[0],
				(java.util.ArrayList<java.lang.Long>)arguments[1],
				(java.lang.Long)arguments[2]);
		}

<<<<<<< HEAD
		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
=======
		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.getDefaultInstitutionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

<<<<<<< HEAD
		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
=======
		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.addDefaultInstitution((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
=======
		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.addInstitution((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

<<<<<<< HEAD
		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
=======
		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.updateInstitution(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

<<<<<<< HEAD
		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
=======
		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.deleteInstitution(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

<<<<<<< HEAD
		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
=======
		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return InstitutionLocalServiceUtil.updateCounter();
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
	private String _methodName177;
	private String[] _methodParameterTypes177;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
	private String _methodName186;
	private String[] _methodParameterTypes186;
<<<<<<< HEAD
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName194;
	private String[] _methodParameterTypes194;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
=======
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName199;
	private String[] _methodParameterTypes199;
	private String _methodName200;
	private String[] _methodParameterTypes200;
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
>>>>>>> refs/remotes/l2go@github/master
}