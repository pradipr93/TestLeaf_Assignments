package javaLearning.practiceProgram.String;

public class FindTypes {

	public static void main(String[] args) {

		int num = 0, character =0, space = 0,  spChar = 0;
		
		String str = "$$&& Welcome 2 India 178906211 &&%)";
		
		str = str.toUpperCase();
		
		
		for(int i =0; i<str.length(); i++)
		{
			if(str.charAt(i)>='A' && str.charAt(i)<='Z')
				++character;
			else if(str.charAt(i)>='0' && str.charAt(i)<='9')
				++num;
			else if(str.charAt(i) == ' ')
				++space;
			else
				++spChar;
		}
		
		System.out.println("Total occurance of Character is " +character);
		System.out.println("Total occurance of Number is " +num);
		System.out.println("Total occurance of Space is " +space);
		System.out.println("Total occurance of SCharacter is " +spChar);

	}

}
