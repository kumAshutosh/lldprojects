package entities;

import java.util.HashMap;
import java.util.Map;

public class ATMInventory {
	private Map<CashType,Integer> cashInventory;
	
	public ATMInventory() {
		cashInventory=new HashMap<>();
		initializeInventory();
	}

	private void initializeInventory() {
		// TODO Auto-generated method stub
		cashInventory.put(CashType.BILL_100, 10);
		cashInventory.put(CashType.BILL_50, 10);
		cashInventory.put(CashType.BILL_20, 10);
		cashInventory.put(CashType.BILL_10, 10);
	}
	
	public boolean hasCash(int amount) {
		return getTotalCash()>=amount;
	}
	public void addCash(Map<CashType,Integer> amount) {
		
	}
	public int getTotalCash() {
		int total=0;
		for(Map.Entry<CashType, Integer> entry:cashInventory.entrySet()) {
			total+=entry.getKey().value *entry.getValue();
		}
		return total;
	}
	
	public Map<CashType,Integer> dispenseCash(int amount) {
		Map<CashType,Integer> dispenseCash=new HashMap<>();
		
		if(!hasCash(amount)) return null;
		
		int remainingAmount=amount;
		for(CashType cashType:CashType.values()) {
			int count=Math.min(remainingAmount/cashType.value,cashInventory.get(cashType));
			
			if(count>0) {
				dispenseCash.put(cashType, count);
				remainingAmount-=count*cashType.value;
				cashInventory.put(cashType, cashInventory.get(cashType)-count);
			}
		}
		
		if(remainingAmount>0) {
			//rollaback
			for(Map.Entry<CashType,Integer> entry:dispenseCash.entrySet()) {
				cashInventory.put(entry.getKey(), cashInventory.get(entry.getKey())+entry.getValue());
			}
			return null;
		}
		return dispenseCash;
	}

	public boolean hasSufficientCash(int amount) {
		// TODO Auto-generated method stub
		return getTotalCash()>=amount?true:false;
	}
}
