package atmState;

import entities.Account;
import entities.Card;
import entities.TransactionType;

public class Main {
    public static void main(String[] args) {
        // Create and initialize ATM
        ATMMachineContext atm = new ATMMachineContext();

        // Add sample accounts
        atm.addAccount(new Account("123456", 1000.0));
        atm.addAccount(new Account("654321", 500.0));

        try {
            // Sample workflow
            System.out.println("=== Starting ATM Demo ===");

            // Insert card
            atm.insertCard(new Card("126", 1234, "123456"));

            // Enter PIN
            atm.enterPin(1234);

            // Select operation
            atm.selectOperationState(TransactionType.WITHDRAW_CASH);

            // Perform transaction
            atm.performTransaction(980);

            // Select another operation
            atm.selectOperationState(TransactionType.CHECK_BALANCE);

            // Perform balance check
            atm.performTransaction(0);

            // Return card
            atm.returnCard();

            System.out.println("=== ATM Demo Completed ===");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
