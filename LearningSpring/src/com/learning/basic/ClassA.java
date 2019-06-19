package com.learning.basic;

import org.springframework.beans.factory.annotation.Autowired;

public class ClassA {
	
	ClassBInterface b=new ClassB();
//	public ClassA() {
//		
//	}
//	public ClassA(ClassBInterface b){
//		this.b=b;
//	}

	public void methodA() {
		System.out.println("Method A");	
		System.out.println(b.methodB());
	}

	public ClassBInterface getB() {
		return b;
	}
	@Autowired
	public void setB(ClassBInterface b) {
		this.b = b;
	}
	
	public void init() {
		System.out.println("Constructor A called");
	}

//	@Override
//	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
//		System.out.println("postProcessAfterInitialization");
//		return null;
//	}
//
//	@Override
//	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
//		System.out.println("postProcessBeforeInitialization");
//		return null;
//	}

}
