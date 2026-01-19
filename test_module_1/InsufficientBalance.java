package test_module_1;

public class InsufficientBalance extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientBalance() {
		System.out.println("Insufficient balance! Cant withdraw amount.");
	}
	
}