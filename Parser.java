package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/**
 * Parses and sorts words from user chosen file into end Arraylist. 
 * 
 * Creates a new menu to allow choice between using text or URL file or to go back to Main Menu.
 * Takes in list of words as Strings from input file and converts to a HashMap. 
 * Takes in separate set of Strings of common words <code>stopwords</code> to ignore in text, e.g. "he" "the" "then". 
 * Removes <code>stopwords</code> from created HashMap and sorts words based on their frequency, using a comparator.
 * Creates an <code>ArrayList</code> of user specified size; of the most frequent words to be used in the word cloud.
 * 
 * @author Hazel O'Driscoll
 * @version 1.0
 * @since 1.8
 * @throws Exception 
 *
*/

/** 
 * Constructor creates instance variables needed to carry out program and gets the stopwords set.
 * Initialises a new parser menu and processes user choice.
*/
public class Parser {

	private static Scanner scanner = null;
	private boolean keepRunning = true;

	private Set<String> stopwords = new TreeSet<>();
	private Map<String, Integer> wordMap = new HashMap<>();

	public Parser() throws Exception {
		
		scanner = new Scanner(System.in);
		getStopwords();
		System.out.println("[Words to ignore have been processed]");
		initialiseMenu();
		do {
			processMenuChoice();
		} while (keepRunning == true);
	}

	private Set<String> getStopwords() throws IOException {
		//Get list of words to ignore from word cloud.
		//Big-O Complexity: O(n log n) as adding/searching Treeset is O(log n), and while loop/buffered reader is O(n)
		File file = new File("./ignorewords.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = br.readLine()) != null) {
			String[] words = line.split(" ");
			for (String s : words) {
				stopwords.add(s);
			}
		}
		br.close();
		return stopwords;
	}

	
	private void parseURLFile() throws IOException {
		//Parses URL File into TreeSet
		//Big-O Complexity: O(n) as while loop is O(n)
		System.out.println(ConsoleColour.BLUE_BOLD);
		System.out.println("[Please enter URL:]");
		System.out.println(ConsoleColour.RESET);
		
		String filename = scanner.next();
		URL url = new URL(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String line = null;

		while ((line = br.readLine()) != null) {

			String[] words = line.split(" ");
			for (String s : words) {
				s = s.replaceAll("[^a-zA-Z]", "").toLowerCase(); // working now
				if (!stopwords.contains(s))
					addToMap(s);
			}
		}
		br.close();
	}
	
	private void parseFile() throws Exception {
		//Big-O Complexity: As while loop is O(n)
		System.out.println(ConsoleColour.BLUE_BOLD);
		System.out.println("[Please enter filepath of the text you wish to use:]");
		System.out.println(ConsoleColour.RESET);
		String userPath = scanner.next();
		File file = checkFileExists(userPath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line = null;

		while ((line = br.readLine()) != null) {

			String[] words = line.split(" ");
			for (String s : words) {
				s = s.replaceAll("[^a-zA-Z]", "").toLowerCase(); //Removes anything that isn't in specified range
				if (!stopwords.contains(s))
					addToMap(s);
			}
		}
		br.close();
	}

	private void addToMap(String s) {
		//Add words to wordMap as String value and stores their frequency as the Integer value.
		//Big-O Complexity: O(1) as if statement and key based operations of HashMaps are done in O(1)
		int frequency = 1;
		if (wordMap.containsKey(s)) {
			frequency += wordMap.get(s);
		}
		wordMap.put(s, frequency);
	}

	private Object[] processWordMap() { // Sorts words using compartor into decending value
		//Big-O Complexity: O(n) as multiple statements are O(n) such as for each loop, and Arrays.copyOfRange
		Set<Entry<String, Integer>> entries = wordMap.entrySet(); // not yet sorted
		Set<Entry<String, Integer>> temp = new TreeSet<>(new ComparatorByValue());
		temp.addAll(entries);

		Set<String> wordsOnly = new LinkedHashSet<>(); // LinkedHashSet to keep order obtained from TreeSet Comparator

		for (Entry<String, Integer> entry : temp) {
			String words = entry.getKey();
			wordsOnly.add(words);
			// No need to show frequency on map so creating new set with ordered words only
		}
		System.out.println(ConsoleColour.BLUE_BOLD);
		System.out.println("Please Enter Max Number of Words:");
		System.out.println(ConsoleColour.RESET);
		String input = scanner.next();
		int MIN_WORDS = 1; //Skips blank space
		int MAX_WORDS = Integer.parseInt(input) + 1; //+1 to allow for correct amount of words output, avoid indexoutofbounds exceptions

		Object[] wordArray = wordsOnly.toArray(new Object[wordsOnly.size()]);
		Object[] mostFrequentWords = Arrays.copyOfRange(wordArray, MIN_WORDS, MAX_WORDS);
		
		return mostFrequentWords;
	}
	
	private File checkFileExists(String userPath) { // Checks that file name entered by user exists
		//Big-O Complexity: O(n) as WhileLoop iterations depends on value f		
		File f = new File(userPath);

		while (!f.exists()) {// Added a loop so that it keeps taking input until correct file name is put in
			System.out.println(ConsoleColour.RED);
			System.out.println("[Error] Invalid File Name - Please try again:");
			System.out.print(ConsoleColour.RESET);
			String path = scanner.next();
			f = new File(path);
		}
		return f;
	}
	/** 
	 * Prints Parser menu and corresponding options.
	*/
	public void initialiseMenu() {
		//Big-O Complexity: O(1) as all simple statements
		System.out.println(ConsoleColour.BLUE_BOLD);
		System.out.println("[Please enter choice between options <1-3> ]");
		System.out.println(ConsoleColour.RESET);
		System.out.println("[1] Retrieve Text File From Path");
		System.out.println("[2] Retrieve File From URL");
		System.out.println("[3] Go Back");
	}
	/** 
	 * Process user choice using switch statement.
	 * @throws Exception unless <code> NumberFormatException </code> in which case an error message is printed and menu resets.
	*/
	public void processMenuChoice() throws Exception {
		//Big-O Complexity: O(n) due to Switch Statement
		try {
			String userInput = scanner.next();
			int userChoice = Integer.parseInt(userInput);

			switch (userChoice) {
			case 1 -> {
				System.out.println("[[Retrieve Text From Path]]");
				parseFile();
				Object[] mostFrequentWords = processWordMap();
				new CloudRender(mostFrequentWords);
				keepRunning = false;
			}
			case 2 -> {
				System.out.println("[[Retrieve File From URL]]");
				parseURLFile();
				Object[] mostFrequentWords = processWordMap();
				new CloudRender(mostFrequentWords);
				keepRunning = false; // No need to bring up Menu again
			}

			case 3 -> {
				keepRunning = false;
				System.out.println("<<Initialising Main Menu>>"); // Option to quit out of application
			}
			default -> { // Look at exceptions to handle if user enters anything that is not an int
				System.out.println(ConsoleColour.RED);
				System.out.println(
						"\n[ERROR]: <Invalid Number: Please select option using specified numbers [1-3]>");
				System.out.println(ConsoleColour.RESET);
				processMenuChoice(); // Resets menu and reminds user they need to have the correct input method
			}
			} // End of switch statement
		} // End of try block
		catch (NumberFormatException e) {
			System.out.println(ConsoleColour.RED);
			System.out.println(
					"\n[ERROR]: <Invalid Character Input> Restarting Parser Menu>");
			System.out.println(ConsoleColour.RESET);
			processMenuChoice(); // Resets menu and reminds user they need to have the correct input method
		}
	}

}