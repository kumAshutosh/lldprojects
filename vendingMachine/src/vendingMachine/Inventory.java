package vendingMachine;

public class Inventory {
	ItemShelf[] inventory=null;
	
	public Inventory(int itemCount) {
		inventory=new ItemShelf[itemCount];
		initializeInventory();
	}
	
	private void initializeInventory() {
		// TODO Auto-generated method stub
		int startCode=101;
		for(int i=0;i<inventory.length;i++) {
			inventory[i] = new ItemShelf(5, false);
			inventory[i].setCode(startCode);
			startCode++;
		}
	}

	public void addItem(Item item,int code) {
		for(ItemShelf itemShelf:inventory) {
			if(itemShelf.getCode()==code) {
				itemShelf.add(item);
			}
		}
	}
	public ItemShelf[] getInventory() {
		return inventory;
	}
	
	public Item getItem(int codeNumber) throws Exception{
		for(ItemShelf itemShelf: inventory) {
			if(itemShelf.getCode()==codeNumber) {
				if(itemShelf.isSoldOut())
					throw new Exception("Item soldout");
				else return itemShelf.getItems().get(0);
			}
		}
		throw new Exception("Invalid code");
	}
	
	public void updateSoldOutItem(int code) {
		for(ItemShelf itemShelf:inventory) {
			if(itemShelf.getCode()==code) {
				if(itemShelf.getItems().isEmpty())
					itemShelf.setSoldOut(true);
			}
		}		
	}
	public boolean hasItem() {
		for(ItemShelf itemShelf:inventory) {
			if(!itemShelf.isSoldOut())
				return true;
		}
		return false;
	}
	public void removeItem(int code) {
		for(ItemShelf itemShelf:inventory) {
			if(itemShelf.getCode()==code) {
				itemShelf.getItems().remove(0);
			}
		}
	}
}
