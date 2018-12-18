package ss.week2.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.Password;
import ss.week2.hotel.Safe;

public class SafeTest {

	private Safe safe;
	private Password password;
	
	@Before
	public void setUp() {
		safe = new Safe();		 
	}

	@Test
	public void testInitialState() {
		assertEquals(safe.isActive(), false);
		assertEquals(safe.isOpen(), false);
		assertTrue(safe.getPassword() != null);
	}

	@Test
	public void testActivateCorrectPassword() {
		safe.activate(password.INITIAL);
		assertTrue(safe.isActive());
		
	}
	
	@Test
	public void testActivateWrongPassword() {
		safe.activate("wrong");
		assertFalse(safe.isActive());
		
	}
	
	@Test
	public void testDeactivate() {
		safe.deactivate();
		assertFalse(safe.isActive());
	}
	
	@Test
	public void testOpenCorrectPasswordActive() {
		safe.activate(password.INITIAL);
		safe.open(password.INITIAL);
		assertTrue(safe.isOpen());
	}
	
	@Test
	public void testOpenCorrectPasswordDeactive() {
		safe.open(password.INITIAL);
		assertFalse(safe.isOpen());
	}
	
	@Test
	public void testOpenWrongPasswordActive() {
		safe.activate(password.INITIAL);
		safe.open("wrong1");
		assertFalse(safe.isOpen());
		
	}
	
	@Test
	public void testOpenWrongPasswordDeactive() {
		safe.open("wrong1");
		assertFalse(safe.isOpen());
		
	}
	
	@Test
	public void testClose() {
		safe.close();
		assertFalse(safe.isOpen());
	}
}
