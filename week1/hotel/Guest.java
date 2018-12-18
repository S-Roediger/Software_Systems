package ss.week1.hotel;

public class Guest {

	private String name;
	private Room room;
	
	/***
	 * Creates a Guest with the given name and without room.
	 * @param name
	 */
	public Guest(String name) {
		this.name = name;
	}
	
	/***
	 * @returns the name of the guest
	 */
	public String getName() {
		return name;
	}
	
	/***
	 * @returns the room that is rented by the guest; null if this Guest does not rent a room
	 */
	public Room getRoom() {
		return room;
	}
	
	
	/***
	 * Rents a Room to this Guest. This is only possible if this Guest does not already have a Room.
	 * and the Room to be assigned is not already rented. 
	 * Also adapts the Guest-reference of the Room.
	 * @param room
	 * @returns true if guest is checked in successful or false if guest already had a room.
	 * or room already had a guest
	 */
	public boolean checkin(Room room) {
		if (this.room != null || room.getGuest() != null) {
			return false;
		} else {
			this.room = room;
			room.setGuest(this);
			return true;
		}
	}
	
	/***
	 * Sets the Room of this Guest to null. 
	 * Also resets the Guest-reference of the (current) Room
	 * @returns true if action succeeded or false if guest does not have a room
	 */
	public boolean checkout() {
		if (room != null && room.getGuest() != null) {
			room.setGuest(null);
			room = null;
			return true;
		}
		
		return false;
	}
	
	/***
	 * To String method provides a name for each guest.
	 */
	public String toString() {
		return "Guest: " + name;
	}
}
