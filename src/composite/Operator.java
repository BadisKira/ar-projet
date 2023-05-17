package composite;

public enum Operator {
    PLUS('+'),
    MINUS('-'),
    NEGATIVE('~'),
    DIVISION('/'),
    MULTIPLY('*');

    private char symbol;
    Operator(char c){
        symbol = c;
    }
}
