package factory.rational;

import factory.Expression;
import factory.ExpressionFactory;

public class RationalExpressionFactory implements ExpressionFactory {

    /**
     * Concrete Creator
     *
     * */

    @Override
    public Expression createExpression() {
        return new RationalExpression();
    }
}
