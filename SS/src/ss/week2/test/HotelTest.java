package ss.week2.test;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import ss.week2.hotel.*;

import static org.junit.Assert.*;

public class HotelTest {
    /** Test variable for a <tt>Hotel</tt> object. */
    private Hotel hotel;
    private String correctPassword;
    private String wrongPassword;
    public static final String GUEST_NAME_1 = "Major Gowen";
    public static final String GUEST_NAME_2 = "Miss Tibbs";
    public static final String GUEST_NAME_3 = "Miss Gatsby";

    /**
     * Sets the instance variable <tt>hotel</tt> to a well-defined initial value.
     * All test methods should be preceded by a call to this method.
     */
    @Before
    public void setUp() {
        hotel = new Hotel("Fawlty Towers");

        // initialisation of password-variable
        correctPassword = Password.INITIAL;
        wrongPassword = Password.INITIAL + "_invalid";
    }

    /**
     * checkIn must return null is the password is wrong.
     */
    @Test
    public void testCheckInWithWrongPassword() {
        Room room = hotel.checkIn(wrongPassword, GUEST_NAME_1);
        assertNull("No check in with wrong password", room);
    }

    /**
     * checkIn must, as long as rooms are available, return a room occupied by the specified guest.
     * When the hotel is full, checkIn must return null.
     */
    @Test
    public void testCheckInWithCorrectPassword() {
        Room room1 = hotel.checkIn(correctPassword, GUEST_NAME_1);
        assertEquals("Correct 1st guest check in", GUEST_NAME_1, room1.getGuest().getName());

        Room room2 = hotel.checkIn(correctPassword, GUEST_NAME_2);
        assertEquals("Correct 2nd guest check in", GUEST_NAME_2, room2.getGuest().getName());

        Room noRoom = hotel.checkIn(correctPassword, GUEST_NAME_3);
        assertNull("No check in when hotel is full", noRoom);
    }

    /**
     * If the specified guest is checked in, he must be checked out, i.e., afterwards, he must not have a room anymore,
     * and his room must now be empty. The room's safe must be inactivated as well.
     */
    @Test
    public void testCheckoutOccupiedRoom() {
        Room room = hotel.checkIn(correctPassword, GUEST_NAME_1);
        Guest guest = room.getGuest();
        Safe safe = room.getSafe();
        safe.activate(Password.INITIAL);

        hotel.checkOut(GUEST_NAME_1);
        assertNull("Guest has no room", guest.getRoom());
        assertNull("Room has no guest", room.getGuest());
        assertFalse("Safe is inactive", safe.isActive());
    }

    @Test
    public void testCheckoutEmptyRoom() {
        hotel.checkOut(GUEST_NAME_1);
        // nothing to be checked here, but no exception should occur.
    }

    /**
     * If there is a free room, getFreeRoom must return a room without guest.
     */
    @Test
    public void testGetFreeRoomFromNotFullHotel() {
        Room room = hotel.getFreeRoom();
        assertNull("A room is free", room.getGuest());

        hotel.checkIn(correctPassword, GUEST_NAME_1);
        Room freeRoom = hotel.getFreeRoom();
        assertNotNull("Another room is free", freeRoom);
        assertNotEquals("Another room is free", room, freeRoom);
    }

    /**
     * If there is no free room, getFreeRoom must return null.
     */
    @Test
    public void testGetFreeRoomFromFullHotel() {
        hotel.checkIn(correctPassword, GUEST_NAME_1);
        hotel.checkIn(correctPassword, GUEST_NAME_2);

        Room noRoom = hotel.getFreeRoom();
        assertNull("No room available in a full hotel", noRoom);
    }

    /**
     * getRoom must not return any room, if the guest is not checked in
     */
    @Test
    public void testGetRoomBeforeCheckIn() {
        Room room = hotel.getRoom(GUEST_NAME_1);
        assertNull("Guest 1 not checked in", room);
    }

    /**
     * If the guest is checked in, the returned room must be occupied by the specified guest.
     */
    @Test
    public void testGetRoomAfterCheckIn() {
        hotel.checkIn(correctPassword, GUEST_NAME_1);

        Room room = hotel.getRoom(GUEST_NAME_1);
        assertEquals("Guest 1 checked in", GUEST_NAME_1, room.getGuest().getName());
    }

    /**
     * A password object must be returned.
     */
    @Test
    public void testGetPassword() {
        Password password = hotel.getPassword();
        assertNotNull("Returned password is not null", password);
    }

    /**
     * ToString is difficult to test fully because there is no restriction on the format of the returned String.
     * At least it can be tested that a String is returned and that it contains the name of a checked in guest.
     */
    @Test
    public void testToString() {
        hotel.checkIn(correctPassword, GUEST_NAME_1);

        assertThat(hotel.toString(), CoreMatchers.containsString(GUEST_NAME_1));
    }
}
