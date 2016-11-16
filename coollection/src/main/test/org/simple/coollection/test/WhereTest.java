package org.simple.coollection.test;


import static org.simple.coollection.Coollection.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.simple.coollection.test.pojos.Cat;
import org.simple.coollection.test.pojos.Dog;
import org.simple.coollection.test.pojos.PetAnimal;
import org.simple.coollection.test.pojos.PetShop;
import org.simple.coollection.test.pojos.StoreItem;

public class WhereTest {
	PetShop myPet = new PetShop();
	@Before
	public void setUp() throws Exception {
		myPet.getVitrine().add(new Dog("brutus", "1"));
		myPet.getVitrine().add(new Dog("mila", "2"));
		myPet.getVitrine().add(new Cat("kila", "3"));
		myPet.getVitrine().add(new Cat("mani", "4"));
	}

	@Test
	public void listAllCats() {
		List<StoreItem> allCats = from(myPet.getVitrine()).where("getSpecies", eqIgnoreCase("cat")).all();
		for (StoreItem animal : allCats) {
			System.out.println("Cat: " + animal.getName());
		}
		assert allCats!=null && !allCats.isEmpty();
		
	}

	@Test
	public void firstCat() {
		StoreItem cat = from(myPet.getVitrine()).where("getSpecies", eqIgnoreCase("cat")).first();
		System.out.println(cat.getName());
		assert cat!=null && ((PetAnimal)cat).getSpecies()=="cat";
		
	}
	@Test
	public void allCatsWithName() {
		List<StoreItem> cats = from(myPet.getVitrine())
				.where("getSpecies", eqIgnoreCase("cat"))
				.and("name", eqIgnoreCase("kila")).all();
		
		for (StoreItem cat : cats) {
			System.out.println(cat.getName());
		}

		PetAnimal kila = (PetAnimal) cats.get(0);
		
		assert kila.getSpecies()=="cat" && kila.getName().equalsIgnoreCase("kila");
		
	}

	@Test
	public void allCatsOrCatsWithName() {
		List<StoreItem> cats = from(myPet.getVitrine())
				.where("getSpecies", eqIgnoreCase("cat"))
				.or("name", eqIgnoreCase("kila")).all();
		
		for (StoreItem cat : cats) {
			System.out.println(cat.getName());
		}

		assert cats.size()>1;
		
	}

	@Test
	public void testWherePrimitive() {

		List<Long> list = from(Arrays.asList(new Long[] { 1l, 2l, 3l, 4l })).where(eq(1l)).all();
		System.out.println(list.size());
		assert list.size() == 1;

	}

}
