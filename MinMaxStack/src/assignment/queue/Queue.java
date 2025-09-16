package assignment.queue;

//import LinkedQueue.Node;

public class Queue<T> implements QueueADT<T> {

	private Node<T> front;
	private Node<T> back;
	
	private int size;
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		front = null;
		back = null;
		size = 0;
	}

	@Override
	public void enqueue(T newItem) {
		Node<T> newNode = new Node<T>();
		newNode.data = newItem;
		if(isEmpty()) {
			front = newNode;
			back = front;
		}else {
			back.next = newNode;
			back = newNode;
		}
		size +=1;
	}

	@Override
	public T dequeue() {
		Node<T> temp = front;
		if(size ==1) {
			clear();
		}else {
			front = front.next;
			temp.next = null;
			size -= 1;
		}
	
		return temp.data;
	}

	@Override
	public T getFront() {

		return front.data;
	}
	
	private class Node<E>{
		E data;
		Node<E> next;
	}

}
