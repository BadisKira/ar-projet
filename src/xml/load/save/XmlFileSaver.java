package xml.load.save;

import factory.Expression;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import stack.ExpressionStack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlFileSaver {
    IBuilderXML builderXML;
    public XmlFileSaver(IBuilderXML builderXML) {
        this.builderXML = builderXML;
    }

    /**
     * Director 1 : create xml file from an expression and saves it to a file
     * */

    /**
     *
     * saveXmlFile(Expression expression, String filePath): Creates an XML file from the given expression and saves it to the specified filePath.
     * Implement this method by using the XmlConcreteBuilder to build the XML file
     * based on the properties of the expression object and then save it to the file.
     * **/

    public void buildXml(ExpressionStack stack , String filePath) throws ParserConfigurationException, SAXException, IOException {
        // Création d'un gestionnaire SAX personnalisé
        CustomHandler handler = new CustomHandler();

        // Création du parser SAX
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // Parcours de la pile et génération du contenu XML
        if(stack.isEmpty())
        {
            System.out.println("The stack is empty. Unable to build XML from an empty stack.");
            return;
        }
        while (!stack.isEmpty()) {
            Expression expression = stack.peek();

        }

        // Écriture du contenu XML dans le fichier
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(handler.getXmlContent().getBytes());
        fos.close();
    }
    private class CustomHandler extends DefaultHandler {
        private StringBuilder xmlContent = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Génération du début d'un élément XML
            xmlContent.append("<").append(qName).append(">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Génération du contenu d'un élément XML
            String content = new String(ch, start, length);
            xmlContent.append(content);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Génération de la fin d'un élément XML
            xmlContent.append("</").append(qName).append(">");
        }

        public String getXmlContent() {
            return xmlContent.toString();
        }
    }
}
