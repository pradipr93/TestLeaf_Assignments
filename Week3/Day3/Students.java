package javaLearning.practiceProgram;



public class Students {

	public void getStudentInfo(int id)
	{
		System.out.println("Student ID: " +id);
		
	}
	
	public void getStudentInfo(int id, String name)
	{
		System.out.println("Student ID: " +id);
		System.out.println("Name: " +id);
	}
	
	public void getStudentInfo(String email, String phno)
	{
		System.out.println("Email ID: " +email);
		System.out.println("Phone Number: " +phno);
	}
	public static void main(String[] args) {

      Students stud = new Students();
      
      stud.getStudentInfo(123567);
      stud.getStudentInfo("pradiprock965@gmail.com", "781761651651");
      
      stud.getStudentInfo(1675167, "PK");

	}

}
