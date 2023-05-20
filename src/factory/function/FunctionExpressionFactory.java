package factory.function;

import factory.Expression;
import factory.ExpressionFactory;

public class FunctionExpressionFactory implements ExpressionFactory {
    /**
     * Concrete Creator
     */
    @Override
    public Expression createExpression() {
        return new FunctionExpression();
    }

    @Override
    public Expression createBinaryExpression(Expression exp1, char operator, Expression exp2) {
        return null;
    }

    @Override
    public Expression createUnaryExpression(char operator, Expression expression) {
        return null;
    }
}
