/*
Problem 1.5 - Cracking the Coding Interview

Write a method to implement string compression using counts of repeated characters. 
If the original string is shorter than the compressed string, return the original.

e.g.
Input: "aabcccccaaa" 
Output: "a2b1c5a3"

James Earle - August 29, 2015
*/
import java.io.*;
import java.util.LinkedList;

public class OneFive {

	BufferedReader reader;

	public OneFive() {
		reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Enter a string: ");
			String input = reader.readLine();

			input = compress(input);

			System.out.println("Compressed version: ");
			System.out.println(input);
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

	public String compress(String str) {
		char[] newStr = str.toCharArray();
		String result = "";

		//The previous character, so we take first values before loop.
		char last = newStr[0];
		int ctr = 1;

		//We will append values to result.
		result += last;

		for(int i=1;i<newStr.length;i++) {
			if(newStr[i] == last) {
				ctr++;
			} else {
				result += String.valueOf(ctr);
				ctr = 1;
				last = newStr[i];
				result += last;
			}

			if(i+1 == newStr.length) result += String.valueOf(ctr);
		}

		return result.length() >= str.length() ? str : result;
	}

	public static void main(String[] args) {
		new OneFive();
	}

}