package com.bvancleave.examples;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Bradley Van Cleave
 * @modified 12/08/2015
 *
 */
public class WeirdIterator2<T> implements Iterator<T> {
	// What fields do you need?
	private WeirdArray<T> weirdArray;
	private int next;
	private int count;


	private WeirdIterator2() {
		this.count = 0;
		this.next = -1;
	}

	public WeirdIterator2(WeirdArray<T> wa) {
		this.weirdArray = wa;

		this.count = 0;
		this.next = -1;
	}

	public boolean hasNext() {	
		return ( count < this.weirdArray.getLength() ) ? true : false;
	}


	public T next() {
		T result = null;

		if ( hasNext() ) {
			if ( count % 2 == 0 ) {
				next = ( count + 1 ) / 2;
			} else {
				next = this.weirdArray.getLength() - ( ( count + 1 ) / 2 );
			}

			result = this.weirdArray.getElement( next );
			count++;
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
