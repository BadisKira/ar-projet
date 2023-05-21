package stack;

import expression.Expression;
import xml.load.save.XmlFileLoader;
import xml.load.save.XmlFileSaver;

import java.util.Stack;

public interface ExpressionStack<T extends Expression> {
    void addExpression(T expression);
    void input(String str);
    Stack<T> getStack();
    String toString();
    boolean isEmpty() ;
    Expression peek() ;


    XmlFileLoader xmlLoader = null;
    XmlFileSaver xmlSaver = null ;
}