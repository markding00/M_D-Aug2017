package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		boolean finish = false;
		Scanner input = new Scanner(System.in);
		while(finish==false) {
			System.out.println("Enter your fraction: "); // This asks the user to enter a fraction.
			String userExpr = input.nextLine(); //This calls the line where the user can enter something.
			if(userExpr.equals("quit")) {
				System.out.println("See you later!");//This is a fun statement!!, it is not neccessary though.
				finish=true;
			} else {
				System.out.println(produceAnswer(userExpr));
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
        
        return "";
    }

    
    
}
