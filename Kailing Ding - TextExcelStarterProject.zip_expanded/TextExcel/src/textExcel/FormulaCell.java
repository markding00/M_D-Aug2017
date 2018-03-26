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
		double result = 0.0;
		for(int i = 4; i < formula.length - 4; i += 4) {
			if(formula[i].equals("+")) {
				result += Double.parseDouble(formula[i-2]) + Double.parseDouble(formula[i+2]);
			}else if(formula[i].equals("-")) {
				result += Double.parseDouble(formula[i-2]) - Double.parseDouble(formula[i+2]);
			}else if(formula[i].equals("*")) {
				result += Double.parseDouble(formula[i-2]) * Double.parseDouble(formula[i+2]);
			}else if(formula[i].equals("/")) {
				result += Double.parseDouble(formula[i-2]) / Double.parseDouble(formula[i+2]);
			}else if(formula.length == 5){
				result = Double.parseDouble(formula[2]);
			}
		}
		return result;
	}

	@Override
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	
	public double[] operand() {
		String[] operandString = getRealCell().split(" ");
		double[] operand;
		for(int i = 2; i < operandString.length - 3; i += 4) {
			double num = Double.parseDouble(operandString[i]);
			
		}
		return operand;
	}

}
