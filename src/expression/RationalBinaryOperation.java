package expression;

import expression.operators.OperatorBinaryRat;

import java.util.List;

public class RationalBinaryOperation implements RationalExpression{
    private RationalExpression exp1;
    private RationalExpression exp2;
    private OperatorBinaryRat operator;
    public RationalBinaryOperation(RationalExpression exp1, OperatorBinaryRat operator, RationalExpression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operator = operator;
    }
    @Override
    public List<String> getRecognizedWords() {
        return operator.calculate(exp1,exp2);
    }
    public String toString(){
        return  exp1.toString() + " " + exp2.toString() + " " + operator.getChar();
    }
}
