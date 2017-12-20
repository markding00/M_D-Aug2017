/*
 * Mark Ding
 * 12/15/17
 * This class parses and defines fractions to be able to be used.
 */
package fracCalc;

public class Fraction {
	private int whole;
	private int numerator;
	private int denominator;

	//constructor that takes string
	public Fraction(String operand) { 
		String whole = "";
		String numerator = "";
		String denominator = "";
		if (operand.indexOf("_") >= 0) {// tests if it is a mixed number
			whole = operand.substring(0, operand.indexOf("_"));
		} else {
			whole = "0";
		}
		
		if (operand.indexOf("/") >= 0) {// tests if there is a fraction
			if (operand.indexOf("_") >= 0) {
				numerator = operand.substring(operand.indexOf("_") + 1, operand.indexOf("/"));

			} else {
				numerator = operand.substring(0, operand.indexOf("/"));
			}
			denominator = operand.substring(operand.indexOf("/") + 1, operand.length());
		} else {
			whole = operand;
			numerator = "0";
			denominator = "1";
		}
		String[] answer = {whole, numerator, denominator};
		this.whole = toInt(answer[0]);
		this.numerator = toInt(answer[1]);
		this.denominator = toInt(answer[2]);
	}
	//constructor that takes mixed number
	public Fraction(int whole, int numer, int deno) {
		this.whole = whole;
		this.numerator = numer;
		this.denominator = deno;
	}
	//constructor that takes improper or just fraction
	public Fraction(int numer, int deno) {
		this.whole = 0;
		this.numerator = numer;
		this.denominator = deno;
	}
	//constructor that takes nothing
	public Fraction() {
		this.whole = 0;
		this.numerator = 0;
		this.denominator = 1;
	}
	//constructor that will copy another fraction
	public Fraction(Fraction f) {
		this(f.getWhole(),f.getNumerator(), f.getDenominator());
	}
	public void toMixedNumber() {
		//updates whole and numerator
		this.whole = this.numerator / this.denominator;
		if(this.numerator > 0 || (this.numerator < 0 && this.denominator < 0)) {
			this.numerator = this.numerator % this.denominator;
		}else if(this.whole == 0 && this.numerator < 0) {
			this.numerator = this.numerator % this.denominator; 
		}else {
			this.numerator = Math.abs(this.numerator % this.denominator);
		}
	}
	public void toImproper() {
		//update whole to 0
		//update numerator
		if(this.whole < 0) {
			this.numerator = (Math.abs(this.whole * this.denominator) + this.numerator) * -1; 
		}else {
		this.numerator = (this.whole * this.denominator) + this.numerator;
		}
		this.whole = 0;
	}
	private int toInt(String str) {
		//convert string to int
		return Integer.parseInt(str);
	}
	public void simplify() {
		this.toImproper();
		int gcf = gcf(Math.abs(this.numerator), Math.abs(this.denominator));
		this.numerator /= gcf;
		this.denominator /= gcf;
		if(this.denominator < 0 && this.numerator >= 0) {
			this.denominator *= -1;
			this.numerator *= -1;
		}
		this.toMixedNumber();
		
	}
	public String toString() {
		//creates string to be printed out
		
		if(this.whole == 0 && this.numerator == 0) {//if equivalent to 0
	    	   return "0";
	       }else if(this.whole == 0 && this.numerator != 0) {//if whole is 0 then only fraction
	    	   if(this.denominator < 0) {//if denominator is negative, return absValue and multiply numerator by -1
	    		   return -this.numerator + "/" + Math.abs(this.denominator);
	    	   }else {
	    		   return this.numerator + "/" + this.denominator;
	    	   }
	       }else if(this.whole != 0 && this.numerator == 0) {//if only whole number
	    	   return "" + this.whole;
	       }else {//if the whole thing
	    	   return this.whole + "_" + Math.abs(this.numerator) + "/" + Math.abs(this.denominator);
	       }
	}
	private int gcf(int greaterN, int lesserN) {
		int a = greaterN;
		int b = lesserN;
		int result;
		while (b != 0) {
			result = a % b;
			a = b;
			b = result;
		}
		return a;//a will be the gcf
	}
	public int getWhole() {
		return whole;
	}
	public void setWhole(int whole) {
		this.whole = whole;
	}
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public Fraction multiply(Fraction operand2) {
		int numAnswer = this.numerator * operand2.getNumerator();
		int denomAnswer = this.denominator * operand2.getDenominator();
		Fraction answer = new Fraction(numAnswer, denomAnswer);
		
		return answer;
	}
	public Fraction add(Fraction frac2) {
		Fraction answer = new Fraction();
		this.toImproper();
		frac2.toImproper();
		commonDeno(this, frac2);
		answer.setNumerator(this.getNumerator() + frac2.getNumerator());
		answer.setDenominator(this.getDenominator());
		answer.simplify();
		return answer;
	}
	public static void commonDeno(Fraction frac1, Fraction frac2) {
		frac1.setNumerator(frac1.getNumerator() * frac2.getDenominator());
		int temp = frac1.getDenominator();
		frac1.setDenominator(frac1.getDenominator() * frac2.getDenominator());
		
		frac2.setNumerator(frac2.getNumerator() * temp);
		frac2.setDenominator(frac2.getDenominator() * temp);
	}
}