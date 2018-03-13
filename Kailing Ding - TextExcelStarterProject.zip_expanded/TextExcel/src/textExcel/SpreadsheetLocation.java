package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{	
	private String cellName = "";
    public SpreadsheetLocation(String cellName) {
    		this.cellName = cellName;
    }
	@Override
    public int getRow()
    {
		int rowNum = Integer.parseInt(cellName.substring(1));
        return rowNum - 1;
    }

    @Override
    public int getCol()
    {
    		char colLetter = Character.toLowerCase(cellName.charAt(0));
        return ((int)colLetter - 'a');
    }
    
}
