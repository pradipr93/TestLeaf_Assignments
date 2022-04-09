package javaLearning.practiceProgram.String;

public class Palindrome {

	public static String reverseString(String str) {

		String str2= "";
		for (int i = str.length()-1; i >=0; i--)
			str2 = str2+str.charAt(i);
		System.out.println(str2);

		return str2;
	}

	public static void main(String[] args) {
		String str = "madam";
		String revStr = reverseString(str);
		System.out.println("Reverse of String is"+revStr);
		if (str.equals(revStr))
			System.out.println("Given string is palindrome");
		else
			System.out.println("Given string is not palindrome");

	}

}
