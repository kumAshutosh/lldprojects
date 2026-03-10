package atmState;

public class SelectOperationState implements ATMState{

	public SelectOperationState() {
		System.out.println("System in SelectOperation State");
	}
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "SelectOperationState";
	}
	@Override
	public ATMState next(ATMMachineContext context) {
		// TODO Auto-generated method stub
		if(context.getCurrentCard()==null)
			return new IdleState();
		if(context.getSelectedOperation()!=null)
			return new TransactionState();
		return this;
	}

}
