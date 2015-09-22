//Reverse strings but maintain individual space locations

import java.lang.StringBuffer;
import java.util.Stack;
import java.util.LinkedList;

public class ReverseString {

	public ReverseString(String str) {

		System.out.println(reverse(str));
	}

	//Best solution, iterate less than one full time just swap characters. 
	public static void reverse2(String str) {
		int len = str.length();
		char arr[] = str.toCharArray();

		for(int i=0, j = len-1; i<=j; i++,j--){
			if(arr[i] == ' ') i++;
			if(arr[j] == ' ') j--;

			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;

		}
		System.out.println(arr);
	}

	//Time: O(2n) = O(n)
	//Space: O(3n) = O(n) (for the bool array, buffer, and stack sizes)
	public String reverse(String str) {
		boolean[] arr = new boolean[str.length()];
		StringBuffer buffer = new StringBuffer();
		Stack<Character> myStack = new Stack<Character>();

		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);	
			arr[i] = c == ' ';
			if(!arr[i]) myStack.push(c);
		}

		for(int i=0;i<str.length();i++) {
			if(arr[i]) {
				buffer.append(' ');
			} else {
				if(!myStack.empty()) {
					buffer.append(myStack.pop());
				}
			}
		}
		return buffer.toString();
	}


	public static void main(String[] args) {
		String value = "I am the machine";

		new ReverseString(value);
	}

}