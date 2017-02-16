package repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import model.Type;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@ActiveProfiles("test")
public class TypeRepositoryTest {
	
	@Autowired
	TypeRepository repo;
	
	@Autowired
	DataSource ds;
	

	String typeName;
	Type type;
	

	@Before
	public void setUp() throws Exception {
		typeName = ""+ Math.random();
		type = new Type(typeName);
		repo.save(type);
	}

	@Test
	public void shouldSave() throws InterruptedException {
	    assertNotNull(repo.findByName(typeName));
	}
	
	@Test
	public void shouldFindAll() {
	 assertTrue(repo.findAll().contains(type));
	}
	
	@Test
	public void shouldFindByName() {
	  assertEquals(repo.findByName(typeName), type);
	}

}
