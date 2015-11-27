package ss.week2.test;

import org.junit.Before;
import org.junit.Test;

import ss.week3.hotel.Guest;
import ss.week3.hotel.Room;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    private Guest guest;
    private Room room;
    private String password = "wawaweewa";

    @Before
    public void setUp() {
        guest = new Guest("Jip");
        room = new Room(101, password);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    
    @Test
    public void testSafe() {
    	room.getSafe().activate(password);
    	assertEquals(true, room.getSafe().isActive());
    }
}
