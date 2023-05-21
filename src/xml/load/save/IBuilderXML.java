package xml.load.save;

import stack.ExpressionStack;

public interface IBuilderXML {

    public void setRootElement(String rootElement) ;

    public void addElement(String name, String value);

    public void buildXml(ExpressionStack expressionStack , String file) ;
}



