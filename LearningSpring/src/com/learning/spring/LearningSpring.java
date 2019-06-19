package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learning.basic.ClassA;
import com.learning.basic.ClassB;
import com.learning.basic.ClassB2;
import com.learning.basic.ClassC;
import com.learning.dao.ICustomer;
import com.learning.model.Customer;

public class LearningSpring {

	private static ApplicationContext context;

	public static void main(String[] args) {
		System.out.println("Learning Spring");
//		ClassB2 b=new ClassB2();
//		ClassA a=new ClassA(b);
//		a.methodA();
//		ClassC c=new ClassC(b);
//		c.methodC();
		
		context = new ClassPathXmlApplicationContext("beans.xml");
//		ClassA a= (ClassA) context.getBean("a");
//		System.out.println(a);
//		ClassA a2= (ClassA) context.getBean("a");
//		System.out.println(a2);
//		a.methodA();
//		ClassC c= (ClassC) context.getBean("c");
//		c.methodC();
		Customer customer1= new Customer();
		customer1.setCust_id(2);
		customer1.setName("Shipra");
		customer1.setAge(22);
		ICustomer customer=(ICustomer)context.getBean("customerDao");
		customer.saveCustomer(customer1);
	    ((ConfigurableApplicationContext)context).close();
 
	}

}
