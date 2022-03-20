package week1.day1;

public class CovertNeg2Pos {

	public static void main(String[] args) {
		int num = -35;
		
		if(num<0)
		{
			System.out.println(num + " is negative number");
			
			num = num * -1;
			
			System.out.println("Converted Number :" +num);
		}

	}

}
