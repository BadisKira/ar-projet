package client;

import factory.Expression;
import stack.ArithmeticStack;
import stack.ExpressionStack;
import stack.FunctionalStack;
import stack.RationalStack;

import java.util.Scanner;
import java.util.Stack;

public  class Expedid {
    static Scanner scanner = new Scanner(System.in);
    private static final String QUIT_COMMAND = "!quit";
    private static final String SAVE_COMMAND = "!save";
    private static final String LOAD_COMMAND = "!load";
    private static final String TYPE_COMMAND = "!type";
    private static final String EMPTY_COMMAND = "";

    private static ExpressionStack expressionStack = null ;

    public static void run() {
        System.out.println("Hello , could you choose the expression type :");
        String input;

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();
            if (input.equals(EMPTY_COMMAND)) {
                System.out.println(" YOU CAN WRITE SOMETHING IF YOU WANT ");
            }
            else if (input.equals(QUIT_COMMAND)) {
                System.out.println("GOOD BYE !");
                System.exit(0);
            } else if (input.startsWith(SAVE_COMMAND)) {
                /**
                 * !save nom_fichier : enregistre dans le fichier dont le chemin est indiqué la sérialisation en XML de
                 * l’expression au sommet de la pile. L’expression reste sur la pile.
                 */
                handleSaveCommand(input);
            } else if (input.startsWith(LOAD_COMMAND)) {
                /** — !load nom_fichier : désérialise le contenu XML du fichier dont le chemin est indiqué pour construire
                         une expression. L’expression construite est placée au sommet de la pile
                 */
                handleLoadCommand(input);
            } else if (input.startsWith(TYPE_COMMAND)) {
                handleTypeCommand(input);
            } else {
                if(expressionStack == null){
                    handleInputExpression(input);
                }
                else{
                    handleStackExpression(input);
                    System.out.println(expressionStack.toString());
                }
            }
        }
    }

    private static void handleSaveCommand(String file) {
        System.out.println("Please provide a valid file name. Syntax: !save file_name\n");
        //  String filename = input.substring(SAVE_COMMAND.length() + 1);
        // saveExpressionToXML(pile, filename);
    }

    private static void handleLoadCommand(String file) {
        System.out.println("Please provide a valid file name. Syntax: !load file_name\n");
        //loadExpressionFromXML(pile, filename);
    }

    private static void handleTypeCommand(String input) {
        if (input.equals(TYPE_COMMAND)) {
            displayExpressionTypes();
        }
    }

    private static void handleInputExpression(String type) {
        switch (type) {
            case "arith":
                expressionStack =  new ArithmeticStack() ;
                // stack
                break;
            case "function":
                expressionStack =  new FunctionalStack() ;
                break;
            case "rational":
                expressionStack =  new RationalStack() ;
                break;
            default:
                System.out.println("Type d'expression inexistant : " + type);
                break;
        }
    }

    private static void saveExpressionToXML(Stack<Expression> stack, String filename) {
        // Code to save expression to XML file
        System.out.println("Expression saved to XML file: " + filename);
    }

    private static void loadExpressionFromXML(Stack<Object> stack, String filename) {
        // Code to load expression from XML file
        System.out.println("Expression loaded from XML file: " + filename);
    }

    private static void displayExpressionTypes() {
        System.out.println("arith    : Arithmetic expression");
        System.out.println("function : Functional expression");
        System.out.println("rational : Rational expression");
    }


    private static void handleStackExpression(String input) {
        // System.out.println("nous buildons maintenant l'expresssion a utiliser");
        expressionStack.input(input);
    }
}