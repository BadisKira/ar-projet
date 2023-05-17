package composite;

import factory.Expression;

public class OperateurUnaire implements Expression {
    /**
     * Composite 2
     **/
    private Expression operand1;
    private char operateur;
    public OperateurUnaire(char operateur,Expression operand1){
        if(operateur != '~'){
            throw new UnsupportedOperationException("Unsupported operation : " + operateur);
        }
        this.operateur = operateur;
        this.operand1 = operand1;
    }
    public OperateurUnaire(Expression operand1){
        this.operand1 = operand1;
    }
    public OperateurUnaire(){}
    public void setOperateur(char c){
        if(c != '~'){
            throw new UnsupportedOperationException("Unsupported operation : " + operateur);
        }
        operateur = c;
    }
    public void setOperand(Expression exp){
        operand1 = exp;
    }
    @Override
    public double evaluate() {
        return -operand1.evaluate();
    }
}
