/*
Problem 2.5 - Cracking the Coding Interview

You have two numbers represented by a linked list, where each Node contains a single digit.
The digits are store in reverse order, such that the 1's digit is at the head of the list.
Write a function that adds the two numbers and returns the sum as a linked list.

James Earle - September 24, 2015

Example Output:
*/
public class TwoFive {

	public TwoFive(Node<Integer> h1, Node<Integer> h2) {
		add(h1, h2);
	}

	//adjust after for lists not the same length
	public Node<Integer> add(Node<Integer> h1, Node<Integer> h2) {

		// Error checking. If either are null, return the opposite as if adding 0
		if(h1 == null && h2 == null) {
			return null;
		} else if(h1 == null && h2 != null) {
			return h2;
		} else if(h1 != null && h2 == null) {
			return h1;
		}

		Node<Integer> result = new Node<Integer>(null, 0);
		Node<Integer> ptr = h1;
		Node<Integer> qtr = h2;

		int c = ptr.data + qtr.data;
		boolean carry;
		if(c >= 10) {
			result.data = c % 10;
			carry = true;
		} else {
			result.data = c;
			carry = false;
		}

		result.data = (ptr.data + qtr.data) % 10;

		System.out.println(result.data % 10);

		return h1;
	}

	public static void main(String[] args) {

		//617
		Node<Integer> h1 = new Node<Integer>(null, 7);
		h1.add(1);
		h1.add(6);
		h1.print();

		Node<Integer> h2 = new Node<Integer>(null, 5);
		h2.add(9);
		h2.add(2);
		h2.print();

		new TwoFive(h1, h2);
	}

}