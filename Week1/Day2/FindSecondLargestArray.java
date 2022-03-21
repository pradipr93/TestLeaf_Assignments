package javaLearning.practiceProgram;

import java.util.Arrays;

public class FindSecondLargestArray {
	
public void getSecondLargestNum(int[] a) {
	
	//sort Array
	Arrays.sort(a);
	
	System.out.println(a.toString());
	//2nd last number will be second largest number
	System.out.println("Second Largest Number is: " + a[a.length - 2]);

}

public static void main(String[] args) {
	
	FindSecondLargestArray largeNumObj = new FindSecondLargestArray();
	int a[] = {20,40,30,90,180,250,670,900,700};
	largeNumObj.getSecondLargestNum(a);
	
}

}
