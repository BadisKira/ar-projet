package client.gestion.stack;

import factory.Expression;
import factory.arithmetic.ArithmeticExpressionFactory;

public class StackArith implements StackTypeExpression{
    private Expression expression;
    public StackArith(){
        expression = new ArithmeticExpressionFactory().createExpression();
    }
    @Override
    public void in() {


    }
}
