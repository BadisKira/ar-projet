package expression.arithmetic;

import expression.operators.OperatorUnaryArith;
import visitor.ExpressionVisitor;

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

    @Override
    public void acceptVisitor(ExpressionVisitor visitor) {
        visitor.visitArithUnary(this);
    }

    public ArithmeticExpression getExpression(){
        return expression;
    }
    public OperatorUnaryArith getOperator(){
        return operator;
    }
}
