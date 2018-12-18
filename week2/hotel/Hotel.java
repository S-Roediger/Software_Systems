package ss.week2.hotel;

public class Hotel {

	private Room room1;
	private Room room2;
	private String name;
	private Password password;
	
	// ------- Constructor ---------- //
	
	public Hotel(String name) {
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
			this.getRoom(name).setGuest(null);
		}

	}
	
	// --------- Queries ----------- //
	
	public Room checkIn(String pass, String name) {
		if (this.getFreeRoom() != null) {
			Room room = this.getFreeRoom();
			if (password.testWord(pass)) {
				if (room1.getGuest() == null && room2.getGuest() == null) {
					Guest g = new Guest(name);
					room.setGuest(g);
					return room;
					
					
				} else if (room1.getGuest() != null && room2.getGuest() != null) {
					if (name.equals(room1.getGuest().getName()) || name.equals(room2.getGuest().getName()))  {
						return null;		
				} else {
					Guest g = new Guest(name);
					room.setGuest(g);
					return room;
				}
				
					
				} else if (room1.getGuest() != null && room2.getGuest() == null) {
					if (name.equals(room1.getGuest().getName()))  {
						return null;		
				} else {
					Guest g = new Guest(name);
					room.setGuest(g);
					return room;
				} 
					
					
				} else if (room2.getGuest() != null && room1.getGuest() == null) {
					if (name.equals(room2.getGuest().getName()))  {
						return null;		
				} else {
					Guest g = new Guest(name);
					room.setGuest(g);
					return room;
				}
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
	

	
/*	if (guest1 == null) {
		guest1 = new Guest(name);
		this.getFreeRoom().setGuest(guest1);
	} else {
		guest2 = new Guest(name);
		this.getFreeRoom().setGuest(guest2);
	} 
	
	public static void main(String[] args) {
		Hotel hotel = new Hotel("Naam");
		hotel.checkIn("start1", "Guus");
		System.out.println(hotel.toString());
	}
	*/
}
