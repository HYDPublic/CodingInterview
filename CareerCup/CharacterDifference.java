/*
	Given a string and  array of strings, find whether the array contains a string with one character 
	difference from the given string. Array may contain string of different lengths
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CharacterDifference {
	
	BufferedReader br;

	public CharacterDifference() {}

	public boolean contains(String str, String[] arr) {

		char[] orig = str.toCharArray();

		System.out.println(str);

		for(String s : arr) {
			int offset = 0;
			char[] next = s.toCharArray();

			int[] origCounts = countChars(orig);
			int[] nextCounts = countChars(next);

			for(int i=0;i<origCounts.length;i++) {
				offset += (nextCounts[i] - origCounts[i]);
			}

			System.out.println(s + " --- " + offset);


			// if(offset == 0) {
			// 	if(offset == (next.length - orig.length)) {
			// 	System.out.println(s + " --- " + offset);

			// 	return true;
			// }

		}

		return false;
	}

	public int[] countChars(char[] arr) {

		//ASCII charset
		int[] result = new int[128];

		for(char c : arr) {
			result[c]++;
		}

		return result;
	}

	public static void main(String[] args) {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "banana";
		String[] arr =  {
			"cdgdgd",
			"bana",
			"banaa",
			"bandba",
			"apple",
			"banaba",
			"bonanza",
			"bonamf"
		};

		System.out.println(new CharacterDifference().contains(str, arr));
	}

}