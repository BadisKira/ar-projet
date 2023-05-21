package stack;

import expression.RationalExpression;
import expression.operators.OperatorBinaryArith;
import expression.operators.OperatorBinaryRat;
import expression.operators.OperatorUnaryArith;
import expression.operators.OperatorUnaryRat;
import factory.Expression;
import factory.ExpressionFactory;
import factory.rational.RationalExpressionFactory;

import java.util.Stack;

public class RationalStack implements ExpressionStack<RationalExpression>{
    private Stack<RationalExpression> expressionStack;
    private RationalExpressionFactory expressionFactory ;
    private final String FORMAT_RATIONAL = "[a-z1]+" ;
    public RationalStack(){
        expressionStack = new Stack<>();
        expressionFactory = new RationalExpressionFactory();
    }
    @Override
    public void addExpression(RationalExpression expression) {

        expressionStack.add(expression);
        System.out.println(toString());
    }

    @Override
    public void input(String strExp) {
        //ToDo : create expression,pop element...

        if(OperatorUnaryRat.isUnaryOperator(strExp) ){
            if(this.expressionStack.size() >= 1) {
                addExpression(expressionFactory.createUnaryExpression(
                        strExp.charAt(0),this.expressionStack.pop())
                );
            }else {
                System.out.println("Invalid operator. Expected a constant");
            }
            return;
        }
        if(OperatorBinaryRat.isBinaryOperator(strExp) ){
            if(this.expressionStack.size() >= 2 ){
                addExpression(expressionFactory.createBinaryExpression(
                        this.expressionStack.pop(),
                        strExp.charAt(0),
                        this.expressionStack.pop())
                );
            }else {
                System.out.println("Invalid operator. Expected a constant or a unary operator");
            }
            return;
        }

        if(strExp.matches(FORMAT_RATIONAL)){
            if(strExp.length() <= 20) {
                    expressionFactory.createConstExpression(strExp) ;

            }else {
                System.out.println("Error: The input is too long (max 20).");
            }
        }else {
            System.out.println("Error: The input does not match the format of constants.");
        }

    }

    @Override
    public Stack<RationalExpression> getStack() {
        return expressionStack;
    }
    @Override
    public boolean isEmpty() {
        return this.expressionStack.isEmpty() ;
    }

    /**
     * @return
     */
    @Override
    public Expression peek() {
        return this.expressionStack.peek();
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
