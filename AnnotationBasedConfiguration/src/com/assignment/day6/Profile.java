package com.assignment.day6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
	@Autowired
	   @Qualifier("student")
	   private Student student;

	   public Profile(){
	      System.out.println("Inside Profile constructor." );
	   }
	   public void printAge() {
	      System.out.println("Age : " + student.getAge() );
	   }
	   public void printName() {
	      System.out.println("Name : " + student.getName() );
	   }
}
