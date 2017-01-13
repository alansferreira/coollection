package org.simple.coollection.matcher.custom;

import org.simple.coollection.matcher.Matcher;

public class GreaterThan implements Matcher {

	private final Object value;

	public GreaterThan(Object value) {
		this.value = value;
	}

	
	public boolean match(Object matchValue) {
		if (matchValue == null){
			return false;
		}
		
		Comparable<Object> v = (Comparable<Object>) value;
		
		return (v.compareTo(matchValue) < 0);

	}

}
