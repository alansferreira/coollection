package org.simple.coollection.test;

import static org.simple.coollection.Coollection.from;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.simple.coollection.test.pojos.Cat;
import org.simple.coollection.test.pojos.Dog;
import org.simple.coollection.test.pojos.PetAnimal;
import org.simple.coollection.test.pojos.PetShop;

public class MaxTest {
	PetShop myPet = new PetShop();
	@Before
	public void setUp() throws Exception {
		myPet.getAnimalsStore().add(new Dog("brutus", "1", 100d));
		myPet.getAnimalsStore().add(new Dog("mila", "2", 100d));
		myPet.getAnimalsStore().add(new Cat("kila", "4", 1000d));
		myPet.getAnimalsStore().add(new Cat("mani", "4", 1000d));
	}

	@Test
	public void distinctSpecies() {
		List<PetAnimal> maxPedgree = from(myPet.getAnimalsStore()).max("price").all();
		for (PetAnimal species : maxPedgree) {
			System.out.println(species.getName());
			System.out.println(species.getPrice());
		}
		assert maxPedgree!=null && !maxPedgree.isEmpty();
		
	}
	
	@Test
	public void distinctSpecies1() {
		PetAnimal maxPedgree = from(myPet.getAnimalsStore()).max("price").first();
		
			System.out.println(maxPedgree.getName());
			System.out.println(maxPedgree.getPrice());
			
		assert maxPedgree!=null;
		
	}

}
