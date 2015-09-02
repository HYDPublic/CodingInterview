/*
Problem 1.1 - Cracking the Coding Interview

Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?

James Earle - August 26, 2015
*/
import java.io.*;

public class OneOne {
	
	public static final int ASCIIOFFSET = 65;
	BufferedReader reader;

	public OneOne() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = reader.readLine();
			System.out.println(hasUniqueChars(input.toUpperCase()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public boolean hasUniqueChars(String input) {
		int[] arr = new int[26];
		String[] words = input.split(" ");

		for(String s : words) {
			for(int i=0;i<s.length();i++) {
				arr[s.charAt(i) - ASCIIOFFSET]++;
				if(arr[s.charAt(i) - ASCIIOFFSET] > 1) {
					System.out.println(s.charAt(i));
					return false;
				}	
			}
		}

		return true;

	}

	public static void main(String[] args) {
		new OneOne();
	}

}