package payment;

public class CashPaymentStrategy implements PaymentStrategy{

	@Override
	public void processPayment(double amount) {
		// TODO Auto-generated method stub
		System.out.println("cash payment done:"+ amount);
	}

}
