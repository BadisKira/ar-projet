package stack;

import expression.FunctionalExpression;
import expression.operators.OperatorBinaryArith;
import expression.operators.OperatorUnaryArith;
import factory.Expression;
import factory.ExpressionFactory;
import factory.function.FunctionalExpressionFactory;

import java.util.Stack;

public class FunctionalStack  implements ExpressionStack{

    private Stack<FunctionalExpression> expressionStack;
    private FunctionalExpressionFactory expressionFactory ;

    private String variableForm = "x" ;
    public FunctionalStack(){

        expressionStack = new Stack<>();
        expressionFactory = new FunctionalExpressionFactory();
    }

    /**
     * @param expression
     */
    @Override
    public void addExpression(Expression expression) {
    }

    /**
     * @param strExp
     */
    @Override
    public void input(String strExp) {
        //ToDo : create expression,pop element...


        if(OperatorUnaryArith.isUnaryOperator(strExp) ){
            if(this.expressionStack.size() >= 1) {
                addExpression(expressionFactory.createUnaryExpression(
                        strExp.charAt(0),
                        this.expressionStack.pop()  ));

                return;
            }else {
                System.out.println("Invalid operator. Expected a constant");
                return ;
            }
        }
        if(OperatorBinaryArith.isBinaryOperator(strExp) ){
            if(this.expressionStack.size() >= 2 ){
                addExpression(expressionFactory.createBinaryExpression(
                        this.expressionStack.pop(),
                        strExp.charAt(0),
                        this.expressionStack.pop())
                );
                return ;
            }else {
                System.out.println("Invalid operator. Expected a constant or a unary operator");
                return;
            }
        }

        if(isDouble(strExp)) {
            addExpression(expressionFactory.createConstExpression(strExp)) ;
            return;
        }else {
            if(strExp.equals(variableForm)) {
                addExpression(expressionFactory.createVariableExpression(strExp)) ;
            } else {
                System.out.println("Invalid operator.only variable accepted is 'x'");
                return ;
            }
            System.out.println("Invalid value. Expected a double.");
        }


    }

    public  boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @return
     */
    @Override
    public Stack getStack() {
        return null;
    }
}
