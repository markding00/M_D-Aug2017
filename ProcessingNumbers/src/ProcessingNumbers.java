import java.util.*;
/*
 * Mark Ding
 * APCS 1
 * 03 October 2017
 * This program will process a string of numbers from the user input.
 */
public class ProcessingNumbers {	

	public static void main(String[] args) {
		System.out.println("How many numbers do you want?");
		Scanner userinput = new Scanner(System.in);
		int totalNumber = userinput.nextInt();
		int next;
		
		System.out.println("What are the numbers?");
		next = userinput.nextInt();
		
		int maximum = next;
		int minimum = next;
		int sumEven = next;
		int largestEven = next;
		
		for(int i = 1; i < totalNumber; i++) {
			next = userinput.nextInt();
			if(next > maximum) {
				maximum = next;
			}
			if(next < minimum) {
				minimum = next;
			}
			if(next % 2 == 0) {
				sumEven += next;
			}
			if(next > largestEven && next % 2 == 0) {
				largestEven = next;
			}
			
		}
		System.out.println("Max: " + maximum);
		System.out.println("Min: " + minimum);
		System.out.println("The sum of all the even numbers is " + sumEven);
		System.out.println("Largest Even Number: " + largestEven);
		
		
		
		
		
	}

}
