import java.util.Scanner;
/*
 * Mark Ding
 * September 26, 2017
 * This is a library that contains several methods that build up the description of the graph.
 */

public class Quadratic {
	
	public static double absValue(double num) {
		if(num > 0) {
			return num;
		}else if(num == 0) {
			return 0;
		}else {
			return -1 * num;
		}
	}
	
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
	
	public static String quadrDescriber(double coef1, double coef2, double coef3) {
		String intro = "Welcome to the Quadratic Describer\nProvide values for coefficients a, b, and c";
		String num1 = "a: " + coef1;
		String num2 = "b: " + coef2;
		String num3 = "c: " + coef3;
		
		String equation = "y = " + (double)(coef1) + " x^2 + " + (double)(coef2) + " x + " + (double)(coef3);
		String description = "\nDescription of the graph of: \n" + equation;
		
		String total = intro + num1 + num2 + num3 + description; 
		return total; 
		
	}
	
	
	
	
	
}
