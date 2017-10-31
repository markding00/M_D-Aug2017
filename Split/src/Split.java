import java.util.Arrays;

/*
 * Mark Ding
 * Ms.Dreyer 
 * APCS1 10/30/2017
 * Split class is working with the concept of Split method.
 */
public class Split 
{

	public static void main(String[] args) 
	{
		//String.split();
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		// Example: "I like apples!".split(" "); 
		//		it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples"split("really")
		//		it will split at the word "really" and return an array of ["I "," like "," apples!"]
		
		//play around with String.split! what happens if you "I reallyreally like apples".split("really") ?
		String str = "I reallyreally like apples";
		String[] split = str.split("really");
		System.out.println(Arrays.toString(split));
		System.out.println(Arrays.toString("I reallyreally like apples".split("really")));
		System.out.println(Arrays.toString("I like math.".split("I")));
		//System.out.println(Arrays.toString(split));
		
		//TASK 1:
		System.out.println("Results of Task 1:");
		middleOfSandwich("bread");
		middleOfSandwich("bacon");
		middleOfSandwich("breadbacon");
		middleOfSandwich("breadbread");
		middleOfSandwich("breadbaconbread");
		middleOfSandwich("applebreadbacanbread");
		middleOfSandwich("lemonbreadbaconbreadsushi");
		middleOfSandwich("breadlemonbreadbaconbreadsushi");
		middleOfSandwich("lemonbreadbaconbreadsushi");
		
		//breadcheese
		//TASK 2:
		System.out.println();
		System.out.println("Results of Task 2:");
		middleOfSandwichWithSpaces("bread");
		middleOfSandwichWithSpaces("bacon");
		middleOfSandwichWithSpaces("bread bacon");
		middleOfSandwichWithSpaces("bacon bread");
		middleOfSandwichWithSpaces("bread bread");
		middleOfSandwichWithSpaces("bread bacon bread");
		middleOfSandwichWithSpaces("apple bread bacan bread");
		middleOfSandwichWithSpaces("lemon bread bacon bread sushi");
		middleOfSandwichWithSpaces("bread lemon bread bacon bread sushi");
		middleOfSandwichWithSpaces("lemon bread bacon bread sushi");
	}
	
	//Both methods won't work if there is no "bread" or only one "bread".
	
	//Your task:
			/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
			 * use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
			 * What if it's a fancy sandwich with multiple pieces of bread?
			*/
	public static void middleOfSandwich(String sandwich){ 
		String[] object = sandwich.split("bread");
		int firstBreadPosi = sandwich.indexOf("bread");
		int secondBreadPosi = sandwich.indexOf("bread", firstBreadPosi+5);
		
		//check if "bread" occurs twice
		if(firstBreadPosi < 0){
			System.out.println("Not a sandwich");
		}else if(firstBreadPosi >=0&& secondBreadPosi < 0){
			System.out.println("Not a sandwich");
		}else if(object == null){
			System.out.println("Not a sandwich");
			
		}else{
			String middle;// middle of the sandwich
			if(firstBreadPosi+5 == secondBreadPosi){
				System.out.println("Not a sandwich");
			}else{
				middle = sandwich.substring(firstBreadPosi+5, secondBreadPosi);
				System.out.println(middle);
				}
		}
			
	}
		
		
	
	//public static void 
	
	//Your task part 2:
			/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
			 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
			 * Again, what if it's a fancy sandwich with multiple pieces of bread?
			*/
	public static void middleOfSandwichWithSpaces(String sandwich){
		int firstBreadPosi = sandwich.indexOf("bread");
		int secondBreadPosi = sandwich.indexOf("bread" , firstBreadPosi +5);
		
		if (secondBreadPosi > 0){
			String middle = sandwich.substring(firstBreadPosi+6, secondBreadPosi);
			if (middle.length() > 1){
				String[] realSandwich1 = middle.split(" ");
				String newSandwich1 = Arrays.toString(realSandwich1);
				sandwich = newSandwich1;
			}else if (middle.length() < 1){
				sandwich = "Not a sandwich";
		
			}else{ 
				sandwich = "Not a sandwich";
			}
			System.out.println(sandwich);
		}
	}	
}