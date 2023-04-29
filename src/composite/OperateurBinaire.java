package composite;

import factory.Expression;

public class OperateurBinaire implements Expression {
    /**
     * Composite 1
     **/
    private Expression operand1;
    private Expression operand2;
    private char operateur;

    public OperateurBinaire(Expression operand1, Expression operand2, char operateur){
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operateur = operateur;
    }
    public OperateurBinaire(){}

    public void setOperateur(char c){
        operateur = c;
    }
    public void setOperand1(Expression exp){
        operand1 = exp;
    }
    public void setOperand2(Expression exp){
        operand2 = exp;
    }
    @Override
    public double evaluate() {
        double leftResult = operand1.evaluate();
        double rightResult = operand2.evaluate();
        switch (operateur) {
            case '+': return leftResult + rightResult;
            case '-': return leftResult - rightResult;
            case '*': return leftResult * rightResult;
            case '/': return leftResult / rightResult;
            default: throw new IllegalArgumentException("Invalid operator: " + operateur);
        }
    }
}
