package de.uhh.l2g.plugins.migration.mapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.uhh.l2g.plugins.model.Creator;

public class CreatorMapper {
	static final Log log = LogFactoryUtil.getLog(CreatorMapper.class); 
	public static Creator mapCreator(Creator creator, String firstName, String lastName, String middleName, String jobTitle, String gender, String fullName) {
		creator.setFirstName(firstName);
		creator.setLastName(lastName);
		creator.setMiddleName(middleName);
		creator.setJobTitle(jobTitle);
		creator.setGender(gender);
		creator.setFullName(fullName);
		return creator;
	} 

}
