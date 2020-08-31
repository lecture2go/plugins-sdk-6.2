package de.uhh.l2g.plugins.util;

import java.io.UnsupportedEncodingException;

import com.josephoconnell.html.HTMLInputFilter;

/**
 * The Class HtmlManager.
 */
public class HtmlManager {

	/** The html. */
	private String html = "";

	/**
	 * Gets the html.
	 *
	 * @return the html
	 */
	public String getHtml() {
		return html;
	}

	/**
	 * Sets the html.
	 *
	 * @param html the new html
	 */
	public void setHtml(String html) {
		this.html = html;
	}
	
	/**
	 * Prepare html for wyswyg editor.
	 *
	 * @param html the html
	 * @return the string
	 */
	public static String prepareHtmlForWyswygEditor(String html){
		try{
			// Remove tab
			html = html.replace("\t", "");
	        // Remove line break (Unix)
			html = html.replace("\n", "");
	        // Line break / carriage return remove (Windows)
			html = html.replace("\r", "");
			 // introduction of characters replace
			html = html.replace("\'", "\""); 			
		}catch(NullPointerException npe){}
		
		return html;
	}
	
	/**
	 * Clean html tags.
	 *
	 * @param html the html
	 * @return the string
	 */
	public static String cleanHtmlTags(String html){
		// retrieve input from user
		String clean = "";
		try {
			clean = new HTMLInputFilter().filter( html );
		}catch (Exception e){
			clean = "Error!";
		}
		return clean;
	}
	
	/**
	 * Checks if is o88591to ut f8.
	 *
	 * @param text the text
	 * @return the string
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public static String ISO88591toUTF8(String text) throws UnsupportedEncodingException{
		return new String(text.getBytes("ISO-8859-1"),"UTF-8");
	}
}
