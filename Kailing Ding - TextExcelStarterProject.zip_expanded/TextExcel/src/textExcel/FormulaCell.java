package textExcel;

public class FormulaCell extends RealCell{

	private Spreadsheet grid;
	public FormulaCell(String input, Spreadsheet grid) {
		super(input);
		this.grid = grid;
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
		double result = 0.0;
		if(Character.isLetter(formula[0].indexOf(0))) {
			result = findCell(formula[0]);
		}else {
			result = Double.parseDouble(formula[0]);
		}
		for(int i = 1; i < formula.length - 1; i += 2) {
			if(Character.isLetter(formula[i+1].indexOf(0))) {
				double num = findCell(formula[i+1]);
				if(formula[i].equals("+")) {
					result += num;
				}else if(formula[i].equals("-")) {
					result -= num;
				}else if(formula[i].equals("*")) {
					result *= num;
				}else if(formula[i].equals("/")) {
					result /= num;
				}else if(formula.length == 1){
					result = num;
				}
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
	
	public double findCell(String cell) {
		double num = 0.0;
		SpreadsheetLocation loc = new SpreadsheetLocation(cell);
		Cell realcell = grid.getCell(loc);
		if(realcell instanceof RealCell) {
			RealCell temp = (RealCell)realcell;
			num = temp.getDoubleValue();
		}
		return num;
	}
	
	@Override
	public String fullCellText() {
		return getRealCell();
	}
	

}
