package client;

import factory.Expression;
import factory.arithmetic.ArithmeticExpressionFactory;
import factory.function.FunctionExpressionFactory;
import factory.rational.RationalExpressionFactory;

import java.util.Scanner;
import java.util.Stack;

public class Expedid {

    public static final String  QUITTER  ="!quit" ;

    public static void run() {
        Scanner sc = new Scanner(System.in) ;
        Expression exp = null ;
        Stack<Expression> stack = new Stack<>() ;
        System.out.println("faites ce que vous avez a faire ");
        String expression_type=null ;
        while(true && expression_type != QUITTER){
            expression_type = sc.next();
            exp = createExpression(expression_type) ;
            if(exp ==null){
                System.out.println("merde choisi bien");
            }else {
                break ;
            }
        } ;

        System.out.println("Stack is empty");
        System.out.println("gfexp.type");



        String op_stack = "";
        while (op_stack != QUITTER ){
            System.out.print("> ");
            op_stack = sc.nextLine();


        }

    } ;


    public static  Expression createExpression(String type) {
            switch (type){
                case "arith" : return new ArithmeticExpressionFactory().createExpression() ;
                case "func" : return new FunctionExpressionFactory().createExpression() ;
                case "rational" : return new RationalExpressionFactory().createExpression() ;
                default: return null ;
            }
    }

}
