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

    /**
     * @param exp1
     * @param operator
     * @param exp2
     * @return
     */
    @Override
    public Expression createBinaryExpression(Expression exp1, char operator, Expression exp2) {
        return null;
    }

    /**
     * @param operator
     * @param expression
     * @return
     */
    @Override
    public Expression createUnaryExpression(char operator, Expression expression) {
        return null;
    }
}
