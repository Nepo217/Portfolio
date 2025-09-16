package assignment.queue;

import common.CollectionADT;

public interface QueueADT<T> extends CollectionADT {
	public void enqueue(T newItem);
	public T dequeue();
	//Returns the item at the front of the queue
	public T getFront();
}
