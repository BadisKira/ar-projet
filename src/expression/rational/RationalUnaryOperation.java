package expression.rational;

import expression.operators.OperatorUnaryRat;

import java.util.List;

public class RationalUnaryOperation implements RationalExpression{
    private RationalExpression expression;
    private OperatorUnaryRat operator;
    public RationalUnaryOperation(RationalExpression expression, OperatorUnaryRat operator){
        this.expression = expression;
        this.operator = operator;
    }
    public RationalUnaryOperation(RationalExpression expression){
        this.expression = expression;
    }
    @Override
    public List<String> getRecognizedWords() {
        return operator == null ? expression.getRecognizedWords() : operator.calculate(expression);
    }

    @Override
    public String toString(){
        return expression.toString() + " " + operator.getChar();
    }
}
