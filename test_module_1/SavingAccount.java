package test_module_1;

public class SavingAccount extends Account {
	private static float interestRate = 12;

	public SavingAccount(SavingAccount sa) {
		super();
	}
	
	public SavingAccount() {
		super();
	}
	
	public void print() {
		System.out.println("Interest rate: "+ interestRate);
	}

	@Override
	public String toString() {
		return super.toString() + "SavingAccount [interestRate=" + interestRate + "]";
	}

	public float getInterestRate() {
		return interestRate;
	}
	
}
