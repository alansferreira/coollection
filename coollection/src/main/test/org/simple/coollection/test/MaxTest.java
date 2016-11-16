package org.simple.coollection.test;
 
import static org.simple.coollection.Coollection.from;

import java.util.Arrays;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;
import org.simple.coollection.test.pojos.Cat;
import org.simple.coollection.test.pojos.Dog;
import org.simple.coollection.test.pojos.PetAnimal;
import org.simple.coollection.test.pojos.PetShop;
import org.simple.coollection.test.pojos.StoreItem;
 
public class MaxTest {
   PetShop myPet = new PetShop();
   @Before
   public void setUp() throws Exception {
       myPet.getVitrine().add(new Dog("brutus", "1", Double.valueOf(100d)));
       myPet.getVitrine().add(new Dog("brutus", "5", Double.valueOf(1000d)));
       myPet.getVitrine().add(new Dog("mila", "2", Double.valueOf(100d)));
       myPet.getVitrine().add(new Cat("kila", "4", Double.valueOf(1000d)));
       myPet.getVitrine().add(new Cat("mani", "4", Double.valueOf(1000d)));
   }
 
   @Test
   public void maxPriceAll() {
	   System.out.println("Max price is: " + from(myPet.getVitrine()).maxValue("unitPrice", Double.class));
	   
       List<StoreItem> maxPedgree = from(myPet.getVitrine()).max("unitPrice", Double.class).all();
       for (StoreItem species : maxPedgree) {
           System.out.println(species.getName());
           System.out.println(species.getUnitPrice());
       }

       assert maxPedgree!=null && !maxPedgree.isEmpty();
       
   }
   
   @Test
   public void maxPriceFirst() {
	   System.out.println("Max price is: " + from(myPet.getVitrine()).maxValue("unityPrice", Double.class));

	   StoreItem maxPedgree = from(myPet.getVitrine()).max("price", Double.class).first();
       
       System.out.println(maxPedgree.getName());
       System.out.println(maxPedgree.getUnitPrice());
           
       assert maxPedgree!=null;
       
   }

   @Test
   public void maxNameAll() {
	   System.out.println("Max name is: " + from(myPet.getVitrine()).maxValue("name", String.class));
	   
       List<StoreItem> maxPedgree = from(myPet.getVitrine()).max("name", String.class).all();
       for (StoreItem species : maxPedgree) {
           System.out.println(String.format("%1s %2s %3s", species.getName(), ((PetAnimal)species).getPedigree(), species.getUnitPrice()));
       }

       assert maxPedgree!=null && !maxPedgree.isEmpty();
       
   }

   @Test
	public void testMaxPrimitive() {

		List<Long> list = from(Arrays.asList(new Long[] { 1l, 2l, 3l, 4l, 4l })).max().all();
		System.out.println(list.size());
		assert list.size() == 2;

	}

}