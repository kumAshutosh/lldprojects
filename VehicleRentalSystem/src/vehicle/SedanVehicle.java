package vehicle;

public class SedanVehicle extends Vehicle{
	private static final double rateMultiplier=1.25;
	public SedanVehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
		super(registrationNumber, model, type, baseRentalPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateRentalFee(int days) {
		// TODO Auto-generated method stub
		return getBaseRentalPrice()*days*rateMultiplier;
	}

}
