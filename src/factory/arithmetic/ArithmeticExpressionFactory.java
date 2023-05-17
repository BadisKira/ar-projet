package factory.arithmetic;

import factory.Expression;
import factory.ExpressionFactory;

public class ArithmeticExpressionFactory implements ExpressionFactory {

    /**
     * Concrete Creator
     */
    @Override
    public Expression createExpression() {
        return new ArithmeticExpression();
    }
}
