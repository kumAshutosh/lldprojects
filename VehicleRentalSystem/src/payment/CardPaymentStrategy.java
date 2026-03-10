package payment;

public class CardPaymentStrategy implements PaymentStrategy{

	@Override
	public void processPayment(double amount) {
		// TODO Auto-generated method stub
		System.out.println("card payment done:"+ amount);
	}

}
