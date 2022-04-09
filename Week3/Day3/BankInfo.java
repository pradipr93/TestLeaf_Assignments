package javaLearning.practiceProgram;

//Bank Info- Contains information related to bank
public class BankInfo {
	
	double expense,  sal;
	public void saving() {
		 
		System.out.println("Saving is " +(this.sal - this.expense));

	}
	

	public void fixed(double fd) {
		
		System.out.println("Fixed Deposit Amount at 6 % rate of interest " +(fd + fd*6/100));

	}

	public void deposit(double deposit) {
		
		
		System.out.println("Deposited " +(this.sal + deposit));

	}

}
