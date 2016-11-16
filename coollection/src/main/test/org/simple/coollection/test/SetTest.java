package org.simple.coollection.test;
 
import static org.simple.coollection.Coollection.from;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.simple.coollection.test.pojos.Cat;
import org.simple.coollection.test.pojos.Dog;
import org.simple.coollection.test.pojos.PetShop;
import org.simple.coollection.test.pojos.StoreItem;
 
public class SetTest {
   
	   PetShop myPet = new PetShop();
	   List<PetShop> myShops = Arrays.asList(new PetShop[]{myPet});
   
   @Before
   public void setUp() throws Exception {
       myPet.getVitrine().add(new Dog("brutus", "1", 1d));
       myPet.getVitrine().add(new Dog("mila", "2", 2d));
       myPet.getVitrine().add(new Cat("kila", "4", 3d));
       myPet.getVitrine().add(new Cat("mani", "4", 9d));
       myPet.getVitrine().add(new Cat("mani", "4", 10d));
       myPet.getVitrine().add(new Cat("mani", "4", 11d));
   }
   
   @Test
   public void testSet() {
       
       List<StoreItem> list = from(myPet.getVitrine()).set("unitPrice", 0d).all();
       for (StoreItem petAnimal : list) {
		System.out.println(petAnimal.getUnitPrice());
       }
       assert list != null;
       
   }

   @Test
   public void testNestedSet() {
	   //from(myShops).select("animalsStore.price").all();
	   
       List<PetShop> list = from(myShops).set("animalsStore.price", 0d).all();
       for (PetShop petShop : list) {
           for (StoreItem petAnimal : petShop.getVitrine()) {
       		System.out.println(petAnimal.getUnitPrice());
              }
       }
       assert list != null;
       
   }
 
}