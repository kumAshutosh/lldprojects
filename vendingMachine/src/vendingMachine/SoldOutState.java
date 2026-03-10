package vendingMachine;

public class SoldOutState implements VendingMachineState {

	public SoldOutState() {
		System.out.println("system in soldout --- out of stock");
	}
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "SoldOut State";
	}

	@Override
	public VendingMachineState next(VendingMachineContext context) {
		// TODO Auto-generated method stub
		if(context.getCoinList().isEmpty())
			return new IdleState();
		
		return this;
	}

}
