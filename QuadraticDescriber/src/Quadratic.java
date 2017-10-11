/*
 * Mark Ding
 * September 26, 2017
 * This is a library that contains several methods that build up the description of the graph.
 */

public class Quadratic {
	
	public static String quadrDescriber(double coef1, double coef2, double coef3) {
		
		String equation = "y = " + (double)(coef1) + " x^2 + " + (double)(coef2) + " x + " + (double)(coef3);
		String description = "\nDescription of the graph of: \n" + equation + "\n";
		
		String direction = "Open: "; 
		if(coef1 > 0) {
			direction = direction + "Up";
		}else if(coef1 < 0) {
			direction = direction + "Down";
		}else{
			throw new IllegalArgumentException("This is not a quadratic equation.");
		}
		
		double numAOS = round2(-coef2 / (2 * coef1));
		String aos = "Axis of Symmetry: " + numAOS;
		
		double xVertex = round2(-coef2 / (2 * coef1));
		double yVertex = coef1 * square(xVertex) + coef2 * xVertex + coef3;
		String vertex = "Vertex: (" + xVertex + ", " + yVertex + ")";
		
		String roots = quadForm(coef1, coef2, coef3);
		String xIntercept = "x-intercept(s): " + roots;
		String yIntercept = "y-intercept: " + coef3;
		
		String total = description + "\n" + direction + "\n" + aos + "\n" + vertex + "\n" +
						xIntercept + "\n" + yIntercept + "\n"; 
		return total; 
	}
	
	
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
	
	public static String quadForm(double coef1, double coef2, double coef3) {
		String result;
		if(discriminant(coef1, coef2, coef3) < 0) {
			result = "None";
		}else if(discriminant(coef1, coef2, coef3) == 0) {
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
	
	public static double square(double coef2) {
		return round2(coef2 * coef2);
	}
	
	public static double discriminant(double coef1, double coef2, double coef3) {
		return (coef2 * coef2) - 4 * coef1 * coef3;
	}
	
	
}
