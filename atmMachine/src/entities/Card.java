package entities;

public class Card {
	private String cardNumber;
	private int pin;
	private String accountNumber;

	public String getCardNumber() {
		return cardNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public boolean validatePin(int enterPin) {
		return this.pin==enterPin;
	}
	public Card(String cardNumber,int pin,String acNo) {
		this.accountNumber=acNo;
		this.pin=pin;
		this.cardNumber=cardNumber;
	}
}
