package fracCalc;
import java.util.Scanner;
/*
 * Mark Ding
 * Ms.Dreyer
 * APCS1 11/07/2017
 * This class calculate two fractions from user's input. 
 */
public class FracCalc {
	public static void main (String[] args){
		System.out.println("Please put in an expression");
		Scanner input  = new Scanner(System.in);
		String userInput = input.nextLine();
		while (userInput.equals("quit")!= true){
			String answer = produceAnswer(userInput);
			System.out.println(answer);
			System.out.println("Next One: ");
			userInput = input.nextLine();
		}
		System.out.println("Please restart!!!");
	}

	/*produceAnswer method: Separate the first operand, operator and the second operand
	Call parseOperands Method
	Call toImproperFrac
	Determine the operator of the calculation to Call AddFrac or
	Call SubtractFrac or
	Call MultipleFrac or
	Call DivideFrac
	In this method, it also calls toMixedFrac to reduce answers*/

	public static String produceAnswer(String Input){
		String[] splitBySpaces = Input.split(" ");
		String operator= splitBySpaces[1];
		int[] firstOperand= parseOperand(splitBySpaces[0]);//store the first  operand
		int[] secondOperand= parseOperand(splitBySpaces[2]);//store the second operand
		int[] firstImproperOperand=toImproperFrac(firstOperand);//convert the first operand to an improper fraction
		int[] secondImproperOperand=toImproperFrac(secondOperand);//convert the second operand to an improper fraction
		String answer;
		if ( operator.equals("+") ){
			answer = toMixedFrac(addFrac(firstImproperOperand,secondImproperOperand));
		}else if(operator.equals("-")){
			answer = toMixedFrac(subtractFrac(firstImproperOperand,secondImproperOperand));
		}else if(operator.equals("*")){
			answer = toMixedFrac(multiplyFrac(firstImproperOperand,secondImproperOperand));
		}else if(operator.equals("/")){
			answer = toMixedFrac(divideFrac(firstImproperOperand,secondImproperOperand));	
		}else{
			answer = "Please check your expression";
		}

		return answer;
	}

	/*Take in an operand 
	Split the operand into a whole number, a numerator and a denominator
	Store them in an int array */
	public static int[] parseOperand(String operand){
		String[] partsOfOperand=new String [3];
		if (operand.indexOf("_")<0 && operand.indexOf("/")<0) {
			//integers
			partsOfOperand[0] = operand;
			partsOfOperand[1] = "0";
			partsOfOperand[2] = "1";
		}else if(operand.indexOf("_")<0 && operand.indexOf("/")>0 ){
			//improper fraction
			partsOfOperand[0] = "0";
			partsOfOperand[1] = operand.substring(0, operand.indexOf("/"));
			partsOfOperand[2] = operand.substring(operand.indexOf("/")+1);
		}else if(operand.indexOf("_")>0 && operand.indexOf("/")>0){
			//Mixed fraction
			partsOfOperand[0] = operand.substring(0,operand.indexOf("_"));
			partsOfOperand[1]=operand.substring(operand.indexOf("_")+1,operand.indexOf("/"));
			partsOfOperand[2] = operand.substring(operand.indexOf("/")+1);
		}
		int[] parseOfOperand=new int [3];
		for(int i = 0; i < 3; i++){
			parseOfOperand[i]= Integer.parseInt(partsOfOperand[i]);
		}
		return parseOfOperand;
	}


	/*Take in an operand
 	Convert a mixed fraction into an improper fraction*/
	public static int[] toImproperFrac (int[] operand){
		int[] improperFrac=new int [2];
		if(operand[0]<0){
			//negative fraction
			improperFrac[0] = (operand[0]*operand[2])+(operand[1]*-1)	;
			improperFrac[1] = operand[2];
		}else{
			improperFrac[0] =((operand[0]*operand[2])+operand[1]);
			improperFrac[1]=operand[2];
		}
		return improperFrac;
	}
	/*Call gcf method
	Check if the denominator is negative
	Check if the numerator is divisible by the denominator
	Check whether the denominator is 1 or-1, or 0.
	Return the whole number, the numerator and the denominator as one string
	 */
	public static String toMixedFrac(int[] answer){

		String reducedAnswer;
		int gcf = gcf(answer[0],answer[1]);
		if(gcf!=1){
			answer[0] = answer[0]/gcf;//answer[0] is the numerator of the answer
			answer[1] = answer[1]/gcf;//answer[1] is the denominator of the answer
		}
		if(answer[1]<0){
			answer[1]=(int) absValue(answer[1]);
			answer[0]=answer[0]*-1;
		}
		int coefficient = answer[0]/answer[1];
		int remainder = answer[0] % answer[1];
		if (coefficient<0){
			if(remainder==0 && answer[1]==1){
				reducedAnswer = (Integer.toString(coefficient));
			}else if(remainder==0 && answer[1]==-1){
				reducedAnswer = (Integer.toString(coefficient));
			}else{
				reducedAnswer = coefficient + "_" + absValue(remainder) + "/" + absValue(answer[1]);
			}
		}else if(remainder==0){
			reducedAnswer = coefficient+"";		
		}else if(coefficient==0){			
			if(remainder<0 && answer[1]<0){
				int newNum = remainder*-1;
				int newDenom = answer[1]*-1;
				reducedAnswer = newNum + "/" + newDenom;
			}else{
				reducedAnswer = remainder + "/" + answer[1];
			}
		}else if(remainder<0 && answer[1]<0){
			int numerator = remainder*-1;
			int denominator = answer[1]*-1;
			reducedAnswer = coefficient + "_" + numerator + "/" + denominator;
		}else{
			reducedAnswer = coefficient + "_" + remainder + "/" + answer[1];
		}

		return reducedAnswer;
	}	

	//A method that finds the greatest common factor of two integers
	public static int gcf(int a, int b){
		while(a!=0 && b!=0){
			int c = b;
			b = a%b;
			a = c;
		}
		return (int) absValue(a+b);
	}

	/*Find the common denominator
	Then multiply the numerator with each other’s denominator 
	Finally Add up the numerator */		
	public static int[] addFrac(int[] firstOperand, int[] secondOperand){ 
		int[] answer =new int[2];
		int firstNumerator = firstOperand[0];
		int firstDenominator = firstOperand[1];
		int secondNumerator = secondOperand[0];
		int secondDenominator = secondOperand[1];
		answer[0] = secondDenominator * firstNumerator + firstDenominator * secondNumerator;
		answer[1] = firstDenominator * secondDenominator;
		return answer;
	}

	/*Find the common denominator
Then multiply the numerator with each other’s denominator 
Finally subtract one numerator from another one
	 */
	public static int[] subtractFrac(int[] firstOperand, int[] secondOperand){ 
		int[] answer =new int[2];
		int firstNumerator = firstOperand[0];
		int firstDenominator = firstOperand[1];
		int secondNumerator = secondOperand[0];
		int secondDenominator = secondOperand[1];
		answer[0] = secondDenominator * firstNumerator - firstDenominator * secondNumerator;
		answer[1] = firstDenominator * secondDenominator;
		return answer;
	}

	/*Multiply both numerators and denominators*/
	public static int[] multiplyFrac(int[] firstOperand, int[] secondOperand){ 
		int[] answer =new int[2];
		int firstNumerator = firstOperand[0];
		int firstDenominator = firstOperand[1];
		int secondNumerator = secondOperand[0];
		int secondDenominator = secondOperand[1];
		answer[0] = firstNumerator * secondNumerator;
		answer[1] = firstDenominator * secondDenominator;
		return answer;
	}

	/*Reverse the second operand numerator and denominator
Then multiply (I don’t use multiplyFrac)*/
	public static int[] divideFrac(int[] firstOperand, int[] secondOperand){ 
		int[] answer =new int[2];
		int firstNumerator = firstOperand[0];
		int firstDenominator = firstOperand[1];
		int secondNumerator = secondOperand[0];
		int secondDenominator = secondOperand[1];
		answer[0] =firstNumerator * secondDenominator;
		answer[1] = firstDenominator * secondNumerator;
		return answer;
	}
	// This method takes a double and return its absolute value
	public static double absValue(double num) {
		if(num > 0) {
			return num;
		}else if(num == 0) {
			return 0;
		}else {
			return -1 * num;
		}
	}
}