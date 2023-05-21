package xml.load.save;

import expression.ExpressionType;
import expression.Expression;

public interface ExpressionBuilder {
    void startExpression();
    void setExpression(ExpressionType type);
    void endExpression();
    void startOperator();
    void setOperatorType(char type);
    void endOperator();
    void startValue();
    void setValue(String value);
    void endValue();
    BuilderStatus getStatus();
    Expression build();
}