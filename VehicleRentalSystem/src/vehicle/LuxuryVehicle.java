package vehicle;

public class LuxuryVehicle extends Vehicle{
	private static final double rateMultiplier=2.0;
	public LuxuryVehicle(String registrationNumber, String model, VehicleType type, double baseRentalPrice) {
		super(registrationNumber, model, type, baseRentalPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateRentalFee(int days) {
		// TODO Auto-generated method stub
		return getBaseRentalPrice()*days*rateMultiplier;
	}

}
