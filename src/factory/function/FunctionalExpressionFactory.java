package factory.function;

import expression.arithmetic.ArithmeticExpression;
import expression.functional.FunctionalExpression;
import expression.functional.VariableExpression;
import factory.arithmetic.ArithmeticExpressionFactory;

public class FunctionalExpressionFactory extends ArithmeticExpressionFactory  {

    /**
     * Creator
     *
     * @param value
     */
    @Override
    public ArithmeticExpression createConstExpression(String value) {
        return super.createConstExpression(value) ;
    }
    /**
     * @param exp1
     * @param operator
     * @param exp2
     * @return
     */
   @Override
    public ArithmeticExpression createBinaryExpression(ArithmeticExpression exp1, char operator, ArithmeticExpression exp2) {
        return super.createBinaryExpression(exp1,operator,exp2);
    }

    /**
     * @param operator
     * @param expression
     * @return
     */
    @Override
    public ArithmeticExpression createUnaryExpression(char operator, ArithmeticExpression expression) {
        return  super.createUnaryExpression(operator,expression);
    }

   public FunctionalExpression createVariableExpression(String value) {
        return new VariableExpression() ;
    }
}
