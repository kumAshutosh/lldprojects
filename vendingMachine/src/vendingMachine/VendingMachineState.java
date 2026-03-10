package vendingMachine;

public interface VendingMachineState {
	String getStateName();
	
	VendingMachineState next(VendingMachineContext context);
}
