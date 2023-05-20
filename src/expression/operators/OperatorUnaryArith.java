package expression.operators;

import expression.ArithmeticExpression;

public enum OperatorUnaryArith {
    NEGATIVE('~');
    private char symbol;
    OperatorUnaryArith(char c){
        symbol = c;
    }
    public char getChar(){
        return symbol;
    }

    public Double calculate(ArithmeticExpression exp1){
        switch(this){
            case NEGATIVE:
                return - exp1.getValue();
            default:
                return null;
        }
    }
}