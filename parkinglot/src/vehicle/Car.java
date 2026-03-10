package vehicle;

import fee.ParkingFeeStrategy;

public class Car extends Vehicle{

	public Car(String numberPlate, String type, ParkingFeeStrategy feeStrategy) {
		super(numberPlate, type, feeStrategy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateFee() {
		// TODO Auto-generated method stub
		return 0;
	}

}
