package assignment.day3.exception_logging;

import java.util.logging.*;
public class ArithmeticException_Demo { 
	public static void main(String args[]) 
	    { 
		Logger logger = Logger.getLogger("loggertest.BasicLogging");

	        try { 
	            int a = 748, b = 0; 
	            int c = a / b; // cannot divide by zero 
	            System.out.println("Result = " + c); 
	            logger.info("Result = " + c);
	        } 
	        catch (ArithmeticException e) { 
	            System.out.println("Divided by zero (error)!!!!!!!"); 
	            logger.log(Level.INFO, "Divided by zero (error)!!!!!!!");
	        } 
	    } 
} 