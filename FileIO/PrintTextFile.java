/* Program to list out all the files that end with ".txt "extension and then delete them */

package assignment.day3.fileio;

import java.io.File;
import java.util.Scanner;

public class PrintTextFile {

public static boolean isTextFile(File f) {
	String name = f.getName();
	String extension = name.substring(name.lastIndexOf('.'));
	//System.out.println(extension + name);
	
	if(extension.equals(".txt")) {				//checking if the file ends with .txt entension
		return true;
	}
	else 
		return false;
}

public static void main(String[] args) { 
			//String dirpath= "C:\\MyFolder";
			System.out.println("Enter the Path of the Directory : ");
			@SuppressWarnings("resource")
			Scanner scn = new Scanner(System.in);
			String dirpath= scn.next();
			File dir= new File(dirpath);
			if(dir.exists()&&dir.isDirectory()) { //if file exist and if it directory
				File[] files = dir.listFiles();
				
				System.out.println("*********************************************************");
				System.out.println(" All the files of the Directory : ["+dir.getName()+"] with .txt extension are listed below : ");
				System.out.println("*********************************************************");
				for(File f : files) {
					if(isTextFile(f)) {
						System.out.println(f.getName());
						f.delete();
					}
				}
	
			}
			else {
				System.out.println("Directory Not Found");
			}
}

}
