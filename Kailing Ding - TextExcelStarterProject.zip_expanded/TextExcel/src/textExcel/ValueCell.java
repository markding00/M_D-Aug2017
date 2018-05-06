//Mark Ding
//Ms. Dreyer
//APCS1
//This class has the ability to change the forms of a value cell.
package textExcel;

public class ValueCell extends RealCell {

	public ValueCell(String input) {
		super(input);
	}
	public String abbreviatedCellText() {
		String cellText = Double.toString(getDoubleValue());
		if(cellText.length() < 10) {
			if(!cellText.contains(".")) {    //checks if its a whole number 
				cellText += ".0";
			}
			return addSpaces(cellText);
		}else {	
			return cellText.substring(0,10);
		}
	}
	
	public String fullCellText() {
		return getRealCell();
	}
	@Override
	public double getDoubleValue() { 				//parse the "string" number into "double" number
		return Double.parseDouble(getRealCell());
	}
	
	
	
	
}
