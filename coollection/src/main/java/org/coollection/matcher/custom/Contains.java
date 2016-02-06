package org.coollection.matcher.custom;

import org.coollection.matcher.Matcher;

public class Contains implements Matcher {

	private final String matcherValue;

	public Contains(String matcherValue) {
		this.matcherValue = matcherValue;
	}

	public boolean match(Object value) {
		return String.valueOf(value).contains(matcherValue);
	}

}
