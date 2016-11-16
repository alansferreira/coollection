package org.simple.coollection.test;

import static org.simple.coollection.Coollection.eq;
import static org.simple.coollection.Coollection.from;
import static org.simple.coollection.Coollection.in;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.simple.coollection.test.pojos.Cat;
import org.simple.coollection.test.pojos.Dog;
import org.simple.coollection.test.pojos.PetShop;
import org.simple.coollection.test.pojos.StoreItem;

public class InTest {
	PetShop myPet = new PetShop();
	@Before
	public void setUp() throws Exception {
		myPet.getVitrine().add(new Dog("brutus", "1", 100d));
		myPet.getVitrine().add(new Dog("mila", "2", 200d));
		myPet.getVitrine().add(new Cat("kila", "3", 300d));
		myPet.getVitrine().add(new Cat("mani", "4", 400d));
	}

	@Test
	public void inString() {
		/*List<String> brothersNames = from(myPet.getAnimalsStore())
				.select("name", String.class)
				.in(Arrays.asList(new String[]{"mila", "brutus"})).all();*/
		
		List<String> brothersNames = from(myPet.getVitrine())
				.where("name", in("mila", "brutus"))
				.select("name", String.class)
				.all();
		for (String brotherName : brothersNames) {
			System.out.println(brotherName);
		}
		assert brothersNames!=null && !brothersNames.isEmpty() && brothersNames.size()==2;

		brothersNames = from(myPet.getVitrine())
				.where("name", in(Arrays.asList("mila", "brutus")))
				.select("name", String.class)
				.all();
		for (String brotherName : brothersNames) {
			System.out.println(brotherName);
		}
		assert brothersNames!=null && !brothersNames.isEmpty() && brothersNames.size()==2;

	}

	@Test
	public void inNumber() {
		/*List<String> brothersNames = from(myPet.getAnimalsStore())
				.select("name", String.class)
				.in(Arrays.asList(new String[]{"mila", "brutus"})).all();*/
		
		List<StoreItem> brothers = from(myPet.getVitrine())
				.where("unitPrice", in(100d, 300d))
				.all();
		
		for (StoreItem brother : brothers) {
			System.out.println(brother.getName());
		}
		
		assert !brothers.isEmpty() && brothers.size()==2;
		
	}
	

	@Test
	public void inFieldName() {
		 List<StoreItem> brothers = from(myPet.getVitrine())
				 .where("name", in("mila", "brutus", "brutus", "mani"))
				.all();
		 
		 
		for (StoreItem brother : brothers) {
			System.out.println(brother.getName());
		}
		
		assert brothers!=null && !brothers.isEmpty() && brothers.size()==3;
		assert from(brothers).where("name", eq("mila")).first().getName().equals("mila");
		assert from(brothers).where("name", eq("brutus")).first().getName().equals("brutus");
		assert from(brothers).where("name", eq("mani")).first().getName().equals("mani");

		assert from(brothers).where("name", eq("mila")).all().size()==1;
		assert from(brothers).where("name", eq("brutus")).all().size()==1;
		assert from(brothers).where("name", eq("mani")).all().size()==1;

	}

	
	@Test
	public void testInPrimitive() {

		List<Long> list = from(Arrays.asList(new Long[] { 1l, 2l, 3l, 4l })).in(1l, 3l).all();
		System.out.println(list.size());
		assert list.size() == 2;

	}

	@Test
	public void testInCast() {

		List<Long> list = from(Arrays.asList(new Long[] { 1l, 2l, 3l, 4l })).in("1", "3").all();
		System.out.println(list.size());
		assert list.size() == 2;

	}

}
