package org.simple.coollection.query;

public interface CallbackSelectCast<TFrom, TTo> {
	public TTo cast(TFrom item, int index);
}
