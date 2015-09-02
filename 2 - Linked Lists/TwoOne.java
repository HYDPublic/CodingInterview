/*
Problem 2.1 - Cracking the Coding Interview

Write code to remove duplicates from an unsorted LinkedList
FOLLOWUP
How would you solve this problem if a temporary buffer is not allowed.

James Earle - September 2, 2015
*/
import java.io.*;
import java.util.LinkedList;
public class TwoOne {

	BufferedReader reader;

	public TwoOne() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<Integer>();

		try {
			System.out.print("# of elements: ");
			int n = Integer.valueOf(reader.readLine());

			System.out.println("Enter " + n + " values");
			for(int i=0;i<n;i++) {
				list.add(Integer.valueOf(reader.readLine()));
			}

			print(list);
			removeDuplicates(list);
			print(list);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	

	//Pre-followup, allowing for temp buffer
	public void removeDuplicates(LinkedList<Integer> list) {
		// Below should work, but can't we make an array of the list and increase access time in second for loop?
		// for(int i=0;i<list.length();i++) {
		// 	int val = list.get(i);
		// 	for(int j=0;j<list.length();j++) {
		// 		if(list.get(j) == val) {
		// 			list.remove(j);
		// 		}
		// 	}
		// }
	}

	public void print(LinkedList<Integer> list) {
		System.out.println("Printing list");
		for(int i : list) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		new TwoOne();
	}

}