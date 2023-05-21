package expression;

public enum ExpressionType {
    ARITHMETIC("arith"),
    RATIONAL("rational"),
    FUNCTIONAL("function");

    private String symbol;
    ExpressionType(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }
}
