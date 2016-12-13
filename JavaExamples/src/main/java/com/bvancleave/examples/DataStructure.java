package com.bvancleave.examples;

import java.io.PrintStream;

/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
public class DataStructure {
    
    // Create an array
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];
    
    public DataStructure() {
        // fill the array with ascending integer values
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }
    
	@SuppressWarnings("static-access")
	/**
	 * 
	 * @return the size of the array
	 */
	protected int size() {
		return this.SIZE;
	}
	
	/**
	 * 
	 * @param index
	 * @return the element
	 */
	public int getElement( int index ) {
		return this.arrayOfInts[index];
	}
	
	public static Boolean isEvenIndex( Integer index ) {
		if ( index % 2 == 0 ) return Boolean.TRUE;
		return Boolean.FALSE; 
	}
	
	public static Boolean isOddIndex( Integer index ) {
		if ( index % 2 == 0 ) return Boolean.FALSE;
		return Boolean.TRUE; 
	}
	
	/**
	 * 
	 * @param writer
	 */
    public void printEven( /* Refactored for easier testing */ PrintStream writer ) {
        
        // Print out values of even indices of the array
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            writer.print(iterator.next() + " ");
        }
        
        writer.println();
    }
    
    public DataStructureIterator getEvenIterator() {
    	return new EvenIterator();
    }
    
    /**
     * Define a method named print(DataStructureIterator iterator).
     *  
     * Invoke this method with an instance of the class EvenIterator 
     * so that it performs the same function as the method printEven.
     * 
     * @param iterator
     * @param writer
     */
    public void print( DataStructureIterator iterator, PrintStream writer ) {
    	while( iterator.hasNext()) {
    		writer.print( iterator.next() + " ");
    	}
    	
    	writer.println();
    }
    
    /**
     * Define a method named print(java.util.function.Function<Integer, Boolean> iterator)
     *  that performs the same function as print(DataStructureIterator iterator).
     *  
     * Invoke this method with a lambda expression to print elements that have an even index value. Invoke this method again with a lambda expression to print elements that have an odd index value.
     *	
     * @param iterator
     * @param writer
     */
    public void print( java.util.function.Function<Integer, Boolean> iterator, 
    		PrintStream writer )
    {
    	for ( int i = 0; i < SIZE; i++ ) {
    		if ( iterator.apply(i) ) {
    			writer.print( getElement(i) + " ");
    		}
    	}
    	
    	writer.println();
    }
    
    interface DataStructureIterator extends java.util.Iterator<Integer> { } 

    // Inner class implements the DataStructureIterator interface,
    // which extends the Iterator<Integer> interface
    
    private class EvenIterator implements DataStructureIterator {
        
        // Start stepping through the array from the beginning
        private int nextIndex = 0;
        
        public boolean hasNext() {
            
            // Check if the current element is the last in the array
            return (nextIndex <= SIZE - 1);
        }        
        
        public Integer next() {
            
            // Record a value of an even index of the array
            Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
            
            // Get the next even element
            nextIndex += 2;
            return retValue;
        }
    }
    
    public static void main(String s[]) {
    	
        // Fill the array with integer values and print out only
        // values of even indices
        DataStructure ds = new DataStructure();
        ds.printEven( System.out );
        
        ds.print( 
        		new DataStructure.DataStructureIterator() {

        			private int nextIndex = 1;

        			@Override
        			public Integer next() {
        				// Record a value of an odd index of the array
        				Integer retValue = ds.getElement(nextIndex);

        				// Get the next odd element
        				nextIndex += 2;
        				return retValue;
        			}

        			@Override
        			public boolean hasNext() {
        				// Check if the current element is the last in the array
        				return (nextIndex <= ds.size() - 1);
        			}
        		}, System.out );
    }
}