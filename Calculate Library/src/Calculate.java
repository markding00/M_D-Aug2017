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
}




