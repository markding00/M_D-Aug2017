package textExcel;

public class FormulaCell extends RealCell{

	public FormulaCell(String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {
		String cellText = getDoubleValue() + "";
		if(cellText.length() < 10) {
			addSpaces(cellText);
		}else {
			cellText = cellText.substring(0,10);
		}
		return cellText;
	}
	
	public double getDoubleValue() {
		String[] formula = getRealCell().split(" ");
		double result = Double.parseDouble(formula[1]);
		for(int i = 2; i < formula.length - 3; i += 2) {
			if(formula[i].equals("+")) {
				result += Double.parseDouble(formula[i+1]);
			}else if(formula[i].equals("-")) {
				result -= Double.parseDouble(formula[i+1]);
			}else if(formula[i].equals("*")) {
				result *= Double.parseDouble(formula[i+1]);
			}else if(formula[i].equals("/")) {
				result /= Double.parseDouble(formula[i+1]);
			}else if(formula.length == 3){
				result = Double.parseDouble(formula[1]);
			}
		}
		return result;
	}

	@Override
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	
	

}
