/*
Problem 1.8 - Cracking the Coding Interview

Assume you have a method isSubstring which checks if one word is a substring of another. 
Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
call to isSubstring (e.g. "waterbottle" is a rotation of "erbottlewat")

James Earle - September 2, 2015
*/
public class OneEight {

	public OneEight() {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";

		System.out.println(isRotation(s1, s2));

	}

	//Big-Oh of this algorithm is restricted by efficiency of isSubstring.
	public boolean isRotation(String s1, s2) {
		if(s1.length() == s2.length() && !s1.isEmpty()) {
			String str = s2 + s2;
			return isSubstring(s1, str);
		}
		return false;	
	}

	public boolean isSubstring(String s1, String s2) {/*Black box method*/}

	public static void main(String[] args) {
		new OneEight();
	}

}