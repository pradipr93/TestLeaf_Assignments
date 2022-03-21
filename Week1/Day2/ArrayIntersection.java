package javaLearning.practiceProgram;

public class ArrayIntersection {

	//To find Intersection of 2 array
	//i.e. to find common element
	public void getIntersection(int[] a, int[] b)
	{
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
	public static void main(String[] args) {
		int[] a = {1,2,4,6,9};
		int[] b = {1,8,3,6,9};
		ArrayIntersection intersectionObj = new ArrayIntersection();
		intersectionObj.getIntersection(a, b);
		

	}

}
