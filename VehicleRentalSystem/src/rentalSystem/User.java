package rentalSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private int id;
	private String email;
	private List<Reservation> reservations;
	
	public User(String name,int id, String email) {
		this.email=email;
		this.id=id;
		this.name=name;
		this.setReservations(new ArrayList<>());
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}
	
	public void removeReservation(Reservation reservation) {
		reservations.remove(reservation);
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	
}
