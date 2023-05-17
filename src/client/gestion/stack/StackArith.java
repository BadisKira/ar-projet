package client.gestion.stack;

import factory.Expression;
import factory.ExpressionFactory;
import factory.arithmetic.ArithmeticExpressionFactory;

import java.util.Stack;

public class StackArith implements StackTypeExpression{
    private Stack<Expression> expressionStack;
    private ExpressionFactory expFac;
    public StackArith(){
        expressionStack = new Stack<Expression>();
        expFac = new ArithmeticExpressionFactory();
    }
    @Override
    public void in(String input) {
        try {
            double d = Double.parseDouble(input);
            expressionStack.add(expFac.createExpression());
        } catch (NumberFormatException nfe) {
        }
    }


    private Expression createExp(){
        return null;
    }

    private Expression createExp(Double d){
        return new ArithmeticExpressionFactory().createExpression();
    }
}
