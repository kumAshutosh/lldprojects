package vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineContext {
	private VendingMachineState currentState;
	
//no need to hae=ve other strategy of payment and handling inventory here, just for easy 
//codebase i am doing it in real scenario it should be different and context should only
//handle states
	private Inventory inventory;
	List<Coin> coinList;
	int selectedItemCode;
	
	public VendingMachineContext() {
		inventory=new Inventory(10);
		coinList=new ArrayList<>();
		currentState=new IdleState();//initially idle state
		System.out.println("Initialised:"+ currentState.getStateName());
	}
	
	public VendingMachineState getCurrentState() {
		return currentState;
	}
	public Inventory getInventory() {
		return inventory;
	}
	//main function for context or controller
	public void advanceState() {
		VendingMachineState nextState=currentState.next(this);//get next state
		currentState=nextState;
		System.out.println("Current State:"+currentState.getStateName());
	}
	
	public void clickOnInsertCoinButton(Coin coin) {
		if (currentState instanceof IdleState || currentState instanceof HasMoneyState) {
			System.out.println("Inserted Money:"+coin.name()+"value:"+coin.value);
			coinList.add(coin);
			advanceState();
		}
		else {
			System.out.println("Can't insert coin in:"+currentState.getStateName());
		}
	}
	
	
	public void clickOnProductSelectionButton(int codeNumber) {
		if(currentState instanceof HasMoneyState) {
			setSelectedItemCode(codeNumber);
			advanceState();//move to product selection state
			selectProduct(codeNumber);//select product
		}
		else {
			System.out.println("Product selection can only be clicked in HasMoney State");
		}
	}

	private void selectProduct(int codeNumber) {
		// TODO Auto-generated method stub
		if(currentState instanceof SelectionState) {
			try {
				Item item = inventory.getItem(codeNumber);
				int balance = getBalance();
				if (balance < item.getPrice()) {
					System.out.println("Insufficient amount");
					return;
				}
				setSelectedItemCode(codeNumber);
				advanceState();
				dispenseItem(codeNumber);

				if (balance > item.getPrice()) {
					int change = balance - item.getPrice();
					System.out.println("Returning change" + change);
				}
			} catch (Exception e) {
				System.out.println("Failed to select at this moment");;
			}
		}
		else
			System.out.println("Can't select in :"+currentState.getStateName());
	}

	private int getBalance() {
		// TODO Auto-generated method stub
		int balance=0;
		for(Coin coin:coinList)
			balance+=coin.value;
		return balance;
	}

	private void dispenseItem(int codeNumber) {
		// TODO Auto-generated method stub
		if (currentState instanceof DispenseState) {
			try {
				Item item = inventory.getItem(codeNumber);
				System.out.println("Dispensing item" + item.getType());
				inventory.removeItem(codeNumber);
				inventory.updateSoldOutItem(codeNumber);
				resetBalance();
				resetSelection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Faailed to dispense at this moment");
			}
		}
	}

	private void resetSelection() {
		// TODO Auto-generated method stub
		this.selectedItemCode=0;
	}

	private void resetBalance() {
		// TODO Auto-generated method stub
		coinList.clear();
	}

	private void setSelectedItemCode(int codeNumber) {
		// TODO Auto-generated method stub
		this.selectedItemCode=codeNumber;
	}

	public List<Coin> getCoinList() {
		// TODO Auto-generated method stub
		return coinList;
	}

	public int getSelectedItemCode() {
		// TODO Auto-generated method stub
		return selectedItemCode;
	}

	public void updateInventory(Item newItem, int codeNumber) {
		// TODO Auto-generated method stub
		inventory.addItem(newItem, codeNumber);
	}

}
