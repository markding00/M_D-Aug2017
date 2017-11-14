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
    
    public static String produceAnswer(String input)
    { 
       
    		String[] operand = input.split(" ");
        String answer;
        
        
        
        answer = "whole:" + wholeNum + " numerator:" + numerator + " denominator:" + denominator;
        return answer;
    }

    /*This method takes 3 integers and return
	*a string where it shows the proper fraction. 
	*/ 
	public static String toImproperFrac(String operand) {
		String wholeNum = "", numerator = "", denominator = "";
		int underScore = operand.indexOf("_");
     	int slash = operand.indexOf("/");
        
		if(operand.indexOf("_") >= 0) {
    			wholeNum = operand.substring(0, underScore);
    			numerator = operand.substring(underScore + 1, slash);
    			denominator = operand.substring(slash + 1, operand.length());
		} else if (operand.indexOf("_") < 0 && operand.indexOf("/") >= 0) {
    			wholeNum = "0";
    			numerator = operand.substring(0, slash);
    			denominator = operand.substring(slash + 1, operand.length());
		} else if (operand.indexOf("_") < 0 && operand.indexOf("/") < 0) {
			wholeNum = operand;
    			numerator = "0";
    			denominator = "1";
		}
		int numerator = wholeNum * bottom + top;
		int denominator = bottom;
		String improp;
		improp = numerator + "/" + denominator;
		return improp;
	}
	
	/*
	 * this method takes two integers from a fraction and return a string where it 
	 * shows an improper fraction. 
	 */
	public static String toMixedNum(int top, int bottom){
		int wholeNumber = top / bottom;
		int numerator = top - wholeNumber * bottom;
		int denominator = bottom;
		String mixedNum = wholeNumber + "_" + numerator + "/" + denominator; 
		return mixedNum;
	}
    
}
