package textExcel;

public class RealCell implements Cell{
	private String input;
	public RealCell(String input) {
		this.input = input;
	}
	@Override
	public String abbreviatedCellText() {
		return input.substring(0,10);
	}

	@Override
	public String fullCellText() {
		return input;
	}
	
	public double getDoubleValue() {
		return 0;
	}
	
	public String getInput(){
		return input;
	}
}
