/*
Problem 2.1 - Cracking the Coding Interview

Write code to remove duplicates from an unsorted LinkedList
FOLLOWUP
How would you solve this problem if a temporary buffer is not allowed.

James Earle - September 5, 2015
*/
import java.io.*;
import java.util.LinkedList;
import java.util.HashMap;

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

			print(list, "Before");
			list = removeDuplicates(list);
			print(list, "After");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	

	//No buffer, equivalent to two pointers: current and runner
	//O(n^2)
	public void removeDuplicatesNoBuffer(LinkedList<Integer> list) {
		//Below should work, but can't we make an array of the list and increase access time in second for loop?
		for(int i=0;i<list.size();i++) {
			int val = list.get(i);
			for(int j=i;j<list.size();j++) {
				if(list.get(j) == val) {
					list.remove(j);
				}
			}
		}
	}

	//Pre-followup, allowing for temp buffer
	//We can use a HashMap because they enforce uniqueness (so no duplicates)
	//O(n)
	public LinkedList<Integer> removeDuplicates(LinkedList<Integer> list) {
		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();

		for(int val : list) {
			if(!result.containsKey(val)) {
				result.put(val, val);
			}
		}

		//Return the result.values() Collection<Integer> c
		return new LinkedList<Integer>(result.values());
	}

	public void print(LinkedList<Integer> list, String msg) {
		System.out.println("\n" + msg);
		for(int i : list) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		new TwoOne();
	}

}