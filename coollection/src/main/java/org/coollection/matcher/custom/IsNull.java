package org.coollection.matcher.custom;

import org.coollection.matcher.Matcher;

public class IsNull implements Matcher {

	public boolean match(Object value) {
		return value == null;
	}

}
