package expression.functional;

import expression.functional.FunctionalExpression;

public class VariableExpression implements FunctionalExpression {

    private double value;

    public void setValue(double value) {
        this.value = value;
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
}