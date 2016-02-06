package org.coollection.matcher.custom;

import org.coollection.matcher.Matcher;

public class EqualsIgnoreCase implements Matcher {

	private final String value;

	public EqualsIgnoreCase(String value) {
		this.value = value;
	}

	public boolean match(Object anotherValue) {
		return (value).equalsIgnoreCase((String)anotherValue);
	}

}
