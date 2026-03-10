package vehicle;

import fee.ParkingFeeStrategy;

public class VehicleFactory {
	public static Vehicle createVehicle(String type,String plate,ParkingFeeStrategy feeStrategy) {
		switch(type.toLowerCase()) {
		case "car": return new Car(type, plate, feeStrategy);
		default: return new Bike(type, plate, feeStrategy);
		}
	}
}
