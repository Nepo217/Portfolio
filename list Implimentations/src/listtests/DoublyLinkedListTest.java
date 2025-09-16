package listtests;

import listi.DoublyLinkedList;

public class DoublyLinkedListTest {

	public static void main(String[] args) {

		DoublyLinkedList<Character> dll = new DoublyLinkedList<Character>();

		System.out.println(dll);
		dll.add(0, '0');
		dll.add(0, '1');
		dll.add(1, '2');
		dll.append('3');
		dll.prepend('4');
		dll.add(2, '5');
		dll.add(2, '6');
		dll.add(2, '7');
		dll.add(2, '8');
		dll.add(2, '9');
		dll.add(2, '0');
		System.out.println(dll);
		System.out.println(dll.get(7));
	}

}
