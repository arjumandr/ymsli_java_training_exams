package test_module_1;

public class CurrentAccount extends Account {
	private static float minimumBalance = 2000;

	public CurrentAccount(CurrentAccount ca) {
		super();
	}
	public CurrentAccount() {
		super();
	}
	public void print() {
		System.out.println("Minimum Balance: " + minimumBalance);
	}
	@Override
	public String toString() {
		super.toString();
		return super.toString() + "CurrentAccount [minimumBalance=" + minimumBalance + "]";
	}
	public float getMinimumBalance() {
		return minimumBalance;
	}
}
