package composite;

import factory.Expression;

import java.util.HashMap;
import java.util.Map;

public class ConstantExpression implements Expression {
    private static Map<String,Double> constants = new HashMap<>();
    private String nom;
    private Double val;

    public ConstantExpression(String nom,double val){
        this.nom = nom;
        this.val = val;
    }

    public ConstantExpression(){}

    @Override
    public double evaluate() {
        return 0;
    }
    public static double getValeur(String nom){
        return constants.get(nom);
    }
}
