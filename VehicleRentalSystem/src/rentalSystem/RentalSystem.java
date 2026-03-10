package rentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import payment.PaymentProcessor;
import payment.PaymentStrategy;
import vehicle.Vehicle;
import vehicle.VehicleFactory;

public class RentalSystem {
	private static RentalSystem instance;
	private List<RentalStore> stores;
	private VehicleFactory vehicleFactory;
	private Map<Integer, User> users;
	private ReservationManager reservationManager;
	private PaymentProcessor paymentProcessor;
	//List<SystemObserver> observers; 
	private int nextUserId;
	
	private RentalSystem() {
		this.stores=new ArrayList<>();
		this.vehicleFactory=new VehicleFactory();
		this.paymentProcessor=new PaymentProcessor();
		this.reservationManager=new ReservationManager();
		this.users=new HashMap<>();
		this.nextUserId=1;
	}
	public static synchronized RentalSystem getInstance() {
		if(instance==null)
			instance=new RentalSystem();
		return instance;
	}
	
	public void addStore(RentalStore store) {
		stores.add(store);
	}
	
	public RentalStore getStore(int storeId) {
		for(RentalStore store:stores) {
			if(store.getId()==storeId)
				return store;
		}
		return null;
	}
	
	
	public Reservation createReservation(int userId, String vehicleNumber, int pickupStoreId,
			int dropStoreId, Date startDate, Date endDate) {
		User user=users.get(userId);
		RentalStore pickupStore=getStore(pickupStoreId);
		RentalStore dropStore=getStore(dropStoreId);
		Vehicle vehicle=pickupStore.getVehicle(vehicleNumber);
		if(pickupStore!=null && dropStore!=null)
			return reservationManager.createReservation(user, vehicle, pickupStore, dropStore, startDate, endDate);
		return null;
	}
	
	public boolean processPayment(int reservationId, PaymentStrategy paymentStrategy) {
		Reservation reservation=reservationManager.getReservation(reservationId);
		if(reservation!=null) {
			boolean result=paymentProcessor.processPayment(reservation.getTotalAmount(),paymentStrategy);
			if(result) {
				reservationManager.confirmReservation(reservationId);
				return true;
			}
		}
		return false;
	}
	public void add(RentalStore store) {
		// TODO Auto-generated method stub
		stores.add(store);
	}
	public User registerUser(String name,int id,String email) {
		// TODO Auto-generated method stub
		return new User(name,id,email);
	}
	public void startRental(int id) {
		// TODO Auto-generated method stub
		reservationManager.startRental(id);
	}
	public void confirmReservation(int id) {
		// TODO Auto-generated method stub
		reservationManager.confirmReservation(id);
	}
	public void cancelReservation(int id) {
		// TODO Auto-generated method stub
		reservationManager.cancelReservation(id);
	}
}
