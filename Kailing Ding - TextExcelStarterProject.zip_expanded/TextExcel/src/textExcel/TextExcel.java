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
			if(userInput.nextLine().equals("quit")) {
				done = true;
			}
		}
	}
}
