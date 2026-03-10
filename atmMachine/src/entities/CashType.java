package entities;

public enum CashType {

BILL_100(100),
BILL_50(50),
BILL_20(20),
BILL_10(10);

	public final int value;
	CashType(int i) {
	// TODO Auto-generated constructor stub
	this.value=i;
	}
}
