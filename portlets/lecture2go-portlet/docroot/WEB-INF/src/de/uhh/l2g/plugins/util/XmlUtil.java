package de.uhh.l2g.plugins.util;

import java.util.regex.Pattern;

/**
 * Provides Xml Utils 
 */
public class XmlUtil {
	
	private Pattern pattern;
	// the invalid xml (control) characters
	private String xml10pattern = "[^"
	                    + "\u0009\r\n"
	                    + "\u0020-\uD7FF"
	                    + "\uE000-\uFFFD"
	                    + "\ud800\udc00-\udbff\udfff"
	                    + "]";

	public XmlUtil() {
		// the regex pattern for removing is compiled once on initialization for performance reasons
		this.pattern = Pattern.compile(this.xml10pattern);
	}

	/**
	 * Remove invalid xml (control) characters from String
	 * @param text
	 * @return
	 */
	public String cleanInvalidXmlCharacters(String text) {
		return this.pattern.matcher(text).replaceAll("");
	}

}
