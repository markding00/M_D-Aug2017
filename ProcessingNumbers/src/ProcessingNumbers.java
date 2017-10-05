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
		
		//initialization
		int maximum = next;
		int minimum = next;
		int sumEven = next;
		int largestEven = next;
		
		for(int i = 1; i < totalNumber; i++) {
			next = userinput.nextInt();
			
			//This if statement can find the maximum in this string of numbers.
			if(next > maximum) {
				maximum = next;
			}
			
			//This if statement can find the minimum in this string of numbers.
			if(next < minimum) {
				minimum = next;
			}
			
			//This if statement can find the sum of all the even numbers.
			if(next % 2 == 0) {
				sumEven += next;
			}
			
			//This if statement can find the largest even number in this string of numbers.
			if(next > largestEven && next % 2 == 0) {
				largestEven = next;
			}
			
		}
		
		//These will print out max, min, sum of even numbers, max of even number.
		System.out.println("Max: " + maximum);
		System.out.println("Min: " + minimum);
		System.out.println("The sum of all the even numbers is " + sumEven);
		System.out.println("Largest Even Number: " + largestEven);
		
		
		
		
		
	}

}
