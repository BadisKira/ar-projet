package client;

import org.xml.sax.SAXException;
import stack.ArithmeticStack;
import stack.ExpressionStack;
import stack.FunctionalStack;
import stack.RationalStack;
import visitor.ExpressionVisitor;
import visitor.XMLExpressionVisitor;
import xml.load.save.ExpressionBuilder;
import xml.load.save.StdExpressionBuilder;
import xml.load.save.XmlFileLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public  class Expedid {
    static Scanner scanner = new Scanner(System.in);
    private static final String QUIT_COMMAND = "!quit";
    private static final String SAVE_COMMAND = "!save";
    private static final String LOAD_COMMAND = "!load";
    private static final String TYPE_COMMAND = "!type";
    private static final String EMPTY_COMMAND = "";

    private static ExpressionStack expressionStack = null ;
    private static String expressionType;
    public static void run() throws FileNotFoundException, ParserConfigurationException, SAXException {
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
                loadExpressionFromXML(expressionStack,input);
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

    private static void handleSaveCommand(String file) throws FileNotFoundException {
        file = file.split(" ")[1];
        File f = new File(file);
        PrintStream ps = new PrintStream(f);
        ExpressionVisitor visitor = new XMLExpressionVisitor(ps,expressionType);
        expressionStack.getFirst().acceptVisitor(visitor);
        visitor.endVisit();
        System.out.println("The XML file has ben generated !");
    }


    private static void handleTypeCommand(String input) {
        if (input.equals(TYPE_COMMAND)) {
            displayExpressionTypes();
        }
    }

    private static void handleInputExpression(String type) {
        switch (type) {
            case "arith":
                expressionType = type;
                expressionStack =  new ArithmeticStack();
                break;
            case "function":
                expressionType = type;
                expressionStack =  new FunctionalStack() ;
                break;
            case "rational":
                expressionType = type;
                expressionStack =  new RationalStack() ;
                break;
            default:
                System.out.println("Type d'expression inexistant : " + type);
                break;
        }
    }

    private static void loadExpressionFromXML(ExpressionStack stack, String input) throws FileNotFoundException, ParserConfigurationException, SAXException {
        String filename = input.split(" ")[1];
        ExpressionBuilder eb = new StdExpressionBuilder();
        XmlFileLoader.load("C:\\Users\\berka\\Desktop\\archi-log new\\ar-projet\\src\\client/test.xml",eb);
        stack.addExpression(eb.build() );
        System.out.println(stack.toString());
        // System.out.println(eb.build().toString());
    }

    private static void displayExpressionTypes() {
        System.out.println("arith    : Arithmetic expression");
        System.out.println("function : Functional expression");
        System.out.println("rational : Rational expression");
    }


    private static void handleStackExpression(String input) {
        expressionStack.input(input);
    }
}