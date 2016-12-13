package com.bvancleave.examples.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Test;

import com.bvancleave.examples.DataStructure;

public class DataStructureTest {

	@Test
	public void testPrintEven() {
		DataStructure ds = new DataStructure();
		
		//Prepare to redirect output
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);

		ds.printEven( ps );
		assertEquals("0 2 4 6 8 10 12 14 " + System.getProperty("line.separator"), 
				os.toString());

		//Restore normal output
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}
	
	@Test
	public void testPrintWithDataStructureIterator() {
		DataStructure ds = new DataStructure();
		
		//Prepare to redirect output
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
        ds.print(ds.getEvenIterator(), System.out);
        
        assertEquals("0 2 4 6 8 10 12 14 " + System.getProperty("line.separator"), 
				os.toString());

		//Restore normal output
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}
	
	@Test
	public void testPrintWithLambdaExpression() {
		DataStructure ds = new DataStructure();
		
		//Prepare to redirect output
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		 ds.print( index -> {
 			if ( index % 2 == 0 ) return Boolean.TRUE;
 			return Boolean.FALSE; 
 		}, System.out );
        
        assertEquals("0 2 4 6 8 10 12 14 " + System.getProperty("line.separator"), 
				os.toString());

		//Restore normal output
		PrintStream originalOut = System.out;
		System.setOut(originalOut);
	}
	
	@Test
	public void testPrintWithMethodReferenceOdd() {
		DataStructure ds = new DataStructure();
		
		//Prepare to redirect output
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		ds.print( DataStructure::isOddIndex, System.out );
		
		 assertEquals("1 3 5 7 9 11 13 " + System.getProperty("line.separator"), 
					os.toString());

		 //Restore normal output
		 PrintStream originalOut = System.out;
		 System.setOut(originalOut);
	}
	
	@Test
	public void testPrintWithMethodReferenceEven() {
		DataStructure ds = new DataStructure();
		
		//Prepare to redirect output
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		ds.print( DataStructure::isEvenIndex, System.out );
		
		 assertEquals("0 2 4 6 8 10 12 14 " + System.getProperty("line.separator"), 
					os.toString());

		 //Restore normal output
		 PrintStream originalOut = System.out;
		 System.setOut(originalOut);
	}
}
