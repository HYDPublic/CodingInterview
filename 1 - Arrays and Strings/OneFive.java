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
import java.lang.StringBuffer;

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
		StringBuffer result = new StringBuffer();

		//Don't bother compressing if the length is more than the string itself
		if(compressionLength(str) >= str.length()) return str;

		//The previous character, so we take first values before loop.
		char last = newStr[0];
		int ctr = 1;

		//We will append values to result.
		result.append(last);

		for(int i=1;i<newStr.length;i++) {
			if(newStr[i] == last) {
				ctr++;
			} else {
				last = newStr[i];
				result.append(String.valueOf(ctr) + last);
				ctr = 1;
			}

			if(i+1 == newStr.length) result.append(String.valueOf(ctr));
		}

		return result.toString();
	}

	public int compressionLength(String str) {
		int result = 0;

		if(str.isEmpty() || str == null) return result;

		char[] newStr = str.toCharArray();
		char last = newStr[0];
		int ctr = 1, overallCount = 0;

		for(int i=1;i<str.length();i++) {
			if(newStr[i] == last) {
				ctr++;
			} else {
				last = newStr[i];
				//Use .length() below for multiple digit numbers.
				overallCount += 1 + String.valueOf(ctr).length();
				ctr = 1;
			}
		}

		return overallCount;
	}

	public static void main(String[] args) {
		new OneFive();
	}

}