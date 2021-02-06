package org.keycloak.broker.spid.metadata;

import org.keycloak.saml.SamlProtocolExtensionsAwareBuilder;
import org.keycloak.saml.common.exceptions.ProcessingException;
import org.keycloak.saml.common.util.StaxUtil;

import javax.xml.stream.XMLStreamWriter;

public class SpidSpMetadataExtensionGenerator implements SamlProtocolExtensionsAwareBuilder.NodeGenerator {

    public static final String NS_URI = "https://spid.gov.it/saml-extensions";
    public static final String NS_PREFIX = "spid";

    private final String ELEMENT;
    private final String ELEMENT_VALUE;

    public SpidSpMetadataExtensionGenerator(String element, String value) {
        this.ELEMENT = element;
        this.ELEMENT_VALUE = value;
    }

    @Override
    public void write(XMLStreamWriter xmlStreamWriter) throws ProcessingException {
        StaxUtil.writeStartElement(xmlStreamWriter, NS_PREFIX, ELEMENT, NS_URI);
        StaxUtil.writeNameSpace(xmlStreamWriter, NS_PREFIX, NS_URI);
        StaxUtil.writeCharacters(xmlStreamWriter, ELEMENT_VALUE);
        StaxUtil.writeEndElement(xmlStreamWriter);
        StaxUtil.flush(xmlStreamWriter);
    }
}
