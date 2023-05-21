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

public class RationalStack extends BaseStack<RationalExpression>{
    private RationalExpressionFactory expressionFactory ;
    private final String FORMAT_RATIONAL = "[a-z1]+" ;
    public RationalStack(){
        super();
        expressionFactory = new RationalExpressionFactory();
    }
    @Override
    public void input(String strExp) {
        //ToDo : create expression,pop element...

        if(OperatorUnaryRat.isUnaryOperator(strExp) ){
            if(getStack().size() >= 1) {
                addExpression(expressionFactory.createUnaryExpression(
                        strExp.charAt(0),getStack().remove(0))
                );
            }else {
                System.out.println("Invalid operator. Expected a constant");
            }
            return;
        }
        if(OperatorBinaryRat.isBinaryOperator(strExp) ){
            if(getStack().size() >= 2 ){
                addExpression(expressionFactory.createBinaryExpression(
                        getStack().remove(0),
                        strExp.charAt(0),
                        getStack().remove(0))
                );
            }else {
                System.out.println("Invalid operator. Expected a constant or a unary operator");
            }
            return;
        }

        if(strExp.matches(FORMAT_RATIONAL)){
            if(strExp.length() <= 20) {
                    addExpression(expressionFactory.createConstExpression(strExp));
            }else {
                System.out.println("Error: The input is too long (max 20).");
            }
        }else {
            System.out.println("Error: The input does not match the format of constants.");
        }
    }
}