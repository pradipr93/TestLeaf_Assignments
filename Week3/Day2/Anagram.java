package javaLearning.practiceProgram.String;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {

		String str1 = "silent";
		String str2 = "listen";

		char ch1[] = str1.toCharArray();
		char ch2[] = str2.toCharArray();
		if (str1.length() == str2.length()) {
			Arrays.sort(ch1);
			Arrays.sort(ch2);

			String string1 = Arrays.toString(ch1);
			String string2 = Arrays.toString(ch2);
			
			System.out.println(string1);
			System.out.println(string2);
			if(string1.equals(string2))
			{
				System.out.println("Two Strings are not Anagram of each other");
			}

		}
		else
			System.out.println("Two Strings are not Anagram of each other");

	}

}
