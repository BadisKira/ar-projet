package expression;

import factory.Expression;

import java.util.List;

public interface RationalExpression extends Expression {
    public static final String EMPTY_WORD = "1";
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" + EMPTY_WORD;
    public static final int MAX_WORD_SIZE = 20;
    List<String> getRecognizedWords();
}
