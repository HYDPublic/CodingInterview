/*
Problem 2.4 - Cracking the Coding Interview

Implement an algorithm to partition a linked list around a value x, such that
all nodes less than x come before all nodes greater than or equal to x.

James Earle - September 23, 2015

Example Output:
*/

public class TwoFour {
	
	public TwoFour(Node<Integer> head) {
		head.print();
		head = partition(head, 7);
		head.print();
	}

	public Node<Integer> partition(Node<Integer> node, int x) {

		if(node == null || node.next == null) return null;

		Node<Integer> head = node, 
					  tail = node;

		while(node != null) {
			Node<Integer> next = node.next;
			if(node.data < x) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;

	}

	public static void main (String[] args) {
		Node<Integer> head = new Node<Integer>(null, 0);
		head.add(3);
		head.add(1);
		head.add(5);
		head.add(12);
		head.add(7);
		head.add(15);
		head.add(2);
		head.add(4);

		new TwoFour(head);
	}

}