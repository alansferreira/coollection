

package org.simple.coollection.query;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class QueryIterator<T> implements Iterator<T>, Iterable<T> {
	private Query<T> query;
	private T currentItem;
	private Iterator<T> collIterator;
	
	
	public QueryIterator(Query<T> argQuery){
		query = argQuery;
		collIterator = query.getCollectionIterator();
	}
	
	public Iterator<T> iterator() {
		return this;
	}

	public boolean hasNext() {
		while(collIterator.hasNext()){
			currentItem = collIterator.next();
			
			return (query.getCriterias().match(currentItem));
		}
		return false;
	}

	public T next() {
		return currentItem;
	}
	
	public List<T> iterateAll(){
		ArrayList<T> ret = new ArrayList<T>();
		
		while(hasNext()){
			ret.add(next());
		}
		
		return ret;
	}

}