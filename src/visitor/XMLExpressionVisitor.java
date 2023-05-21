package visitor;

import expression.arithmetic.ArithmeticBinaryOperation;
import expression.arithmetic.ArithmeticConst;
import expression.arithmetic.ArithmeticUnaryExpression;
import expression.functional.VariableExpression;
import expression.rational.RationalBinaryOperation;
import expression.rational.RationalConst;
import expression.rational.RationalUnaryOperation;
import java.io.PrintStream;

public class XMLExpressionVisitor implements ExpressionVisitor{

    private StringBuilder builder;
    private PrintStream printStream;
    private String expressionType;
    public XMLExpressionVisitor(PrintStream ps, String et){
        builder = new StringBuilder();
        printStream = ps;
        expressionType = et;
        builder.append("<"+expressionType+">");
    }
    @Override
    public void visitArithConst(ArithmeticConst arithmeticConst) {
        builder.append("\n<expression>");
        builder.append("\n<value> " + arithmeticConst.getValue() + "</value>");
        builder.append("\n</expression>");
    }

    @Override
    public void visitArithUnary(ArithmeticUnaryExpression arithmeticUnary) {
        builder.append("\n<expression>");
        builder.append("\n<operator>"+arithmeticUnary.getOperator().getChar()+"</operator>");
        arithmeticUnary.getExpression().acceptVisitor(this);
        builder.append("\n</expression>");
    }

    @Override
    public void visitArithBinary(ArithmeticBinaryOperation arithmeticBinary) {
        builder.append("\n<expression>");
        builder.append("\n<operator>"+arithmeticBinary.getOperator().getChar()+"</operator>");
        arithmeticBinary.getExpression1().acceptVisitor(this);
        arithmeticBinary.getExpression2().acceptVisitor(this);
        builder.append("\n</expression>");
    }

    @Override
    public void visitRatConst(RationalConst rationalConst) {
        builder.append("\n<expression>");
        builder.append("\n<value>"+rationalConst.getRecognizedWords().get(0)+"</value>");
        builder.append("\n</expression>");
    }

    @Override
    public void visitRatUnary(RationalUnaryOperation rationalUnary) {
        builder.append("\n<expression>");
        builder.append("\n<operator>"+rationalUnary.getOperator().getChar()+"</operator>");
        rationalUnary.getExpression().acceptVisitor(this);
        builder.append("\n</expression>");
    }

    @Override
    public void visitRatBinary(RationalBinaryOperation rationalBinary) {
        builder.append("\n<expression>");
        builder.append("\n<operator>"+rationalBinary.getOperator().getChar()+"</operator>");
        rationalBinary.getExp1().acceptVisitor(this);
        rationalBinary.getExp2().acceptVisitor(this);
        builder.append("\n</expression>");
    }

    @Override
    public void visitVariable(VariableExpression variableExpression) {
        builder.append("\n<expression>");
        builder.append("\n<value>x</value>");
        builder.append("\n</expression>");
    }

    @Override
    public void endVisit() {
        builder.append("\n</"+expressionType+">");
        printStream.println(builder.toString());
    }
}