package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Rectangle;

/**
 * Test program for Rectangle Class.
 * @author sarah.roediger
 *
 */
public class RectangleTest {
	
	/**
	 * Test Object Rectangles.
	 */
	private Rectangle recPositive;

	/**
	 * Initialize the objects to be tested.
	 */
	@Before
	public void setUp() {
		recPositive = new Rectangle(2, 2);
		//recNegativeLength = new Rectangle(-2,2);
		//recNegativeWidth = new Rectangle(2,-2);
	}
	
	/**
	 * Tests if the initial condition complies to the specifications.
	 */
	@Test 
	public void testInitialCondition() {
		assertEquals(2, recPositive.length());
		assertEquals(2, recPositive.width());
	}
	/**
	 * Tests computing the area for a rectangle using the length and width.
	 */
	@Test
	public void testArea() {
		assertEquals(4, recPositive.area());
	}
	
	/**
	 * Tests computing the perimeter for a rectangle using the length and width.
	 */
	@Test
	public void testPerimeter() {
		assertEquals(8, recPositive.perimeter());
	}
	
	
}
