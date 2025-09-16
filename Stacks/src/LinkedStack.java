
public class LinkedStack<T> {

	private Node<T> top;
	private int size;

	public LinkedStack() {
		clear();
	}

	public T Peek() {

		if (isEmpty()) {
			throw new EmptyStackException("Unabe to peek - The stack is empty.");
		}
		return top.data;
	}

	public T pop() {

		if (isEmpty()) {
			throw new EmptyStackException("Unabe to pop - The stack is empty.");
		}

		T data = top.data;
		Node<T> temp = top;
		top = top.prev;
		temp.prev = null;
		size -= 1;
		return data;
	}

	public void push(T newData) {

		Node<T> newNode = new Node<T>();
		newNode.data = newData;

		if (!isEmpty()) {
			newNode.prev = top;
		}

		top = newNode;
		size += 1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		top = null;
		size = 0;
	}

	private class Node<E> {
		E data;
		Node<E> prev;
	}

}
