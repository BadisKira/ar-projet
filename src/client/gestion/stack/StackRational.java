package client.gestion.stack;

import factory.Expression;
import factory.function.FunctionExpressionFactory;
import factory.rational.RationalExpressionFactory;

public class StackRational implements StackTypeExpression{
    private Expression expression;

    public StackRational(){
        expression = new RationalExpressionFactory().createExpression();
    }

    @Override
    public void in() {

    }
}
