package atmState;

public class TransactionState implements ATMState{

	public TransactionState() {
		System.out.println("System in Transaction State");
	}
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "TransactionState";
	}

	@Override
	public ATMState next(ATMMachineContext context) {
		// TODO Auto-generated method stub
		if(context.getCurrentCard()==null)
			return new IdleState();
		return new SelectOperationState();
	}

}
