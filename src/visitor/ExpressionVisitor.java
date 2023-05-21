package visitor;

import expression.arithmetic.ArithmeticBinaryOperation;
import expression.arithmetic.ArithmeticConst;
import expression.arithmetic.ArithmeticUnaryExpression;
import expression.functional.VariableExpression;
import expression.rational.RationalBinaryOperation;
import expression.rational.RationalConst;
import expression.rational.RationalUnaryOperation;

public interface ExpressionVisitor {
    //arith
    void visitArithConst(ArithmeticConst arithmeticConst);
    void visitArithUnary(ArithmeticUnaryExpression arithmeticUnary);
    void visitArithBinary(ArithmeticBinaryOperation arithmeticBinary);

    //binary
    void visitRatConst(RationalConst rationalConst);
    void visitRatUnary(RationalUnaryOperation rationalUnary);
    void visitRatBinary(RationalBinaryOperation rationalBinary);

    //funcitonal
    void visitVariable(VariableExpression variableExpression);

    void endVisit();
}
