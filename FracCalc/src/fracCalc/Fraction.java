package fracCalc;

public class Fraction {
	private int whole, numerator, denominator;
	private String sign;
	
	public void Fraction(String input) {
		String[] splitUserInput = input.split(" ");
		
	}
	
	public String toString() {
		System.out.println("whole:" + whole + " numerator:" + numerator + " denominator:" + denominator);
	}
}
