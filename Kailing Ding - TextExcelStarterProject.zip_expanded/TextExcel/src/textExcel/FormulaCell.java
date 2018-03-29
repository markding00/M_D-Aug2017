package textExcel;

public class FormulaCell extends RealCell{

	public FormulaCell(String input) {
		super(input);
	}
	
	public String abbreviatedCellText() {
		String cellText = getDoubleValue() + "";
		if(cellText.length() < 10) {
			return addSpaces(cellText);
		}else {
			return cellText.substring(0,10);
		}
	}
	
	public double getDoubleValue() {
		String[] formula = getRealCell().split(" ");
		double result = Double.parseDouble(formula[1]);
		for(int i = 2; i < formula.length - 2; i += 2) {
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
		return getRealCell();
	}
	
	

}
