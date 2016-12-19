package com.bvancleave.examples.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bvancleave.examples.WeirdArray;
import com.bvancleave.examples.WeirdIterator;

public class WeirdArrayTest {
	
	private WeirdArray<String> waS = null;

	@Before
	public void setup() {
		// Create a String array of size 11.
		waS = new WeirdArray<String>(11);
		
		// Initialize the array.
		waS.setElement(0,  "a");
		waS.setElement(1,  "bb");
		waS.setElement(2,  "ccc");
		waS.setElement(3,  "dddd");
		waS.setElement(4,  "eeeee");
		waS.setElement(5,  "ffffff");
		waS.setElement(6,  "ggggg");
		waS.setElement(7,  "hhhh");
		waS.setElement(8,  "iii");
		waS.setElement(9,  "jj");
		waS.setElement(10, "k");
	}
	
	@After
	public void tearDown() {
		waS = null;
	}
	
	@Test
	public void testGetLength() {
		assertEquals(11, waS.getLength());
	}
	
	@Test
	public void testGetElementSuccess() {
		assertEquals("a", waS.getElement(0));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetElementArrayIndexOutOfBounds() {
		assertEquals("a", waS.getElement(100));
	}
	
	@Test
	public void testIterator() {
		@SuppressWarnings("unchecked")
		Iterator<String> iterator = mock(WeirdIterator.class);
		when(iterator.hasNext()).thenReturn(true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				true,
				false);
		when(iterator.next()).thenReturn("a",
				"bb",
				"ccc",
				"dddd", 
				"eeeee", 
				"ffffff", 
				"ggggg", 
				"hhhh", 
				"iii", 
				"jj", 
				"k");
		
		@SuppressWarnings("unchecked")
		WeirdArray<String> wa = mock(WeirdArray.class);
		when(wa.iterator()).thenReturn(iterator);
		
		int count = 0;
		for ( String s : wa ) {
			assertThat( waS.getElement(count), is(s));
			count++;
		}
		
		assertThat( count, is(waS.getLength()) );
	}
}
