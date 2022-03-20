package week1.day1;

public class Factorial {
	
	
	public static void main(String[] args) {
		
		int num =5, fact=1;
		System.out.println("Factorial of a Number " +num+":");
		for(int i=1; i<=num; i++)
		{
			fact =fact*i;
			
		}
		System.out.println(fact);
	}

}
