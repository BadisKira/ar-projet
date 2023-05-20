package factory.function;

import factory.Expression;
import factory.ExpressionFactory;

public class FunctionalExpressionFactory implements ExpressionFactory {





    /**
     * Creator
     *
     * @param value
     */
    @Override
    public Expression createConstExpression(String value) {
        return null;
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
