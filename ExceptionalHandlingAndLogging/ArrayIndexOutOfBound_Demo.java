package assignment.day3.exception_logging;

import java.util.logging.Logger;

public class ArrayIndexOutOfBound_Demo { 
	public static void main(String args[]) 
	    { 
		
		Logger logger = Logger.getLogger("loggertest.BasicLogging");
		
	        try { 
	            int arr[] = new int[5]; 
	            arr[7] = 9; // accessing 7th element in an array of 
	            // size 5 
	        } 
	        catch (ArrayIndexOutOfBoundsException e) { 
	            System.out.println("Array Index is Out Of Bounds"); 
	            logger.info("Array Index is Out Of Bounds");
	        } 
	    } 
}
