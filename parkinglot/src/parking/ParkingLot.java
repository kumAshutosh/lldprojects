package parking;

import java.util.List;

import vehicle.Vehicle;

public class ParkingLot {
	List<ParkingSlot> slots;
	
	public ParkingLot(List<ParkingSlot> slots) {
		this.slots=slots;
	}
	
	public ParkingSlot findParkingSlot(String vehicleType) {
		for(ParkingSlot slot:slots) {
			if(!slot.isOccupied() && slot.getSpotType().equals(vehicleType)) {
				return slot;
			}
		}
		return null;
	}
	
	public ParkingSlot parkVehicle(Vehicle vehicle) {
		ParkingSlot slot=findParkingSlot(vehicle.getVehicleType());
		if(slot!=null) {
			slot.parkVehicle(vehicle);
			System.out.println("Parked in spot number:"+slot.getSpotNumber());
			return slot;
		}
		System.out.println("No slots available");
		return null;
	}
	public void vacateSpot(ParkingSlot slot,Vehicle vehicle) {
		if(slot!=null && slot.getVehicle().equals(vehicle)) {
			slot.vacate();
		}else {
			System.out.println("No such slot & vehicle combination present");
		}
	}
}
