package rentalSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import payment.CardPaymentStrategy;
import payment.CashPaymentStrategy;
import payment.PaymentStrategy;
import payment.UpiPaymentStrategy;
import vehicle.Vehicle;
import vehicle.VehicleFactory;
import vehicle.VehicleType;

public class RentalMain {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		RentalSystem rentalSystem = RentalSystem.getInstance();

		RentalStore store1 = new RentalStore(1, new Location("93b", "new delhi", "delhi", "110047"), "Caramel rental");
		RentalStore store2 = new RentalStore(2, new Location("293a", "old delhi", "delhi", "110054"), "Always rental");
		rentalSystem.add(store1);
		rentalSystem.add(store2);

		Vehicle economyCar = VehicleFactory.createVehicle(VehicleType.economy, "ECX001", "Toyota", 50);
		Vehicle suvCar = VehicleFactory.createVehicle(VehicleType.economy, "SUX001", "Honda", 150);
		Vehicle luxuryCar = VehicleFactory.createVehicle(VehicleType.economy, "LUX001", "BMW", 350);

		store1.addVehicle(luxuryCar);
		store2.addVehicle(suvCar);
		store2.addVehicle(economyCar);
		
		User user1=rentalSystem.registerUser("John", 97320, "john@gmail.com");
		Reservation reservation=rentalSystem.createReservation(user1.getId(), economyCar.getRegistrationNumber(), 
				store1.getId(), store2.getId(), sdf.parse("06/01/2025"), sdf.parse("11/01/2025"));
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Processing the payment for reservation #"+reservation.getId());
		System.out.println("Select payment method: 1.cash 2.card 3.Upi");
		
		int choice=scanner.nextInt();
		PaymentStrategy paymentStrategy;
		
		switch(choice) {
		case 1:
			paymentStrategy=new CashPaymentStrategy();
			break;
		case 2:
			paymentStrategy=new CardPaymentStrategy();
			break;
		default:
			paymentStrategy=new UpiPaymentStrategy();
			break;
		}
		
		
		boolean paymentSuccess=rentalSystem.processPayment(reservation.getId(), paymentStrategy);
		if(paymentSuccess) {
			System.out.println("Payment Successfully done");
			
			//start rental
			rentalSystem.startRental(reservation.getId());
			////simulate rental period///////
			//complete the rental
			rentalSystem.confirmReservation(reservation.getId());
		}
		else
			System.out.println("Payment failed");
	}
}