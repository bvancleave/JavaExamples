package com.bvancleave.examples;

/**
 * 
 * @author brad
 *
 */
public class LinkedList<T> {
	private Node<T> head;
	private int size;
	
	/**
	 * This constructor sets the head of the list to null
	 *  and the size to zero.
	 */
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	/**
	 * This inner class stores the data and link.
	 */
	class Node<S> {
		public S data;
		public Node<S> next;
	}
	
	public final int size() { return this.size; }
	
	/**
	 * This method inserts a new element at the beginning of the list.
	 * 
	 * @param element
	 */
	public void add( T element ) {
		Node<T> node = new Node<T>();
		node.data = element;
		node.next = null;
		
		if (head != null) {
			node.next = head;
		}
		
		head = node;
		size++;
	}
	
	/**
	 * This method inserts the node before the ith node in the linked list.
	 * If the ith node doesn't exist, then ElementNotFoundException is thrown.
	 * 
	 * @param element
	 * @param index
	 * @throws ElementNotFoundException
	 */
	public void addBefore( T element, int index ) throws ElementNotFoundException {
		if ( index == 0 ) {
			add( element );
			
			return;
		} else {
			int counter = 0;
			
			Node<T> node = new Node<T>();
			node.data = element;
			node.next = null;

			Node<T> pointer = head;
			Node<T> previous = head;
			while( pointer != null ) {
				if ( counter == index ) {
					node.next = pointer;
					previous.next = node;
					size++;

					return;
				}

				counter++;
			}
		}		
		
		throw new ElementNotFoundException();
	}
	
	/**
	 * This method inserts an element after the node that refers to the head of
	 * the linked list.
	 * 
	 * @param element
	 */
	public void addAfter( T element ) {
		if (head != null) {
			Node<T> node = new Node<T>();
			node.data = element;
			node.next = null;
			
			node.next = head.next;
			head.next = node;
			size++;
		} else {
			add( element );
		}
	}
	
	/**
	 * This method inserts a node at the end of the linked list.
	 * 
	 * @param element
	 */
	public void addLast( T element ) {
		if ( head == null || head.next == null ) {
			addAfter( element );
		} else {
			Node<T> node = new Node<T>();
			node.data = element;
			node.next = null;
			
			Node<T> pointer = head;
			while( pointer.next != null ) {
				pointer = pointer.next;
			}

			pointer.next = node;
			size++;
		}
	}
	
	/**
	 * This method modifies the node after the node referred by head
	 * so that its data is changed to element.
	 * 
	 * @param element
	 * @return
	 */
	public boolean setAfter( T element ) {
		/* Guard Statements */
		if ( head == null ) return false;
		if ( head.next == null ) return false;
		
		Node<T> node = head.next;
		node.data = element;
		
		return true;
	}
	
	/**
	 * This method returns the data of the ith element removed from
	 * the linked list.
	 *  
	 * @param index
	 * @return
	 * @throws ElementNotFoundException
	 */
	public T remove( int index ) throws ElementNotFoundException {
		int counter = 0;
		Node<T> pointer = head;
		Node<T> previous = head;
		
		while ( pointer != null ) {
			if ( counter == index ) {
				Node<T> node = pointer;
				previous.next = pointer.next;
				this.size--;
				return node.data;
			}
			
			previous = pointer;
			pointer = pointer.next;
			counter++;
		}
		
		throw new ElementNotFoundException();
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 * @throws ElementNotFoundException
	 */
	public T get( int index ) throws ElementNotFoundException {
		int counter = 0;
		Node<T> pointer = head;
		while( pointer != null ) {
			if ( counter == index )
				return pointer.data;
			
			pointer = pointer.next;
			counter++;
		}
		
		throw new ElementNotFoundException();
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		
		if ( head == null ) 
			return buffer.append(" ]").toString();
		
		Node<T> pointer = head;
		
		while( pointer != null ) {
			buffer.append(" ").append(pointer.data);
			pointer = pointer.next;	
		}
		
		buffer.append(" ]");
		return buffer.toString();
	}
}
