/*
Problem 2.2 - Cracking the Coding Interview

Implement an algorithm to find the kth to last element in a single linked list.

Using recursive approaches, solutions are O(n)

James Earle - September 5, 2015
*/
import java.io.*;
import java.util.LinkedList;

public class TwoTwo {
	
	BufferedReader reader;

	public TwoTwo() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		
		Node<Integer> head = new Node<Integer>(1);
		for(int i=0;i<15;i++) {
			head.add(i + (int)(Math.random() * 15));
		}

		head.print();

		try {
			System.out.print("k: ");
			int k = Integer.valueOf(reader.readLine());

			Node kth = kthLastRecursive2(head, k, new CounterWrapper());
			System.out.println(kth.data);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	//To be used the in second recursive approach granted by the book.
	private class CounterWrapper {
		int counter = 0;
	}

	//Uses an internal class CounterWrapper to track the value externally from the recursion, as suggested by the book.
	public Node kthLastRecursive2(Node n, int k, CounterWrapper cw) {
		if(n == null) return n;
		
		Node m = kthLastRecursive2(n.next, k, cw);

		cw.counter++;
		if(cw.counter == k) return n;
		return m;
	}

	//Solves passing of values by simply printing the relevant data
	public int kthLastRecursive(Node n, int k, int ctr) {
		if(n == null) return 0;

		ctr = kthLastRecursive(n.next, k, ctr) + 1;

		if(ctr == k) {
			System.out.println(n.data);
		}
		return ctr;
	}

	//Using the list object size is known, and it's O(1) so assume size is unknown as this is trivial
	public int kthLast(LinkedList<Integer> list, int k) {
		return list.get(list.size() - k);
	}

	//min and max capacity of the list.
	public LinkedList<Integer> generateList(int min, int max) {
		LinkedList<Integer> result = new LinkedList<Integer>();

		int size = min + (int)(Math.random() * max);
		for(int i=0;i<size;i++) {
			result.add((int)(Math.random() * 100));
		}

		return result;
	}

	private class Node<T> {

		Node next;
		T data;

		private Node(T t) {
			data = t;
			next = null;
		}

		private void add(T t) {
			Node n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = new Node<T>(t);
		}

		private void print() {
			Node n = this;
			while(n != null) {
				System.out.print(n.data + " ");
				n = n.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new TwoTwo();
	}

}