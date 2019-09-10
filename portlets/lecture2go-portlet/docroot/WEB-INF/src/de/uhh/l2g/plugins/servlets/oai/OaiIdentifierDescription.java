package de.uhh.l2g.plugins.servlets.oai;

import javax.xml.stream.XMLStreamException;

import org.dspace.xoai.xml.XSISchema;
import org.dspace.xoai.xml.XmlWritable;
import org.dspace.xoai.xml.XmlWriter;

import com.lyncode.xml.exceptions.XmlWriteException;

public class OaiIdentifierDescription implements XmlWritable {
	private static final String NAMESPACE_URI = "http://www.openarchives.org/OAI/2.0/oai-identifier";

	private static final String SCHEMA_LOCATION = "http://www.openarchives.org/OAI/2.0/oai-identifier.xsd";
	
	protected String repositoryIdentifier;
	protected String delimiter;

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
    
	@Override
	public void write(XmlWriter writer) throws XmlWriteException {
		try {
			writer.writeStartElement("oai-identifier");
			
			writer.writeDefaultNamespace(NAMESPACE_URI);
            writer.writeNamespace(XSISchema.PREFIX, XSISchema.NAMESPACE_URI);
	        writer.writeAttribute(XSISchema.PREFIX, XSISchema.NAMESPACE_URI, "schemaLocation", NAMESPACE_URI + " " + SCHEMA_LOCATION);

		 	writer.writeElement("scheme", "oai");
            writer.writeElement("repositoryIdentifier", getRepositoryIdentifier());
            writer.writeElement("delimiter", getDelimiter());
            writer.writeElement("sampleIdentifier", getRepositoryIdentifier() + getDelimiter() + 123);
            writer.writeEndElement();
		} catch (XMLStreamException e) {
            throw new XmlWriteException(e);
        }
	}
}
