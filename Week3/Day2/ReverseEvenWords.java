package javaLearning.practiceProgram.String;

import java.util.Arrays;

public class ReverseEvenWords {

	public static String reverseString(String str) {

		String str2= "";
		for (int i = str.length()-1; i >=0; i--)
			str2 = str2+str.charAt(i);
		System.out.println(str2);

		return str2;
	}

	
	public static void main(String[] args) {

		String str = "I am a software tester";
		String str2 =""; 
		
		String[] strArr = str.split(" "); 
		
		System.out.println(Arrays.toString(strArr));
		
		for(int i =0; i<strArr.length; i++)
		{
			if((i+1)%2 == 0)
			{
				strArr[i] = reverseString(strArr[i]);
				System.out.println(strArr[i]);
			}
		}
		
		System.out.println(Arrays.toString(strArr));
		for(int i =0; i<strArr.length; i++)
		{
			str2 = str2 + strArr[i]+" ";
		}
		
		System.out.println("After reversing Even word: " +str2);


	}

}
