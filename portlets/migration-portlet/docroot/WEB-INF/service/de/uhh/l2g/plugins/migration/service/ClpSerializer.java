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

package de.uhh.l2g.plugins.migration.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import de.uhh.l2g.plugins.migration.model.LegacyAddressClp;
import de.uhh.l2g.plugins.migration.model.LegacyContactClp;
import de.uhh.l2g.plugins.migration.model.LegacyCoordinatorClp;
import de.uhh.l2g.plugins.migration.model.LegacyFacilityClp;
import de.uhh.l2g.plugins.migration.model.LegacyFacilityHostClp;
import de.uhh.l2g.plugins.migration.model.LegacyHostClp;
import de.uhh.l2g.plugins.migration.model.LegacyL2gSysClp;
import de.uhh.l2g.plugins.migration.model.LegacyLastVideoListClp;
import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesClp;
import de.uhh.l2g.plugins.migration.model.LegacyLectureSeriesFacilityClp;
import de.uhh.l2g.plugins.migration.model.LegacyLicenseClp;
import de.uhh.l2g.plugins.migration.model.LegacyMetadataClp;
import de.uhh.l2g.plugins.migration.model.LegacyOfficeClp;
import de.uhh.l2g.plugins.migration.model.LegacyProducerClp;
import de.uhh.l2g.plugins.migration.model.LegacyProducerLectureseriesClp;
import de.uhh.l2g.plugins.migration.model.LegacySegmentClp;
import de.uhh.l2g.plugins.migration.model.LegacyUploadClp;
import de.uhh.l2g.plugins.migration.model.LegacyUserClp;
import de.uhh.l2g.plugins.migration.model.LegacyVideoClp;
import de.uhh.l2g.plugins.migration.model.LegacyVideoFacilityClp;
import de.uhh.l2g.plugins.migration.model.LegacyVideoHitlistClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author unihh
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"migration-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"migration-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "migration-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(LegacyAddressClp.class.getName())) {
			return translateInputLegacyAddress(oldModel);
		}

		if (oldModelClassName.equals(LegacyContactClp.class.getName())) {
			return translateInputLegacyContact(oldModel);
		}

		if (oldModelClassName.equals(LegacyCoordinatorClp.class.getName())) {
			return translateInputLegacyCoordinator(oldModel);
		}

		if (oldModelClassName.equals(LegacyFacilityClp.class.getName())) {
			return translateInputLegacyFacility(oldModel);
		}

		if (oldModelClassName.equals(LegacyFacilityHostClp.class.getName())) {
			return translateInputLegacyFacilityHost(oldModel);
		}

		if (oldModelClassName.equals(LegacyHostClp.class.getName())) {
			return translateInputLegacyHost(oldModel);
		}

		if (oldModelClassName.equals(LegacyL2gSysClp.class.getName())) {
			return translateInputLegacyL2gSys(oldModel);
		}

		if (oldModelClassName.equals(LegacyLastVideoListClp.class.getName())) {
			return translateInputLegacyLastVideoList(oldModel);
		}

		if (oldModelClassName.equals(LegacyLectureSeriesClp.class.getName())) {
			return translateInputLegacyLectureSeries(oldModel);
		}

		if (oldModelClassName.equals(
					LegacyLectureSeriesFacilityClp.class.getName())) {
			return translateInputLegacyLectureSeriesFacility(oldModel);
		}

		if (oldModelClassName.equals(LegacyLicenseClp.class.getName())) {
			return translateInputLegacyLicense(oldModel);
		}

		if (oldModelClassName.equals(LegacyMetadataClp.class.getName())) {
			return translateInputLegacyMetadata(oldModel);
		}

		if (oldModelClassName.equals(LegacyOfficeClp.class.getName())) {
			return translateInputLegacyOffice(oldModel);
		}

		if (oldModelClassName.equals(LegacyProducerClp.class.getName())) {
			return translateInputLegacyProducer(oldModel);
		}

		if (oldModelClassName.equals(
					LegacyProducerLectureseriesClp.class.getName())) {
			return translateInputLegacyProducerLectureseries(oldModel);
		}

		if (oldModelClassName.equals(LegacySegmentClp.class.getName())) {
			return translateInputLegacySegment(oldModel);
		}

		if (oldModelClassName.equals(LegacyUploadClp.class.getName())) {
			return translateInputLegacyUpload(oldModel);
		}

		if (oldModelClassName.equals(LegacyUserClp.class.getName())) {
			return translateInputLegacyUser(oldModel);
		}

		if (oldModelClassName.equals(LegacyVideoClp.class.getName())) {
			return translateInputLegacyVideo(oldModel);
		}

		if (oldModelClassName.equals(LegacyVideoFacilityClp.class.getName())) {
			return translateInputLegacyVideoFacility(oldModel);
		}

		if (oldModelClassName.equals(LegacyVideoHitlistClp.class.getName())) {
			return translateInputLegacyVideoHitlist(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputLegacyAddress(BaseModel<?> oldModel) {
		LegacyAddressClp oldClpModel = (LegacyAddressClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyAddressRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyContact(BaseModel<?> oldModel) {
		LegacyContactClp oldClpModel = (LegacyContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyCoordinator(BaseModel<?> oldModel) {
		LegacyCoordinatorClp oldClpModel = (LegacyCoordinatorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyCoordinatorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyFacility(BaseModel<?> oldModel) {
		LegacyFacilityClp oldClpModel = (LegacyFacilityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyFacilityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyFacilityHost(BaseModel<?> oldModel) {
		LegacyFacilityHostClp oldClpModel = (LegacyFacilityHostClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyFacilityHostRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyHost(BaseModel<?> oldModel) {
		LegacyHostClp oldClpModel = (LegacyHostClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyHostRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyL2gSys(BaseModel<?> oldModel) {
		LegacyL2gSysClp oldClpModel = (LegacyL2gSysClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyL2gSysRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyLastVideoList(
		BaseModel<?> oldModel) {
		LegacyLastVideoListClp oldClpModel = (LegacyLastVideoListClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyLastVideoListRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyLectureSeries(
		BaseModel<?> oldModel) {
		LegacyLectureSeriesClp oldClpModel = (LegacyLectureSeriesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyLectureSeriesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyLectureSeriesFacility(
		BaseModel<?> oldModel) {
		LegacyLectureSeriesFacilityClp oldClpModel = (LegacyLectureSeriesFacilityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyLectureSeriesFacilityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyLicense(BaseModel<?> oldModel) {
		LegacyLicenseClp oldClpModel = (LegacyLicenseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyLicenseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyMetadata(BaseModel<?> oldModel) {
		LegacyMetadataClp oldClpModel = (LegacyMetadataClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyMetadataRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyOffice(BaseModel<?> oldModel) {
		LegacyOfficeClp oldClpModel = (LegacyOfficeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyOfficeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyProducer(BaseModel<?> oldModel) {
		LegacyProducerClp oldClpModel = (LegacyProducerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyProducerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyProducerLectureseries(
		BaseModel<?> oldModel) {
		LegacyProducerLectureseriesClp oldClpModel = (LegacyProducerLectureseriesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyProducerLectureseriesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacySegment(BaseModel<?> oldModel) {
		LegacySegmentClp oldClpModel = (LegacySegmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacySegmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyUpload(BaseModel<?> oldModel) {
		LegacyUploadClp oldClpModel = (LegacyUploadClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyUploadRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyUser(BaseModel<?> oldModel) {
		LegacyUserClp oldClpModel = (LegacyUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyVideo(BaseModel<?> oldModel) {
		LegacyVideoClp oldClpModel = (LegacyVideoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyVideoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyVideoFacility(
		BaseModel<?> oldModel) {
		LegacyVideoFacilityClp oldClpModel = (LegacyVideoFacilityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyVideoFacilityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLegacyVideoHitlist(BaseModel<?> oldModel) {
		LegacyVideoHitlistClp oldClpModel = (LegacyVideoHitlistClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLegacyVideoHitlistRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyAddressImpl")) {
			return translateOutputLegacyAddress(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyContactImpl")) {
			return translateOutputLegacyContact(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyCoordinatorImpl")) {
			return translateOutputLegacyCoordinator(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityImpl")) {
			return translateOutputLegacyFacility(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyFacilityHostImpl")) {
			return translateOutputLegacyFacilityHost(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyHostImpl")) {
			return translateOutputLegacyHost(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyL2gSysImpl")) {
			return translateOutputLegacyL2gSys(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyLastVideoListImpl")) {
			return translateOutputLegacyLastVideoList(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesImpl")) {
			return translateOutputLegacyLectureSeries(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyLectureSeriesFacilityImpl")) {
			return translateOutputLegacyLectureSeriesFacility(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyLicenseImpl")) {
			return translateOutputLegacyLicense(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataImpl")) {
			return translateOutputLegacyMetadata(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyOfficeImpl")) {
			return translateOutputLegacyOffice(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyProducerImpl")) {
			return translateOutputLegacyProducer(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyProducerLectureseriesImpl")) {
			return translateOutputLegacyProducerLectureseries(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacySegmentImpl")) {
			return translateOutputLegacySegment(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyUploadImpl")) {
			return translateOutputLegacyUpload(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyUserImpl")) {
			return translateOutputLegacyUser(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyVideoImpl")) {
			return translateOutputLegacyVideo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyVideoFacilityImpl")) {
			return translateOutputLegacyVideoFacility(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"de.uhh.l2g.plugins.migration.model.impl.LegacyVideoHitlistImpl")) {
			return translateOutputLegacyVideoHitlist(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyAddressException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyContactException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyContactException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyCoordinatorException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityHostException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyFacilityHostException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyHostException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyHostException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyL2gSysException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyL2gSysException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyLastVideoListException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyLastVideoListException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyLectureSeriesFacilityException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyLicenseException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyLicenseException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyMetadataException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyOfficeException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyProducerException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyProducerLectureseriesException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyProducerLectureseriesException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacySegmentException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacySegmentException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyUploadException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyUploadException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyUserException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyUserException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyVideoException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyVideoFacilityException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyVideoFacilityException();
		}

		if (className.equals(
					"de.uhh.l2g.plugins.migration.NoSuchLegacyVideoHitlistException")) {
			return new de.uhh.l2g.plugins.migration.NoSuchLegacyVideoHitlistException();
		}

		return throwable;
	}

	public static Object translateOutputLegacyAddress(BaseModel<?> oldModel) {
		LegacyAddressClp newModel = new LegacyAddressClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyAddressRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyContact(BaseModel<?> oldModel) {
		LegacyContactClp newModel = new LegacyContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyContactRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyCoordinator(BaseModel<?> oldModel) {
		LegacyCoordinatorClp newModel = new LegacyCoordinatorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyCoordinatorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyFacility(BaseModel<?> oldModel) {
		LegacyFacilityClp newModel = new LegacyFacilityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyFacilityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyFacilityHost(
		BaseModel<?> oldModel) {
		LegacyFacilityHostClp newModel = new LegacyFacilityHostClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyFacilityHostRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyHost(BaseModel<?> oldModel) {
		LegacyHostClp newModel = new LegacyHostClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyHostRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyL2gSys(BaseModel<?> oldModel) {
		LegacyL2gSysClp newModel = new LegacyL2gSysClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyL2gSysRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyLastVideoList(
		BaseModel<?> oldModel) {
		LegacyLastVideoListClp newModel = new LegacyLastVideoListClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyLastVideoListRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyLectureSeries(
		BaseModel<?> oldModel) {
		LegacyLectureSeriesClp newModel = new LegacyLectureSeriesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyLectureSeriesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyLectureSeriesFacility(
		BaseModel<?> oldModel) {
		LegacyLectureSeriesFacilityClp newModel = new LegacyLectureSeriesFacilityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyLectureSeriesFacilityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyLicense(BaseModel<?> oldModel) {
		LegacyLicenseClp newModel = new LegacyLicenseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyLicenseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyMetadata(BaseModel<?> oldModel) {
		LegacyMetadataClp newModel = new LegacyMetadataClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyMetadataRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyOffice(BaseModel<?> oldModel) {
		LegacyOfficeClp newModel = new LegacyOfficeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyOfficeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyProducer(BaseModel<?> oldModel) {
		LegacyProducerClp newModel = new LegacyProducerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyProducerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyProducerLectureseries(
		BaseModel<?> oldModel) {
		LegacyProducerLectureseriesClp newModel = new LegacyProducerLectureseriesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyProducerLectureseriesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacySegment(BaseModel<?> oldModel) {
		LegacySegmentClp newModel = new LegacySegmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacySegmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyUpload(BaseModel<?> oldModel) {
		LegacyUploadClp newModel = new LegacyUploadClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyUploadRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyUser(BaseModel<?> oldModel) {
		LegacyUserClp newModel = new LegacyUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyVideo(BaseModel<?> oldModel) {
		LegacyVideoClp newModel = new LegacyVideoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyVideoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyVideoFacility(
		BaseModel<?> oldModel) {
		LegacyVideoFacilityClp newModel = new LegacyVideoFacilityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyVideoFacilityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLegacyVideoHitlist(
		BaseModel<?> oldModel) {
		LegacyVideoHitlistClp newModel = new LegacyVideoHitlistClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLegacyVideoHitlistRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}