/* Write this concrete (non-abstract) class called TriangularPrism.  
 * It has 3 private fields (sideA, sideB, and sideC).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 * 
 * Math Note:
 * Perimeter refers to the perimeter of the base - the sum of all the sides.
 * To find the area of a triangle given 3 side lengths, look up Heron's formula.  
 * It uses half the perimeter.  (Why might you want to use 0.5 instead of 1/2?) -- it's not double
 */


public class TriangularPrism extends Prism 
{
	private double sideA, sideB, sideC;
	
	public TriangularPrism(double a, double b, double c, double h) {
		super(h);
		sideA = a;
		sideB = b;
		sideC = c;
	}

	public double calcAreaOfBase() {
		//according to Heron's formula: Area = sqrt(S(S-A)(S-B)(S-C))
		double semiP = calcPerimeter() / 2;
		return Math.sqrt(semiP * (semiP - sideA) * (semiP - sideB) * (semiP - sideC));
	}

	public double calcPerimeter() {
		return sideA + sideB + sideC;
	}

	public double calcVolume() {
		return calcAreaOfBase() * getHeight();
	}

	public double calcSA() {
		return (calcAreaOfBase() * 2 + calcPerimeter() * getHeight());
	}
	
}
