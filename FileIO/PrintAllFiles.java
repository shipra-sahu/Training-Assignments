/* Program to print all the files of a Directory recursively */

package assignment.day3.fileio;

import java.io.File;
import java.util.Scanner;


public class PrintAllFiles {
	//Method to recursively print all the files of a directory
	private static void returnFiles(File[] arr,int level) {
		
		for(File f: arr) {
			for(int i=0;i<level;i++)
				System.out.print("\t");          //tab for each level of hierarchy
			if(f.isFile()) {					 //check if it is a file
				System.out.println(f.getName());
			}
			else if(f.isDirectory()) {			//check if it is a Directory
				System.out.println("[ "+f.getName()+" ]");
				returnFiles(f.listFiles(),level+1);
			}
		}
	}

	public static void main(String[] args) { 
	
			//String dirpath= "C:\\Dell";
			System.out.println("Enter the Path of the Directory : ");
			@SuppressWarnings("resource")
			Scanner scn = new Scanner(System.in);
			String dirpath= scn.next();
			File dir= new File(dirpath);
			if(dir.exists()&&dir.isDirectory()) {
				File[] files = dir.listFiles();
				
				System.out.println("*********************************************************");
				System.out.println(" All the files of the Directory : ["+dir.getName()+"] are listed below : ");
				System.out.println("*********************************************************");
				returnFiles(files,0);
			}
			else {
				System.out.println("Directory Not Found");
			}
	
}
}