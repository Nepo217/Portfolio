import java.util.LinkedList;
import java.util.Queue;

public class IntegerSet<T> {

	private Node root;
	private int size;

	public IntegerSet(int array[]) {
		constructSet(array);
	}

	private void constructSet(int array[]) {

		for (int i : array) {
			add(i);
		}
	}

	public int magnitude() {
		return size;
	}

	Node insertNode(Node root, int data) {

		if (root == null) {

			root = new Node(data);

			return root;

		}
		if (data < root.data) {

			root.leftChild = insertNode(root.leftChild, data);

		} else if (data > root.data) {

			root.rightChild = insertNode(root.rightChild, data);
		}

		return root;
	}

	public void clear() {
		root = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean add(int newItem) {
		
		root = insertNode(root, newItem);
		
		return false;
	}

	public boolean remove(int itemToRemove) {
		
		if (root.data == itemToRemove && size == 1) {
			clear();
		} else {
			Node nodeToRemove = getNode(itemToRemove);
	
			if (isLeafNode(nodeToRemove)) {
				removeLeafNode(nodeToRemove);
			} else {
				Node deepestLeafNode = deepest(nodeToRemove);
				T temp = deepestLeafNode.dataT;
				deepestLeafNode.data = nodeToRemove.data;
				int intConvert = Integer.valueOf(nodeToRemove.data);
				nodeToRemove.data = intConvert;
				removeLeafNode(deepestLeafNode);
			}
			size -= 1;
		}
		return true;
	}

	private Node deepest(Node subTreeRoot) {
		Node current = subTreeRoot;
		Queue<Node> q = new LinkedList<>();

		q.add(current);

		while (!q.isEmpty()) {
			current = q.remove();
			if (current.leftChild != null) {
				q.add(current.leftChild);
			}

			if (current.rightChild != null) {
				q.add(current.rightChild);
			}
		}

		return current;
	}

	private void removeLeafNode(Node toRemove) {
		Node parent = getParent(toRemove);

		if (parent.leftChild == toRemove) {
			parent.leftChild = null;
		} else {
			parent.rightChild = null;
		}
	}

	private boolean isLeafNode(Node node) {
		return node.leftChild == null && node.rightChild == null;
	}

	private Node getParent(Node child) {
		Node current = root;
		Queue<Node> q = new LinkedList<>();

		q.add(current);

		while (true) {
			current = q.remove();
			if (current.leftChild == child || current.rightChild == child) {
				return current;
			}

			if (current.leftChild != null) {
				q.add(current.leftChild);
			}

			if (current.rightChild != null) {
				q.add(current.rightChild);
			}
		}
	}

	private Node getNode(int toGet) {
		Node current = root;
		Queue<Node> q = new LinkedList<>();

		q.add(current);

		while (!q.isEmpty()) {
			current = q.remove();

			if (current.data == toGet) {
				return current;
			}

			if (current.leftChild != null) {
				q.add(current.leftChild);
			}

			if (current.rightChild != null) {
				q.add(current.rightChild);
			}

		}

		return null;

	}


	public boolean contains(int itemToFind) {
		
		return inorderSearch(root, itemToFind);
	}

	public IntegerSet union(IntegerSet other) {
		
		int i[] = new int[0];

		IntegerSet set = new IntegerSet(i);

		treeCopy(root, set);
		treeUnion(other.root, set);

		return set;
	}

	public IntegerSet intersection(IntegerSet other) {
		
		int i[] = new int[0];

		IntegerSet set = new IntegerSet(i);
		treeIntersection(root, other, set);

		return set;
	}

	String treeIntersection(Node root, IntegerSet other, IntegerSet set){

		String data = "";

		if (root != null){

			if (other.contains(root.data)) {

				set.add(root.data);
			}

			treeIntersection(root.leftChild, other, set);
			treeIntersection(root.rightChild, other, set);
		}

		return data;
	}

	public IntegerSet difference(IntegerSet other) {
		return null;
	}

	public IntegerSet symmetricDifference(IntegerSet other) {
		return null;
	}

	public int getMin() {
		return Integer.MIN_VALUE;
	}

	public int getMax() {
		return Integer.MAX_VALUE;
	}

	String Copy(Node root, IntegerSet set){

		String data = "";

		if (root != null) {

			set.add(root.data);
			treeUnion(root.leftChild, set);
			treeUnion(root.rightChild, set);
		}

		return data;
	}

	String treeCopy(Node root, IntegerSet set){

		String data = "";

		if (root != null){

			set.add(root.data);
			treeUnion(root.leftChild, set);
			treeUnion(root.rightChild, set);
		}

		return data;
	}

	String treeUnion(Node root, IntegerSet set){

		String data = "";

		if (root != null){

			if (!set.contains(root.data)) {

				set.add(root.data);
			}

			treeUnion(root.leftChild, set);
			treeUnion(root.rightChild, set);
		}

		return data;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append('(');
		constructInOrderString(sb);
		sb.append(')');

		return sb.toString();
	}

	private void constructInOrderString(StringBuilder sb) {

		inorderRec(root, sb);
	}

	boolean inorderSearch(Node root, int key){

		if (root != null){

			if (key == root.data) {

				return true;
			}

			return inorderSearch(root.rightChild, key) || inorderSearch(root.leftChild, key);
		}
		
		return false;
	}

	String inorderRec(Node root, StringBuilder sb){

		String data = "";

		if (root != null){

			inorderRec(root.leftChild, sb);
			sb.append(root.data + " ");
			inorderRec(root.rightChild, sb);
		}
		
		return data;
	}

	// You may add any methods or constructors
	// to this class that you see fit.
	private class Node {
		private int data;
		private T dataT;

		private Node leftChild;
		private Node rightChild;
		

		public Node(int data) {
			this.data = data;
		}
	}

}