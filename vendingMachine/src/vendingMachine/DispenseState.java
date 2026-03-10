package vendingMachine;

public class DispenseState implements VendingMachineState{

	public DispenseState() {
		System.out.println("Machine is Dispensing item");
	}
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "Dispense State";
	}

	@Override
	public VendingMachineState next(VendingMachineContext context) {
		// TODO Auto-generated method stub
		return new IdleState();
	}

}
