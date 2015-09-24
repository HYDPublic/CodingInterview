/*
Problem 2.3 - Cracking the Coding Interview

Implement an algorithm to delete a node in the middle of a singly-linked list,
given only access to that node.

James Earle - September 23, 2015

Example Output: 
0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
0 -> 1 -> 2 -> 4 -> 5 -> 6
*/

public class TwoThree {

	public TwoThree(IntegerNode head) {
		head.print();
		IntegerNode toBeRemoved = head.get(3);
		head.remove(toBeRemoved);
		head.print();
	}

	//Use an internal class in this case for the list structure
	private static class IntegerNode {

		IntegerNode next;
		int data;

		private IntegerNode(IntegerNode n, int d) {
			this.next = n;
			this.data = d;
		}

		private IntegerNode get(int val) {
			IntegerNode n = this;
			while(true) {
				if(n == null) return null;
				if(n.data == val) {
					return n;
				} else {
					n = n.next;
				}
			}
		}

		private void remove(IntegerNode n) {
			if(n == null || n.next == null) return;
			n.data = n.next.data;
			IntegerNode temp = n.next.next;
			n.next = temp;
		}

		private void add(int d) {
			IntegerNode n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = new IntegerNode(null, d);
		}

		private void print() {
			IntegerNode n = this;
			while(n.next != null) {
				System.out.print(n.data + " -> ");
				n = n.next;
			}
			System.out.print(n.data + "\n");
		}
	}

	public static void main(String[] args) {

		IntegerNode head = new IntegerNode(null, 0);
		
		head.add(1);
		head.add(2);
		head.add(3);
		head.add(4);
		head.add(5);
		head.add(6);

		new TwoThree(head);
	}

}