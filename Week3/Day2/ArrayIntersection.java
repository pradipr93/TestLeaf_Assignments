package javaLearning.practiceProgram;

import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

	//To find Intersection of 2 array
	//i.e. to find common element
	
	//1st method by iterating array
	public void getIntersection(int[] a, int[] b)
	{
		getIntersectionUsingSet(a,b);
		for(int i=0; i<a.length; i++)
		{
			for(int j=0; j<b.length; j++)
			{
				if(a[i] == b[j])
				{
					System.out.println("Intersection of 2 array is: " +a[i]);
				}
			}
		}
	}
	
	//2nd method using Set
	public static void getIntersectionUsingSet(int[] a, int[] b)
	{
		//declared set to collect values in array a
		Set<Integer> intSet = new HashSet<Integer>();
		//declared set to collect values in array b
		Set<Integer> intSet2 = new HashSet<Integer>();
		//declared set to collect intersect values from both a & b
		Set<Integer> resSet = new HashSet<Integer>();
		//loop to iterte array - a and store in intSet
		for(int n : a)
			intSet.add(n);
		//loop to iterte array - b and store in intSet2
		for(int n : b)
			intSet2.add(n);
		//loop to iterte array - b and check if inSet contains b value 
		//and intersecting values in resSet
		for(int n : b)
		{
			if(intSet.contains(n))
			resSet.add(n);
		}
		System.out.println(resSet);
		
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,4,6,9};
		int[] b = {1,8,3,6,9};
		getIntersectionUsingSet(a,b);
	}

}
