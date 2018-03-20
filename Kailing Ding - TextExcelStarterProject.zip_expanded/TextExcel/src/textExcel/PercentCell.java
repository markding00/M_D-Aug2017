package textExcel;

public class PercentCell extends RealCell{

	public PercentCell(String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {                     //return a percentage that only has an integer.
		int decimalPoint = getInput().indexOf(".");
		return (getInput().substring(0,decimalPoint) + "%");
	}
	public String fullCellText() {
		String text = getDoubleValue() + "";
		return text;
		
	}
	
	public double getDoubleValue(){
		String num = getInput().substring(0,getInput().length()-1);
		return Double.parseDouble(num) / 100.0;
	}

}
