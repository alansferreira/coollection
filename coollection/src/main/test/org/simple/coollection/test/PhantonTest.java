package org.simple.coollection.test;
 
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.simple.coollection.reflection.Phanton;
import org.simple.coollection.test.pojos.Cat;
import org.simple.coollection.test.pojos.Dog;
import org.simple.coollection.test.pojos.PetShop;
import org.simple.coollection.test.pojos.Shopping;
import org.simple.coollection.test.pojos.ShoppingStore;
 
public class PhantonTest {
	Shopping myShop = new Shopping();
	
	
   @Before
   public void setUp() throws Exception {
	   PetShop myPet1 = new PetShop();
	   PetShop myPet2 = new PetShop();
	   PetShop myPet3 = new PetShop();

	   myPet1.getVitrine().add(new Dog("brutus", "1", Double.valueOf(100d)));
       myPet1.getVitrine().add(new Dog("brutus", "5", Double.valueOf(1000d)));
       myPet2.getVitrine().add(new Dog("mila", "2", Double.valueOf(100d)));
       myPet2.getVitrine().add(new Cat("kila", "4", Double.valueOf(1000d)));
       myPet3.getVitrine().add(new Cat("mani", "4", Double.valueOf(1000d)));

       myShop.setStores(new ArrayList<ShoppingStore>(Arrays.asList(myPet1, myPet2, myPet3)));
       
   }
 
   @Test
   public void multiplyItems() {
	   
       Object ret = Phanton.from(myShop).call("stores.vitrine.name");

       assert ret!=null;
       
   }
   

}