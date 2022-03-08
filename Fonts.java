package ie.gmit.dip;
import java.awt.Color;
import java.awt.Font;
/** 
 * Enumeration of constant values for fonts, including size, type and color.
 * @author Hazel O'Driscoll
 * @version 1.0
 * @since 1.8
 *
*/
public enum Fonts {
	FONT_1 (new Font(Font.SANS_SERIF, Font.ITALIC, 90), Color.red),
	FONT_2 (new Font(Font.SERIF, Font.ITALIC, 85), Color.magenta),
	FONT_3 (new Font(Font.MONOSPACED, Font.ITALIC, 80), Color.green),
	FONT_4 (new Font(Font.DIALOG, Font.ITALIC, 75), Color.blue),
	FONT_5 (new Font(Font.SANS_SERIF, Font.ITALIC, 70), Color.orange),
	FONT_6 (new Font(Font.SERIF, Font.ITALIC, 65), Color.yellow),
	FONT_7 (new Font(Font.MONOSPACED, Font.ITALIC, 60), Color.cyan),
	FONT_8 (new Font(Font.DIALOG, Font.ITALIC, 55), Color.red),
	FONT_9 (new Font(Font.SANS_SERIF, Font.ITALIC, 50), Color.magenta),
	FONT_10 (new Font(Font.SERIF, Font.ITALIC, 45), Color.green),
	FONT_11 (new Font(Font.MONOSPACED, Font.PLAIN, 40), Color.blue),
	FONT_12 (new Font(Font.DIALOG, Font.PLAIN, 35), Color.orange),
	FONT_13 (new Font(Font.SANS_SERIF, Font.PLAIN, 30), Color.yellow),
	FONT_14 (new Font(Font.SERIF, Font.PLAIN, 30), Color.cyan),
	FONT_15 (new Font(Font.MONOSPACED, Font.PLAIN, 30), Color.red),
	FONT_16 (new Font(Font.DIALOG, Font.PLAIN, 25), Color.magenta),
	FONT_17 (new Font(Font.SANS_SERIF, Font.PLAIN, 25), Color.green),
	FONT_18 (new Font(Font.SERIF, Font.PLAIN, 15), Color.blue),
	FONT_19 (new Font(Font.MONOSPACED, Font.PLAIN, 15), Color.orange),
	FONT_20 (new Font(Font.DIALOG, Font.PLAIN, 10), Color.yellow),
	FONT_21 (new Font(Font.SANS_SERIF, Font.BOLD, 10), Color.cyan),
	FONT_22 (new Font(Font.SERIF, Font.BOLD, 10), Color.red),
	FONT_23 (new Font(Font.MONOSPACED, Font.BOLD, 10), Color.magenta),
	FONT_24 (new Font(Font.DIALOG, Font.BOLD, 10), Color.green),
	FONT_25 (new Font(Font.SANS_SERIF, Font.BOLD, 10), Color.blue),
	FONT_26 (new Font(Font.SERIF, Font.BOLD, 10), Color.orange),
	FONT_27 (new Font(Font.MONOSPACED, Font.BOLD, 10), Color.yellow),
	FONT_28 (new Font(Font.DIALOG, Font.BOLD, 10), Color.cyan),
	FONT_29 (new Font(Font.SANS_SERIF, Font.BOLD, 10), Color.red),
	FONT_30 (new Font(Font.MONOSPACED, Font.BOLD, 10), Color.magenta),
	FONT_31 (new Font(Font.DIALOG, Font.BOLD, 10), Color.green),
	FONT_32 (new Font(Font.SANS_SERIF, Font.BOLD, 10), Color.blue),
	FONT_33 (new Font(Font.SERIF, Font.BOLD, 10), Color.orange),
	FONT_34 (new Font(Font.MONOSPACED, Font.BOLD, 10), Color.yellow),
	FONT_35 (new Font(Font.DIALOG, Font.BOLD, 10), Color.cyan),
	FONT_36 (new Font(Font.SANS_SERIF, Font.BOLD, 10), Color.red),
	FONT_37 (new Font(Font.MONOSPACED, Font.BOLD, 10), Color.magenta),
	FONT_38 (new Font(Font.DIALOG, Font.BOLD, 10), Color.green),
	FONT_39 (new Font(Font.SANS_SERIF, Font.BOLD, 10), Color.blue),
	FONT_40 (new Font(Font.SERIF, Font.BOLD, 8), Color.orange);
	
	
	private Font font;
	private Color color;
	private Fonts(Font font, Color color) {
		//Big-O Complexity: O(1) as simple statements
		this.font = font;
		this.color = color;
	}
	/** 
	 * Gets font  
	 * @return the font
	*/
	public Font getFont() {
		//Big-O Complexity: O(1) as simple statements
		return font;
	}
	/** 
	 * Sets font to font in parameter
	 * @param Font font
	*/
	public void setFont(Font font) {
		//Big-O Complexity: O(1) as simple statements
		this.font = font;
	}
	/** 
	 * Gets Color 
	 * @return the color
	*/
	public Color getColor() {
		//Big-O Complexity: O(1) as simple statements
		return color;
	}
	/** 
	 * Sets color to color in parameter
	 * @param Color color
	*/
	public void setColor(Color color) {
		//Big-O Complexity: O(1) as simple statements
		this.color = color;
	}
}
