package vendingMachine;

public class HasMoneyState implements VendingMachineState{

	public HasMoneyState() {
		System.out.println("Machine in HasMoney State");
	}
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "HasMoney State";
	}

	@Override
	public VendingMachineState next(VendingMachineContext context) {
		// TODO Auto-generated method stub
		if(!context.getInventory().hasItem())
			return new SoldOutState();
		
		if(context.getCoinList().isEmpty())
			return new IdleState();
		
		if(context.getSelectedItemCode()==0)
			return this;
		
		return new SelectionState();
	}

}
