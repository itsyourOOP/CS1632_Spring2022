//TODO: Import libraries as needed
import java.util.NoSuchElementException;

public class SortedCollection {
	// TODO: Add member variables or methods as needed

	private class Node{
		int data;
		Node next;
		Node prev; 
	}

	Node head; 

	/**
	 * Adds the number n to the collection.
	 * 
	 * @param n the number to add to the collection
	 * @return always returns true
	 */
	public boolean add(int n) {
		// TODO: Implement
		Node node = new Node(); 
		node.data = n;
		node.next = null; 
		node.prev = null; 

		if(head == null)
		{
			head = node; 
		}
		else
		{
			Node cur = head; 
			while(cur.next != null) 
			{
				cur = cur.next; 
			}
			cur.next = node; 
			node.prev = cur; 
		}

		return true;
	}

	/**
	 * Removes the smallest number in the collection and returns it.
	 * If the collection is empty, throws a NoSuchElementException.
	 * 
	 * @return the smallest number in the collection
	 */
	public int remove() throws NoSuchElementException {
		// TODO: Implement
		Node cur = head; 
		Node min = head; 

		while(cur.next != null)
		{
			if(cur.data < min.data)
			{
				min = cur; 
			}

			cur = cur.next; 
		}

		if(min == head)
		{
			head = min.next; 
		}
		else
		{
			min.next.prev = min.prev; 
			min.prev.next = min.next; 
		}

		return min.data;
	}

	/**
	 * Prints usage information.
	 */
	public static void showUsage() {
		System.out.println("Usage: java SortedCollection [num1] [num2] [num3] ...");
	}

	/**
	 * Main method. Receives a list of numbers as commandline arguments and prints
	 * out the list in sorted order from smallest to largest.
	 * 
	 * @param args commandline arguments; see showUsage() for detailed information
	 */
	public static void main(String[] args) {
		SortedCollection collection = new SortedCollection();
		if (args.length == 0) {
			showUsage();
			return;
		}
		
		// TODO: add numbers in commandline arguments to collection using the add(int) method.
		// If any commandline argument is not a number, call showUsage() and return.
		for(int i = 0; i < args.length; i++)
		{
			try
			{
				int n = Integer.parseInt(args[i]); 
				collection.add(n); 
			} 
			catch (NumberFormatException ex)
			{
				showUsage(); 
				return; 
			}
		}
		
		System.out.print("sorted: ");
		for (int i = 0; i < args.length; i++) {
			int num = collection.remove();
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
