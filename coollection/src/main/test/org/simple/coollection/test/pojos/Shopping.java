package org.simple.coollection.test.pojos;

import java.util.ArrayList;
import java.util.List;

public class Shopping {
	List<ShoppingStore> stores = new ArrayList<ShoppingStore>();

	public List<ShoppingStore> getStores() {
		return stores;
	}

	public void setStores(List<ShoppingStore> stores) {
		this.stores = stores;
	}

	
}
