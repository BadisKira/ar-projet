package factory;

import expression.Expression;

public interface ExpressionFactory <T extends Expression>{
    /**
     *Creator
     *
     * */
    Expression createConstExpression(String value);
    Expression createBinaryExpression(T exp1,char operator, T exp2);
    Expression createUnaryExpression(char operator,T expression);
}