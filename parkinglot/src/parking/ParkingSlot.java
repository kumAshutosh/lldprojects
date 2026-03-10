package parking;

import vehicle.*;

public class ParkingSlot {
	private String spotType;
	private boolean isOccupied;
	private int spotNumber;
	private Vehicle vehicle;
	
	public ParkingSlot(int spotNumber,String spotType) {
		this.spotNumber=spotNumber;
		this.spotType=spotType;
		this.isOccupied=false;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	
	public void parkVehicle(Vehicle vehicle) {
		if(isOccupied)
			throw new IllegalStateException("State already occupied");
		this.isOccupied=true;
		this.vehicle=vehicle;
	}
	//public abstract boolean canParkVehicle(Vehicle vehicle);
	
	public void vacate() {
		if(!isOccupied)
			throw new IllegalStateException("State already empty");
		this.isOccupied=false;
		this.vehicle=null;
	}
	public int getSpotNumber() {
		return spotNumber;
	}
	public String getSpotType() {
		return spotType;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
}