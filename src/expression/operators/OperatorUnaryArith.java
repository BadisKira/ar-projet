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

    public static boolean isUnaryOperator(String input) {
        for (OperatorUnaryArith operator : values()) {
            if (operator.getChar() == input.charAt(0)) {
                return true;
            }
        }
        return false;
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