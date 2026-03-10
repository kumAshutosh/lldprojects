package rentalSystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import vehicle.Vehicle;

public class ReservationManager {
	private Map<Integer, Reservation> reservations;
	private int nextReservationId;

	public ReservationManager() {
		this.reservations = new HashMap<>();
		this.nextReservationId = 1;
	}
	
	public Reservation createReservation(User user, Vehicle vehicle, RentalStore pickupRentalStore,
			RentalStore dropRentalStore, Date startDate, Date endDate) {
		Reservation reservation = new Reservation(nextReservationId++, user, vehicle, pickupRentalStore,
				dropRentalStore, startDate, endDate);
		reservations.put(reservation.getId(), reservation);
		user.addReservation(reservation);
		return reservation;
	}

	public void confirmReservation(int reservationId) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null)
			reservation.confirmReservation();
	}

	public void cancelReservation(int reservationId) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null)
			reservation.cancelReservation();
	}

	public void startRental(int reservationId) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null)
			reservation.startRental();
	}
	public Reservation getReservation(int reservationId) {
		return reservations.get(reservationId);
	}
}
