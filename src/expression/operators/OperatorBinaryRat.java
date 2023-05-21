package expression.operators;

import expression.rational.RationalExpression;

import java.util.ArrayList;
import java.util.List;

public enum OperatorBinaryRat {
    UNION('+'),
    CONCAT('.');
    private char symbol;
    OperatorBinaryRat(char c){
        symbol = c;
    }

    public char getChar(){
        return symbol;
    }

    public static boolean isBinaryOperator(String input) {
        for (OperatorBinaryRat operator : values()) {
            if (operator.getChar() == input.charAt(0)) {
                return true;
            }
        }
        return false;
    }



    public List<String> calculate(RationalExpression exp1, RationalExpression exp2){
        List<String> words;
        switch(this){
            case UNION :
                words = new ArrayList<String>();
                words.addAll(exp1.getRecognizedWords());
                words.addAll(exp2.getRecognizedWords());
                return words;
            case CONCAT:
                words = new ArrayList<String>();
                List<String> exp1Words = exp1.getRecognizedWords();
                List<String> exp2Words = exp2.getRecognizedWords();
                for(int i = 0;i < exp1Words.size();i++){
                    for(int j = 0; j < exp2Words.size(); j++){
                        words.add(exp1Words.get(i) + exp1Words.get(j));
                    }
                }
                return words;
            default:
                return null;
        }
    }
}
