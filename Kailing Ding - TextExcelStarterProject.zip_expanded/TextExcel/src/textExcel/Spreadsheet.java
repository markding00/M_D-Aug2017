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
			return clearCell(Command[1]);
		}else if(Command.length == 3){						//assignment to string values (e.g., A1 = "Hello").
			return assignValue(Command[0],Command[2]);	
		}else{
			if(Command.length==1&&Command[0].toLowerCase().equals("clear")){  //clearing the entire sheet (e.g., clear).
				return clear();
				
			}else{     			//cell inspection (e.g., A1). This should return the value at that cell
				return inspectCell(Command[0]);
				
			}
		}
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
	//This should return the value at that cell using fullCellText() method on Cell interface.
	public String inspectCell(String cell) {
		SpreadsheetLocation loc = new SpreadsheetLocation(cell);
		return getCell(loc).fullCellText();	
	}
	
	//Assign the value to the given
	public String assignValue(String cell, String input) {
		SpreadsheetLocation loc = new SpreadsheetLocation(cell);
		grid[loc.getRow()][loc.getCol()] = new TextCell(input);
		return getGridText();
		
	}
	//clear the entire sheet
	public String clear(){
		for(int i = 0; i<20;i++){
			for(int j = 0;j<12;j++){
				grid [i][j] = new EmptyCell();
			}
		}
		return getGridText();
	}
	
	public String clearCell(String cell){
		//Clear the value within the assigned cell
		SpreadsheetLocation loc = new SpreadsheetLocation(cell);
		grid[loc.getRow()][loc.getCol()] = new EmptyCell();
		return getGridText();
	}
	

}
