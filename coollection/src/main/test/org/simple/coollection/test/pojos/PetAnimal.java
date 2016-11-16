package org.simple.coollection.test.pojos;

public abstract class PetAnimal extends StoreItem implements Animal {
	String pedigree;
	public PetAnimal(){
		
	}
	public PetAnimal(String argName, String argPedigree) {
		this();
		this.name = argName;
		this.pedigree = argPedigree;
	}
	public PetAnimal(String argName, String argPedigree, Double argPrice) {
	       this();
	       this.name = argName;
	       this.pedigree = argPedigree;
	       this.unitPrice = argPrice;
	   }
	 
	public abstract String getSpecies();

	public String getPedigree() {
		return pedigree;
	}

	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}

}
