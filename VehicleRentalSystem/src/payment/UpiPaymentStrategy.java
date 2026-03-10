package payment;

public class UpiPaymentStrategy implements PaymentStrategy{

	@Override
	public void processPayment(double amount) {
		// TODO Auto-generated method stub
		System.out.println("upi payment done:"+ amount);
	}

}
