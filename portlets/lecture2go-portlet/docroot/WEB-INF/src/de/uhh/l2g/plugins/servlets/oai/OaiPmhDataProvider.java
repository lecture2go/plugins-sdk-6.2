package de.uhh.l2g.plugins.servlets.oai;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.dspace.xoai.dataprovider.DataProvider;
import org.dspace.xoai.dataprovider.exceptions.OAIException;
import org.dspace.xoai.dataprovider.model.Context;
import org.dspace.xoai.dataprovider.model.MetadataFormat;
import org.dspace.xoai.dataprovider.parameters.OAIRequest;
import org.dspace.xoai.dataprovider.repository.Repository;
import org.dspace.xoai.dataprovider.repository.RepositoryConfiguration;
import org.dspace.xoai.model.oaipmh.DeletedRecord;
import org.dspace.xoai.model.oaipmh.Granularity;
import org.dspace.xoai.model.oaipmh.OAIPMH;
import org.dspace.xoai.xml.XmlWriter;

import com.liferay.portal.kernel.util.PropsUtil;
import com.lyncode.xml.exceptions.XmlWriteException;

import de.uhh.l2g.plugins.service.OaiRecordLocalServiceUtil;

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

		Repository repository = Repository.repository().withConfiguration(repositoryConfig).withItemRepository(new L2GoItemRepository()).withSetRepository(new L2GoSetRepository());
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer dataCiteTransformer;
		Transformer dublinCoreTransformer;
		try {
			// set up datacite transformer
			InputStream dataCiteStylesheet =  getServletContext().getResourceAsStream("/WEB-INF/oai_datacite.xml");
            StreamSource dataCiteStylesource = new StreamSource(dataCiteStylesheet); 
			dataCiteTransformer = transformerFactory.newTransformer(dataCiteStylesource);
			
			// set up dublincore transformer
			InputStream dublinCoreStylesheet =  getServletContext().getResourceAsStream("/WEB-INF/oai_dublincore.xml");
            StreamSource dublinCoreStylesource = new StreamSource(dublinCoreStylesheet); 
			dublinCoreTransformer = transformerFactory.newTransformer(dublinCoreStylesource);
/*
			transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
           */ 
			// define datacite metadataformat
			MetadataFormat dataCiteMetadataFormat = new MetadataFormat().withPrefix("oai_datacite")
					.withNamespace("http://datacite.org/schema/kernel-4")
					.withSchemaLocation("http://schema.datacite.org/meta/kernel-4.2/metadata.xsd")
					.withTransformer(dataCiteTransformer);

			// define dublin core metadataformat
			MetadataFormat dublinCoreMetadataFormat = new MetadataFormat()
					.withPrefix("oai_dc")
					.withNamespace("http://www.openarchives.org/OAI/2.0/oai_dc/")
					.withSchemaLocation("http://www.openarchives.org/OAI/2.0/oai_dc.xsd")
					.withTransformer(dublinCoreTransformer);
			
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
				if (PropsUtil.contains("lecture2go.oaipmh.stylesheet")) {
					String stylesheetRelativePath = PropsUtil.get("lecture2go.oaipmh.stylesheet");
					writer.writeProcessingInstruction("xml-stylesheet type='text/xsl' href='"+stylesheetRelativePath+"'");
				}
				
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
