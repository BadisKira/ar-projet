package client;

import expression.arithmetic.ArithmeticExpression;
import expression.rational.RationalExpression;
import org.xml.sax.SAXException;
import xml.load.save.ExpressionBuilder;
import xml.load.save.StdExpressionBuilder;
import xml.load.save.XmlFileLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;

public class Nullable {
    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException {
        if(args.length < 1){
            System.out.println("You need to give the filename !");
            return;
        }
        ExpressionBuilder eb = new StdExpressionBuilder();
        XmlFileLoader.load(args[0],eb);
        RationalExpression expression = (RationalExpression) eb.build();
        System.out.println(expression.getRecognizedWords().contains(RationalExpression.EMPTY_WORD));
    }
}
