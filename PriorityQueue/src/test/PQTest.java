package test;

import ds.priorityQueue.HeapPQ;
import ds.priorityQueue.PriorityType;

public class PQTest {

	public static void main(String[] args) {
		HeapPQ<Integer> pq = new HeapPQ<>(PriorityType.MAX);
		
		pq.add(10, 100);
		pq.add(5, 110);
		pq.add(15, 105);
		pq.add(20, 150);
		pq.add(25, 103);
		pq.add(2, 100);
		System.out.println(pq);
		
	

	}

}
