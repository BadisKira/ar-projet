package composite;

import factory.Expression;

public interface BinaryOperator<T> extends Expression<T> {
    void setOperator(char c);
    void setOperand1(Expression<T> exp);
    void setOperand2(Expression<T> exp);
}