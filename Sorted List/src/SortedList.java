import listi.EmptyCollectionException;

import javax.xml.crypto.Data;

import listi.DoublyLinkedList.Node;

public class SortedList<T extends Comparable<? super T>> {

	// Fields
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	// Constructor
	public void listSort(T data) {
		Node<T> current = head;
		Node<T> index = null;
		T temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {
				index = current.next;
				while (index != null) {
					if (current.data.compareTo(index.data) > 0) {
						temp = current.data;
						current.data = index.data;
						index.data = (T) temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	private void addToEmptyList(T data) {
		head = new Node<T>(data);
		tail = head;
		size += 1;
	}

	public void add(T data) {
		if (isEmpty()) {
			addToEmptyList(data);
		} else {
			append(data);
		}
		listSort(data);
	}

	public void prepend(T obj) {
		if (isEmpty()) {
			addToEmptyList(obj);
		} else {
			Node<T> newNode = new Node<T>(obj);
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
			size += 1;
		}
	}

	public void append(T obj) {
		if (isEmpty()) {
			addToEmptyList(obj);
		}
		Node<T> newNode = new Node<T>(obj);
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size += 1;
	}

	public T removeAt(int index) {
		if (isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty collection.");
		}
		validateIndex(index, 0, size - 1);
		if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<T> toRemove = getNode(index);
			toRemove.prev.next = toRemove.next;
			toRemove.next.prev = toRemove.prev;
			toRemove.next = null;
			toRemove.prev = null;
			size -= 1;
			return toRemove.data;
		}
	}

	public T removeFirst() {
		if (isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty collection.");
		}
		Node<T> temp = head;
		if (size == 1) {
			clear();
		} else {
			head = head.next;
			head.prev.next = null;
			head.prev = null;
			size -= 1;
		}
		return temp.data;
	}

	public T removeLast() {
		if (isEmpty()) {
			throw new EmptyCollectionException("Can't remove from an empty collection.");
		}
		Node<T> temp = tail;
		if (size == 1) {
			clear();
		} else {
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
			size -= 1;
		}
		return temp.data;
	}

	public T get(int index) {
		if (isEmpty()) {
			throw new EmptyCollectionException("Can't ''get'' from an empty collection.");
		}
		validateIndex(index, 0, size - 1);
		Node<T> temp = getNode(index);
		return temp.data;
	}

	public boolean contains(T data) {
		Node<T> temp = head;
		for (int i = 0; i < size; i++) {
			if (temp.data.equals(data)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public int find(T data) {
		Node<T> temp = head;
		for (int i = 0; i < size; i++) {
			if (temp.data.equals(data)) {
				return i;
			}
			temp = temp.next;
		}
		return 0;
	}

	public int count(T data) {
		int found = 0;
		Node<T> temp = head;
		for (int i = 0; i < size; i++) {
			if (temp.data.equals(data)) {
				found++;
			}
			temp = temp.next;
		}
		return found;
	}

	public void removeAll(SortedList<T> otherList) {
		Node<T> sortNode = head;
		Node<T> otherNode = otherList.head;
		int sortIndex = 0;
		int otherIndex = 0;
		validateIndex(sortIndex, 0, size - 1);
		validateIndex(otherIndex, 0, size - 1);
		
		while (otherIndex < otherList.size) {
			if (sortNode.data.compareTo(otherNode.data) == 0) {
				//System.out.println("Found a Match");
				//System.out.println("removing " + sortNode.data);
				removeAt(otherIndex);
				sortIndex++;
				sortNode.next = sortNode.prev;
			}
			otherIndex++;
		}
		// compare SortedList node at index to otherList node at index.
		// if compare method returns zero then run remove method on sorted list node at
		// index location.
		// if not, move index of SortedList to next node.
		// once end of SortedList is reached, move otherList index, and reset SortedList
		// index.
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("((");
		if (!isEmpty()) {
			Node<T> temp = head;
			while (temp.next != null) {
				sb.append(temp.data.toString());
				sb.append(", ");
				temp = temp.next;
			}
			sb.append(temp.data.toString());
		}
		sb.append("))");
		return sb.toString();
	}

	private void validateIndex(int index, int lowerBound, int upperBound) {

		if (!(index >= lowerBound && index <= upperBound)) {
			throw new IndexOutOfBoundsException(
					String.format("Index must be between %d and %d", lowerBound, upperBound));
		}
	}

// Your node class. You may move it to a different file but
// you will need to change this to public class Node
	public class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;

		public Node(E data) {
			this.data = data;
		}

	}

	public Node<T> getNode(int index) {
		Node<T> temp = index <= size / 2 ? head : tail;
		if (temp == head) {
			// System.out.println("going forward");
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		} else {
			// System.out.println("going backwards");
			for (int i = size - 1; i > index; i--) {
				temp = temp.prev;
			}
			return temp;
		}
	}

//	public Node<T> reverse() {
//
//		Node<T> prev = null;
//		Node<T> current = head;
//		Node<T> next = null;
//		while (current != null) {
//			next = current.next;
//			current.next = prev;
//			prev = current;
//			current = next;
//		}
//		head = prev;
//		return head;
//	}
	
	public void reverseSort(T data) {
		Node<T> current = head;
		Node<T> index = null;
		T temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {
				index = current.next;
				while (index != null) {
					if (current.data.compareTo(index.data) < 0) {
						temp = current.data;
						current.data = index.data;
						index.data = (T) temp;
					}
					index = index.next;
				}
				current = current.next;
			}
		}
	}
	
	
	public void reverse(T data) {
		reverseSort(data);
	}
	

}
