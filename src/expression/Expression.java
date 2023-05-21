package expression;

import visitor.ExpressionVisitor;

public interface Expression {

    /**
     * Abstract product
     * **/
    String toString();
    //void acceptVisitor();
    void acceptVisitor(ExpressionVisitor visitor);
}
