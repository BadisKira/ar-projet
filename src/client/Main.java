package client;

import org.xml.sax.SAXException;
import xml.load.save.ExpressionBuilder;
import xml.load.save.StdExpressionBuilder;
import xml.load.save.XmlFileLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException {
        Expedid.run();
    }
}
