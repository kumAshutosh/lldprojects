package atmState;

public class HasCardState implements ATMState{

	public HasCardState() {
		System.out.println("System in HasCard State");
	}
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "HasCardState";
	}

	@Override
	public ATMState next(ATMMachineContext context) {
		// TODO Auto-generated method stub
		if(context.getCurrentCard()==null)
			return new IdleState();
		if(context.getCurrentAccount()!=null)
			return new SelectOperationState();
		return this;
	}

}
