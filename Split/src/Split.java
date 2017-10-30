import java.util.Arrays;

public class Split {

	public static void main(String[] args) {
		// Example: "I like apples!".split(" "); 
			//it will split at spaces and return an array of ["I","like","apples!"]
		System.out.println(Arrays.toString("I like apples!".split(" ")));
		
		// Example 2: "I really like really red apples"split("really")
        //it will split at the word "really" and return an array of ["I "," like "," red apples!"]
		System.out.println(Arrays.toString("I really like really red apples".split("really")));

		//play around with String.split! what happens if you "I reallyreally like apples".split("really") ?
		System.out.println(Arrays.toString("I reallyreally like apples".split("really")));
		System.out.println(Arrays.toString("I like math.".split("I")));
		
		//Your task:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		* What if it's a fancy sandwich with multiple pieces of bread?
		*/
		System.out.println(sandwich("applespineapplesbreadlettustomatobaconmayohambreadcheese"));
		System.out.println(sandwich("applesbreadpineapplesbreadlettustomatobaconmayohambreadcheese"));
		System.out.println(sandwich("applespineapplesbreadbreadlettustomatobaconmayohambreadcheese"));
		System.out.println(sandwich("apples pineapples lettus tomato bacon mayo ham cheese"));
		System.out.println(sandwich("bread"));
		
		//Your task pt 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		* Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/
		System.out.println(Arrays.toString("apples pineapples bread lettus tomato bacon mayo ham bread cheese".split("bread")));
		
	}
	
	//Your task:
			/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
			* use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
			* What if it's a fancy sandwich with multiple pieces of bread?
			*/
	public static String sandwich(String bread) {
		String[] realSandwich = bread.split("bread");
		return realSandwich[1];
	}
	
	
}
