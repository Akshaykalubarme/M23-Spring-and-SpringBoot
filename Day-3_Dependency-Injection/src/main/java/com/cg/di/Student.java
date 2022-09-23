package com.cg.di;

public class Student 
{
	private String StudentName;
	private int rollno;
	
	//DI using constructor
	public Student(String studentName, int rollno) {
		super();
		StudentName = studentName;
		this.rollno = rollno;
	}
	
	/*//DI using setters method
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}*/
	
	//userDefined method
	public void display()
	{
		System.out.println("Studentname is: "+StudentName+" "+"and Roll No is:"+rollno);
	}


}
