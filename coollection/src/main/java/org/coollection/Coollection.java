package org.coollection;

import java.util.Collection;

import org.coollection.matcher.Matcher;
import org.coollection.matcher.custom.Contains;
import org.coollection.matcher.custom.Equals;
import org.coollection.matcher.custom.EqualsIgnoreCase;
import org.coollection.matcher.custom.GreaterThan;
import org.coollection.matcher.custom.IsNull;
import org.coollection.matcher.custom.LessThan;
import org.coollection.matcher.custom.Not;
import org.coollection.query.Query;

public class Coollection {

	public static <T> Query<T> from(Collection<T> collection) {
		return new Query<T>(collection);
	}

	public static Matcher eq(Object value) {
		return new Equals(value);
	}
	
	public static Matcher contains(String value) {
		return new Contains(value);
	}
	
	public static Matcher eqIgnoreCase(String value) {
		return new EqualsIgnoreCase(value);
	}
	
	public static Matcher not(Matcher matcher) {
		return new Not(matcher);
	}
	
	public static Matcher greaterThan(Number value) {
		return new GreaterThan(value);
	}
	
	public static Matcher lessThan(Number value) {
		return new LessThan(value);
	}
	
	public static Matcher isNull() {
		return new IsNull();
	}

}