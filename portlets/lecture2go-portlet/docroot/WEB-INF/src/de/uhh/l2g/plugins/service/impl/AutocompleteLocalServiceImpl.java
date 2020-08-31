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

package de.uhh.l2g.plugins.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.NoSuchAutocompleteException;
import de.uhh.l2g.plugins.model.Autocomplete;
import de.uhh.l2g.plugins.model.OaiRecord;
import de.uhh.l2g.plugins.service.AutocompleteLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.AutocompleteLocalServiceBaseImpl;

/**
 * The implementation of the autocomplete local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.AutocompleteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.AutocompleteLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.AutocompleteLocalServiceUtil
 */
public class AutocompleteLocalServiceImpl
	extends AutocompleteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.AutocompleteLocalServiceUtil} to access the autocomplete local service.
	 */
	
	protected static Log LOG = LogFactoryUtil.getLog(Autocomplete.class.getName());
	
	public Autocomplete addAutocomplete(Autocomplete object) {
		Long id;
		try {
			// check if there already an autocomplete entry, as we want only one entry in the database
			getSingularAutocomplete();
			LOG.info("Autocomplete already existing, update the existing one instead!");
			object = updateAutocomplete(object);
			return object;
		} catch (NoSuchAutocompleteException e) {
			// the default case: add a new autocomplete entry 
			try {
				id = counterLocalService.increment(Autocomplete.class.getName());
				object.setPrimaryKey(id);
				super.addAutocomplete(object);
				return object;
			} catch (SystemException e1) {
				LOG.error("can't add new object with id " + object.getPrimaryKey() + "!");
			}
		} catch (SystemException e) {
			LOG.error("can't update autocomplete entry");
		}
		return object;
	}
	
	public Autocomplete getSingularAutocomplete() throws NoSuchAutocompleteException, SystemException {
		List<Autocomplete> autocompletes;
		autocompletes = AutocompleteLocalServiceUtil.getAutocompletes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if (autocompletes.isEmpty()) {
			// no autocomplete record
			throw new NoSuchAutocompleteException();
		} else {
			// an autocomplete record is already existing
			return autocompletes.get(0);
		}
	}
}