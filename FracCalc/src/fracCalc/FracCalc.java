package fracCalc;
import java.util.Scanner;

/*
 * Mark Ding
 * Ms.Dreyer
 * APCS1 11/07/2017
 */
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	boolean done = false;
    	while(!done) {
    		String formula = userInput.nextLine();
        	String answer = produceAnswer(formula);
        	System.out.println(answer);
        	if(formula.equals("quit")) {
        		done = true;
        	}
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] operand = input.split(" ");
        String answer;
        String wholeNum = "", numerator = "", denominator = "";
        int underScore = operand[2].indexOf("_");
     	int slash = operand[2].indexOf("/");
        
        if(operand[2].indexOf("_") >= 0) {
        	wholeNum = operand[2].substring(0, underScore);
        	numerator = operand[2].substring(underScore + 1, slash);
        	denominator = operand[2].substring(slash + 1, operand[2].length());
        } else if (operand[2].indexOf("_") < 0 && operand[2].indexOf("/") >= 0) {
        	wholeNum = "0";
        	numerator = operand[2].substring(0, slash);
        	denominator = operand[2].substring(slash + 1, operand[2].length());
        } else if (operand[2].indexOf("_") < 0 && operand[2].indexOf("/") < 0) {
        	wholeNum = operand[2];
        	numerator = "0";
        	denominator = "1";
        }
        
        answer = "whole:" + wholeNum + " numerator:" + numerator + " denominator:" + denominator;
        return answer;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
