package expression;

import expression.operators.OperatorBinaryArith;

public class FunctionalBinaryOperation extends ArithmeticBinaryOperation implements FunctionalExpression{
    public FunctionalBinaryOperation(ArithmeticExpression expression1, ArithmeticExpression expression2, OperatorBinaryArith operator) {
        super(expression1, expression2, operator);
    }
}
