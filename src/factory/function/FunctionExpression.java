package factory.function;

import factory.Expression;

import java.util.ArrayList;
import java.util.List;

public class FunctionExpression implements Expression<Double> {
    private List<Expression> children;
    public FunctionExpression() {
        children = new ArrayList<>();
    }

    public void add(Expression expression) {
        children.add(expression);
    }

    public void remove(Expression expression) {
        children.remove(expression);
    }

    public Double evaluate() {
        return 0.0;
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
