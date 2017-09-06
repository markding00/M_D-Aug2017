//Mark Ding
//September 5, 2017
//This is a homegrown library that will contain various math method. 
public class Calculate {
	
	//This method takes an integer and return its square.
	public static int square(int number) {
		return number * number;
	}
	
	//This method takes an integer and return its cube.
	public static int cube(int number) {
		return number * number * number;
	}
	
	//This method takes 2 numbers and return their average.
	public static double average(double a, double b) {
		return (a + b)/2;
	}
	
	//This method takes 3 numbers and return their average.
	public static double average(double a, double b, double c) {
		return (a + b + c)/3;
	}
	
	//This method converts radians into degrees.
	public static double toDegrees(double radian) {
		double pi = 3.14159;
		return radian * (360 / (2 * pi));
	}
	
	//This method converts degrees into radians.
	public static double toRadians(double degrees) {
		double pi = 3.14159;
		return degrees * ((2 * pi) / 360);
	}
	
	
	//This method takes 3 coefficients and return the value of the discriminant.
	public static double discriminant(double a, double b, double c) {
		return (b * b) - 4 * a * c;
	}
	
	/*This method takes 3 integers and return
	*a string where it shows the proper fraction. 
	*/ 
	public static String toImproperFrac(int a, int b, int c) {
		int numerator = a * c + b;
		int denominator = c;
		String improp;
		improp = numerator + "/" + denominator;
		return improp;
	}
	
	/*
	 * this method takes two integers from a fraction and return a string where it 
	 * shows an improper fraction. 
	 */
	public static String toMixedNum(int top, int bottom){
		int wholeNumber = top % bottom;
		int numerator = top - wholeNumber * bottom;
		int denominator = bottom;
		String mixedNum = wholeNumber + "_" + numerator + "/" + denominator; 
		return mixedNum;
	}
	
	/*
	 * this method converts a binomial multiplication of tthe form(ax + b)(cx + d) into
	 * a quadratic equation of the form ax^2 + bx + c. It will takes 4 integers and 1 string 
	 * and then returns a string.
	 */
	public static String foil(int a, int b, int c, int d, String n){
		int firstCoef = a * c;
		int secondCoef = a * d - b * c;
		int constantNum = b * d;
		String quadratic = firstCoef + n + "^2 + " + secondCoef + n + " +" + constantNum;

		return quadratic;
	}

}




