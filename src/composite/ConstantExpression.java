package composite;

import factory.Expression;

public class ConstantExpression implements Expression {
    @Override
    public double evaluate() {
        return 0;
    }
}
