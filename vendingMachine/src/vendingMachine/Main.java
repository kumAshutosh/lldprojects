package vendingMachine;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachineContext vendingMachine = new VendingMachineContext();
		try {
			System.out.println("Filling up items in inventory");
			
			fillUpInventory(vendingMachine);
			displayInventory(vendingMachine);
			
			System.out.println("InsertING the coinS");
			vendingMachine.clickOnInsertCoinButton(Coin.FIVE_RUPEES);
			vendingMachine.clickOnInsertCoinButton(Coin.TEN_RUPEES);
			
			System.out.println("product selection");
			vendingMachine.clickOnProductSelectionButton(103);
			displayInventory(vendingMachine);
		}
		catch(Exception e) {
			System.out.println("Error"+e.getMessage());
			displayInventory(vendingMachine);
		}
	}

	// Method to fill up the inventory of the vending machine
    private static void fillUpInventory(VendingMachineContext vendingMachine) {
        for (int i = 0; i < 9; i++) {
            Item newItem = new Item();
            int codeNumber = 100 + i; // Shelf code
            // Set item type and price based on the index range
            if (i >= 0 && i < 3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            } else if (i >= 3 && i < 5) {
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            } else if (i >= 5 && i < 7) {
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            } else if (i >= 7 && i < 10) {
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            // Update the inventory with multiple same items per shelf
            for (int j = 0; j < 5; j++) {
                // Add 5 items to each shelf
                vendingMachine.updateInventory(newItem, codeNumber);
            }
        }
    }

    // Method to display the current inventory of the vending machine
    private static void displayInventory(VendingMachineContext vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (ItemShelf slot : slots) {
            List<Item> items = slot.getItems(); // Get the list of items in the shelf
            if (!items.isEmpty()) {
                System.out.println("CodeNumber: " + slot.getCode() + " Items: ");
                for (Item item : items) { // Display all items in the shelf
                    System.out.println(
                            "    - Item: " + item.getType().name() + ", Price: " + item.getPrice());
                }
                System.out.println("SoldOut: " + slot.isSoldOut());
            } else {
                // Display empty shelf information
                System.out.println("CodeNumber: " + slot.getCode() + " Items: EMPTY"
                        + " SoldOut: " + slot.isSoldOut());
            }
        }
    }

}
