/*
 * Mark Ding
 * Ms.Dreyer
 * APCS1 10/31/2017
 * This class will figure out what will be changed or what will not be, related to an array. 
 */
import java.util.Arrays;

public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 1;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		
		//pass three variables above into a method that has been changed values inside, 
		//in order to determine whether the value changes or not. 
		changeMe(num, strMain, arrMain);
		System.out.println(num + "\n" + strMain + "\n" + Arrays.toString(arrMain));
		
		
	}
	
	//change the value inside the method
	public static void changeMe(int x, String str, int[] arr) {
		x = 2;
		str = "hello_world";
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 3; 
		}
		
		//The following statements test that if the second value will change, when it equals to 
		//the first value and the first value is changed. 
		int b = x; 
		x = 10;
		System.out.println(b);
		
		String string = str;
		str = "hhhhhh";
		System.out.println(string);
		
		int[] arrays = arr;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i; 
		}
		System.out.println(Arrays.toString(arrays));
	}
}
