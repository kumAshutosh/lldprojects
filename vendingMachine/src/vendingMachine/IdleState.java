package vendingMachine;

public class IdleState implements VendingMachineState {

	public IdleState() {
		System.out.println("Machine in Idle State");
	}
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "Idle State";
	}

	@Override
	public VendingMachineState next(VendingMachineContext context) {
		// TODO Auto-generated method stub
		if(!context.getInventory().hasItem())
			return new SoldOutState();
		
		if(!context.getCoinList().isEmpty())
			return new HasMoneyState();
		
		return this;
	}

}
