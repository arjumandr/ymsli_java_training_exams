package test_module_1;

public class Account {
	Owner owner;
	private float balance;
	private String number;
	public Account(Owner owner, float balance, String number) {
		this.owner = owner;
		this.balance = balance;
		this.number = number;
	}
	
	public Account() {
	}
	
	public Account(Account account) {
		this.balance = account.getBalance();
		this.number = account.getNumber();
		this.owner = account.getOwner();
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	 @Override
	 public String toString() {
		 owner.toString();
		return "Account [balance=" + balance + ", number=" + number + "]";
	 }
	 public void deposit(double amount) {
		 this.balance += amount;
	 }
	 public void withdraw(double amount) throws InsufficientBalance {
		 try {
			 if(balance >= amount) {
				 balance -= amount;
				 System.out.println("Withdrew rupees "+amount);
			 }
			 else {
				 throw new InsufficientBalance();
			 }
		 }
		 catch(InsufficientBalance e) {
			 e.getStackTrace();
		 }
	 }
	
}
