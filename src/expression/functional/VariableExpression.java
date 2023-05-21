package expression.functional;

import expression.functional.FunctionalExpression;
import visitor.ExpressionVisitor;

public class VariableExpression implements FunctionalExpression {

    private static double value;

    public static void setValue(double value) {
        VariableExpression.value = value;
    }

    public VariableExpression(){

    }


    /**
     * @return
     */
    @Override
    public double getValue() {
        return this.value;
    }

    /**
     * Abstract product
     **/
    @Override
    public String toString() {
        return "(x)";
    }

    @Override
    public void acceptVisitor(ExpressionVisitor visitor) {
        visitor.visitVariable(this);
    }
}
