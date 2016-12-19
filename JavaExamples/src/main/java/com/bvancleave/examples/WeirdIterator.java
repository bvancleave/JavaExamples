package com.bvancleave.examples;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Bradley Van Cleave
 * @modified 11/17/2015
 *
 * Create a WeirdIterator<T> class that implements the Iterator<T> interface.
 *  Here is how your iterator should iterate through the array. If the array
 *   has an odd number of items, return the middle item first, then the item
 *   just before the middle item, then the item just after the middle, then 
 *   the item two places before the middle, then the item two places after 
 *   the middle, then the item three places before the middle, etc. If the 
 *   array has an even number of items, first return the last item of the 
 *   first half of the array, then the first item of the second half of the 
 *   array, then the second to last item of the first half of the array, then
 *   the second item of the second half of the array, then the third to last 
 *   item from the first half, etc. (Notice that in both cases, the iterator 
 *   starts in the "middle" of the array and then works it way towards the 
 *   "ends" of the array.)
 *
 * Your WeirdIterator<T> class should have one constructor that takes a reference 
 * to a WeirdArray<T> object (the object that it will iterate through). Since the 
 * WeirdIterator<T> class implements the Iterator<T> interface, the 
 * WeirdIterator<T> class has three methods, hasNext(), next(), and remove(). The 
 * remove() method does not have any meaning in this example, so it should throw a 
 * UnsupportedOperationException. The hasNext() and next() methods are what 
 * actually implement the iterator as described above. In order to implement the 
 * iterator, your WeirdIterator<T> class can have any fields or extra methods 
 * that you might think are useful. You will definitely need at least a field to 
 * remember which WeirdArray is being iterated and a field to remember the 
 * current position (or index) of the iterator as it iterates through the array. 
 */
public class WeirdIterator<T> implements Iterator<T> {
	// What fields do you need?
	private WeirdArray<T> weirdArray;
	private int currentIndex;
	private int next;
	private int offset;
	private int count;


	private WeirdIterator() {
		this.offset = 0;
		this.count = 0;
		this.currentIndex = -1;
		this.next = -1;
	}

	public WeirdIterator(WeirdArray<T> wa) {
		this.weirdArray = wa;

		this.offset = 0;
		this.count = 0;
		this.currentIndex = -1;
		this.next = -1;
	}


	public boolean hasNext() {

		return ( count < this.weirdArray.getLength() ) ? true : false;

	}


	public T next() {
		T result = null;

		if ( hasNext() ) {
			int middle = this.weirdArray.getLength() / 2;
			if ( !isEven() ) {
				if ( offset == 0 ) {
					result = this.weirdArray.getElement( middle );
					currentIndex = middle;
					offset++;

					next = middle - offset;
				} else if ( next <= middle ) {
					result = this.weirdArray.getElement( next );
					currentIndex = next;
					next = middle + offset;
				} else {
					result = this.weirdArray.getElement( next );
					currentIndex = next;
					offset++;
					next = middle - offset;
				}

				count++;
			} else {
				if ( offset == 0 ) {
					result = this.weirdArray.getElement( middle - 1 );
					currentIndex = middle - 1;
					offset++;

					next = middle - 1 + offset;		    
				} else if ( next <= (middle - 1 ) ) {
					result = this.weirdArray.getElement( next );
					currentIndex = next;
					next = middle -1 + offset;
				} else {
					result = this.weirdArray.getElement( next );
					currentIndex = next;
					offset++;

					next = middle - offset;
				}

				count++;
			}
		} else
			throw new NoSuchElementException();

		return result;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	private boolean isEven() {
		return (this.weirdArray.getLength() % 2 == 0);
	}
}
