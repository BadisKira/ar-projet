package expression;

import expression.operators.OperatorUnaryArith;

public class FunctionalUnaryOperation extends ArithmeticUnaryExpression implements FunctionalExpression{
    public FunctionalUnaryOperation(ArithmeticExpression expression, OperatorUnaryArith operator) {
        super(expression, operator);
    }
}