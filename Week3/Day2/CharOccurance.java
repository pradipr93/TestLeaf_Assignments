package javaLearning.practiceProgram.String;

public class CharOccurance {
	
	public static void main(String[] args) {
		
		String str = "Welcome to Chennai";
		char[] ch =str.toCharArray();
		int count =0;
		for(int i=0; i<str.length(); i++) {
			
			if(ch[i] == 'e')
			{
				++count;
			}
			
		}
		System.out.println("Number of occurance of e is "+count);
	}

}
