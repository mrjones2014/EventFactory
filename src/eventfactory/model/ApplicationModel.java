package eventfactory.model;

public class ApplicationModel {
	private String[] colorScheme;
	private Occasion occasion;
	
	public ApplicationModel(String primaryColor, String secondaryColor, String accentColor, Occasion occasion){
		this.occasion = occasion;
		colorScheme = new String[3];
		colorScheme[0] = primaryColor;
		colorScheme[1] = secondaryColor;
		colorScheme[2] = accentColor;
	}
	
	public ApplicationModel(String[] colorScheme, Occasion occasion){
		if(colorScheme.length > 3) throw new UnsupportedOperationException("Maximum of 3 colors can be defined for color scheme.\n");
		System.arraycopy(colorScheme, 0, this.colorScheme, 0, 3);
		this.occasion = occasion;
	}
	
	
}
