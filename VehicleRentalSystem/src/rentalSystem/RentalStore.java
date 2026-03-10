package rentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import vehicle.Vehicle;
import vehicle.VehicleStatus;

public class RentalStore {
	private int id;
	private Location location;
	private String name;
	Map<String, Vehicle> vehicles;
	
	public RentalStore(int id, Location location, String name) {
		this.id = id;
		this.location = location;
		this.name = name;
		this.vehicles = new HashMap<>();
	}
	public List<Vehicle> getAvailableVehicles(Date startDate, Date endDate){
		List<Vehicle> availableVehicles=new ArrayList<>();
		for(Vehicle vehicle:vehicles.values()) {
			if(vehicle.getVehicleStatus()==VehicleStatus.avaialable)
				availableVehicles.add(vehicle);
		}
		return availableVehicles;
	}
	public void addVehicle(Vehicle vehicle) {
		vehicles.put(vehicle.getRegistrationNumber(), vehicle);
	}
	public void removeVehicle(String registrationNumber) {
		vehicles.remove(registrationNumber);
	}
	public boolean isVehicleAvailable(String registrationNumber,Date startDate, Date endDate) {
		Vehicle vehicle=vehicles.get(registrationNumber);
		return vehicle!=null && vehicle.getVehicleStatus()==VehicleStatus.avaialable;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public Vehicle getVehicle(String vehicleNumber) {
		// TODO Auto-generated method stub
		return vehicles.get(vehicleNumber);
	}

}
