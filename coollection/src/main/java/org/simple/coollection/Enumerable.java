package org.simple.coollection;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Enumerable<T> implements IEnumerable<T>{
	Iterable<T> baseIterable = null;
	protected Iterator<T> currentIterator = null;
	
	public Enumerable(final Iterable<T> argBaseIterable){
		baseIterable = argBaseIterable;
	}
	public Enumerable(final Iterator<T> argBaseIterator){
		this(new Iterable<T>() {
			public Iterator<T> iterator() {
				return argBaseIterator;
			}
		});
		
	}
	
	/**
	 * renew, reset and return current iterator
	 */
	public Iterator<T> iterator() {
		reset();
		return currentIterator;
	}

	public boolean hasNext() {
		return currentIterator.hasNext();
	}

	public T next() {
		return currentIterator.next();
	}

	/**
	 * Iterate all elements and return an ArrayList of containing elements
	 * @return
	 */
	public List<T> asList() {
		List<T> ret = new ArrayList<T>();
		for (T t : baseIterable) {
			ret.add(t);
		}
		return ret;
	}

	/**
	 * Raises iteration of all elements
	 * @return count of iterated elements
	 */
	public int size() {
		int count = 0;
		Iterator<T> iterator = iterator();

		while(iterator.hasNext()) count++;
		
		return count;
	}
	public boolean isEmpty() {
		return !iterator().hasNext();
	}
	public void reset() {
		currentIterator = baseIterable.iterator();
	}
}
