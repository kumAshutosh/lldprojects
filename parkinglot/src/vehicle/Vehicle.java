package vehicle;

import fee.ParkingFeeStrategy;

public abstract class Vehicle {
	protected String numberPlate;
	protected String type;
	private ParkingFeeStrategy feeStrategy;
	
	public Vehicle(String numberPlate,String type,ParkingFeeStrategy feeStrategy) {
		this.numberPlate=numberPlate;
		this.type=type;
		this.feeStrategy=feeStrategy;
	}
	
	public String getVehicleType() {
		return type;
	}

	public abstract double calculateFee();
	
}
