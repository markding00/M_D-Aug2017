//Mark Ding
//Ms. Dreyer
//APCS1
//This class has the ability to change the forms of a percent cell(decimals form, abbreviated form, etc)
package textExcel;

public class PercentCell extends RealCell{

	public PercentCell(String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {                     //return a percentage that only has an integer.
		int decimalPoint = getRealCell().indexOf(".");
		String wholeNum = getRealCell().substring(0,decimalPoint);
		if(wholeNum.length() < 10) {
			wholeNum += "%";
			return super.addSpaces(wholeNum);
		}else {
			return (wholeNum.substring(0,8) + "%");
		}
	}
	public String fullCellText() {
		String text = getDoubleValue() + "";
		return text;
		
	}
	
	public double getDoubleValue(){						//return the percentage in decimal form.
		String num = getRealCell().substring(0,getRealCell().length()-1);
		return Double.parseDouble(num) / 100.0;
	}

}
