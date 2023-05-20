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
