package ss.week3.hotel;
import ss.week3.pw.*;

/**
 * Hotel with name, rooms and possibly, guests.
 * @author max
 * @version $Revision: 1.0 $
 */

public class Hotel {

	//@ public invariant name != null;
	//@ public invariant room1 != null;
	//@ public invariant room2 != null;
	public String name;
	public Room room1;
	public Room room2;
	private PricedRoom billRoom;
	private Bill bill;
	public Guest guest1;
	public Guest guest2;
	private Password pass;
	private Checker checker;
	private String factoryPassword;
	
	/**
	 * Creates a Hotel with a name.
	 * @param name - The name of the hotel.
	 */
	//@ requires name != null;
	//@ ensures this.name == name;
	//@ ensures room1 != null && room2 != null;
	//@ ensures getPassword() != null;
	public Hotel(String name) {
		assert name != null;
		room1 = new Room(001, "Pass001");
		room2 = new Room(002, "Pass002");
		this.name = name;
		pass = new Password();
		assert room1 != null && room2 != null && pass != null;
		assert this.name == name;
	}
	
	/**
	 * Checks a guest in in a room.
	 * @param password - The checkin password of the hotel.
	 * @param guestName - the name of the guest.
	 * @return returns a room with a guest of the given name checked in, 
	 * or gives null if the password was wrong, 
	 * there already exists a guest with this name of if the hotel is full.
	 */
	//@ requires password != null && guestName != null;
	//@ ensures getPassword().testWord(password) ==> \result.getGuest().getName().equals(guestName);
	//@ ensures !getPassword().testWord(password) ==> \result == null;
	public Room checkIn(String password, String guestName) {
		assert password != null && guestName != null;
		if (guest1 == null) {
			if (pass.testWord(password) && (guest2 == null || !guest2.getName().equals(guestName))) {
				guest1 = new Guest(guestName);
				guest1.checkin(getFreeRoom());
				assert guest1.getName().equals(guestName);
				return guest1.getRoom();
			}
		}
		if (guest2 == null) {
			if (pass.testWord(password) && (guest1 == null || !guest1.getName().equals(guestName))) {
				guest2 = new Guest(guestName);
				guest2.checkin(getFreeRoom());
				assert guest2.getName().equals(guestName);
				return guest2.getRoom();
			}
		}
		return null;
	}
	
	/**
	 * Checks a guest out of the hotel.
	 * @param guestName - The name of the guest.
	 */
	//@ requires guestName != null;
	//@ ensures getRoom(guestName) == null;
	public void checkOut(String guestName) {
		assert guestName != null;
		if (guest1 != null && guest1.getName().equals(guestName)) {
			getRoom(guestName).getSafe().deactivate();
			guest1.checkout();
			guest1 = null;
			assert getRoom(guestName) == null;
		}
		if (guest2 != null && guest2.getName().equals(guestName)) {
			getRoom(guestName).getSafe().deactivate();
			guest2.checkout();
			guest2 = null;
			assert getRoom(guestName) == null;
		}
	}
	
	/**
	 * Gets a free room.
	 * @return Returns a room without a guest.
	 */
	//@ ensures \result.getGuest() == null || \result == null;
	/*@pure */ public Room getFreeRoom() {
		if (room1.getGuest() == null) {
			return room1;
		}
		if (room2.getGuest() == null) {
			return room2;
		}
		return null;
	}
	
	/**
	 * Gets the room where this guest is checked in.
	 * @param guestName - The name of the guest.
	 * @return Returns the room where the guest is checked in, 
	 * or null if there is no room with this guest.
	 */
	//@ requires guestName != null;
	//@ ensures \result.getGuest().getName().equals(guestName) || \result == null;
	/*@pure */ public Room getRoom(String guestName) {
		assert guestName != null;
		if (room1.getGuest() != null && room1.getGuest().getName().equals(guestName)) {
			assert room1.getGuest().getName().equals(guestName);
			return room1;
		}
		if (room2.getGuest() != null && room2.getGuest().getName().equals(guestName)) {
			assert room2.getGuest().getName().equals(guestName);
			return room2;
		}
		assert room1.getGuest() == null && room2.getGuest() == null;
		return null;
	}
	
	/**
	 * Gets the password of the hotel which is used by checkin.
	 * @return Returns the password object of this hotel.
	 */
	/*@pure */ public Password getPassword() {
		return pass;
	}
	
	/**
	 * gets the factory password
	 */
	/*@pure */ public String getFactoryPassword() {
		return factoryPassword;
	}
	
	/**
	 * Sets the factory password.
	 * @return Returns the factory password
	 */
	//@ ensures getFactoryPassword() == fpw;
	public void setFactorypassword(String fpw) {
		factoryPassword = fpw;
	}
	
	/**
	 * Gets the checker.
	 * @return Returns the checker
	 */
	/*@pure */ public Checker getChecker() {
		return checker;
	}
	
	/**
	 * sets the checker.
	 */
	//@ ensures getChecker() == ch;
	public void setChecker(Checker ch) {
		checker = ch;
	}
	
	/**
	 * Gives a textual description of all the rooms in this hotel, 
	 * including the name of the guest staying in it, 
	 * and the status of the safe in that room.
	 */
	/*@pure */ public String toString() {
		if (room1.getGuest() != null && room2.getGuest() != null) {
			return "Room " + room1.getNumber() + " currrently hosts " + room1.getGuest().getName() 
					+ ". Is the safe in this room active?:  " +
					room1.getSafe().isActive() + " And is it open?: " + room1.getSafe().isOpen() + 
					". Room " + room2.getNumber() + " currently hosts " + room2.getGuest().getName()
					+ ". Is the safe in this room active?:  " +
					room2.getSafe().isActive() + " And is it open?: " + room2.getSafe().isOpen();
		}
		if (room1.getGuest() != null && room2.getGuest() == null) {
			return "Room " + room1.getNumber() + " currently hosts " + room1.getGuest().getName()
					+ ". Is the safe in this room active?:  " +
					room1.getSafe().isActive() + " And is it open?: " + room1.getSafe().isOpen() + 
					". Room " + room2.getNumber() + 
					" currrently hosts noone. Is the safe in this room active?:  " +
					room2.getSafe().isActive() + " And is it open?: " + room2.getSafe().isOpen();
		}
		if (room2.getGuest() != null && room1.getGuest() == null) {
			return "Room " + room1.getNumber() + 
					" currently hosts noone. Is the safe in this room active?:  " +
					room1.getSafe().isActive() + " And is it open?: " + room1.getSafe().isOpen() + 
					". Room " + room2.getNumber() + 
					" currrently hosts " + room2.getGuest().getName() + 
					". Is the safe in this room active?:  " +
					room2.getSafe().isActive() + " And is it open?: " + room2.getSafe().isOpen();
		}
		if (room1.getGuest() == null && room2.getGuest() == null) {
			return "Room " + room1.getNumber() + 
					" currently hosts noone. Is the safe in this room active?:  " +
					room1.getSafe().isActive() + " And is it open?: " + room1.getSafe().isOpen() + 
					". Room " + room2.getNumber() + 
					" currrently hosts noone. Is the safe in this room active?:  " +
					room2.getSafe().isActive() + " And is it open?: " + room2.getSafe().isOpen();
		}
		return null;
	}
	
	public Bill getBill(String naam, int aantal, java.io.PrintStream output)	{
		if (getRoom(naam) == null || naam == null || !(getRoom(naam) instanceof PricedRoom))	{
			return null;
		}
		billRoom = (PricedRoom) getRoom(naam);
		bill = new Bill(output);
		for (int i = 0; i < aantal; i++)	{
			bill.newItem(billRoom);
		}
		if (billRoom.getSafe().isActive() && billRoom.getSafe() instanceof pricedSafe)	{
			bill.newItem((pricedSafe) billRoom.getSafe());
		}
		bill.close();
		return bill;
	}
}