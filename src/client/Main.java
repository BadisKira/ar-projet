package client;

import org.xml.sax.SAXException;
import xml.load.save.ExpressionBuilder;
import xml.load.save.StdExpressionBuilder;
import xml.load.save.XmlFileLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException {
        ExpressionBuilder eb = new StdExpressionBuilder();
        XmlFileLoader.load("C:\\Users\\berka\\Desktop\\archi-log new\\ar-projet\\src\\client/test.xml",eb);
        System.out.println(eb.build().toString());
        Expedid.run();
    }
}
