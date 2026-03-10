package vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class ItemShelf {
	private int code;
	private List<Item> items;
	private boolean isSoldOut;
	
	public ItemShelf(int code,boolean isSoldOut) {
		this.setCode(code);
		this.setSoldOut(isSoldOut);
		this.setItems(new ArrayList<>());
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSoldOut() {
		return isSoldOut;
	}

	public void setSoldOut(boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void add(Item item) {
		// TODO Auto-generated method stub
		items.add(item);
		if(isSoldOut())
				setSoldOut(false);
	}
}
