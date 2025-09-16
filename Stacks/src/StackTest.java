
public class StackTest {

	public static void main(String[] args) {
		LinkedStack<String> stringStack = new LinkedStack<>();
		
		stringStack.push("A");
		stringStack.push("B");
		stringStack.push("C");
		
		while(!stringStack.isEmpty()) {
			System.out.println(stringStack.Peek());
			stringStack.pop();
		}
		
//		System.out.println("Testing pop error");
//		stringStack.pop();
//		
//		System.out.println("Testing peek error");
//		stringStack.Peek();
	}

}
