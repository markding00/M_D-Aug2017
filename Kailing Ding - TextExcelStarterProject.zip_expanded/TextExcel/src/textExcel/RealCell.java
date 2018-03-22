package textExcel;

public abstract class RealCell implements Cell{
	private String input;
	public RealCell(String input) {
		this.input = input;
	}
	@Override
	public abstract String abbreviatedCellText();

	@Override
	public abstract String fullCellText();
	
	public abstract double getDoubleValue();
	
	public String getRealCell(){
		return input;
	}
	
	public String addSpaces(String hold) {
		//if the input.length() is under 10, add spaces
		while(hold.length() < 10) {
			hold += " ";
		}
		return hold;
	}
}
