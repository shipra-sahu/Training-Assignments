package com.assignment.day6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      
	      Student student = (Student) context.getBean("student");
	      System.out.println("Name : " + student.getName() );
	      System.out.println("Age : " + student.getAge() );
	      TextEditor te = (TextEditor) context.getBean("textEditor");

	      te.spellCheck();
	      
	      Profile profile = (Profile) context.getBean("profile");
	      profile.printAge();
	      profile.printName();
	   }

}
