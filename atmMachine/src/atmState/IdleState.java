package atmState;

public class IdleState implements ATMState{

	public IdleState() {
		System.out.println("System in IDLE State");
	}
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return "IdleState";
	}

	@Override
	public ATMState next(ATMMachineContext context) {
		// TODO Auto-generated method stub
		if(context.getCurrentCard()!=null)
			return new HasCardState();
		return this;
	}

}
