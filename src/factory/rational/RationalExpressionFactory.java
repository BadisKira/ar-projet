package factory.rational;

import expression.rational.RationalBinaryOperation;
import expression.rational.RationalConst;
import expression.rational.RationalExpression;
import expression.rational.RationalUnaryOperation;
import expression.operators.OperatorBinaryRat;
import expression.operators.OperatorUnaryRat;
import factory.ExpressionFactory;

public class RationalExpressionFactory implements ExpressionFactory<RationalExpression> {

    /**
     * Concrete Creator
     *
     * */

    @Override
    public RationalExpression createConstExpression(String value) {
        return new RationalConst(value);
    }

    /**
     * @param exp1
     * @param operator
     * @param exp2
     * @return
     */
    @Override
    public RationalExpression createBinaryExpression(RationalExpression exp1, char operator, RationalExpression exp2) {
        OperatorBinaryRat opb = null;
        for (OperatorBinaryRat op : OperatorBinaryRat.values()) {
            if (op.getChar() == operator) {
                opb = op;
                break;
            }
        }
        return new RationalBinaryOperation(exp1,opb,exp2);
    }

    /**
     * @param operator
     * @param expression
     * @return
     */
    @Override
    public RationalExpression createUnaryExpression(char operator, RationalExpression expression) {
        OperatorUnaryRat opb = null;
        for (OperatorUnaryRat op : OperatorUnaryRat.values()) {
            if (op.getChar() == operator) {
                opb = op;
                break;
            }
        }
        return new RationalUnaryOperation(expression,opb);
    }
}
