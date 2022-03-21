package javaLearning.practiceProgram;

import java.util.Arrays;

public class FindDuplicateArray {
	
	public void findDuplicateNum(int[] a)
	{
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		for(int i=0; i<a.length; i++)
		{
			int count =0;
			
			for(int j= i+1; j<a.length; j++)
			{
				if(a[i] == a[j])
				{
					count++;
				}
			}
			
			if(count>0)
			{
				System.out.println(a[i]);
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		int[] a = {20,40,30,20,90,180,250,670,900,900,700};
		int b[] =new int[] {10, 20, 30, 40};
		System.out.println(b);
		FindDuplicateArray duplObj = new FindDuplicateArray();
		duplObj.findDuplicateNum(a);
		
	}

}
