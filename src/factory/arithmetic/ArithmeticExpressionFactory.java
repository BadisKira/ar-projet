package factory.arithmetic;

import expression.arithmetic.ArithmeticBinaryOperation;
import expression.arithmetic.ArithmeticConst;
import expression.arithmetic.ArithmeticExpression;
import expression.arithmetic.ArithmeticUnaryExpression;
import expression.operators.OperatorBinaryArith;
import expression.operators.OperatorUnaryArith;
import factory.ExpressionFactory;

public class ArithmeticExpressionFactory implements ExpressionFactory<ArithmeticExpression> {

    /**
     * Concrete Creator
     */
    @Override
    public ArithmeticExpression createConstExpression(String val) {
        return  new ArithmeticConst(Double.parseDouble(val));
    }

    @Override
    public ArithmeticExpression createBinaryExpression(ArithmeticExpression exp1, char operator, ArithmeticExpression exp2){
        OperatorBinaryArith op = null;
        for (OperatorBinaryArith operator1 : OperatorBinaryArith.values()) {
            if (operator1.getChar() == operator) {
                 op = operator1;
                 break;

            }
        }
        return new ArithmeticBinaryOperation( exp1,  exp2, op);
    }

    @Override
    public ArithmeticExpression createUnaryExpression(char operator, ArithmeticExpression expression) {
        OperatorUnaryArith op = null;
        for (OperatorUnaryArith operator1 : OperatorUnaryArith.values()) {
            if (operator1.getChar() == operator) {
                op = operator1;
                break;

            }
        }
        return new ArithmeticUnaryExpression(expression , op);
    }
}