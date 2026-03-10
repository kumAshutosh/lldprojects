package rentalSystem;

import java.util.Date;

import vehicle.Vehicle;
import vehicle.VehicleStatus;

public class Reservation {
	private int id;
	private User user;
	private Vehicle vehicle;
	private RentalStore pickupRentalStore;
	private RentalStore dropRentalStore;
	private Date startDate;
	private Date endDate;
	private ReservationStatus status;
	private double totalAmount;
	
	public Reservation(int id, User user, Vehicle vehicle, RentalStore pickupRentalStore, RentalStore dropRentalStore,
			Date startDate, Date endDate) {
		this.id=id;
		this.user=user;
		this.vehicle=vehicle;
		this.pickupRentalStore=pickupRentalStore;
		this.dropRentalStore=dropRentalStore;
		this.startDate=startDate;
		this.endDate=endDate;
		this.status=ReservationStatus.pending;
		
		long diffMilliSec=endDate.getTime()-startDate.getTime();
		int days=(int)(diffMilliSec/(1000*60*60*24))+1;
		this.totalAmount=vehicle.calculateRentalFee(days);
	}
	
	public void confirmReservation() {
		if(status==ReservationStatus.pending) {
			status=ReservationStatus.confirmed;
			vehicle.setVehicleStatus(VehicleStatus.reserved);
		}
	}
	public void startRental() {
		if(status==ReservationStatus.confirmed) {
			status=ReservationStatus.in_progress;
			vehicle.setVehicleStatus(VehicleStatus.rented);
		}
	}
	public void completeReservation() {
		if(status==ReservationStatus.in_progress) {
			status=ReservationStatus.completed;
			vehicle.setVehicleStatus(VehicleStatus.avaialable);
		}
	}
	public void cancelReservation() {
		if(status==ReservationStatus.pending || status==ReservationStatus.confirmed) {
			status=ReservationStatus.cancelled;
			vehicle.setVehicleStatus(VehicleStatus.avaialable);
		}
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
}
