package de.uhh.l2g.plugins.servlets.oai;

import javax.xml.stream.XMLStreamException;

import org.dspace.xoai.xml.XSISchema;
import org.dspace.xoai.xml.XmlWritable;
import org.dspace.xoai.xml.XmlWriter;

import com.lyncode.xml.exceptions.XmlWriteException;


/**
 * This description for oai identifier (see: http://www.openarchives.org/OAI/2.0/guidelines-oai-identifier.htm) is used with the verb identify
 * and returns an xml encoded info about the oai identifier used in the repository
 */
public class OaiIdentifierDescription implements XmlWritable {
	private static final String NAMESPACE_URI = "http://www.openarchives.org/OAI/2.0/oai-identifier";
	private static final String SCHEMA_LOCATION = "http://www.openarchives.org/OAI/2.0/oai-identifier.xsd";
	
	protected String repositoryIdentifier;
	protected String delimiter;
	protected String scheme;

    public String getRepositoryIdentifier() {
        return repositoryIdentifier;
    }

    public OaiIdentifierDescription withRepositoryIdentifier(String repositoryIdentifier) {
        this.repositoryIdentifier = repositoryIdentifier;
        return this;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public OaiIdentifierDescription withDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }
    
    public String getScheme() {
        return scheme;
    }

    public OaiIdentifierDescription withScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }
    
	@Override
	public void write(XmlWriter writer) throws XmlWriteException {
		try {
			writer.writeStartElement("oai-identifier");
			
			writer.writeDefaultNamespace(NAMESPACE_URI);
            writer.writeNamespace(XSISchema.PREFIX, XSISchema.NAMESPACE_URI);
	        writer.writeAttribute(XSISchema.PREFIX, XSISchema.NAMESPACE_URI, "schemaLocation", NAMESPACE_URI + " " + SCHEMA_LOCATION);

		 	writer.writeElement("scheme", getScheme());
            writer.writeElement("repositoryIdentifier", getRepositoryIdentifier());
            writer.writeElement("delimiter", getDelimiter());
            writer.writeElement("sampleIdentifier", getScheme() +  getDelimiter() + getRepositoryIdentifier() + getDelimiter() + 123);
            writer.writeEndElement();
		} catch (XMLStreamException e) {
            throw new XmlWriteException(e);
        }
	}
}
