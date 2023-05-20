package factory.arithmetic;

import expression.ArithmeticConst;
import expression.ArithmeticExpression;
import factory.Expression;
import factory.ExpressionFactory;

public class ArithmeticExpressionFactory implements ExpressionFactory {

    /**
     * Concrete Creator
     */
    @Override
    public ArithmeticExpression createConstExpression(String val) {
        return  new ArithmeticConst(Double.parseDouble(val));
    }

    @Override
    public ArithmeticExpression createBinaryExpression(Expression exp1, char operator, Expression exp2){
        return null;
    }

    @Override
    public ArithmeticExpression createUnaryExpression(char operator, Expression expression) {
        return null;
    }
}