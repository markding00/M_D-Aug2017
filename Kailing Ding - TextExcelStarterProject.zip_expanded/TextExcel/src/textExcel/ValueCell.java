package textExcel;

public class ValueCell extends RealCell {

	public ValueCell(String input) {
		super(input);
	}
	public String abbreviatedCellText() {
		String cellText = getRealCell();
		if(cellText.length() < 10) {
			if(!cellText.contains(".")) {    //checks if its a whole number 
				cellText += ".0";
			}else if(cellText.charAt(cellText.length() -1) == 0 && cellText.indexOf(".") != cellText.length() - 2){       
				//reverse for loop to check for two or more zeros together from the end
				delete0(cellText);
			}
			return addSpaces(cellText);
		}else {	
			return cellText.substring(0,10);
		}
	}
	
	public String fullCellText() {
		return getRealCell();
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getRealCell());
	}
	
	//this method can delete all the 0s behind the last valuable decimal number. 
	public String delete0(String cellText) {
		int count = 0;
		for(int i = cellText.length() - 1; i >= 0; i--) {
			if(cellText.charAt(i) == 0) {
				count++;
				if(count >= 2){
					cellText = cellText.substring(0, i);
				}
			}
		}
		return cellText;
	}
}
