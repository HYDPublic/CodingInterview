// Node Class
public class Node<T> {
	
	Node<T> next;
	T data;

	public Node(Node<T> n, T d) {
		this.next = n;
		this.data = d;
	} 

	public void add(Node<T> d) {
		Node<T> n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = d;
	}

	public void add(T d) {
		Node<T> n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = new Node<T>(null, d);
	}

	public void print() {
		Node<T> n = this;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.print(n.data + "\n");
	}

}