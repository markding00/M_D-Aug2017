//Mark Ding
//Ms. Dreyer
//APCS1
//This class has the ability to change the forms of a formula cell and calculate the formula cell(sum, avg, etc).
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
		String modified = getRealCell().substring(2, getRealCell().length()-2);
		String[] arr = modified.split(" ");
		double result;
		if(arr[0].toLowerCase().equals("sum")) {
			result = sum(arr[1].toLowerCase());
		}else if(arr[0].toLowerCase().equals("avg")) {
			result = avg(arr[1].toLowerCase());
		}else{
			result = getCellVal(arr[0]);
		}

		if(!(arr.length == 1)) {	
			for(int i = 1; i < arr.length; i+=2) {
				if(arr[i].equals("+")){
					result += getCellVal(arr[i+1]);
				}else if(arr[i].equals("-")) {
					result -= getCellVal(arr[i+1]);
				}else if(arr[i].equals("*")){
					result *= getCellVal(arr[i+1]);
				}else if(arr[i].equals("/")){
					result /= getCellVal(arr[i+1]);
				}
			}
		}
		return result;
	}

	public double getCellVal(String ele) {
		if(!(Character.isDigit(ele.charAt(0))) && !(ele.charAt(0) == '-')){
			RealCell a = (RealCell) grid.getCell(new SpreadsheetLocation(ele));
			return a.getDoubleValue();
		}else {
			return Double.parseDouble(ele);
		}	
	}

	public double sum(String expression) {//a1-c10
		String[] operands = expression.toLowerCase().split("-");
		int startNum = Integer.parseInt(operands[0].substring(1));
		int endNum = Integer.parseInt(operands[1].substring(1));
		char startChar = operands[0].charAt(0);
		char endChar = operands[1].charAt(0);
		double sum = 0;
		for(char i = startChar; i <= endChar; i++) {
			for(int j = startNum; j <= endNum; j++) {
				SpreadsheetLocation loc = new SpreadsheetLocation("" + i + j);

				if(grid.getCell(loc) instanceof RealCell) {
					RealCell temp = (RealCell)(grid.getCell(loc));
					sum += temp.getDoubleValue();
				}
			}
		}
		return sum;
	}

	public double avg(String expression) {
		String[] operands = expression.split("-");
		int startNum = Integer.parseInt(operands[0].substring(1));
		int endNum = Integer.parseInt(operands[1].substring(1));
		char startChar = operands[0].charAt(0);
		char endChar = operands[1].charAt(0);
		double s = sum(expression);
		int totalCol = (endChar - startChar) + 1;
		int totalRow = (endNum - startNum) + 1;
		return s/(totalCol * totalRow);
	}




	@Override
	public String fullCellText() {
		return getRealCell();
	}


}
