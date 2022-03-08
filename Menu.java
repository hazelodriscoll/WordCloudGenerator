package ie.gmit.dip;

import java.util.Scanner;

/** 
 * Initializes main menu of options and processes user choice.
 * @author Hazel O'Driscoll
 * @version 1.0
 * @since 1.8
 *
*/
public class Menu {

	private Scanner scanner = null;
	private boolean keepRunning = true; // Used to give option to shut down the application/menu process
	/** 
	 * Constructor for Menu shows user options and processes that choice.
	 * @throws Checked Exception that might occur in generating image.
	*/
	public Menu() throws Exception {
		scanner = new Scanner(System.in);
		initialiseMenu();

		do {
			processMenuChoice();
		} while (keepRunning == true);
	}
	/** 
	 * Prints main menu and corresponding options.
	*/
	public void initialiseMenu() { 
		//Big-O Complexity: O(1) as all simple statements

		System.out.println(ConsoleColour.BLUE_BOLD);
		System.out.println(" ___________________________________________________");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics   *");
		System.out.println("*                                                   *");
		System.out.println("*           Word Cloud Generator V0.1               *");
		System.out.println("*     H.Dip in Science (Software Development)       *");
		System.out.println("*               Hazel O'Driscoll                    *");
		System.out.println("*___________________________________________________*");

		System.out.println("\n[1] Generate WordCloud"); // Ask user to specify the file to process.
		System.out.println("[2] Open WordCloud"); // Look at code to open file generated
		System.out.println("[3] Quit"); // Terminate
		System.out.println(ConsoleColour.RESET);
		System.out.print(ConsoleColour.BLACK_BOLD);

	}
	/** 
	 * Process user choice using switch statement.  
	 * @throws Exception unless <code> NumberFormatException </code> in which case an error message is printed and menu resets.
	*/
	public void processMenuChoice() throws Exception {
		//Big-O Complexity: O(n) due to Switch Statement
		try {
			String input = scanner.next();
			int choice = Integer.parseInt(input);

			switch (choice) {
			case 1 -> { // Accesses class Parser which will take the name of the file
				try {
					new Parser();
				} catch (Exception e) {
					System.out.println(e);
				}

				System.out.println("<Returning Main Menu> Choose from Options [1-3]:");
			}
			case 2 -> { // Accesses ShowImage to allow user to print image to screen.
				new ShowImage();
				System.out.println("<Returning Main Menu> Choose from Options [1-3]:");
			}
			case 3 -> { // Closes application
				keepRunning = false;
				System.out.println("Terminating...");
				System.out.println(ConsoleColour.PURPLE_UNDERLINED);
				System.out.println("*[APPLICATION TERMINATED]*");// Option to quit out of application
				System.out.println(ConsoleColour.RESET);
			}
			default -> {// Looks at exceptions if user enters int outside the range [1-3]
				System.out.println(ConsoleColour.RED);
				System.out.println("[ERROR]: <Invalid Number: Please select option using specified numbers [1-3]>");
				System.out.println(ConsoleColour.RESET);
			}
			} // End of switch statement
		} // End of try block
		catch (NumberFormatException e) { // Catches exceptions for invalid character inputs
			System.out.println(ConsoleColour.RED);
			System.out.println(
					"[ERROR]: <Invalid Character Input> Restarting Initial Menu: Please used numbers specfied for each menu.>");
			System.out.println(ConsoleColour.RESET);
			processMenuChoice(); // Resets to original menu and reminds user they need to have the correct input
		}
	} // End of method

}
