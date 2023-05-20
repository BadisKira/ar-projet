package stack;

import factory.Expression;
import factory.ExpressionFactory;
import factory.function.FunctionalExpressionFactory;

import java.util.Stack;

public class FunctionalStack implements ExpressionStack{

    private Stack<FunctionalExpression> expressionStack;
    private ExpressionFactory expressionFactory ;
    public FunctionalStack(){

        expressionStack = new Stack<FunctionalExpression>();
        expressionFactory = new FunctionalExpressionFactory();
    }

    /**
     * @param expression
     */
    @Override
    public void addExpression(Expression expression) {
    }

    /**
     * @param str
     */
    @Override
    public void input(String str) {

    }

    /**
     * @return
     */
    @Override
    public Stack getStack() {
        return null;
    }
}
