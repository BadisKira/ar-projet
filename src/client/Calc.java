package client;

import expression.arithmetic.ArithmeticExpression;
import expression.functional.FunctionalExpression;
import expression.functional.VariableExpression;
import org.xml.sax.SAXException;
import stack.ExpressionStack;
import stack.FunctionalStack;
import xml.load.save.ExpressionBuilder;
import xml.load.save.StdExpressionBuilder;
import xml.load.save.XmlFileLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;

public class Calc {
    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException {
        if(args.length < 2){
            System.out.println("You need to give two arguments : filename and value");
            return;
        }
        double value = 0.0;
        try{
            value = Double.parseDouble(args[1]);
        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        VariableExpression.setValue(value);
        ExpressionBuilder eb = new StdExpressionBuilder();
        XmlFileLoader.load(args[0],eb);
        ArithmeticExpression expression = (ArithmeticExpression) eb.build();
        System.out.println(expression.getValue());
    }
}
