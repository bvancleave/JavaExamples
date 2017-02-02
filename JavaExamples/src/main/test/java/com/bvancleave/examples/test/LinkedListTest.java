package com.bvancleave.examples.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bvancleave.examples.ElementNotFoundException;
import com.bvancleave.examples.LinkedList;

public class LinkedListTest {

	private LinkedList<Integer> list;
	
	@Before
	public void setUp() throws Exception {
		list = new LinkedList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		list = null;
	}

	@Test
	public void testAdd_ThenGet() throws ElementNotFoundException {
		Integer data = new Integer(10);
		list.add(data);
		
		assertNotNull(list);
		assertThat(list.size(), is(1));
		assertThat(list.get(0),is(10));
	}
	
	@Test
	public void testAddAfterNonEmpty_ThenGet() throws ElementNotFoundException {
		Integer data = new Integer(10);
		list.add(data);
		
		assertNotNull(list);
		assertThat(list.size(), is(1));
		
		list.addAfter(5);
		
		assertThat(list.get(1),is(5));
		assertThat(list.size(), is(2));
	}
	
	@Test
	public void testAddAfterEmpty_ThenGet() throws ElementNotFoundException {
		assertNotNull(list);
		assertThat(list.size(), is(0));
		
		list.addAfter(5);
		
		assertThat(list.get(0),is(5));
		assertThat(list.size(), is(1));
	}
	
	@Test
	public void testAddLastNonEmpty_ThenGet() throws ElementNotFoundException {
		assertNotNull(list);
		assertThat(list.size(), is(0));
		
		list.addLast(10);
		assertThat(list.size(), is(1));
		assertThat(list.get(0),is(10));
		
		list.addLast(5);
		assertThat(list.size(), is(2));
		assertThat(list.get(1),is(5));
	}

	@Test
	public void testSetAfterTrue_ThenGet() throws ElementNotFoundException {
		Integer ten = new Integer(10);
		Integer five = new Integer(5);
		
		list.add(ten);
		list.add(five);
		
		assertNotNull(list);
		assertThat(list.size(),is(2));
		assertThat(list.get(1), is(10));
		
		assertThat(list.setAfter(100), is(true));
		assertThat(list.get(1), is(100));
	}
	
	@Test
	public void testSetAfterFalse_ThenGet() throws ElementNotFoundException {
		Integer ten = new Integer(10);
		
		list.add(ten);
		
		assertNotNull(list);
		assertThat(list.size(),is(1));
		assertThat(list.get(0), is(10));
		
		assertThat(list.setAfter(100), is(false));
		assertThat(list.get(0), is(10));
	}
	
	@Test
	public void testToStringNonEmptyList() {
		Integer ten = new Integer(10);
		Integer five = new Integer(5);
		
		list.add(ten);
		list.add(five);
		
		assertNotNull(list);
		assertThat(list.size(), is(2));
		
		assertThat( list.toString(), is("[ 5 10 ]"));
	}
	
	@Test
	public void testToStringEmptyList() {
		assertNotNull(list);
		assertThat(list.size(), is(0));
		
		assertThat( list.toString(), is("[ ]"));
	}
	
	@Test
	public void testRemove_ThenSize() throws ElementNotFoundException {
		Integer ten = new Integer(10);
		Integer two = new Integer(2);
		Integer five = new Integer(5);
		
		list.add(ten);
		list.add(five);
		list.add(two);
		
		assertNotNull(list);
		assertThat(list.size(), is(3));
		
		assertThat(list.remove(1), is(5));
		assertThat(list.size(),is(2));
		
		assertThat(list.remove(1), is(10));
		assertThat(list.size(),is(1));
		
		assertThat(list.remove(0), is(2));
		assertThat(list.size(),is(0));
	}
	
	@Test(expected = ElementNotFoundException.class)
	public void testRemove_ExpectException() throws ElementNotFoundException {
		assertNotNull(list);
		assertThat(list.size(), is(0));
		assertThat(list.remove(1), is(5));
	}
}
