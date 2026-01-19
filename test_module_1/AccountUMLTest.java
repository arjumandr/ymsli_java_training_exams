//package test_module_1;
//
//public class AccountUMLTest {
//	public static void main(String[] args) {
//		Date date = new Date(19, 1, 2026);
//		Owner owner = new Owner("AR", date, "nic1");
//		Account acc1 = new Account();
//		Account acc2 = new Account(owner, 20000, "93479472");
//		Account acc3 = new Account(acc2);
//		System.out.println(acc2.toString());
//		System.out.println(acc3.toString());
//
//		try {
//			acc2.withdraw(22000);
//		} catch (InsufficientBalance e) {
//			e.printStackTrace();
//		}
//		acc2.deposit(10000);
//		try {
//			acc2.withdraw(22000);
//		} catch (InsufficientBalance e) {
//			e.printStackTrace();
//		}
//		System.out.println(acc2.toString());
//		Account acc4 = new SavingAccount();
//		acc4.setBalance(30000);
//		acc4.setOwner(owner);
//		acc4.setNumber("4728649");
//		try {
//			acc4.withdraw(423);
//		} catch (InsufficientBalance e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(acc4.toString());
//		
//		Account acc5 = new CurrentAccount();
//		acc5.toString();
//		acc5.setBalance(30000);
//		acc5.setOwner(owner);
//		acc5.setNumber("4728649");
//		try {
//			acc5.withdraw(4500);
//		} catch (InsufficientBalance e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(acc5.toString());
//	}
//}


package test_module_1;

public class AccountUMLTest {

    public static void main(String[] args) {

        // ---------- Common Test Data ----------
        Date dob = new Date(19, 1, 2026);
        Owner owner = new Owner("AR", dob, "nic1");

        // ---------- Account Creation ----------
        System.out.println("=== Account Creation ===");

        Account defaultAccount = new Account();
        Account accountWithData = new Account(owner, 20000, "93479472");
        Account copiedAccount = new Account(accountWithData);

        System.out.println("Account with data: " + accountWithData);
        System.out.println("Copied account: " + copiedAccount);

        // ---------- Withdraw & Deposit Tests ----------
        System.out.println("\n=== Withdraw & Deposit Tests ===");

        System.out.println("Attempting to withdraw 22000 from accountWithData");
        try {
            accountWithData.withdraw(22000); 
        } catch (InsufficientBalance e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        System.out.println("Depositing 10000 into accountWithData");
        accountWithData.deposit(10000);

        System.out.println("Attempting to withdraw 22000 from accountWithData again");
        try {
            accountWithData.withdraw(22000); 
            System.out.println("Withdrawal successful");
        } catch (InsufficientBalance e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        System.out.println("Final state of accountWithData: " + accountWithData);

        // ---------- Saving Account Test ----------
        System.out.println("\n=== Saving Account Test ===");

        Account savingAccount = new SavingAccount();
        savingAccount.setOwner(owner);
        savingAccount.setNumber("4728649");
        savingAccount.setBalance(30000);

        System.out.println("Attempting to withdraw 423 from savingAccount");
        try {
            savingAccount.withdraw(423);
            System.out.println("Withdrawal successful");
        } catch (InsufficientBalance e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        System.out.println("Saving account state: " + savingAccount);

        // ---------- Current Account Test ----------
        System.out.println("\n=== Current Account Test ===");

        Account currentAccount = new CurrentAccount();
        currentAccount.setOwner(owner);
        currentAccount.setNumber("4728650");
        currentAccount.setBalance(30000);

        System.out.println("Attempting to withdraw 4500 from currentAccount");
        try {
            currentAccount.withdraw(4500);
            System.out.println("Withdrawal successful");
        } catch (InsufficientBalance e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }

        System.out.println("Current account state: " + currentAccount);
    }
}

