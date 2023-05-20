package factory;

public interface ExpressionFactory {
    /**
     *Creator
     *
     * */
    Expression createConstExpression(String value);
    Expression createBinaryExpression(Expression exp1,char operator, Expression exp2);
    Expression createUnaryExpression(char operator,Expression expression);
}