package stack;

import factory.Expression;

import java.util.Stack;

public interface ExpressionStack<T extends Expression> {
    void addExpression(T expression);
    void input(String str);
    Stack<T> getStack();
    String toString();
}