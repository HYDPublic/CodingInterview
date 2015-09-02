/*
Problem 1.4 - Cracking the Coding Interview

Replace all spaces with %20, but use a char array to perform the operation in place.

e.g.
Input: "Mr John Smith   ", 13
Output: "Mr%20John%20Smith"

James Earle - August 27, 2015
*/
import java.io.*;

public class OneFour {

	BufferedReader reader;
	public OneFour() {
		char[] str = {'j', 'a', 'm', ' ', 'e', 's', 'E', ' ', ' ', ' ', ' ', ' ', ' '};
    	int size = 7;
    	
		str = replaceSpace(str, size);

		for(char c : str) {
			System.out.print(c);
		}
	}

	public char[] replaceSpace(char[] str, int size) {
		int numSpaces = 0;

		for(char c : str) {
			if (c == ' ') numSpaces++;
		}

		int newSize = size + numSpaces * 2;

		char[] newStr = new char[newSize];

		int adder = 0;
		for(int i=0;i<str.length;i++) {
			if(str[i] != ' ') {
				newStr[i + adder] = str[i];
			} else {
				if(i + adder + 2 < newStr.length) { 
					newStr[i + adder ]    = '%';
					newStr[i + adder + 1] = '2';
					newStr[i + adder + 2] = '0';
					adder += 2;
				}
			}
		}

		return newStr;
	}

	public static void main(String[] args) {
		new OneFour();
	}

}