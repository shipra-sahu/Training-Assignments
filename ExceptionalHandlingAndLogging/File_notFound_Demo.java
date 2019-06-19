package assignment.day3.exception_logging;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger; 
class File_notFound_Demo { 
  
	public static void main(String args[]) throws IOException 
	    { 
		Logger logger = Logger.getLogger("loggertest.BasicLogging"); 
		
	        try { 
	  
	            // Following file does not exist 
	            File file = new File("E:// file.txt"); 
	  
	            FileReader fr = new FileReader(file); 
	            fr.close();
	        } 
	        catch (FileNotFoundException e) { 
	            System.out.println("File does not exist"); 
	            logger.severe("File does not exist");
	        } 
	    } 
}
