package org.simple.coollection.test;
 
import static org.simple.coollection.Coollection.between;
import static org.simple.coollection.Coollection.from;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.simple.coollection.test.pojos.Cat;
import org.simple.coollection.test.pojos.Dog;
import org.simple.coollection.test.pojos.PetShop;
import org.simple.coollection.test.pojos.StoreItem;
 
public class BetweenTest {
   
   PetShop myPet = new PetShop();
   
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
   public void testBetween() {
       
       List<StoreItem> list = from(myPet.getVitrine()).where("unitPrice", between(1d, 2d)).all();
       System.out.println(list.size());
       assert list != null;
       
   }

   @Test
   public void testBetweenPrimitive() {
       
       List<Long> list = from(Arrays.asList(new Long[]{1l,2l,3l,4l})).between(2l, 4l).all();
       System.out.println(list.size());
       assert list != null;
       
   }
 
}