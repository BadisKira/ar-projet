package stack;

import expression.ArithmeticExpression;
import expression.operators.OperatorBinaryArith;
import expression.operators.OperatorUnaryArith;
import factory.Expression;
import factory.ExpressionFactory;
import factory.arithmetic.ArithmeticExpressionFactory;

import java.util.Stack;

public class ArithmeticStack extends BaseStack<ArithmeticExpression>{
    private ArithmeticExpressionFactory expressionFactory;

    public ArithmeticStack(){
        super();
        expressionFactory = new ArithmeticExpressionFactory() ;
    }

    @Override
    public void input(String strExp) {
        //ToDo : create expression,pop element...
        // check binary ou unary et si c'est un double

         if(OperatorUnaryArith.isUnaryOperator(strExp) ){
             if(getStack().size() >= 1) {
                 addExpression(expressionFactory.createUnaryExpression(
                         strExp.charAt(0),
                         getStack().remove(0)));
                 return;
             }else {
                 System.out.println("Invalid operator. Expected a constant");
                 return;
             }
         }
        if(OperatorBinaryArith.isBinaryOperator(strExp) ){
             if(getStack().size() >= 2 ){
                 addExpression(expressionFactory.createBinaryExpression(
                         getStack().remove(0),
                         strExp.charAt(0),
                         getStack().remove(0))
                 );
                 return;
             }else {
                 System.out.println("Invalid operator. Expected a constant or a unary operator");
                 return;
             }
        }

        if(isDouble(strExp)) {
            addExpression(expressionFactory.createConstExpression(strExp)) ;
        }else {
            System.out.println("Invalid value. Expected a double.");
        }

    }
    private  boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}