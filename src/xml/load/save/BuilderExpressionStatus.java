package xml.load.save;

public class BuilderExpressionStatus {
    private OperatorType type;
    private BuilderExpressionStatus expression1;
    private BuilderExpressionStatus expression2;
    private char operator;
    private String value;
    private BuilderExpressionStatus previous;

    public BuilderExpressionStatus(){
        type = OperatorType.CONS;
    }
    public OperatorType getType() {
        return type;
    }

    public void setType(OperatorType type) {
        this.type = type;
    }

    public BuilderExpressionStatus getExpression1() {
        return expression1;
    }

    public void setExpression1(BuilderExpressionStatus expression1) {
        this.expression1 = expression1;
    }

    public BuilderExpressionStatus getExpression2() {
        return expression2;
    }

    public void setExpression2(BuilderExpressionStatus expression2) {
        this.expression2 = expression2;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BuilderExpressionStatus getPrevious() {
        return previous;
    }

    public void setPrevious(BuilderExpressionStatus previous) {
        this.previous = previous;
    }
}
