package textExcel;

public class ValueCell extends RealCell {

	public ValueCell(String input) {
		super(input);
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getInput());
	}
}
