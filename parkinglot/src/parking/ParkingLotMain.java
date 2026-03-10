package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fee.BasicHourStrategy;
import fee.ParkingFeeStrategy;
import fee.PremiumDayStrategy;
import payment.CashPaymentStrategy;
import payment.PaymentStrategy;
import payment.UpiPaymentStrategy;
import vehicle.Vehicle;
import vehicle.VehicleFactory;

public class ParkingLotMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ParkingSlot> slots=new ArrayList<>();
		slots.add(new ParkingSlot(1, "car"));
		slots.add(new ParkingSlot(2, "bike"));
		slots.add(new ParkingSlot(3, "car"));
		slots.add(new ParkingSlot(5, "car"));
		slots.add(new ParkingSlot(10, "bike"));
		
		ParkingLot parkingLot=new ParkingLot(slots);
		ParkingFeeStrategy basicFeeStrategy=new BasicHourStrategy();
		ParkingFeeStrategy premiumFeeStrategy=new PremiumDayStrategy();
		
		Vehicle vehicle1=VehicleFactory.createVehicle("bike", "abc321", premiumFeeStrategy);
		Vehicle vehicle2=VehicleFactory.createVehicle("car", "bsa178", basicFeeStrategy);
		
		ParkingSlot bikeSpot=parkingLot.parkVehicle(vehicle1);
		ParkingSlot carSpot=parkingLot.parkVehicle(vehicle2) ;
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Which payment method is suitable for you now?");
		System.out.println("1.Cash, 2.Upi 3.Card");
		int paymentMethod=scanner.nextInt();
		
		//payment using strategy patterns
		if(carSpot!=null) {
			double carFee=vehicle1.calculateFee();
			PaymentStrategy carPaymentStrategy=getPaymentStrategy(paymentMethod);
			carPaymentStrategy.processPayment(carFee);
			parkingLot.vacateSpot(carSpot, vehicle1);
		}
		if(bikeSpot!=null) {
			double bikeFee=vehicle2.calculateFee();
			PaymentStrategy bikePaymentStrategy=getPaymentStrategy(paymentMethod);
			bikePaymentStrategy.processPayment(bikeFee);
			parkingLot.vacateSpot(bikeSpot, vehicle2);
		}
	}

	private static PaymentStrategy getPaymentStrategy(int paymentMethod) {
		// TODO Auto-generated method stub
		switch(paymentMethod) {
		case 1: return new UpiPaymentStrategy();
		default: return new CashPaymentStrategy();
		}
	}

}
