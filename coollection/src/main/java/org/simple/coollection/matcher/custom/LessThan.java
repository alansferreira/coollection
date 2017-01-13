package org.simple.coollection.matcher.custom;

import org.simple.coollection.matcher.Matcher;

public class LessThan implements Matcher {

	private final Object value;

	public LessThan(Object value) {
		this.value = value;
	}

	
	public boolean match(Object matchValue) {
		if (matchValue == null){
			return false;
		}
		
		Comparable<Object> v = (Comparable<Object>) value;
		
		return (v.compareTo(matchValue) > 0);
	}

}
