package ss.week2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;
import ss.week2.hotel.Safe;

public class RoomTest {
    private Guest guest;
    private Room room1;
    private Room room2;
    private Safe safe;
    
    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room1 = new Room(101);
        safe = new Safe();
        room2 = new Room(102, safe);
        
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room1.getNumber());
        assertEquals(102, room2.getNumber());
        assertEquals(safe, room2.getSafe());
        assertFalse(safe == room1.getSafe());
    }

    @Test
    public void testSetGuest() {
        room1.setGuest(guest);
        assertEquals(guest, room1.getGuest());
    }
    
    @Test 
    public void testSafe() {
    	//room1.setSafe(safe);
    	assertEquals(safe, room2.getSafe());
    }
}
