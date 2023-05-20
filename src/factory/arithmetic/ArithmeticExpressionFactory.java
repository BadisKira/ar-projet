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

    @Override
    public Expression createBinaryExpression(Expression exp1, char operator, Expression exp2){
        return null;
    }

    @Override
    public Expression createUnaryExpression(char operator, Expression expression) {
        return null;
    }
}