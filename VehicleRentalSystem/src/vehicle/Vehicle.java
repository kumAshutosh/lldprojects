package vehicle;

public abstract class Vehicle {
	private String registrationNumber;
	private String model;
	private VehicleStatus status;
	private VehicleType type;
	private double baseRentalPrice;
	
	public Vehicle(	String registrationNumber,String model,
			VehicleType type,double baseRentalPrice) {
		this.baseRentalPrice=baseRentalPrice;
		this.registrationNumber=registrationNumber;
		this.model=model;
		this.type=type;
		this.status=VehicleStatus.avaialable;
	}
	public abstract double calculateRentalFee(int days);
	
	public double getBaseRentalPrice() {
		return baseRentalPrice;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public String getModel() {
		return model;
	}
	public VehicleType getVehicleType() {
		return type;
	}
	public VehicleStatus getVehicleStatus() {
		return status;
	}
	public void setVehicleStatus(VehicleStatus status) {
		this.status=status;
	}
}
