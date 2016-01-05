package ss.week1.hotel;
/**
 * Hotel guest with name and possibly a room.
 * @author Max Hendriks
 * @version $Revision: 1.0 $
 */
public class Guest {
	//------------------------instance variables------------------------
	public String name;
	public Room room = null;

	//------------------------constructor------------------------
	/**
	 * create a <code>Guest</code> with the given name.
	 * @param name of the new <code>Guest</code>.
	 */
	public Guest(String name) {
		this.name = name;
	}
	//------------------------queries------------------------
	/**
	 * returns the name of this <code>Guest</code>.
	 */
	public String getName() {
		return name;
	}
	/**
	 * returns the room of this <code>Guest</code>.
	 * @return room of this <code>Guest</code>;
	 * 		   <code>null</code> if this <code>Guest</code> is not renting a room.
	 */
	public Room getRoom() {
		return room;
	}
	//------------------------commands------------------------
	/**
	 * Assign a <code>Room</code> to this <code>Guest</code>.
	 * @param r the next room this <code>Guest</code> will rent.
	 * @return returns true if checkin succeeded, otherwise returns false.
	 */
	public boolean checkin(Room r) {
		if (room == null && r.getGuest() == null) {
			r.setGuest(this);
			room = r;
			return true;
		}
		return false;
	}
	/**
	 * Remove the current <code>Room</code> of this <code>Guest</code>.
	 * @return returns true if checkout succeeded, otherwise returns false.
	 */
	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Guest " + name;
	}
}
