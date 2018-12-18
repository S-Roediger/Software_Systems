package ss.week3.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;

class BillTest {
	
	private StringPrinter p; 
	private Bill b;
	private Item item;
	private static final double DELTA = 1e-15;
	
	public class Item implements Bill.Item {
		
		String text;
		double amount;
		
		public Item(String text, double amount) {
			this.text = text;
			this.amount = amount;
		}

		@Override
		public double getAmount() {
			return amount;
		}
		
		@Override
		public String toString() {
			return text;
		}
		
		
	}

	@BeforeEach
	void setUp() {
		p = new StringPrinter();
		b = new Bill(p);
		String text = "Apples";
		double price = 2.0;
		item = new Item(text, price);
	}
 
	@Test
	void testItem() {
		assertEquals("Apples", item.toString());
		assertEquals(2.0, item.getAmount(), DELTA);
	}
	
	@Test 
	void testBill() {
		assertEquals("Sum: 0.0", b.toString());
		assertEquals(0.0, b.getSum(), DELTA);
		b.addItem(item);
		assertEquals(2.0, b.getSum(), DELTA);
		//p.printLine(item.toString(), item.getAmount());
		b.close();
		String s = "Final Bill: Total              2.0";
		assertTrue(b.toString().contains(s));
		
	}

}
