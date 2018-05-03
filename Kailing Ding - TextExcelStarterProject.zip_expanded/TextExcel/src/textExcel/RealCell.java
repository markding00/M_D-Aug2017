package textExcel;

//Mark Ding
//Ms. Dreyer
//APCS1
//This class is a superclass which has two subclasses(valueCell and percentCell), and it provides some abstract method for its subclasses.
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
	
	public String addSpaces(String text) {
		//if the input.length() is under 10, add spaces
		while(text.length() < 10) {
			text += " ";
		}
		return text;
	}
}
