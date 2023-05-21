package factory.rational;

import expression.RationalBinaryOperation;
import expression.RationalConst;
import expression.RationalExpression;
import expression.RationalUnaryOperation;
import expression.operators.OperatorBinaryArith;
import expression.operators.OperatorBinaryRat;
import expression.operators.OperatorUnaryArith;
import expression.operators.OperatorUnaryRat;
import factory.Expression;
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
