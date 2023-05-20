package stack;

import expression.ArithmeticExpression;
import expression.operators.OperatorBinaryArith;
import expression.operators.OperatorUnaryArith;
import factory.ExpressionFactory;
import factory.arithmetic.ArithmeticExpressionFactory;

import java.util.Stack;

public class ArithmeticStack implements ExpressionStack<ArithmeticExpression>{
    private Stack<ArithmeticExpression> expressionStack;
    private ArithmeticExpressionFactory expressionFactory ;

    double constant  ;
    char operator ;

    public ArithmeticStack(){
        expressionStack = new Stack<>();
        expressionFactory = new ArithmeticExpressionFactory() ;
    }
    @Override
    public void addExpression(ArithmeticExpression expression) {

        expressionStack.add(expression);
        toString();
    }

    @Override
    public void input(String strExp) {
        //ToDo : create expression,pop element...
        // check binary ou unary et si c'est un double

         if(OperatorUnaryArith.isUnaryOperator(strExp) ){
             if(this.expressionStack.size() >= 1) {
                 addExpression(expressionFactory.createUnaryExpression(
                         strExp.charAt(0),
                         this.expressionStack.pop()  ));
             }else {
                 System.out.println("Invalid operator. Expected a constant");
             }
         }
        if(OperatorBinaryArith.isBinaryOperator(strExp) ){
             if(this.expressionStack.size() >= 2 ){
                 addExpression(expressionFactory.createBinaryExpression(
                         this.expressionStack.pop(),
                         strExp.charAt(0),
                         this.expressionStack.pop())
                 );
             }else {
                 System.out.println("Invalid operator. Expected a constant or a unary operator");
             }
        }
        try {
            constant = Double.parseDouble(strExp);
            addExpression(expressionFactory.createConstExpression(strExp)) ;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid value. Expected a double.");
        }
      //
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