package factory.arithmetic;

import composite.OperateurBinaire;
import composite.OperateurUnaire;
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
    public Expression createBinaryExpression(Expression exp1, char operator, Expression exp2) {
        return new OperateurBinaire(exp1,exp2,operator);
    }

    @Override
    public Expression createUnaryExpression(char operator, Expression expression) {
        return new OperateurUnaire(operator,expression);
    }
}