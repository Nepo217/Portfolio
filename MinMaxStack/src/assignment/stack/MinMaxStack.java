package assignment.stack;

//import LinkedStack.Node;
import common.EmptyCollectionException;

public class MinMaxStack <T extends Comparable<? super T>> implements StackADT<T> {
	
	private Node<T> top;
	private int size;
	
	
	public T getMin() {	
		
		if (isEmpty()) {
			throw new EmptyCollectionException("Unabe to getMin - The stack is empty.");
		}
		
		int i = 0;
		Node<T> min = top; 
		Node<T> tempPointer = top;
		
		while(i < size) {
			
			if(tempPointer.data.compareTo(min.data) < 0){

				min = tempPointer;			
			}
								
			tempPointer = tempPointer.prev;
			i++;	
		}
	
		return min.data;
	}
	
	public T getMax() {
		
		if (isEmpty()) {
			throw new EmptyCollectionException("Unabe to getMax - The stack is empty.");
		}
					
		int i = 0;
		Node<T> max = top; 
		Node<T> tempPointer = top;
		
		while(i < size) {
			
			if(tempPointer.data.compareTo(max.data) > 0){

				max = tempPointer;			
			}
								
			tempPointer = tempPointer.prev;
			i++;	
		}
	
		return max.data;
	}
	
	@Override
	public T pop() {

		if (isEmpty()) {
			throw new EmptyCollectionException("Unabe to pop - The stack is empty.");
		}

		T data = top.data;
		Node<T> temp = top;
		top = top.prev;
		temp.prev = null;
		size -= 1;
		return data;
		
	}

	@Override
	public T peek() {
		
		if (isEmpty()) {
			throw new EmptyCollectionException("Unabe to peek - The stack is empty.");
		}
		return top.data;
	}

	@Override
	public void push(T newItem) {
		
		Node<T> newNode = new Node<T>();
		newNode.data = newItem;

		if (!isEmpty()) {
			newNode.prev = top;
		}

		top = newNode;
		size += 1;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {
		top = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
		
	}
	
	private class Node<E> {
		E data;
		Node<E> prev;
	}
}
