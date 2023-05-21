package expression.arithmetic;

import expression.operators.OperatorUnaryArith;

public class ArithmeticUnaryExpression implements ArithmeticExpression {
    private ArithmeticExpression expression;
    private OperatorUnaryArith operator;
    public ArithmeticUnaryExpression(ArithmeticExpression expression, OperatorUnaryArith operator){
        this.expression = expression;
        this.operator = operator;
    }
    @Override
    public double getValue() {
        return operator == null ? expression.getValue() : operator.calculate(expression);
    }
    @Override
    public String toString(){
        return expression.toString() + " " + operator.getChar();
    }
}
