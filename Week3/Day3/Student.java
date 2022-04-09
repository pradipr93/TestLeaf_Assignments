package org.student;
import org.department.Department;

public class Student extends Department{
	
	private String studentName(String studName)
	{
		return studName;
	}

	private String studentDept(String studDep) {

		return studDep;
		
	}
	
	private int studentID(int id)
	{
		return id;
	}
	
	public static void main(String[] args)
	{
		Student stud = new Student();
		System.out.println(stud.collegeCode(1101));
		System.out.println(stud.collegeName("IT"));
		System.out.println(stud.collegeRank(11));
		System.out.println(stud.departName("CSE"));
		System.out.println(stud.studentName("Ram"));
		System.out.println(stud.studentDept("CSE"));
		System.out.println(stud.studentID(1259964));
	}
}
