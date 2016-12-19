package com.bvancleave.examples;

/**
Create a (parameterized) class WeirdArrayr<T> that implements the Iterable<T> interface. 
The WeirdArray<T> class should contain a private reference to an array that will hold 
references to objects of type T. The WeirdArray<T> class should have a constructor that 
takes a single integer n and creates an empty array of size n. The WeirdArray<T> class 
should have a getElement(int i) method that returns a reference to the element of type T
stored at index i in the private array, and a setElement(int i, T e) method that puts a
reference to a T object at index i in the private array. The WeirdArray<T> class should 
have a getLength() method that returns the length of the private array. And, since 
WeirdArray<T> implements the Iterable<T> interface, the WeirdArray<T> class should have a
iterator() method that returns a reference to a Iterator<T> object. This method should 
construct, and then return a reference to, a WeirdIterator<T> object. The WeirdIterator<T> 
class is described in the next paragraph. 
*/
import java.util.Iterator;

public class WeirdArray<T> implements Iterable<T>
{
   private Object[] theArray;

   private WeirdArray() {
       /* left blank */
   }

   public WeirdArray(int n)
   {
       this.theArray = new Object[n];
   }

   @SuppressWarnings("unchecked")
   public T getElement( int i ) {
	   return (T) this.theArray[i];
   }

   public void setElement( int i, T e ) {
       this.theArray[i] = (Object) e;
   }

   public int getLength() {
       return this.theArray.length;
   }

   /**
      Implement the Iterable<T> interface.
   */
   public Iterator<T> iterator()
   {
       return new WeirdIterator<T>(this);
   }

}
