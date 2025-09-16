package test;

import datastructures.bst.BinarySearchTree;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		bst.add(1);
		bst.add(25);
		bst.add(75);
		bst.add(60);
		bst.add(85);
		bst.add(80);
		bst.add(95);

		
		System.out.println(bst.levelOrderToString());
		
		bst.remove(50);
		System.out.println(bst.levelOrderToString());
		
	}

}
