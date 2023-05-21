package factory.function;

import expression.ArithmeticExpression;
import expression.FunctionalExpression;
import expression.VariableExpression;
import factory.Expression;
import factory.ExpressionFactory;
import factory.arithmetic.ArithmeticExpressionFactory;

public class FunctionalExpressionFactory extends ArithmeticExpressionFactory  {

    /**
     * Creator
     *
     * @param value
     */
/*    @Override
    public ArithmeticExpression createConstExpression(String value) {
        return super.createConstExpression(value) ;
    }*/
    /**
     * @param exp1
     * @param operator
     * @param exp2
     * @return
     */
   /* @Override
    public FunctionalExpression createBinaryExpression(FunctionalExpression exp1, char operator, FunctionalExpression exp2) {
        return createBinaryExpression(exp1,operator,exp2);
    }*/

    /**
     * @param operator
     * @param expression
     * @return
     */
   /* @Override
    public FunctionalExpression createUnaryExpression(char operator, FunctionalExpression expression) {
        return  createUnaryExpression(operator,expression);
    }*/

   /* public FunctionalExpression createVariableExpression(String value) {
        return new VariableExpression() ;
    }*/
}
