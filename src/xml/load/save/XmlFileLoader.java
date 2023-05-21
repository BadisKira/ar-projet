package xml.load.save;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XmlFileLoader {

    /**
     * Reads an XML file from the specified path and creates a Stack of expressions.
     *
     * @param filePath The path of the XML file to be read.
     * @return A Stack of expressions created from the XML file.
     */
    public static void load(String filePath, ExpressionBuilder eb) throws ParserConfigurationException, SAXException, FileNotFoundException
    {
        InputSource is = new InputSource(new BufferedInputStream((new FileInputStream(filePath))));
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();
        ExpressionHandler eh = new ExpressionHandler(eb);
        xr.setContentHandler(eh);
        xr.setErrorHandler(eh);
        try
        {
            xr.parse(is);
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
