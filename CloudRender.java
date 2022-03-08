package ie.gmit.dip;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
/** 
 * Creates image of a word cloud using array <code>mostFrequentWords</code> created in <code>Parser</code>.
 * 
 * Prints words at x, y co-ordinates and assigns corresponding Fonts enum using seperated if statements and for loops.
 * Saves image to user specified file name in the current directory.
 * @author Hazel O'Driscoll
 * @version 1.0
 * @since 1.8
 * @see Parser
 * @see Fonts
 *
*/
public class CloudRender {
	/** 
	 * Constructor takes in Array of <code>mostFrequentWords</code> and passes it through method to generate the word cloud.
	 * @param An Array mostFrequentWords
	 * @throws Checked Exception that might occur in generating image.
	*/
	public CloudRender(Object[] mostFrequentWords) throws Exception {
		generateWordCloud(mostFrequentWords);
	}
	
	private void generateWordCloud(Object[] mostFrequentWords) {
		//Big-O Complexity: O(n) as for all simple for loops O(n) and simple if statements are O(1)
		BufferedImage image = new BufferedImage(600, 400, BufferedImage.TYPE_4BYTE_ABGR);

		Graphics graphics = image.getGraphics();
		
		//Places first element of array first
		Font firstFont = setFont(Fonts.FONT_1.getFont());
		Color firstColor = setColor(Fonts.FONT_1.getColor());
		graphics.setFont(firstFont);
		graphics.setColor(firstColor);
		graphics.drawString(mostFrequentWords[0].toString(), 260, 80);
		
		//Vertically places next 8 most frequent words to the left of image
		if (mostFrequentWords.length < 8) { // Using if statements to avoid array index being out of bounds
			for (int i = 1; i < mostFrequentWords.length; i++) {
				int x = 40;
				int y = i*50;
				Font font = setFont(Fonts.values()[i].getFont());
				Color color = setColor(Fonts.values()[i].getColor());
				graphics.setFont(font);
				graphics.setColor(color);
				graphics.drawString(mostFrequentWords[i].toString(), x, y);
			}
		}
			//Vertically places next 8 most frequent words to the left and remaining words under the first most frequent word
			else if (mostFrequentWords.length < 30) {
				for (int i = 1; i < 8; i++) {
					int x = 40;
					int y = i*50;
					Font font = setFont(Fonts.values()[i].getFont());
					Color color = setColor(Fonts.values()[i].getColor());
					graphics.setFont(font);
					graphics.setColor(color);
					graphics.drawString(mostFrequentWords[i].toString(), x, y);
				}
				for (int i = 8; i < mostFrequentWords.length; i++) {
					int x = 260 + (int) (Math.random() * 100);
					int y = i*16;
					Font font = setFont(Fonts.values()[i].getFont());
					Color color = setColor(Fonts.values()[i].getColor());
					graphics.setFont(font);
					graphics.setColor(color);
					graphics.drawString(mostFrequentWords[i].toString(), x, y);
				}
			}	
				//Does the same as above except for any words above count 25 they are placed randomly on right hand side
				else if (mostFrequentWords.length < 40) { 
					for (int i = 1; i < 8; i++) {
						int x = 40;
						int y = i*50;
						Font font = setFont(Fonts.values()[i].getFont());
						Color color = setColor(Fonts.values()[i].getColor());
						graphics.setFont(font);
						graphics.setColor(color);
						graphics.drawString(mostFrequentWords[i].toString(), x, y);
					}
					for (int i = 8; i < 25; i++) {
						int x = 260 + (int) (Math.random() * 100);
						int y = i*16;
						Font font = setFont(Fonts.values()[i].getFont());
						Color color = setColor(Fonts.values()[i].getColor());
						graphics.setFont(font);
						graphics.setColor(color);
						graphics.drawString(mostFrequentWords[i].toString(), x, y);
					}
					for (int i = 25; i < mostFrequentWords.length; i++) {
						int x = 360 + (int) (Math.random() * 200);
						int y = (int) (Math.random() * 200);
						Font font = setFont(Fonts.values()[i].getFont());
						Color color = setColor(Fonts.values()[i].getColor());
						graphics.setFont(font);
						graphics.setColor(color);
						graphics.drawString(mostFrequentWords[i].toString(), x, y);
					}
			
		} else {
			//Handles 40+ words where words after 40 are randomly placed and have same Fonts enum type
			for (int i = 1; i < 8; i++) {
				int x = 40;
				int y = i*50;
				Font font = setFont(Fonts.values()[i].getFont());
				Color color = setColor(Fonts.values()[i].getColor());
				graphics.setFont(font);
				graphics.setColor(color);
				graphics.drawString(mostFrequentWords[i].toString(), x, y);
			}
			for (int i = 8; i < 25; i++) {
				int x = 260 + (int) (Math.random() * 100);
				int y = i*16;
				Font font = setFont(Fonts.values()[i].getFont());
				Color color = setColor(Fonts.values()[i].getColor());
				graphics.setFont(font);
				graphics.setColor(color);
				graphics.drawString(mostFrequentWords[i].toString(), x, y);
			}
			for (int i = 25; i < 40; i++) {
				int x = 360 + (int) (Math.random() * 200);
				int y = (int) (Math.random() * 200);
				Font font = setFont(Fonts.values()[i].getFont());
				Color color = setColor(Fonts.values()[i].getColor());
				graphics.setFont(font);
				graphics.setColor(color);
				graphics.drawString(mostFrequentWords[i].toString(), x, y);
			}
			
			for (int i = 40; i < mostFrequentWords.length; i++) {
				int x = (int) (Math.random() * 500);
				int y = (int) (Math.random() * 400);
				Font font = setFont(Fonts.FONT_40.getFont()); 
				Color color = setColor(Fonts.FONT_40.getColor());
				graphics.setFont(font);
				graphics.setColor(color);
				graphics.drawString(mostFrequentWords[i].toString(), x, y);
			}
		}
		//Uses buffered reader to take in user input for image and saves under that name
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(ConsoleColour.BLUE_BOLD);
		System.out.println("<Enter name you wish to save file as:>");
		System.out.println(ConsoleColour.RESET);
		System.out.println("Note: Image file will be saved in current directory");
		
		try {
			String outputFilename = (reader).readLine();

			graphics.dispose();
			ImageIO.write(image, "png", new File(outputFilename + ".png"));

			System.out.println(ConsoleColour.GREEN);
			System.out.println("File saved as " + outputFilename + ".png"); // Saves file under chosen name
			System.out.println(ConsoleColour.RESET);
			
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("[ERROR SAVING FILE]");
		}
	}
	
	private Color setColor(Color color) {
	//Big-O Complexity: O(1) as simple statements
	Color colorChoice = color;
	return colorChoice;
	}

	private Font setFont(Font font) {
	//Big-O Complexity: O(1) as simple statements
	Font fontChoice = font;
	return fontChoice;
	}
}
