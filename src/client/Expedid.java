package client;

import factory.Expression;
import factory.ExpressionFactory;
import factory.arithmetic.ArithmeticExpressionFactory;
import factory.function.FunctionExpressionFactory;
import factory.rational.RationalExpressionFactory;

import java.util.Scanner;
import java.util.Stack;

public  class Expedid {
    static Scanner scanner = new Scanner(System.in);
    private static final String QUIT_COMMAND = "!quit";
    private static final String SAVE_COMMAND = "!save";
    private static final String LOAD_COMMAND = "!load";
    private static final String TYPE_COMMAND = "!type";

    private static Stack<Object> pile = new Stack<>();

    private static ExpressionFactory expressionFactory ;
    private static Expression expression ;



    public static void run() {
        System.out.println("Bonjour, veuillez choisir le type d'expression :");
        String input;

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine();

            if (input.equals(QUIT_COMMAND)) {
                System.out.println("Au revoir !");
                System.exit(0);
            } else if (input.startsWith(SAVE_COMMAND)) {
                handleSaveCommand(input);
            } else if (input.startsWith(LOAD_COMMAND)) {
                handleLoadCommand(input);
            } else if (input.startsWith(TYPE_COMMAND)) {
                handleTypeCommand(input);
            } else {
                if(expression == null)
                    handleInputExpression(input);

                handleConstructExpression() ;
            }
        }
    }

    private static void handleSaveCommand(String input) {
        System.out.println("Veuillez fournir un nom de fichier valide. Syntaxe : !save nom_du_fichier");
        //  String filename = input.substring(SAVE_COMMAND.length() + 1);
        // saveExpressionToXML(pile, filename);
    }

    private static void handleLoadCommand(String input) {
        System.out.println("Veuillez fournir un nom de fichier valide. Syntaxe : !load nom_du_fichier");
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
                expressionFactory = new ArithmeticExpressionFactory() ;
                expression = expressionFactory.createExpression() ;
                break;
            case "function":
                expressionFactory = new FunctionExpressionFactory() ;
                expression = expressionFactory.createExpression() ;
                break;
            case "rational":
                expressionFactory = new RationalExpressionFactory() ;
                expression = expressionFactory.createExpression() ;
                break;
            default:
                System.out.println("Type d'expression inexistant : " + type);
                break;
        }
    }

    private static void saveExpressionToXML(Stack<Object> stack, String filename) {
        // Code to save expression to XML file
        System.out.println("Expression saved to XML file: " + filename);
    }

    private static void loadExpressionFromXML(Stack<Object> stack, String filename) {
        // Code to load expression from XML file
        System.out.println("Expression loaded from XML file: " + filename);
    }

    private static void displayExpressionTypes() {
        System.out.println("[arith]    : Expression arithmétique");
        System.out.println("[function] : Expression fonctionnelle");
        System.out.println("[rational] : Expression rationnelle");
    }


    private static void handleConstructExpression() {
        System.out.println("nous buildons maintenant l'expresssion a utiliser");
    }



}
