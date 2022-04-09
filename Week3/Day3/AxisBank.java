package javaLearning.practiceProgram;

//AxisBank child of BankInfo Class
public class AxisBank extends BankInfo {

	//overrides fixed method to enhance the rate of interest
@Override
public void fixed(double fd) {
		
		System.out.println("Fixed Deposit Amount at 10 % rate of interest " +(fd + fd*10/100));

	}
	
	public static void main(String[] args) {
		AxisBank bank = new AxisBank();
		bank.sal = 30000;
		bank.expense = 10000;
		
		bank.saving();
		bank.fixed(5000);
		bank.deposit(20000);
	}

}
