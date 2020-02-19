package de.uhh.l2g.plugins.util;

import com.liferay.portal.kernel.util.PropsUtil;

public class FeatureManager {
	
	private static final String CITATION2GO_PROPERTY = "de.uhh.l2g.guest.video.citation2go";
	private static final String COMMSY_PROPERTY = "de.uhh.l2g.guest.video.commsy";
	private static final String SOCIALMEDIA_PROPERTY = "de.uhh.l2g.guest.video.socialmedia";
	private static final String CAPTION_INCLUDE_PROPERTY = "de.uhh.l2g.admin.captioninclude";
	private static final String CATALOG_FILTER_TERMS = "de.uhh.l2g.guest.catalog.filter.terms";
	private static final String CATALOG_FILTER_INSTITUTION = "de.uhh.l2g.guest.catalog.filter.institution";
	private static final String CATALOG_FILTER_SUBINSTITUTION = "de.uhh.l2g.guest.catalog.filter.subinstitution";
	private static final String CATALOG_FILTER_CATEGORY = "de.uhh.l2g.guest.catalog.filter.category";
	
	/**
	 * Checks if citation2go is allowed via config or not
	 * @return true if service is allowed, false if not
	 */
	public static boolean hasCitation2Go() {
		return Boolean.parseBoolean(PropsUtil.get(CITATION2GO_PROPERTY));
	}
	
	/**
	 * Checks if commsy support is allowed via config or not
	 * @return true if service is allowed, false if not
	 */
	public static boolean hasCommsy() {
		return Boolean.parseBoolean(PropsUtil.get(COMMSY_PROPERTY));
	}
	
	/**
	 * Checks if commsy support is allowed via config or not
	 * @return true if service is allowed, false if not
	 */
	public static boolean hasSocialMediaSharing() {
		return Boolean.parseBoolean(PropsUtil.get(SOCIALMEDIA_PROPERTY));
	}
	
	/**
	 * Checks if caption include is is allowed via config or not
	 * @return true if service is allowed, false if not
	 */
	public static boolean hasCaptionInclude() {
		return Boolean.parseBoolean(PropsUtil.get(CAPTION_INCLUDE_PROPERTY));
	}
	
	/**
	 * Checks if catalog term filter is allowed via config or not
	 * @return true if filter is allowed, false if not
	 */
	public static boolean hasTermsCatalogFilter() {
		return Boolean.parseBoolean(PropsUtil.get(CATALOG_FILTER_TERMS));
	}
	
	/**
	 * Checks if catalog institution filter is allowed via config or not
	 * @return true if filter is allowed, false if not
	 */
	public static boolean hasInstitutionCatalogFilter() {
		return Boolean.parseBoolean(PropsUtil.get(CATALOG_FILTER_INSTITUTION));
	}
	
	/**
	 * Checks if catalog sub institution filter is allowed via config or not
	 * @return true if filter is allowed, false if not
	 */
	public static boolean hasSubInstitutionCatalogFilter() {
		return Boolean.parseBoolean(PropsUtil.get(CATALOG_FILTER_SUBINSTITUTION));
	}
	
	/**
	 * Checks if catalog institution filter is allowed via config or not
	 * @return true if filter is allowed, false if not
	 */
	public static boolean hasCategoryCatalogFilter() {
		return Boolean.parseBoolean(PropsUtil.get(CATALOG_FILTER_CATEGORY));
	}

}