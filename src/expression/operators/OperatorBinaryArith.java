package expression.operators;

import expression.ArithmeticExpression;

public enum OperatorBinaryArith {
    PLUS('+'),
    MINUS('-'),
    DIVISION('/'),
    MULTIPLY('*');
    private char symbol;
    OperatorBinaryArith(char c){
        symbol = c;
    }

    public char getChar(){
        return symbol;
    }

    public Double calculate(ArithmeticExpression exp1, ArithmeticExpression exp2){
        switch(this){
            case PLUS:
                return exp1.getValue() + exp2.getValue();
            case MINUS:
                return exp1.getValue() - exp2.getValue();
            case DIVISION:
                return exp1.getValue() / exp2.getValue();
            case MULTIPLY:
                return exp1.getValue() * exp2.getValue();
            default:
                return null;
        }
    }
}
