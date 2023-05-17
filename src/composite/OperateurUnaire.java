package composite;

import factory.Expression;

public class OperateurUnaire implements Expression<Double> {
    /**
     * Composite 2
     **/
    private Expression<Double> operand1;
    private char operateur;
    public OperateurUnaire(char operateur,Expression<Double> operand1){
        if(operateur != '~'){
            throw new UnsupportedOperationException("Unsupported operation : " + operateur);
        }
        this.operateur = operateur;
        this.operand1 = operand1;
    }
    public OperateurUnaire(Expression<Double> operand1){
        this.operand1 = operand1;
    }
    public OperateurUnaire(){}
    public void setOperateur(char c){
        if(c != '~'){
            throw new UnsupportedOperationException("Unsupported operation : " + operateur);
        }
        operateur = c;
    }
    public void setOperand(Expression<Double> exp){
        operand1 = exp;
    }
    @Override
    public Double evaluate() {
        return -operand1.evaluate();
    }
}
