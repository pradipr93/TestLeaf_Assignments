package javaLearning.practiceProgram.String;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWord {

	public static void main(String[] args) {

		String text = "We learn java basics as part of java sessions in java week1";	
		String result ="";
		String[] textArr = text.split("\\s+");
		
		System.out.println(Arrays.toString(textArr));
		Set<String> textSet = new LinkedHashSet<String>();
		
		for(String tex : textArr)
		{
		textSet.add(tex);
		}
		System.out.println(textSet);
		
		for(String str: textSet)
		{
			result = result+str+" ";
		}
		System.out.println(result);
	}

}
