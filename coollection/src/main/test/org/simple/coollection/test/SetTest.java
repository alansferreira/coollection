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
 
public class SetTest {
   
	   PetShop myPet = new PetShop();
	   List<PetShop> myShops = Arrays.asList(new PetShop[]{myPet});
   
   @Before
   public void setUp() throws Exception {
       myPet.getAnimalsStore().add(new Dog("brutus", "1", 1d));
       myPet.getAnimalsStore().add(new Dog("mila", "2", 2d));
       myPet.getAnimalsStore().add(new Cat("kila", "4", 3d));
       myPet.getAnimalsStore().add(new Cat("mani", "4", 9d));
       myPet.getAnimalsStore().add(new Cat("mani", "4", 10d));
       myPet.getAnimalsStore().add(new Cat("mani", "4", 11d));
   }
   
   @Test
   public void testSet() {
       
       List<PetAnimal> list = from(myPet.getAnimalsStore()).set("price", 0d).all();
       for (PetAnimal petAnimal : list) {
		System.out.println(petAnimal.getPrice());
       }
       assert list != null;
       
   }

   @Test
   public void testNestedSet() {
	   //from(myShops).select("animalsStore.price").all();
	   
       List<PetShop> list = from(myShops).set("animalsStore.price", 0d).all();
       for (PetShop petShop : list) {
           for (PetAnimal petAnimal : petShop.getAnimalsStore()) {
       		System.out.println(petAnimal.getPrice());
              }
       }
       assert list != null;
       
   }
 
}