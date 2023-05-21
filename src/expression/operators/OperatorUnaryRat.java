package expression.operators;

import expression.RationalExpression;

import java.util.ArrayList;
import java.util.List;

public enum OperatorUnaryRat {
    KLEENE('*');
    private char symbol;
    OperatorUnaryRat(char c){
        symbol = c;
    }

    public char getChar(){
        return symbol;
    }

    public static boolean isUnaryOperator(String input) {
        for (OperatorUnaryRat operator : values()) {
            if (operator.getChar() == input.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    public List<String> calculate(RationalExpression exp){
        List<String> words;
        switch(this){
            case KLEENE:
                words = new ArrayList<>();
                kleene(exp.getRecognizedWords(),"",words, RationalExpression.MAX_WORD_SIZE);
                return words;
            default:
                return null;
        }
    }

    private void kleene(List<String> strings, String current, List<String> result, int maxLength) {
        if (current.length() > maxLength) {
            return;
        }
        result.add(current);
        for (String str : strings) {
            for (int i = 0; i < str.length(); i++) {
                String newCombination = current + str;
                if (newCombination.length() <= maxLength) {
                    kleene(strings, newCombination, result, maxLength);
                }
            }
        }
    }
}