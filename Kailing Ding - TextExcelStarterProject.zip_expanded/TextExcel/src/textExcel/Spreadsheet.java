package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] grid = new Cell[12][20];
	public Spreadsheet(){
		for(int row = 0; row < 12; row++) {
			for(int col = 0; col < 20; col++) {
				grid[row][col] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
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
		for(char i = 'A'; i < 'L'; i++) {
			topLetter += i + "         |";
		}
		String numbers = "\n";
		for(int i = 0; i < 20; i++) {
			if(i < 9) {
				numbers += (i+1);
				numbers += "  |";
				for(int j = 0; j < 12; j++) {
					numbers += grid[j][i].abbreviatedCellText();
				}
				numbers += "\n";
			}else {
				numbers += (i+1);
				numbers += " |";
				for(int j = 0; j < 12; j++) {
					numbers += grid[j][i].abbreviatedCellText();
				}
				numbers += "\n";
			}	
		}
		return topLetter + numbers;
	}
	//This should return the value at that cell using fullCellText() method on Cell interface.
	public String inspectCell(String cell) {
		SpreadsheetLocation loc = new SpreadsheetLocation(cell.toUpperCase());
		return getCell(loc).fullCellText();	
	}
	
	//Assign the value to the given
	public String assignValues(String cell, String input) {
		
		return getGridText();
		
	}
	//clear the entire sheet
	public String clear(){
		for(int i = 0; i<12;i++){
			for(int j = 0;j<20;j++){
				grid [i][j] = new EmptyCell();
			}
		}
		return getGridText();
	}
	
	public String clearCell(String cell){
		//Clear the value within the assigned cell
		SpreadsheetLocation loc = new SpreadsheetLocation(cell.toUpperCase());  
		grid[loc.getRow()][loc.getCol()] = new EmptyCell();
		return getGridText();
	}
	

}
