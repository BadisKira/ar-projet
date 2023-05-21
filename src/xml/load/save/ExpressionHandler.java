package xml.load.save;

import expression.ExpressionType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ExpressionHandler extends DefaultHandler {
    private ExpressionBuilder builder;
    private StringBuilder elementValue;

    public ExpressionHandler(ExpressionBuilder b)
    {
        builder = b;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        elementValue = new StringBuilder();
        elementValue.append(ch, start, length);
        switch (builder.getStatus()){
            case READING_VALUE:
                builder.setValue(elementValue.toString());
                break;
            case READING_OPERATOR:
                builder.setOperatorType(elementValue.toString().charAt(0));
                break;
            case CREATING_EXPRESSION:
                break;
            default:
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName)
        {
            case "arith":
                builder.setExpression(ExpressionType.ARITHMETIC);
                break;
            case "rational":
                builder.setExpression(ExpressionType.RATIONAL);
                break;
            case "function":
                builder.setExpression(ExpressionType.FUNCTIONAL);
                break;
            case "expression":
                builder.startExpression();
                break;
            case "operator":
                builder.startOperator();
                break;
            case "value":
                builder.startValue();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        switch(qName)
        {
            case "expression":
                builder.endExpression();
                break;
            case "operator":
                builder.endOperator();
                break;
            case "value":
                builder.endValue();
                break;
        }
    }
}
