package xml.load.save;
import factory.Expression;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Stack;

public class XmlFileLoader {
    private IBuilderXML builderXML;

    public XmlFileLoader(IBuilderXML builderXML) {
        this.builderXML = builderXML;
    }

    /**
     * Reads an XML file from the specified path and creates a Stack of expressions.
     *
     * @param filePath The path of the XML file to be read.
     * @return A Stack of expressions created from the XML file.
     */
    public Stack<Expression> loadXmlFile(String filePath , Stack<Expression> expressionStack) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));
            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getTagName();
                    String attributes = "";  // Extract attributes based on your XML structure
                    String content = element.getTextContent();

                    //expressions.push(new Expression());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expressionStack;
    }
}
