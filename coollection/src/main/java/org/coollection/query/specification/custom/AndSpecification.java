package org.coollection.query.specification.custom;

import org.coollection.query.criteria.Criteria;
import org.coollection.query.specification.Specification;

public class AndSpecification<T> implements Specification<T> {

	public boolean match(T item, Criteria<T> one, Criteria<T> other) {
		return one.match(item) && other.match(item);
	}

}