package intlist;

import java.util.Arrays;

class Node {
	int value;
	Node next;
}
/** 
 * Each instance of this class stores a list of integers.
 */

public class IntList {
	
	private Node firstNode;

	public int getSize() {
		int count = 0;
		Node node = firstNode;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
	/** 
	 * @pre The given index is between 0 and one less than the size of the list.
	 * 		| index > 0 && index < getSize() - 1
	 */
	public int get(int index) {
		Node node = firstNode;
		for (int i = 0; i < index; i++)
			node = node.next;
		return node.value;
	}
	
	public int[] getElements() {
		int[] result = new int[getSize()];
		Node node = firstNode;
		for (int i = 0; i < result.length; i++)
			{result[i] = node.value;
			node = node.next;}
		return result;
	}
	
	
	/** 
	 * Adds the given value to the end of this list 
	 * @post the size of this list equals its old size plus one. 
	 * 		|getSize() == old(getSize()) + 1
	 * @post the elements of this list are the old elements with the new one added.
	 * 
	 */
	public void add(int value) {
		if (firstNode == null) {
			firstNode = new Node();
			firstNode.value = value;
		}
		else {
			Node node = firstNode;
			while (node.next.next != null) 
				node = node.next;
			node.next = new Node();
			node.next.value = value;
					
		}
	}
	
	/** 
	 * Removes the elements at the given index from this list.
	 * @pre The given index is between 0 and this list's size
	 * 		| 0 <= index && index < getSize() 
	 * @post This list's size equals its old size minus one.
	 * 		| getSize() == old(getSize()) - 1
	 * @post This list's elements at indices less than the given index have remained unchanged. 
	 * 		| Arrays.equals(getElements(), 0, index, old(getElements()), 0, index)
	 * @post This list's elements at indices after the given index equal the old elements at index + 1 
	 * 		| Arrays.equals(getElements(), index, getSize(), old(getElements()), index + 1, old(getSize))
	 * 
	 * 
	 */
	public void remove(int index) {
		if (index == 0) { 
			firstNode = firstNode.next;
		} else { 
			Node node = firstNode;
			for (int i = 0; i < index - 1; i++) 
				node = node.next;
			node.next = node.next.next;
			
		}		
	}
	
	/**
	 * Inserts a given value into this list at the given index.
	 * @pre The given index is between 0 and this list's size.
	 * 		| 0 <= index && index <= getSize() 
	 * @post This list's size equals it's old size plus one. 
	 * 		| getSize == old(getSize()) + 1 
	 * @post The elements after the index remain unchanged 
	 * 		| Arrays.equals(getElements(), 0, index, old(getElements()), 0, index)
	 * @post The elements at the indices greater than the given index equal the elements at an index one less in the old list. 
	 * 		| Arrays.equals(getElements(), index + 1, getSize(), old(getElements()), index, old(getSize()))
	 */
	
	public void insert(int index, int value) {
		if ( firstNode == null) {
			firstNode = new Node();
			firstNode.value = value;
		} else {
			Node node = firstNode;
			for (int i = 0; i < index - 1; i++)
				node = node.next;
			Node nextNode = node.next;
			node.next = new Node();
			node.next.value = value;
			node.next.next = nextNode;
		}
		
	}
	

}
