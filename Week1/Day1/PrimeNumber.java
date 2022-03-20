package week1.day1;

public class PrimeNumber {
	
	public static void main(String[] args) {
		int num = 13;
		boolean flag = false;
		int rem;
		for (int i = 2; i < num/2; i++) {
			
			rem = num%i;
			if(rem==0)
			{
				flag = true;
				break;
			}
				
			
		}
		if (!flag == true)
		{
			System.out.println(num + " is prime number");
		}

		else
		{
			{
				System.out.println(num + " is not prime number");
			}
		}
		
	}

}
