package factory;

public interface Expression<T> {

    /**
     * Abstract product
     * **/

    T evaluate();
    //void accept(ExpressionVisitor visitor);
}
