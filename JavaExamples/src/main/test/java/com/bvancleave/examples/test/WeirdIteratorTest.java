package com.bvancleave.examples.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

import com.bvancleave.examples.WeirdArray;
import com.bvancleave.examples.WeirdIterator;

public class WeirdIteratorTest {
	private WeirdArray<Integer> array;
	
	@Before
	public void setUp() {
		array = new WeirdArray<Integer>(4){{
			setElement(0, 0);
			setElement(1, 11);
			setElement(2, 222);
			setElement(3, 3333);
		}};
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testRemove() {
		@SuppressWarnings("unchecked")
		WeirdArray<Integer> array = mock(WeirdArray.class);
		WeirdIterator<Integer> it = new WeirdIterator<Integer>(array);
		it.remove();
	}
	
	@Test
	public void testEmpty() {
		@SuppressWarnings("unchecked")
		WeirdArray<Integer> array = mock(WeirdArray.class);
		WeirdIterator<Integer> it = new WeirdIterator<Integer>(array);
		assertFalse(it.hasNext());
	}
	
	@Test
	public void testHasNext() {		
		WeirdIterator<Integer> it = new WeirdIterator<Integer>(array);
		assertTrue(it.hasNext());
	}
	
	@Test
	public void testNextWithEvenNumberOfElements() {
		WeirdIterator<Integer> it = new WeirdIterator<Integer>(array);
		
		assertThat(it.next(), is(11));
		assertThat(it.next(), is(222));
		assertThat(it.next(), is(0));
		assertThat(it.next(), is(3333));
	}
	
	@Test
	public void testNextWithOddNumberOfElements() {
		WeirdArray<Integer> array = new WeirdArray<Integer>(5){{
			setElement(0, 0);
			setElement(1, 11);
			setElement(2, 222);
			setElement(3, 3333);
			setElement(4, 44444);
		}};
		WeirdIterator<Integer> it = new WeirdIterator<Integer>(array);
		
		assertThat(it.next(), is(222));
		assertThat(it.next(), is(11));
		assertThat(it.next(), is(3333));
		assertThat(it.next(), is(0));
		assertThat(it.next(), is(44444));
	}

	@Test(expected=NoSuchElementException.class)
	public void testNoSuchElementException() {
		@SuppressWarnings("unchecked")
		WeirdArray<Integer> array = mock(WeirdArray.class);
		WeirdIterator<Integer> it = new WeirdIterator<Integer>(array);
		it.next();
	}
}
