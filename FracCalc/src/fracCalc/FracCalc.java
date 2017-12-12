package fracCalc;
import java.util.Scanner;
/*
 * Mark Ding
 * Ms.Dreyer
 * APCS1 11/07/2017
 * This class calculate two fractions from user's input. 
 */
public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
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

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		
		/*
		 * This method splits the input by the spaces and goes through each element until it identifies one of the mathematical 
		 * operations: addition,subtraction,division or multiplication. If it successfully finds one of these operations than the
		 *  array will run through and it will keep doing this until it reaches the last element and ultimately will return the last element of the array.
		 */
		String[] splitUserInput = input.split(" ");
		String result = null;
		for(int i =0; i < splitUserInput.length; i++) {
				if( splitUserInput[i].equals("+")||splitUserInput[i].equals("-")||splitUserInput[i].equals("*")||splitUserInput[i].equals("/")) {
					if (splitUserInput[i].equals("+")) {
						result=plusMinus(splitUserInput[i-1],splitUserInput[i+1],"+"); //This line of code calls the method of addOrSubtract to do addition.
					}else if(splitUserInput[i].equals("*")) {
						result = multiplyOrDivide(splitUserInput[i-1],splitUserInput[i+1],"*"); //This line of code calls the method multiplyOrDivideFrac to do multiplication.
					}else if(splitUserInput[i].equals("-")) {
						result=plusMinus(splitUserInput[i-1],splitUserInput[i+1],"-"); //This line of code calls the method of addOrSubtract to do subtraction.
					}else {
						result = multiplyOrDivide(splitUserInput[i-1],splitUserInput[i+1],"/"); //This line of code calls the method multiplyOrDivideFrac to do division.
					}
				if(i<splitUserInput.length) {
					splitUserInput[i+1]=result;
				} else {
					splitUserInput[i]=result;
				}
				}
		}
		return splitUserInput[splitUserInput.length-1];
		
	}
    /*
	 * This method parses the String input into an array to make it easier to compute the whole numbers, denominators and numerators.
	 * This method will check if a "_" is present and if it is than the string will be put in a the format of a mixed number where the 
	 * whole number is first followed by the numerator and denominator. If there isn't a "_" than it will look for the normal type of fraction.
	 * It will finally return the desired result.
	 */
	public static String[] parseFraction(String input) {
		String[] result = new String[3];
		if (input.indexOf("_")>0) {
			String[] wholeNumber= input.split("_"); //Sets the variable wholeNumber to the input split.
			result[0]=wholeNumber[0];
			String[] fraction = wholeNumber[1].split("/");
			result[1]=fraction[0];
			result[2]=fraction[1];
		} else if(input.indexOf("_")<0){
			if(input.indexOf("/")>0) {
				result[0]="0";
				String[] NonWholeFrac = input.split("/"); //Sets the variable NonWholeFrac to the input split.
				result[1]=NonWholeFrac[0];
				result[2]=NonWholeFrac[1];
			} else {
				result[0]=input;
				result[1]="0";
				result[2]="1";
			}
		}
		return result; //returns the result.
	}
	
	
    /*
	 * this method converts an integer array to the appropriate answer in the form of a string and will return the result.
	 */
	
	public static String toString (int[] FractionInput) {
		String result = "";
		if (FractionInput.length==3) {
			result= FractionInput[0]+"_"+FractionInput[1]+"/"+FractionInput[2];
		}else if(FractionInput.length==2 && FractionInput[1]==1) {
			result= FractionInput[0]+"";
		}else if(FractionInput.length==2) {
			result= FractionInput[0]+"/"+FractionInput[1];
		}
		if(result.equals("0/1")||(FractionInput.length==2 && FractionInput[0]==0)) { //This line of sets the result to 0 if the conditions are met.
			result="0";
		}else if(FractionInput.length==3 && FractionInput[1]==0) {
			result=FractionInput[0]+"";
		}else if(FractionInput.length==2 && FractionInput[0]==FractionInput[1]) {
			result=1+"";
		}
		return result; //returns the result
	}
	
	/*
	 * This method will add or subtract a fraction courtesy of the bowtie method and will return the result as as string.
	 */
	public static String plusMinus(String fractionStr1, String fractionStr2, String operation) {
		int[] fraction1= toImproper(StringtoInt(parseFraction(fractionStr1)));//Calls three different methods to account for the inputs in this method.
		int[] fraction2= toImproper(StringtoInt(parseFraction(fractionStr2)));//Calls three different methods to account for the inputs in this method.
		int[] result = new int[2];//Initializes a new array.
		int Operation1=(fraction1[0]*fraction2[1]);
		int Operation2=-(fraction2[0]*fraction1[1]);
		if (operation.equals("-")) {
			result[0]=Operation1+Operation2;
		} else{
			result[0]=Operation1-Operation2;
		}
		result[1]=(fraction1[1]*fraction2[1]);
		return toString(reduce(result));//Returns the result as a string.
	}
	
    /*
	 * converts a type string array into a type int array and will return a result.
	 */
	
	public static int[] StringtoInt(String[] input) {
		int[] result = new int[input.length];
		for (int i=0; i <input.length;i++) {//Using a for loop I can run through the entire array.
			result[i]=Integer.parseInt(input[i]);
		}
		return result; //returns the result.
	}
	
	
	/*
	 * Converts a Mixed Fraction into an Improper Fraction and will return the result.
	*/
	public static int[] toImproper(int[] inputFrac) {
		int[] result = new int[2];
		int a = inputFrac[0];//Initializes a new array.
		int b = inputFrac[1];//Initializes a new array.
		int c = inputFrac[2];//Initializes a new array.
		int numerator =0;
		if(a<0) {
			a*=-1;
			numerator = ((a * c) + b)*-1;
		}else {
			numerator = (a * c) + b;
		}
		result[0]=numerator;
		result[1]=c;
		return result; // returns the result.
	}
	
	/* 
     * This method determines whether or not one integer is evenly divisible by another.
     */
	public static boolean isDivisibleBy(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Dividing by zero isn't allowed!");//This line of code displays an error to the user if they divide by 0.
		}
		if (a % b == 0) {
			return true;// The statement will return true if that conditional is true.
		} else {
			return false;// Checks if inputs are divisible to each other
		}
	}
	
	
	/*
	 * This method finds the greatest common factor and will return it.
	 */
	public static int gcf(int number1, int number2) {
		if(number2==0) {
			return number1; //This line of code will return num1 if num2 is equal to the integer 0.
		}
		return gcf(number2,number1%number2); 
	}
	
	/*
	 * converts an improper fraction into a mixed fraction and returns the result.
	 */
	public static int[] toMixedNum(int[] FractionInput) {
		int[] mixedFraction= new int[3]; //Initializes the array mixedFraction to a new array.
		int Frac = FractionInput[0] % FractionInput[1];
		int wholeNumber = FractionInput[0] / FractionInput[1];
		if(Frac<0) {
			Frac*=-1;
		}
		mixedFraction[0]=wholeNumber;
		mixedFraction[1]=Frac;
		mixedFraction[2]=FractionInput[1];
		return mixedFraction; //This is return the result.
	}
	
	
	/*
	 * The method multiplies or divides fractions and returns the result in a string form.
	 */
	
	public static String multiplyOrDivide(String fractionStr1, String fractionStr2, String operation) {
		int[] fraction1= toImproper(StringtoInt(parseFraction(fractionStr1)));
		int[] fraction2= toImproper(StringtoInt(parseFraction(fractionStr2)));
		int[] result = new int[2];
		if (operation.equals("*")) {
			result[0]=fraction1[0]*fraction2[0];
			result[1]=fraction1[1]*fraction2[1];
		}else if (operation.equals("/")){ // This line shows the symbol for divide so if it isn't a multiplication operation the operation will be division.
			result[0]=fraction1[0]*fraction2[1];
			result[1]=fraction1[1]*fraction2[0];
		}
		return toString(reduce(result));// This line of code returns the result in a string form.
	}
	
	
	
	/*
	 * This method finds the greatest common factor of an improper fraction and divides the fraction(numerator and denominator), 
	 * it also converts the answer into a mixed number if needed. It will finally return the desired result.
	 */
	
	public static int[] reduce(int[] FractionInput) {
		int[] result = new int[2];
		int divisor = gcf(FractionInput[0],FractionInput[1]);
		result[0]=FractionInput[0]/divisor;
		result[1]=FractionInput[1]/divisor;
		int absNumber= 0;
		if (result[0]<0) {
			absNumber=result[0]*-1;//This line of code makes the number positive because if it is less than 0 multiplied by another negative = positive.
		}
		if (result[0]>result[1]||absNumber>result[1]) {
			int[] resultMixed= toMixedNum(result);
			if(resultMixed[2]<0) {
				resultMixed[2]*=-1;
			}
			return resultMixed; // returns resultMixed.
		}else {
			return result; //Returns the result.
		}
	}
}
