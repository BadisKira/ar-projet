package stack;

import expression.RationalExpression;
import factory.ExpressionFactory;
import factory.rational.RationalExpressionFactory;

import java.util.Stack;

public class RationalStack implements ExpressionStack<RationalExpression>{
    private Stack<RationalExpression> expressionStack;
    private ExpressionFactory expressionFactory ;
    public RationalStack(){
        expressionStack = new Stack<RationalExpression>();
        expressionFactory = new RationalExpressionFactory();
    }
    @Override
    public void addExpression(RationalExpression expression) {
        expressionStack.add(expression);
    }

    @Override
    public void input(String string) {
        //ToDo : create expression,pop element...
         expressionFactory.createExpression(string) ;
    }

    @Override
    public Stack<RationalExpression> getStack() {
        return expressionStack;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        int c = 0;
        for(int i = expressionStack.size() - 1; i >= 0; i--){
            str.append(c + ": " + expressionStack.get(i).toString());
            c++;
        }
        return str.toString();
    }
}
