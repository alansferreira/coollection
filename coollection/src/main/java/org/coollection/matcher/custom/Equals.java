package org.coollection.matcher.custom;

import org.coollection.matcher.Matcher;

public class Equals implements Matcher {

	private final Object value;

	public Equals(Object value) {
		this.value = value;
	}

	public boolean match(Object anotherValue) {
		return value.equals(anotherValue);
	}

}
