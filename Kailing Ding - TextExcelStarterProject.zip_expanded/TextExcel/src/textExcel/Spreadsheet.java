//Mark Ding
//Ms. Dreyer
//APCS1
//the purpose of this class is to create a spreadsheet and provides processCommand for users to input their values.
package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] grid = new Cell[20][12];
	public Spreadsheet(){
		for(int row = 0; row < 20; row++) {
			for(int col = 0; col < 12; col++) {
				grid[row][col] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		String[] Command = command.split(" ",3);
		
		if(Command.length == 2&&Command[0].toLowerCase().equals("clear")){  		//clearing a particular cell (e.g., clear A1).
			clearCell(Command[1]);
			return getGridText();
		}else if(Command.length == 3){						//assignment to string values (e.g., A1 = "Hello").
			assignValue(Command[0],Command[2]);
			return getGridText();
		}else{
			if(Command.length==1&&Command[0].toLowerCase().equals("clear")){  //clearing the entire sheet (e.g., clear).
				clear();
				return getGridText();
			}else if(Command.length==1&&!Command[0].toLowerCase().equals("clear")){     			//cell inspection (e.g., A1). This should return the value at that cell
				SpreadsheetLocation loc = new SpreadsheetLocation(Command[0]);
				return getCell(loc).fullCellText();	
			}
		}
		return "";
	}

	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{	
		return grid[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String topLetter = "   |";
		for(char i = 'A'; i <= 'L'; i++) {
			topLetter += i + "         |";
		}
		String numbers = "\n";
		for(int i = 0; i < 20; i++) {
			if(i < 9) {
				numbers += (i+1);
				numbers += "  |";
				for(int j = 0; j < 12; j++) {
					numbers += grid[i][j].abbreviatedCellText();
					numbers += "|";
				}
				numbers += "\n";
			}else {
				numbers += (i+1);
				numbers += " |";
				for(int j = 0; j < 12; j++) {
					numbers += grid[i][j].abbreviatedCellText();
					numbers += "|";
				}
				numbers += "\n";
			}	
		}
		return topLetter + numbers;
	}
	
	//Assign the value to the given
	public void assignValue(String cell, String input) {
		SpreadsheetLocation loc = new SpreadsheetLocation(cell);
		if (input.substring(0,1).equals("\"")){ //a text cell
			grid [loc.getRow()] [loc.getCol()] = new TextCell (input);
		}
		else if (input.substring(input.length()-1).equals("%")){ //a percent cell
			grid [loc.getRow()] [loc.getCol()] = new PercentCell (input);	
		}
		else if (input.charAt(0) == ('(')){ //a formula cell
			grid [loc.getRow()] [loc.getCol()] = new FormulaCell (input,this);	
		}
		else { //a value cell
			grid [loc.getRow()] [loc.getCol()] = new ValueCell (input);	
		}
	}
	//clear the entire sheet
	public void clear(){
		for(int i = 0; i<20;i++){
			for(int j = 0;j<12;j++){
				grid [i][j] = new EmptyCell();
			}
		}
	}
	
	public void clearCell(String cell){
		//Clear the value within the assigned cell
		SpreadsheetLocation loc = new SpreadsheetLocation(cell);
		grid[loc.getRow()][loc.getCol()] = new EmptyCell();
	}
	

}
