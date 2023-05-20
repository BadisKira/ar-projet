package factory.function;

import expression.ArithmeticExpression;
import expression.FunctionalExpression;
import factory.Expression;
import factory.ExpressionFactory;
import factory.arithmetic.ArithmeticExpressionFactory;

public class FunctionalExpressionFactory extends ArithmeticExpressionFactory implements ExpressionFactory {





    /**
     * Creator
     *
     * @param value
     */
    @Override
    public ArithmeticExpression createConstExpression(String value) {
        return super.createConstExpression(value) ;
    }

    /**
     * @param exp1
     * @param operator
     * @param exp2
     * @return
     */
    @Override
    public ArithmeticExpression createBinaryExpression(Expression exp1, char operator, Expression exp2) {
        return null;
    }

    /**
     * @param operator
     * @param expression
     * @return
     */
    @Override
    public ArithmeticExpression createUnaryExpression(char operator, Expression expression) {
        return null;
    }

    public FunctionalExpression createVariableExpression(String value) {
        return null   ;
    }
}
