package org.coollection.query.specification;

import org.coollection.query.criteria.Criteria;

public interface Specification<T> {
	
	public boolean match(T item, Criteria<T> one, Criteria<T> other);
	
}