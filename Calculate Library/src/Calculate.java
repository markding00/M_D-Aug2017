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
	public static double average(double num1, double num2) {
		return (num1 + num2)/2;
	}
	
	//This method takes 3 numbers and return their average.
	public static double average(double num1, double num2, double num3) {
		return (num1 + num2 + num3)/3;
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
	public static double discriminant(double coef1, double coef2, double coef3) {
		return (coef2 * coef2) - 4 * coef1 * coef3;
	}
	
	/*This method takes 3 integers and return
	*a string where it shows the proper fraction. 
	*/ 
	public static String toImproperFrac(int wholeNum, int top, int bottom) {
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
	
	/*
	 * this method converts a binomial multiplication of tthe form(ax + b)(cx + d) into
	 * a quadratic equation of the form ax^2 + bx + c. It will takes 4 integers and 1 string 
	 * and then returns a string.
	 */
	public static String foil(int num1, int num2, int num3, int num4, String n){
		int firstCoef = num1 * num3;
		int secondCoef = num1 * num4 - num2 * num3;
		int constantNum = num2 * num4;
		String quadratic = firstCoef + n + "^2 + " + secondCoef + n + " +" + constantNum;
		return quadratic;
	}
	
	//This method takes 2 integers and return a boolean that determines whether or not 
	//one integer is evenly divisible by another.
	public static boolean isDivisibleBy(int num1, int num2) {
		if (num2 == 0) {
			throw new IllegalArgumentException("The denominator cannot be 0");
		}
		if (num1 % num2 == 0) {
			return true;
		}else {
			return false;
		}
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
	
	//This method takes 2 double and return the bigger value.
	public static double max(double num1, double num2) {
		if (num1 > num2) {
			return num1;
		}else {
			return num2;
		}
	}
	
	//This method takes 3 double and return the biggest value.
	public static double max(double num1, double num2, double num3) {
		if (num1 > num2) {
			return num1;
		}else if(num2> num3) {
			return num2;
		}else {
			return num3;
			}
		}
	
	//This method takes 2 integers and return the smaller number.
	public static int min(int num1, int num2) {
		if (num1 > num2) {
			return num2;
		}else {
			return num1;
		}
	}
	
	//This method takes a double and return a double with 2 decimal places. 
	public static double round2(double num) {
		double remainder = num * 1000 % 10;
		if(num < 0) {
			num *= -1;
			if (remainder < 5) {
				num = (num * 1000 - num * 1000 % 10) / 1000;
			}else {
				num = (10 - num * 1000 % 10 + num * 1000) / 1000;
			}
			num *= -1;
			return num;
		}else {
			if(remainder < 5) {
				return (num * 1000 - num * 1000 % 10) / 1000;
			}else {
				return (10 - num * 1000 % 10 + num * 1000) / 1000;
			}
		}
	}

	
	/*
	 * This method takes a double and an integer and returns a double. 
	 * the integer is the exponent of that double.
	 */
	public static double exponent(double num1, int num2) {
		double initialA = num1;
		if (num2 > 0) {
			for(int i = 1; i <= num2 - 1; i++) {
				num1 *= initialA;
			}
		}else if(num2 == 0){
			return 1.0;
		}else if(num2 < 0) {
			throw new IllegalArgumentException("Number cannot be less than 0");
		}
		return num1;
	}
	
	/*
	 * this method accepts an integer and returns the factorial of the value passed.
	 */
	public static int factorial(int num) {
		int base = num;
		if(num < 0) {
			throw new IllegalArgumentException("Number cannot be less than 0");
		}else if(num == 0) {
			return 1;
		}else if(num > 0) {
			for(int i = num; i >= 1; i--) {
				num *= i;
			}
		}	
		return num/base;
	}
	
	/*
	 * this method takes one integer and returns a boolean that indicates 
	 * whether the number is a prime number or not.
	 */
	public static boolean isPrime(int num) {
		if (num <= 0) {
			return false;
		}
		for(int i = 2; i <= num - 1; i++) {
			if (Calculate.isDivisibleBy(num, i) == true) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * This method takes 2 integers and return their greatest common factor. 
	 */
	public static int gcf(int num1, int num2) {
		int originalNum1 = num1;
		int originalNum2 = num2;
		while(num2!=0){
			if(Calculate.isDivisibleBy(originalNum1, originalNum2) == true){
				return (int) absValue(num1 / num2);
			}else{
				int num3 = num1;
				num1 = num2;
				num2 = num3 % num2;
		    }
		}
		return (int) absValue(num1);
	}
	
	/*
	 * This method takes a double and returns its square root. 
	 */
	public static double sqrt(double num) {
		double guessNumber = 0; 
		double result;
		if(num == 0) {
			result = 0;
		}else if(num > 0) {
			result = num / 2;
			while(absValue(guessNumber - result) >= 0.005) {
				guessNumber = result;
				result = (guessNumber + (num / guessNumber)) / 2;
			}
		}else {
			throw new IllegalArgumentException("no square root of negative number");
		}
		return round2(result);
	}
	
	/*
	 * this method takes 3 coefficients from the quadratic formula and return a string that 
	 * shows the x-value of this quadratic formula.
	 */
	public static String quadForm(int coef1, int coef2, int coef3) {
		String result;
		if(Calculate.discriminant(coef1, coef2, coef3) < 0) {
			result = "no real roots";
		}else if(Calculate.discriminant(coef1, coef2, coef3) == 0) {
			double answer = round2(-coef2 / 2 * coef1);
			result = answer + "";
		}else {
			double answer1 = (-coef2 - sqrt(square(coef2) - 4 * coef1 * coef3)) / (2 * coef1); 
			double answer2 = (-coef2 + sqrt(square(coef2) - 4 * coef1 * coef3)) / (2 * coef1);
			if(answer1 < answer2) {
				result = round2(answer1) + " and " + round2(answer2);
			}else {
				result = round2(answer2) + " and " + round2(answer1);
			}
		}
		return result;
	}
	
}




