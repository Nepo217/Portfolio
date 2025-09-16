package assignment.stack;

import common.CollectionADT;

public interface StackADT<T> extends CollectionADT {
	public T pop();
	public T peek();
	public void push(T newItem);
	public boolean isEmpty();
}
