package org.example;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class XsltXmlToHtmlDomParser {
    private static final String XML_FILENAME
            = "src/main/resources/Hotels.xml";
    private static final String XSLT_FILENAME
            = "src/main/resources/xslt/hotels-xml-html.xslt";

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try(InputStream is = new FileInputStream(XML_FILENAME)){
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();

            Document document = documentBuilder.parse(is);

            try(FileOutputStream output = new FileOutputStream("src/main/resources/hotels.html")) {
                transform(document, output);
            }
        } catch (IOException | ParserConfigurationException | SAXException |
                TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void transform(Document document, FileOutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer(
                new StreamSource(new File(XSLT_FILENAME)));

        transformer.transform(new DOMSource(document), new StreamResult(output));
    }
}
