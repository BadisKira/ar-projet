package xml.load.save;

import expression.ExpressionType;
import expression.functional.VariableExpression;
import expression.operators.OperatorBinaryArith;
import expression.operators.OperatorBinaryRat;
import expression.operators.OperatorUnaryArith;
import expression.operators.OperatorUnaryRat;
import expression.Expression;
import factory.ExpressionFactory;
import factory.arithmetic.ArithmeticExpressionFactory;
import factory.function.FunctionalExpressionFactory;
import factory.rational.RationalExpressionFactory;

public class StdExpressionBuilder implements ExpressionBuilder {
    private BuilderExpressionStatus first;
    private BuilderExpressionStatus current;
    private ExpressionType type;
    private BuilderStatus status;
    private ExpressionFactory fac;
    public StdExpressionBuilder(){
        status = BuilderStatus.IDLE;
    }
    @Override
    public void startExpression() {
        status = BuilderStatus.CREATING_EXPRESSION;
        BuilderExpressionStatus bes = new BuilderExpressionStatus();
        if(first == null){
            first = bes;
            current = first;
        }
        else{
            bes.setPrevious(current);
        }
        if(current.getType() != null){
            switch(current.getType()){
                case UNARY:
                    current.setExpression1(bes);
                    break;
                case BINARY:
                    if(current.getExpression1() == null)
                        current.setExpression1(bes);
                    else
                        current.setExpression2(bes);
                    break;
                default:
                    break;
            }
        }
        current = bes;
    }

    @Override
    public void setExpression(ExpressionType type) {
        this.type = type;
    }

    @Override
    public void endExpression() {
        status = BuilderStatus.IDLE;
        current = current.getPrevious();
    }

    @Override
    public void startOperator() {
        status = BuilderStatus.READING_OPERATOR;
    }

    @Override
    public void endOperator() {
        status = BuilderStatus.IDLE;
    }

    @Override
    public void startValue() {
        status = BuilderStatus.READING_VALUE;
    }

    @Override
    public void setValue(String value) {
        current.setValue(value);
    }

    @Override
    public void endValue() {
        status = BuilderStatus.IDLE;
    }

    @Override
    public void setOperatorType(char c) {
        OperatorType typ = OperatorType.BINARY;
        switch (type){
            case RATIONAL:
                for(OperatorBinaryRat op : OperatorBinaryRat.values()){
                    if(c == op.getChar()){
                        typ = OperatorType.BINARY;
                        break;
                    }
                }
                for(OperatorUnaryRat op : OperatorUnaryRat.values()){
                    if(c == op.getChar()){
                        typ = OperatorType.UNARY;
                        break;
                    }
                }
                break;
            case ARITHMETIC:
                for(OperatorBinaryArith op : OperatorBinaryArith.values()){
                    if(c == op.getChar()){
                        typ = OperatorType.BINARY;
                        break;
                    }
                }
                for(OperatorUnaryArith op : OperatorUnaryArith.values()){
                    if(c == op.getChar()){
                        typ = OperatorType.UNARY;
                        break;
                    }
                }
                break;
            case FUNCTIONAL:
                for(OperatorBinaryArith op : OperatorBinaryArith.values()){
                    if(c == op.getChar()){
                        typ = OperatorType.BINARY;
                        break;
                    }
                }
                for(OperatorUnaryArith op : OperatorUnaryArith.values()){
                    if(c == op.getChar()){
                        typ = OperatorType.UNARY;
                        break;
                    }
                }
                break;
        }
        current.setOperator(c);
        current.setType(typ);
    }

    @Override
    public BuilderStatus getStatus() {
        return status;
    }

    @Override
    public Expression build() {
        if(type == null){
            System.out.println("Builder expression type error ! ");
        }
        current = first;
        switch (type){
            case RATIONAL:
                fac = new RationalExpressionFactory();
                break;
            case ARITHMETIC:
                fac = new ArithmeticExpressionFactory();
                break;
            case FUNCTIONAL:
                fac = new FunctionalExpressionFactory();
                break;
        }
        return buildRecursivly(current);
    }

    private Expression buildRecursivly(BuilderExpressionStatus bes){
        switch (bes.getType()){
            case BINARY:
                return fac.createBinaryExpression(buildRecursivly(bes.getExpression1()),bes.getOperator(),buildRecursivly(bes.getExpression2()));
            case UNARY:
                return fac.createUnaryExpression(bes.getOperator(),buildRecursivly(bes.getExpression1()));
            default:
                if(type == ExpressionType.FUNCTIONAL && bes.getValue().equals("x")){
                    System.out.println("CREATING VARIABLE");
                    return new VariableExpression();
                }
                return fac.createConstExpression(bes.getValue());
        }
    }
}