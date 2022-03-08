package ie.gmit.dip;

import java.util.Comparator;
import java.util.Map;
/** 
 * Compares and sorts the words (String) by their frequency (Integer), from highest to lowest.
 * @author Hazel O'Driscoll
 * @version 1.0
 * @since 1.8
 *
*/
public class ComparatorByValue implements Comparator<Map.Entry<String,Integer>> {
	//Big-O Complexity: O(n log n) as if statement would be O(n) and comparing would be O(log n)
    @Override
    public int compare(Map.Entry<String, Integer> word1, Map.Entry<String, Integer> word2) {
     
    	int result;
		int count1 = word1.getValue().intValue();
		int count2 = word2.getValue().intValue();
		if (count1 < count2) {
			result = 1;

		} else if (count1 > count2) {
			result = -1; //highest to lowest

		} else {
			//If equal, compare keys alphabetically
			result = word1.getKey().compareTo(word2.getKey());
		}
		return result;
    }
}