package de.uhh.l2g.plugins.servlets.oai;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dspace.xoai.dataprovider.model.Item;
import org.dspace.xoai.dataprovider.model.Set;
import org.dspace.xoai.model.oaipmh.About;
import org.dspace.xoai.model.xoai.Element;
import org.dspace.xoai.model.xoai.XOAIMetadata;
import com.google.common.base.Function;
import com.lyncode.builder.ListBuilder;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

public class L2GoItem implements Item {

	public L2GoItem() {
		// TODO Auto-generated constructor stub
	}
	
    private Map<String, Object> values = new HashMap<String, Object>();
	
    public L2GoItem with(String name, Object value) {
        values.put(name, value);
        return this;
    }

	@Override
	public Date getDatestamp() {
		return (Date) values.get("datestamp");
	}

	@Override
	public String getIdentifier() {
		// TODO change video id as identifier to URL
		return (String) values.get("identifier");
	}

	@Override
	public List<Set> getSets() {
		// TODO Auto-generated method stub
        List<String> list = ((List<String>) values.get("sets"));
        return new ListBuilder<String>().add(list.toArray(new String[list.size()])).build(new Function<String, org.dspace.xoai.dataprovider.model.Set>() {
            @Override
            public org.dspace.xoai.dataprovider.model.Set apply(String elem) {
                return new org.dspace.xoai.dataprovider.model.Set(elem);
            }
        });
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
        return (Boolean) values.get("deleted");
	}

	@Override
	public List<About> getAbout() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public org.dspace.xoai.model.oaipmh.Metadata getMetadata() {
		Long videoId = Long.parseLong(getIdentifier());

		Video v = new VideoImpl();
		try {
			v = VideoLocalServiceUtil.getVideo(videoId);
		} catch (Exception e) {
			//throw new IdDoesNotExistException();
		}

		try {
			
			// Title
			String title = v.getTitle();
			this.with("title", title);


			// Creators
			List<Creator> creators = CreatorLocalServiceUtil.getCreatorsByVideoId(v.getVideoId());
			for (Creator c: creators) {
				c.getFullName();
			}
			
			// GenerationData
			// todo - transform to year
			// parse generation date
			SimpleDateFormat parseFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
			Date generationDate = parseFormat.parse(v.getGenerationDate());
			
			// format generation date
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String generationDateString = format.format(generationDate);

			this.with("generationDate", generationDateString);
		
			// ResourceType
			String containerFormat = v.getContainerFormat();
			this.with("containerFormat", containerFormat);
			
			
			// Contributor 
			// todo
			
			// Language
			Metadata metadata = MetadataLocalServiceUtil.getMetadata(v.getMetadataId());
			String language = metadata.getLanguage();
			this.with("language", language);

			
			// Size
			// todo - transform
			String duration = v.getDuration();
			this.with("duration", duration);
			
			// Rights
			License license = LicenseLocalServiceUtil.getLicense(v.getLicenseId());
			String rights = license.getFullName();
			this.with("rights", rights);

			
		} catch (Exception e) {
			// TODO: exception handling -> no video with id
		}
        return new org.dspace.xoai.model.oaipmh.Metadata(toMetadata());
		/*
		XOAIMetadata builder = new XOAIMetadata();
		Element titleElement = new Element("title");
		titleElement.withField("title", "test");
		builder.withElement(titleElement);
		return new org.dspace.xoai.model.oaipmh.Metadata(builder);
		*/
	}
	
	private XOAIMetadata toMetadata() {
        XOAIMetadata builder = new XOAIMetadata();
        for (String key : values.keySet()) {
            Element elementBuilder = new Element(key);
            Object value = values.get(key);
            if (value instanceof String)
                elementBuilder.withField(key, (String) value);
            else if (value instanceof Date)
                elementBuilder.withField(key, ((Date) value).toString());
            else if (value instanceof List) {
                List<String> obj = (List<String>) value;
                int i = 1;
                for (String e : obj)
                    elementBuilder.withField(key + (i++), e);
            }
            builder.withElement(elementBuilder);
        }
        return builder;
    }
	
/*
	@Override
	public org.dspace.xoai.model.oaipmh.Metadata getMetadata() {
        XOAIMetadata builder = new XOAIMetadata();
		try {
			Video v = VideoLocalServiceUtil.getVideo(1);
			
			// Identifier
			
			// Title
			String title = v.getTitle();
			Element titleElement = new Element("title");
			titleElement.withField("title", title);
			builder.withElement(titleElement);
           
			// Creators
			List<Creator> creators = CreatorLocalServiceUtil.getCreatorsByVideoId(v.getVideoId());

			for (Creator c: creators) {
				builder.withElement(new Element("creator")
						.withElement(new Element("fullName").withField("fullName", c.getFullName()))
						.withElement(new Element("firstName").withField("firstName", c.getFirstName()))
						.withElement(new Element("lastName").withField("lastName", c.getLastName()))
						);
			}
			/*
				Element creatorElement = new Element("creator");
				Element creatorFullName = new Element("fullName");
				Element creatorElement = new Element ("jobTitle");
				Element creatorFirstName = new Element ("firstName");
				Element creatorMiddleName = new Element ("middleName");
				Element creatorLastName = new Element ("lastName");
				
				creatorElement.withElement(creatorFullName.withField("fullName", c.getFullName()));
				creatorElement.withElement(creatorElement.withField("jobTitle", c.getJobTitle()));
				creatorElement.withElement(creatorLastName).withElement()

				titleElement.withField("", title);

				Element creatorNameElement
				c.getFullName();        	
				builder.withElement(creatorElement);

			}
			*/

	/*
			
			// PublicationYear
			// todo - transform to year
			String publicationYear = v.getGenerationDate();
		
			// ResourceType
			String resourceType = "";
			if (v.getContainerFormat() == "mp4") {
				resourceType = "Audiovisual";
			}
			if (v.getContainerFormat() == "mp3") {
				resourceType = "Sound";
			}
			
			// Contributor 
			// todo
			
			// Date
			// todo - transform to YYYY-MM-DD or similar
			v.getGenerationDate();
			
			// Language
			Metadata metadata = MetadataLocalServiceUtil.getMetadata(v.getMetadataId());
			String language = metadata.getLanguage();
			
			// Size
			// todo - transform
			String size = v.getDuration();
			
			// Rights
			License license = LicenseLocalServiceUtil.getLicense(v.getLicenseId());
			String Rights = license.getFullName();
			
		// TODO Auto-generated method stub
		return null;
	}
		*/
		/*
	private Element getTitleElement() {
		// <titles>
		Element titlesElement = new Element("titles");
		// <title>
		Element titleElement = new Element("title");
		//titleElement.withField("title", title);
		// </title>
		titlesElement.withElement(titleElement);
	    //builder.withElement(titlesElement);
	    // </titles>
		return null;
	}
	*/
	
    public L2GoItem withDefaults() {
        this
                .with("identifier", "lecture2go.uni-hamburg.de/123")
                .with("datestamp", new Date())
                .with("sets", new ListBuilder<String>().add(randomAlphabetic(3)).build())
                .with("deleted", false);
        return this;
    }

}
