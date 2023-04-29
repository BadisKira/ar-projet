package composite;

import factory.Expression;

public class OperateurUnaire implements Expression {
    /**
     * Composite 2
     **/
    Expression operand1 ;
    Expression operand2;
    @Override
    public double evaluate() {
        return 0;
    }
}
