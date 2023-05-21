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
import java.util.Stack;
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

}
