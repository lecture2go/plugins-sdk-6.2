/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package de.uhh.l2g.plugins.model.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;


/**
 * The extended model implementation for the Metadata service. Represents a row in the &quot;LG_Metadata&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.model.Metadata} interface.
 * </p>
 *
 * @author Iavor Sturm
 */
public class MetadataImpl extends MetadataBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a metadata model instance should use the {@link de.uhh.l2g.plugins.model.Metadata} interface instead.
	 */
	public MetadataImpl() {
	}
	
	
	
	@Override
	public String getDescription() {
		return makeDescriptionMoreAccessible(super.getDescription());
	}
	
	/**
	 * Makes the description more accessible by replacing, adding and removing certain html tags
	 * @param description the unfiltered description from the database
	 * @return the cleaned description with better html syntax to be more accessible
	 */
	private String makeDescriptionMoreAccessible(String description) {
		Document doc = Jsoup.parseBodyFragment(description);
		
		// replace italic (<i>) with <em> tag
		Elements italicElements = doc.select("i");
		italicElements.tagName("em");
		
		// replace all header elements with <p> in conjunction with <strong> tags, as headers are not allowed in the editor but may be pasted
		Elements headerElements = doc.select("h1, h2, h3, h4, h5, h6");
		headerElements.tagName("strong");
		headerElements.wrap("<p></p>");
		
		// replace all <div> elements with <p> to not remove line breaks
		Elements divElements = doc.select("div");
		divElements.tagName("p");
		
		// Clean the html - the whitelist restricts the html to the same elements as the WYSIWYG-editor
		Whitelist whitelist = Whitelist.none();
		whitelist.addTags("a", "p", "strong", "em", "strike", "ul", "ol", "li", "br", "img");
		whitelist.addAttributes("a", "href", "target", "title");
		whitelist.addProtocols("a", "href", "http", "https", "mailto");
		whitelist.addAttributes("img", "align", "alt", "height", "src", "title", "width");
		whitelist.addProtocols("img", "src", "http", "https", "/");
		whitelist.preserveRelativeLinks(true);
		// the placeholder url is necessary to allow for relative linking
		String accessibleDescription = Jsoup.clean(doc.body().html(),  "http://example.com/", whitelist);

		/* Now it gets a bit complicated. Descriptions with nodes which are not part of an element (text only nodes) will be conveyed into a paragraph tag
		 * until the next grouping element is reached, which is <p>, <ul>, <ol>, whereas phrasing content like <a>, <strong> and others should be included 
		 * in the paragraph
		 */
		List<TextNode> textNodes = doc.body().textNodes();
		// empty text nodes may be returned, so to a manual check if "real" text nodes exist
		boolean hasTextNodes = false;
		for (TextNode textNode: textNodes) {
			if (!textNode.text().trim().isEmpty()) {
				hasTextNodes = true;
			}
		}
		
		if (hasTextNodes) {
			// use the already cleaned html code as starting point
			doc = Jsoup.parseBodyFragment(accessibleDescription);

			// the grouping elements
			String[] groupingElements = new String[] {"p","ul","ol"};
			
			List<Node> nodes = doc.body().childNodesCopy();

			// we rebuild the entire html structure from scratch, so remove old nodes
	        doc.body().empty();
			
			boolean isParagraphCurrentlyComposing = false;
			Element paragraphElement = null;
	        for ( Node node : nodes ) {
	    		if ((node instanceof Element) && (!isParagraphCurrentlyComposing)) {
	    			// node is element and no paragraph is currently composing -> add it as a child to the body
        			doc.body().appendChild(node);
	        	}
	    		if ((node instanceof TextNode) && (!isParagraphCurrentlyComposing)) {
	    			if (!((TextNode) node).text().trim().isEmpty()) {
	    				// is text node and no paragraph is currently composing -> create new paragraph-element
	        			paragraphElement = new Element(Tag.valueOf("p"), "");
	            		isParagraphCurrentlyComposing = true;
	    			}
	        	}
	    		if (isParagraphCurrentlyComposing) {
	            	if (node instanceof Element) {
	                	// is Element and paragraph is currently composing
	            		Element element = (Element) node;
	            		// check if element is a grouping element
	            		if (!Arrays.asList(groupingElements).contains(element.tagName())) {
	                    	// Element is not a grouping element -> add as child to the paragraph which is currently composed
	            			paragraphElement.appendChild(element);
	            		} else {
	            			// Element is a grouping element, so we end the composing of the current paragraph 
	            			// and add the composed paragraph to the body as well as the current paragraph
	            			doc.body().appendChild(paragraphElement);
	            			doc.body().appendChild(node);
	            			isParagraphCurrentlyComposing = false;
	            		}
	            	} else if (node instanceof TextNode) {
	            		// is text node and a paragraph is currently composing  -> add to paragraph-element
	            		paragraphElement.append(node.toString());
	            	}
	    		}
	        }
	        // close paragraph is there is still one composing after all nodes are traversed
	        if (isParagraphCurrentlyComposing) {
				doc.body().appendChild(paragraphElement);
	        }

	        accessibleDescription = doc.body().html();
		}
		
		return accessibleDescription;
	}
}