/*
Problem 1.3 - Cracking the Coding Interview

Given two strings, write a method to decide if one is a permutation
of the other.

James Earle - August 27, 2015
*/
import java.io.*;
import java.util.Arrays;

public class OneThree {
	
	BufferedReader reader;

	public OneThree() {
		reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("String one: ");
			String str1 = reader.readLine();

			System.out.println("String two: ");
			String str2 = reader.readLine();

			System.out.println(isPermutation(str1.toUpperCase(), str2.toUpperCase()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isPermutation(String str1, String str2) {
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];

		if(str1.length() != str2.length()) return false;

		for(int i=0;i<str1.length();i++) {
			char c = str1.charAt(i);
			char d = str2.charAt(i);
			arr1[c-65]++;
			arr2[d-65]++;
		}

		return Arrays.equals(arr1, arr2);
	}

	public static void main(String[] args) {
		new OneThree();
	}

}