package de.uhh.l2g.plugins.migration.mapper;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;

import de.uhh.l2g.plugins.migration.model.LegacyAddress;

public class AddressMapper {

	public static Address mapAddress(Address address, LegacyAddress legacyAddress, User user, long companyId, Contact contact) {
        address.setUserId(user.getUserId());
        address.setUserName(user.getFullName());
        address.setStreet1(legacyAddress.getStreet1());
        address.setStreet2(legacyAddress.getStreet2());
        address.setStreet3(legacyAddress.getStreet3());
        address.setZip(legacyAddress.getZip());
        address.setCity(legacyAddress.getCity());
        address.setCountryId(legacyAddress.getCountryId());
        address.setCreateDate(legacyAddress.getCreateDate());
        address.setModifiedDate(legacyAddress.getModifiedDate());
        address.setClassNameId(ClassNameLocalServiceUtil.getClassNameId(Contact.class));
        address.setClassPK(contact.getContactId());
        address.setCompanyId(companyId);
		return address;
	}

}
