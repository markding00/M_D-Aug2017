/* Write this concrete (non-abstract) class called RectangularPrism.  
 * It has 2 private fields (length and width).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 */

public class RectangularPrism extends Prism
{
	private double length, width;
	
	public RectangularPrism(double l, double w, double h) {
		super(h);
		length = l;
		width = w;
	}

	public double calcAreaOfBase() {
		return length * width;
	}

	public double calcPerimeter() {
		return 2 * (length + width);
	}

	public double calcVolume() {
		return calcAreaOfBase() * getHeight();
	}

	public double calcSA() {
		return (calcPerimeter() * getHeight() + calcAreaOfBase() * 2);
	}
	
}

