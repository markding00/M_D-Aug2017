//Mark Ding
//Ms. Dreyer
//APCS1
//This is the class where it has the main method for users to write their input. 
package textExcel;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		boolean done = false;
		Spreadsheet a = new Spreadsheet();
		Scanner userInput = new Scanner(System.in);
		while(!done) {
			String input = userInput.nextLine();
			if(userInput.nextLine().equals("quit")) {
				done = true;
			}else {
				System.out.println(a.processCommand(input));
			}
		}
	}
}
