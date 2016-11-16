package org.simple.coollection.test;

import static org.simple.coollection.Coollection.from;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.simple.coollection.test.pojos.Cat;
import org.simple.coollection.test.pojos.Dog;
import org.simple.coollection.test.pojos.PetShop;

public class DistinctTest {
	PetShop myPet = new PetShop();
	@Before
	public void setUp() throws Exception {
		myPet.getVitrine().add(new Dog("brutus", "1"));
		myPet.getVitrine().add(new Dog("mila", "2"));
		myPet.getVitrine().add(new Cat("kila", "3"));
		myPet.getVitrine().add(new Cat("mani", "4"));
	}

	@Test
	public void distinctSpecies() {
		List<String> allSpecies = from(myPet.getVitrine()).distinct("getSpecies").<String>select("getSpecies").all();
		for (String species : allSpecies) {
			System.out.println(species);
		}
		assert allSpecies!=null && !allSpecies.isEmpty();
		
	}
	   
	@Test
	public void testDistinctPrimitive() {

		List<Long> list = from(Arrays.asList(new Long[] { 1l, 1l, 2l, 2l, 3l, 3l, 4l, 4l })).distinct().all();
		System.out.println(list.size());
		assert list.size() == 4;

	}

}
