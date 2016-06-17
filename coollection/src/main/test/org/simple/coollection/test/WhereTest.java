package org.simple.coollection.test;

import static org.simple.coollection.Coollection.*;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.simple.coollection.query.Query;
import org.simple.coollection.test.pojos.Animal;
import org.simple.coollection.test.pojos.Cat;
import org.simple.coollection.test.pojos.Dog;
import org.simple.coollection.test.pojos.PetAnimal;
import org.simple.coollection.test.pojos.PetShop;

public class WhereTest {
	PetShop myPet = new PetShop();
	@Before
	public void setUp() throws Exception {
		myPet.getAnimalsStore().add(new Dog("brutus", "1"));
		myPet.getAnimalsStore().add(new Dog("mila", "2"));
		myPet.getAnimalsStore().add(new Cat("kila", "3"));
		myPet.getAnimalsStore().add(new Cat("mani", "4"));
	}

	@Test
	public void listAllCats() {
		List<PetAnimal> allCats = from(myPet.getAnimalsStore()).where("getSpecies", eqIgnoreCase("cat")).all();
		for (PetAnimal animal : allCats) {
			System.out.println("Cat: " + animal.getName());
		}
		assert allCats!=null && !allCats.isEmpty();
		
	}

	@Test
	public void firstCat() {
		PetAnimal cat = from(myPet.getAnimalsStore()).where("getSpecies", eqIgnoreCase("cat")).first();
		System.out.println(cat.getName());
		assert cat!=null && cat.getSpecies()=="cat";
		
	}

}
