package org.simple.coollection.test.pojos;

import java.util.ArrayList;
import java.util.List;

public class ShoppingStore {
	public String name;
	public String address;
	
	public List<StoreItem> vitrine = new ArrayList<StoreItem>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<StoreItem> getVitrine() {
		return vitrine;
	}
	public void setVitrine(List<StoreItem> vitrine) {
		this.vitrine = vitrine;
	}
}
