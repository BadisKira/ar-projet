package expression.arithmetic;

import visitor.ExpressionVisitor;

public class ArithmeticConst implements ArithmeticExpression {
    private double value;
    public ArithmeticConst(double value){
        this.value = value;
    }
    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String toString(){
        return Double.toString(value);
    }

    @Override
    public void acceptVisitor(ExpressionVisitor visitor) {
        visitor.visitArithConst(this);
    }
}
