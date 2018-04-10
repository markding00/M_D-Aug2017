package textExcel;

public class FormulaCell extends RealCell{

	private Cell[][] grid;
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
		String noParenthesis = getRealCell().substring(2, getRealCell().length() - 2);
		String[] formula = noParenthesis.split(" ");
		double result = Double.parseDouble(formula[0]);
		for(int i = 1; i < formula.length - 1; i += 2) {
			if(formula[i+1].matches(".*[a-zA-Z]).*")) {
				
			}
			if(formula[i].equals("+")) {
				result += Double.parseDouble(formula[i+1]);
			}else if(formula[i].equals("-")) {
				result -= Double.parseDouble(formula[i+1]);
			}else if(formula[i].equals("*")) {
				result *= Double.parseDouble(formula[i+1]);
			}else if(formula[i].equals("/")) {
				result /= Double.parseDouble(formula[i+1]);
			}else if(formula.length == 1){
				result = Double.parseDouble(formula[0]);
			}
		}
		return result;
	}

	@Override
	public String fullCellText() {
		return getRealCell();
	}
	

}
