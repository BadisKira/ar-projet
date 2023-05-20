package factory.rational;

import expression.RationalConst;
import expression.RationalExpression;
import factory.Expression;
import factory.ExpressionFactory;

public class RationalExpressionFactory implements ExpressionFactory {

    /**
     * Concrete Creator
     *
     * */

    @Override
    public RationalExpression createConstExpression(String value) {
        return new RationalConst(value);
    }

    /**
     * @param exp1
     * @param operator
     * @param exp2
     * @return
     */
    @Override
    public RationalExpression createBinaryExpression(Expression exp1, char operator, Expression exp2) {
        return null;
    }

    /**
     * @param operator
     * @param expression
     * @return
     */
    @Override
    public RationalExpression createUnaryExpression(char operator, Expression expression) {
        return null;
    }
}
