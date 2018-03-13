package textExcel;

public class TextCell implements Cell{
	private String word;
	public TextCell(String word) {
		this.word = word;
	}
	@Override
	public String abbreviatedCellText() {
		return word.substring(0,9);
	}

	@Override
	public String fullCellText() {
		return ("\""+ word + "\"");
	}
	

}
