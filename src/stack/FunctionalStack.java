package stack;

import expression.arithmetic.ArithmeticExpression;
import expression.operators.OperatorBinaryArith;
import expression.operators.OperatorUnaryArith;
import factory.function.FunctionalExpressionFactory;

public class FunctionalStack  extends BaseStack<ArithmeticExpression>{
    private FunctionalExpressionFactory expressionFactory ;

    private String variableForm = "x" ;
    public FunctionalStack(){
        super();
        expressionFactory = new FunctionalExpressionFactory();
    }

    /**
     * @param strExp
     */
    @Override
    public void input(String strExp) {
        //ToDo : create expression,pop element...
        if(OperatorUnaryArith.isUnaryOperator(strExp) ){
            if(getStack().size() >= 1) {
                addExpression(expressionFactory.createUnaryExpression(
                        strExp.charAt(0),
                        getStack().remove(0)));

                return;
            }else {
                System.out.println("Invalid operator. Expected a constant");
                return ;
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
            addExpression(expressionFactory.createConstExpression(strExp));
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
    private  boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
