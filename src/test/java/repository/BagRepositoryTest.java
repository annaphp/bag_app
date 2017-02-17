package repository;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import model.Bag;
import model.Type;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@ActiveProfiles("test")
public class BagRepositoryTest {
	
	@Autowired
	BagRepository bagRepo;
	
	@Autowired
	TypeRepository typeRepo;
	
	Bag bag;
	String name;
	Type t;
	
	@Before
	public void setUp() throws Exception {
		name = "a"+ Math.random();
		
		Type type = new Type(name);
		typeRepo.save(type);
		t = typeRepo.findByName(name);
		
		bag = new Bag(t, name, "a bag", (long)67);
		System.out.println(bag.getName());
		bagRepo.save(bag);
	}
	
	@Test
	public void shouldSave() throws InterruptedException {
	    assertNotNull(bagRepo.findByName(name));
	}
	
	@Test
	public void shouldFindAll() {
		assertTrue(bagRepo.findAll().contains(bag));
	}
	
	@Test
	public void shouldFindByName() {
	  assertEquals(bagRepo.findByName(name), bag);
	}
	
	@Test 
	public void shouldFindByType(){
		assertTrue(bagRepo.findByType(t).contains(bag));
	}
	
	@Test
	public void shouldUpdatePrice(){
		Bag bagBeforUpdate = bagRepo.findByName(bag.getName());
		bagRepo.updatePrice(bagBeforUpdate, (long)300);
		Bag bagAfterUpdate = bagRepo.findByName(bag.getName());
		assertTrue(bagAfterUpdate.getPrice() == 300);
	}
	
	@Test
	public void shouldDelete(){
		Bag bagToDelete = bagRepo.findByName(bag.getName());
		bagRepo.delete(bagToDelete);
		assertNull(bagRepo.findByName(bagToDelete.getName()));
	}

}
