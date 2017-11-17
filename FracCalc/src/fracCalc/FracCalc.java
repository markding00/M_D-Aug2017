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
        String answer = "";
        String operand1 = toImproperFrac(operand[0]);
        String operand2 = toImproperFrac(operand[2]);
        String operator = operand[1];
        
        int slash1 = operand1.indexOf("/");
    	int slash2 = operand2.indexOf("/");
    	int numer1 = Integer.parseInt(operand1.substring(0 , slash1).trim());
    	int numer2 = Integer.parseInt(operand2.substring(0 , slash2).trim());
    	int deno1 = Integer.parseInt(operand1.substring(slash1+1, operand1.length()).trim());
    	int deno2 = Integer.parseInt(operand2.substring(slash2+1, operand2.length()).trim());
    	
        
        if(operator.equals("+")) {
        	answer = addOrSubtract(numer1, numer2, deno1, deno2, operator);
        } else if(operator.equals("-")) {
        	answer = addOrSubtract(numer1, numer2, deno1, deno2, operator);
        } else if(operator.equals("*")) {
        	answer = multiplyOrDivide(numer1, numer2, deno1, deno2, operator);
        } else if(operator.equals("/")) {
        	answer = multiplyOrDivide(numer1, numer2, deno1, deno2, operator);
        }
        return answer;
    }
    
    public static String addOrSubtract(int numer1, int numer2, int deno1, int deno2, String operator) {
    	String answer;
    	int numerator = 0;
    	if(operator.equals("+")) {
    		numerator = numer1*deno2 + numer2*deno1;
    	}else if (operator.equals("-")) {
    		numerator = numer1*deno2 - numer2*deno1;
    	}
    	int denominator = deno1 * deno2;
    	answer = numerator + "/" + denominator;
    	return answer;
    }
    
    public static String multiplyOrDivide(int numer1, int numer2, int deno1, int deno2, String operator) {
    	String answer;
    	int numerator = 0, denominator = 0;
    	if(operator.equals("*")) {
    		numerator = numer1 * numer2;
    		denominator = deno1 * deno2;
    	}else if(operator.equals("/")) {
    		numerator = numer1 * deno2;
    		denominator = deno1 * numer2;
    	}
    	answer = numerator + "/" + denominator;
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
		int whole = Integer.parseInt(wholeNum.trim());
		int numer = Integer.parseInt(numerator.trim());
		int deno = Integer.parseInt(denominator.trim());
		int top;
		if(operand.substring(0,1).equals("-") && whole != 0) {
			top = whole * deno - numer;
		}else if (operand.substring(0,1).equals("-") && whole == 0){
			top = numer;
		}else {
			top = whole * deno + numer;
		}
		
		String improp;
		improp = top + "/" + deno;
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
