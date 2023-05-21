package expression.arithmetic;

import expression.operators.OperatorBinaryArith;
import expression.operators.OperatorUnaryArith;
import visitor.ExpressionVisitor;

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

    @Override
    public String toString(){
        return expression1.toString() +" "+ expression2.toString()+" "+ operator.getChar();
    }

    public OperatorBinaryArith getOperator(){
        return operator;
    }

    public ArithmeticExpression getExpression1(){
        return expression1;
    }

    public ArithmeticExpression getExpression2(){
        return expression2;
    }

    @Override
    public void acceptVisitor(ExpressionVisitor visitor) {
        visitor.visitArithBinary(this);
    }
}
