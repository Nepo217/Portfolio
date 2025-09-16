public class IntegerSetTest {

	public static void main(String[] args) {
		
		IntegerSet tree1 = new IntegerSet(new int[] { 1, 4, 3, 2 });
		IntegerSet tree2 = new IntegerSet(new int[] { 7, 8, 3, 1 });

		System.out.println("Tree 1 : " + tree1.toString());
		System.out.println("Tree 2 : " + tree2.toString());
		System.out.println();

		System.out.println("** Testing Contains Method **");
		System.out.println("Tree 1.contains(3) : " + tree1.contains(3));
		System.out.println("Tree 1.contains(6) : " + tree1.contains(6));
		System.out.println();

		System.out.println("** Testing Union Method **");
		System.out.println("Union : " + tree1.union(tree2));
		System.out.println();

		System.out.println("** Testing Intersection Method **");
		System.out.println("Intersection : " + tree1.intersection(tree2));
		System.out.println();
		
		System.out.println("** Testing Remove Method **");
		System.out.println("Tree 1 : " + tree1.toString());
		System.out.println("Remove 2");
		System.out.println(tree1.remove(1));
		System.out.println("Tree 1 : " + tree1.toString());

	}

}
