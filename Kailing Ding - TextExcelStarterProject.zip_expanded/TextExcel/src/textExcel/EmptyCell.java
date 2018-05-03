//Mark Ding
//Ms. Dreyer
//APCS1
package textExcel;

public class EmptyCell implements Cell{

	@Override
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return "          ";
	}

	@Override
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return "";
	}

}
