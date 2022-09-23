package com.cg.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {

	public static void main(String[] args) {
		/*Student s= new Student();
		s.setStudentName("Akshay kalubarme");
		s.display();*/
		
		ApplicationContext c= new ClassPathXmlApplicationContext("beans.xml");
		Student s=c.getBean("s",Student.class);
		s.display();
	}

}
