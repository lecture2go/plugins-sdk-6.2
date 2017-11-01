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

import de.uhh.l2g.plugins.service.ProducerLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Iavor Sturm
 * @generated
 */
public class ProducerLocalServiceClpInvoker {
	public ProducerLocalServiceClpInvoker() {
		_methodName0 = "addProducer";

		_methodParameterTypes0 = new String[] {
				"de.uhh.l2g.plugins.model.Producer"
			};

		_methodName1 = "createProducer";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteProducer";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteProducer";

		_methodParameterTypes3 = new String[] {
				"de.uhh.l2g.plugins.model.Producer"
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

		_methodName10 = "fetchProducer";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getProducer";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getProducers";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getProducersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateProducer";

		_methodParameterTypes15 = new String[] {
				"de.uhh.l2g.plugins.model.Producer"
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
		_methodName169 = "getProducersByInstitutionId";
=======
		_methodName173 = "getProducersByInstitutionId";

		_methodParameterTypes173 = new String[] { "long" };

		_methodName174 = "getProducersByHostId";

		_methodParameterTypes174 = new String[] { "long" };

		_methodName175 = "getProducersByHostIdCount";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes175 = new String[] { "long" };

<<<<<<< HEAD
		_methodName170 = "getProducersByHostId";
=======
		_methodName176 = "getById";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes176 = new String[] { "long" };

<<<<<<< HEAD
		_methodName171 = "getProducersByHostIdCount";
=======
		_methodName177 = "getInstitutionByProducer";
>>>>>>> refs/remotes/l2go@github/master

		_methodParameterTypes177 = new String[] { "long" };

<<<<<<< HEAD
		_methodName172 = "getById";
=======
		_methodName178 = "getAllProducers";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes172 = new String[] { "long" };
=======
		_methodParameterTypes178 = new String[] { "int", "int" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName173 = "getInstitutionByProducer";
=======
		_methodName179 = "getProdUcer";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes173 = new String[] { "long" };
=======
		_methodParameterTypes179 = new String[] { "java.lang.Long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName174 = "getAllProducers";
=======
		_methodName180 = "getAllProducerIds";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes174 = new String[] { "int", "int" };
=======
		_methodParameterTypes180 = new String[] { "java.lang.Long" };
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodName175 = "getProdUcer";
=======
		_methodName181 = "getProducerIds";
>>>>>>> refs/remotes/l2go@github/master

<<<<<<< HEAD
		_methodParameterTypes175 = new String[] { "java.lang.Long" };

		_methodName176 = "getAllProducerIds";

		_methodParameterTypes176 = new String[] { "java.lang.Long" };

		_methodName177 = "getProducerIds";

		_methodParameterTypes177 = new String[] { "java.lang.Long", "int", "int" };
=======
		_methodParameterTypes181 = new String[] { "java.lang.Long", "int", "int" };
>>>>>>> refs/remotes/l2go@github/master
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ProducerLocalServiceUtil.addProducer((de.uhh.l2g.plugins.model.Producer)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ProducerLocalServiceUtil.createProducer(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ProducerLocalServiceUtil.deleteProducer(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ProducerLocalServiceUtil.deleteProducer((de.uhh.l2g.plugins.model.Producer)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ProducerLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ProducerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ProducerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ProducerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ProducerLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ProducerLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ProducerLocalServiceUtil.fetchProducer(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ProducerLocalServiceUtil.getProducer(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ProducerLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ProducerLocalServiceUtil.getProducers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ProducerLocalServiceUtil.getProducersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ProducerLocalServiceUtil.updateProducer((de.uhh.l2g.plugins.model.Producer)arguments[0]);
		}

<<<<<<< HEAD
		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
=======
		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return ProducerLocalServiceUtil.getBeanIdentifier();
		}

<<<<<<< HEAD
		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
=======
		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			ProducerLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

<<<<<<< HEAD
		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return ProducerLocalServiceUtil.getProducersByInstitutionId(((Long)arguments[0]).longValue());
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return ProducerLocalServiceUtil.getProducersByHostId(((Long)arguments[0]).longValue());
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return ProducerLocalServiceUtil.getProducersByHostIdCount(((Long)arguments[0]).longValue());
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return ProducerLocalServiceUtil.getById(((Long)arguments[0]).longValue());
		}

=======
>>>>>>> refs/remotes/l2go@github/master
		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
<<<<<<< HEAD
			return ProducerLocalServiceUtil.getInstitutionByProducer(((Long)arguments[0]).longValue());
=======
			return ProducerLocalServiceUtil.getProducersByInstitutionId(((Long)arguments[0]).longValue());
>>>>>>> refs/remotes/l2go@github/master
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
<<<<<<< HEAD
			return ProducerLocalServiceUtil.getAllProducers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
=======
			return ProducerLocalServiceUtil.getProducersByHostId(((Long)arguments[0]).longValue());
>>>>>>> refs/remotes/l2go@github/master
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
<<<<<<< HEAD
			return ProducerLocalServiceUtil.getProdUcer((java.lang.Long)arguments[0]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return ProducerLocalServiceUtil.getAllProducerIds((java.lang.Long)arguments[0]);
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
=======
			return ProducerLocalServiceUtil.getProducersByHostIdCount(((Long)arguments[0]).longValue());
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return ProducerLocalServiceUtil.getById(((Long)arguments[0]).longValue());
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return ProducerLocalServiceUtil.getInstitutionByProducer(((Long)arguments[0]).longValue());
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return ProducerLocalServiceUtil.getAllProducers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return ProducerLocalServiceUtil.getProdUcer((java.lang.Long)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return ProducerLocalServiceUtil.getAllProducerIds((java.lang.Long)arguments[0]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
>>>>>>> refs/remotes/l2go@github/master
			return ProducerLocalServiceUtil.getProducerIds((java.lang.Long)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
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
	private String _methodName169;
	private String[] _methodParameterTypes169;
	private String _methodName170;
	private String[] _methodParameterTypes170;
	private String _methodName171;
	private String[] _methodParameterTypes171;
	private String _methodName172;
	private String[] _methodParameterTypes172;
=======
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
>>>>>>> refs/remotes/l2go@github/master
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
<<<<<<< HEAD
=======
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
>>>>>>> refs/remotes/l2go@github/master
}