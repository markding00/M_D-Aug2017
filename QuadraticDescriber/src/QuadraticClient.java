import java.util.*;

/*
 * Mark Ding
 * September 26, 2017
 * This is the runner class for my quadratic methods.
 */
public class QuadraticClient {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Welcome to the Quadratic Describer\nProvide values for coefficients a, b, and c\n");
		
		boolean done = false;
		
		while(done == false) {
			System.out.print("a: ");
			double coefA = userInput.nextDouble();
			System.out.print("b: ");
			double coefB = userInput.nextDouble();
			System.out.print("c: ");
			double coefC = userInput.nextDouble();
		
			System.out.println(Quadratic.quadrDescriber(coefA, coefB, coefC));
		
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			String exit = userInput.next();
			if(exit == "quit") {
				done = true;
			}
			System.out.println();
		}
	}
}
