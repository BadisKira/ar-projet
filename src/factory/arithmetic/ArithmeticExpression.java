package factory.arithmetic;

import factory.Expression;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticExpression implements Expression {
    private List<Expression> children;
    public ArithmeticExpression() {
        children = new ArrayList<>();
    }

    public void add(Expression expression) {
        children.add(expression);
    }

    public void remove(Expression expression) {
        children.remove(expression);
    }

    public double evaluate() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Expression expression : children) {
            sb.append(expression.toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}