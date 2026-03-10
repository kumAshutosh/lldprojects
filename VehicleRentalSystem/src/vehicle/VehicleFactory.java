package vehicle;

public class VehicleFactory {
	public static Vehicle createVehicle(VehicleType type, String model,
			String registrationNumber, double baseRentalPrice) {
		switch(type) {
		case VehicleType.economy:
			return new EconomyVehicle(registrationNumber, model, type, baseRentalPrice);
		case VehicleType.suv:
			return new SuvVehicle(registrationNumber, model, type, baseRentalPrice);
		case VehicleType.luxury:
			return new LuxuryVehicle(registrationNumber, model, type, baseRentalPrice);
		default:
			return new SedanVehicle(registrationNumber, model, type, baseRentalPrice);
		}
	}
}
