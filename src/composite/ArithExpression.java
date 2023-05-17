package composite;

import client.gestion.stack.StackArith;
import factory.Expression;

import java.util.List;
import java.util.Stack;

public class ArithExpression implements Expression {
    private Stack<Expression> arithStack;

    public ArithExpression(){
        arithStack = new Stack<Expression>();
    }

    public void addExpression(Expression expression){
        arithStack.add(expression);
    }

    @Override
    public double evaluate() {
        return 0;
    }
}