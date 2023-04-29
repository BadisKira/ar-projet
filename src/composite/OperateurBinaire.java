package composite;

import factory.Expression;

public class OperateurBinaire implements Expression {
    /**
     * Composite 1
     **/
    Expression operand  ;

    @Override
    public double evaluate() {
        return 0;
    }
}
