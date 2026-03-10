package vendingMachine;

public class SelectionState implements VendingMachineState{

	public SelectionState() {
		System.out.println("Machine in Selection State");
	}
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "Selection State";
	}

	@Override
	public VendingMachineState next(VendingMachineContext context) {
		// TODO Auto-generated method stub
		if(!context.getInventory().hasItem())
			return new SoldOutState();
		
		if(context.getCoinList().isEmpty())
			return new IdleState();
		
		if(context.getSelectedItemCode()>0)
			return new DispenseState();
		
		return this;//for multiple coin check
	}

}
