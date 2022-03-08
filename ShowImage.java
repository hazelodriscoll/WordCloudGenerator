package ie.gmit.dip;

import javax.swing.JFrame;

import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*Code snippet taken and altered from 
https://www.dummies.com/article/technology/programming-web-design/java/how-to-write-java-code-to-show-an-image-on-the-screen-150767
*/
/** 
 * Uses JFrame to show user chosen word map they created and user can decide thru menu if they wish to generate another or not. 
 * Image be in current directory as per images saved in <code> CloudRender </code>.
 * @author Hazel O'Driscoll
 * @version 1.0
 * @since 1.8
 *
*/
public class ShowImage { 
	
	private static Scanner scanner = null;
	
	public ShowImage() {
		//Constructor for ShowImage
		
		scanner = new Scanner(System.in);
		System.out.println("Opening image...");
		
		JFrame frame = new JFrame();
		
		System.out.println(ConsoleColour.BLUE_BOLD);
		System.out.println("Enter name of image as saved in [1] that you wish to open, eg: imagename.png");
		System.out.println(ConsoleColour.RESET);
		
		String userInput = scanner.next();
		File file = checkFileExists(userInput);
		
		ImageIcon icon = new ImageIcon("./" + file);
		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.setDefaultCloseOperation
			(JFrame.DISPOSE_ON_CLOSE); //Allows user to continue when closing image without shutting down application
		frame.pack();
		frame.setVisible(true);
		
		System.out.println("<Image Preview Opened in New Window>");
	 }

	private File checkFileExists(String userInput) {
		//Big-O Complexity: O(n) as WhileLoop iterations depends on value f	
			File f = new File(userInput);

			while (!f.exists()) {// Added a loop so that it keeps taking input until correct file name is put in
				System.out.println(ConsoleColour.RED);
				System.out.println("[Error] Image Not Found - Please Try Again:");
				System.out.print(ConsoleColour.RESET);
				System.out.println("Note: Image name should be image saved from '[1] Parse File' in format imagename.png");
				String path = scanner.next();
				f = new File(path);
				}
			return f;
	}
}