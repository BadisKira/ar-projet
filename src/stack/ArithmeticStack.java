package stack;

import expression.ArithmeticExpression;

import java.util.Stack;

public class ArithmeticStack implements ExpressionStack<ArithmeticExpression>{
    private Stack<ArithmeticExpression> expressionStack;
    public ArithmeticStack(){
        expressionStack = new Stack<ArithmeticExpression>();
    }
    @Override
    public void addExpression(ArithmeticExpression expression) {
        expressionStack.add(expression);
    }

    @Override
    public void input(String string) {
        //ToDo : create expression,pop element...
    }

    @Override
    public Stack<ArithmeticExpression> getStack() {
        return expressionStack;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        int c = 0;
        for(int i = expressionStack.size() - 1; i >= 0; i--){
            str.append(c + ": " + expressionStack.get(i).toString());
            c++;
        }
        return str.toString();
    }
}