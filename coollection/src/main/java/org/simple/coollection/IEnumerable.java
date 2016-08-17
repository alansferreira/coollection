package org.simple.coollection;



import java.util.Iterator;
import java.util.List;


public interface IEnumerable<T> extends Iterable<T>, Iterator<T>{
	/**
	 * Iterate all elements and return an ArrayList of containing elements
	 * @return
	 */
	List<T> asList();
	/**
	 * Raises iteration of all elements
	 * @return count of iterated elements
	 */
	int size();
	
	boolean isEmpty();
	
	void reset();
}
