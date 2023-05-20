package expression;

import expression.operators.OperatorBinaryArith;

public class ArithmeticBinaryOperation implements ArithmeticExpression {
    /**
     * Composite 1
     **/
    private ArithmeticExpression expression1;
    private ArithmeticExpression expression2;
    private OperatorBinaryArith operator;

    public ArithmeticBinaryOperation(ArithmeticExpression expression1, ArithmeticExpression expression2, OperatorBinaryArith operator){
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.operator = operator;
    }

    @Override
    public double getValue() {
        return operator.calculate(expression1,expression2);
    }
}
