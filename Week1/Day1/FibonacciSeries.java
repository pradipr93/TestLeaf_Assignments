package week1.day1;

public class FibonacciSeries {

	public static void main(String[] args) {
		int firstNum = 0;
		int secNum = 1;
		int range = 8;
		int sum;
		
		System.out.println("***Fibonacci Series***");
		System.out.println(firstNum);
		System.out.println(secNum);
		for(int i=1; i<range-1; i++)
		{
			sum = firstNum + secNum; 
			firstNum=secNum;
			secNum =sum;
			System.out.println(sum);
		}
	}

}
