package de.uhh.l2g.plugins.servlets.oai;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.dspace.xoai.dataprovider.DataProvider;
import org.dspace.xoai.dataprovider.exceptions.OAIException;
import org.dspace.xoai.dataprovider.handlers.IdentifyHandler.XOAIDescription;
import org.dspace.xoai.dataprovider.model.Context;
import org.dspace.xoai.dataprovider.model.MetadataFormat;
import org.dspace.xoai.dataprovider.parameters.OAIRequest;
import org.dspace.xoai.dataprovider.repository.InMemoryItemRepository;
import org.dspace.xoai.dataprovider.repository.Repository;
import org.dspace.xoai.dataprovider.repository.RepositoryConfiguration;
import org.dspace.xoai.model.oaipmh.DeletedRecord;
import org.dspace.xoai.model.oaipmh.Description;
import org.dspace.xoai.model.oaipmh.Granularity;
import org.dspace.xoai.model.oaipmh.OAIPMH;
import org.dspace.xoai.services.impl.UTCDateProvider;
import org.dspace.xoai.xml.XmlWriter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.lyncode.xml.exceptions.XmlWriteException;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.service.CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.LicenseLocalServiceUtil;
import de.uhh.l2g.plugins.service.MetadataLocalServiceUtil;
import de.uhh.l2g.plugins.service.OaiRecordLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

/**
 * Servlet implementation class TestServlet
 */
public class OaiPmhDataProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OaiPmhDataProvider() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/xml;charset=UTF-8");
		
		// repository
		
		// retrieve earliest datestamp
		Date earliestDatestamp = OaiRecordLocalServiceUtil.getEarliestDatestamp();
		if (earliestDatestamp == null) {
			// set to 1970 if no earliest datestamp can be obtained from the OaiRecords
			earliestDatestamp = new Date(0L);
		}
		
		// set the optional oai-identifier-description
		OaiIdentifierDescription oaiIdentifierDescription = new OaiIdentifierDescription()
				.withRepositoryIdentifier(PropsUtil.get("lecture2go.oaipmh.identifier"))
				.withDelimiter(":");
		
		String descriptionString = "";
		try {
			descriptionString = XmlWriter.toString(oaiIdentifierDescription);
		} catch (Exception e) {
			// there is a problem creating an xml encoded string for the oai description: proceed anyway, as this is optional
		}
		
				
		RepositoryConfiguration repositoryConfig = new RepositoryConfiguration()
				.withRepositoryName(PropsUtil.get("lecture2go.oaipmh.repositoryName"))
				.withAdminEmail(PropsUtil.get("lecture2go.oaipmh.adminEmail"))
				.withBaseUrl(PropsUtil.get("lecture2go.oaipmh.baseURL"))
				.withMaxListIdentifiers(100)
				.withMaxListRecords(100)
				.withMaxListSets(100)
				.withDeleteMethod(DeletedRecord.PERSISTENT)
				.withGranularity(Granularity.Second)
				.withEarliestDate(earliestDatestamp);
		
		if (!descriptionString.isEmpty()) {
			repositoryConfig.withDescription(descriptionString);
		}

		Repository repository = Repository.repository().withConfiguration(repositoryConfig).withItemRepository(new L2GoItemRepository());
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		try {
			// set up transformer
			//File stylesheet = new File("/Users/matthiashitzler/Documents/oai_datacite.xml");
            //StreamSource stylesource = new StreamSource(stylesheet); 

			//transformer = transformerFactory.newTransformer(stylesource);

			transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
			// define datacite metadataformat
			MetadataFormat dataCiteMetadataFormat = new MetadataFormat().withPrefix("oai_datacite")
					.withNamespace("http://schema.datacite.org/oai/oai-1.1/")
					.withSchemaLocation("http://schema.datacite.org/oai/oai-1.1/oai.xsd")
					.withTransformer(transformer);

			// define dublin core metadataformat
			MetadataFormat dublinCoreMetadataFormat = new MetadataFormat()
					.withPrefix("oai_dc")
					.withNamespace("http://www.openarchives.org/OAI/2.0/oai_dc/")
					.withSchemaLocation("http://www.openarchives.org/OAI/2.0/oai_dc.xsd")
					.withTransformer(transformer);
			
			// context
			Context context = new Context().withMetadataFormat(dataCiteMetadataFormat).withMetadataFormat(dublinCoreMetadataFormat);
			
			// init dataProvider
			DataProvider dataProvider = DataProvider.dataProvider(context, repository);
			
			// get the request parameters
			Map<String, String[]> requestParameterMap = request.getParameterMap();
			
			// translate to map consisting of a list instead of array, as the OAIRequest uses a list here
			Map<String, List<String>> map = new HashMap();
			for (Map.Entry<String, String[]> entry : requestParameterMap.entrySet()) {
				map.put(entry.getKey(), Arrays.asList(entry.getValue()));
			}
						
			// handle OAI request
			OAIRequest requestParameters = new OAIRequest(map);
				OAIPMH oaiPmh = dataProvider.handle(requestParameters);
				OutputStream outputStream = response.getOutputStream();
				XmlWriter writer = new XmlWriter(outputStream);
				oaiPmh.write(writer);
	            writer.flush();
	            writer.close();
		} catch (TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (OAIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		/*try {
			//VideoLocalServiceUtil.getVideo(22524).getTitle();
			List<Video> allOpenAccessVideos = VideoLocalServiceUtil.getByOpenAccess(1);
			long startTime = System.currentTimeMillis();

			for (Video v: allOpenAccessVideos) {
				// Identifier
				Long id = v.getVideoId();
				
				// Title
				String title = v.getTitle();
				
				// Creators
				List<Creator> creators = CreatorLocalServiceUtil.getCreatorsByVideoId(v.getVideoId());
				for (Creator c: creators) {
					c.getFullName();
				}
				
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
				
				
			}
			long endTime = System.currentTimeMillis();
			long timeElapsed = endTime - startTime;

			response.getWriter().append("done in " + timeElapsed + " ms");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
