package stack;

import expression.Expression;

import java.util.Stack;

public abstract class BaseStack<T extends Expression> implements ExpressionStack<T>{
    private Stack<T> expressionStack;
    public BaseStack(){
        expressionStack = new Stack<T>();
    }
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = expressionStack.size() - 1; i >= 0; i--){
            str.append(i + ": " + expressionStack.get(i).toString() + "\n");
        }
        return str.toString();
    }

    @Override
    public void addExpression(T expression) {
        expressionStack.add(0,expression);
    }

    @Override
    public Stack<T> getStack() {
        return expressionStack;
    }

    @Override
    public boolean isEmpty() {
        return expressionStack.isEmpty() ;
    }

    @Override
    public Expression peek() {
        return expressionStack.peek();
    }
    @Override
    public Expression getFirst(){return expressionStack.get(0);}
}