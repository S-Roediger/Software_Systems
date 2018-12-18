package ss.week2.hotel;

public class Hotel2 {
	//@private invariant room1 != null;
	private Room room1;
	//@private invariant room2 != null;
	private Room room2;
	//@private invariant name != null;
	private String name;
	//@private invariant password != null;
	private Password password;
	
	// ------- Constructor ---------- //
	
	public Hotel2(String name) {
		this.name = name; 
		password = new Password();
		room1 = new Room(101);
		room2 = new Room(102);
	}
	
	// ------- Commands ------------ //
	
	public void checkOut(String name) {
		if (this.getRoom(name) != null) {
			this.getRoom(name).getSafe().deactivate();
			this.getRoom(name).getGuest().checkout();
		}

	}
	
	// --------- Queries ----------- //
	public Room checkIn(String pass, String name) {
		if (this.getFreeRoom() != null) {
			Room room = this.getFreeRoom();
			if ((room1.getGuest() == null || !room1.getGuest().getName().equals(name)) 
					&& (room2.getGuest() == null || !room2.getGuest().getName().equals(name))) {
				if (password.testWord(pass)) {
					Guest gu = new Guest(name);
					gu.checkin(room);
					return room;
				}
			}
		}
		return null;
	}
	
	public Room getFreeRoom() {
		if (room1.getGuest() == null) {
			return room1;
		} 
		if (room2.getGuest() == null) {
			return room2;		
		}
		return null;
	}
	
	public Room getRoom(String name) {
		if (room1.getGuest() != null && room1.getGuest().getName().equals(name)) {
			return room1;
		} else if (room2.getGuest() != null && room2.getGuest().getName().equals(name)) {
			return room2;	
		}
		return null;
	}
	 
	public Password getPassword() {
		return this.password;
	}
	
	public String getHotelName() {
		return name;
	}
	
	public String toString() {
		String a = "Name: " + this.getHotelName() + "\r"; 
		if (room1.getGuest() != null && room2.getGuest() != null) {
			String b =	"Guests of Room1: " + room1.getGuest().getName() + "\r";
			String c =	"Status of safe: " + room1.getSafe().isActive() + "\r";
			String d =	"Guests of Room2: " + room2.getGuest().getName() + "\r";
			String e =	"Status of safe: " + room2.getSafe().isActive() + "\r";
			return a+b+c+d+e;
		} else if (room1.getGuest() != null || room2.getGuest() != null) {
			if (room1.getGuest() != null) {
				String b =	"Guests of Room1: " + room1.getGuest().getName() + "\r";
				String c =	"Status of safe: " + room1.getSafe().isActive() + "\r";
				return a+b+c;
			}
			String d =	"Guests of Room2: " + room2.getGuest().getName() + "\r";
			String e =	"Status of safe: " + room2.getSafe().isActive() + "\r";
			return a+d+e;
		}
		return a;
	}
	

	
/*
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel("Naam");
		hotel.checkIn("start1", "Guus");
		System.out.println(hotel.toString());
	}
	*/
}
