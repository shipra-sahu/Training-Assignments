/* Program to copy a file from one Directory into another Directory */

package assignment.day3.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {

	public static void main(String[] args) throws IOException {
		//File file = new File("C:\\\\MyFolder/file1.txt");
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Source Directory Path: (please provide the absolute path)");
		String srcdirpath = scn.next();
		System.out.println("Enter Destination Directory Path : (please provide the absolute path)");
		String desdirpath = scn.next();
		System.out.println("Enter File Name : ");
		String filename = scn.next();
		
		File file = new File(srcdirpath+"/"+filename);
		BufferedReader reader = null;
		BufferedWriter writer  =null;
		File srcdir = new File(srcdirpath);
		File desdir = new File(desdirpath);
		
		//if source directory existed or not
		if(srcdir.exists()&&srcdir.isDirectory()&&file.exists()) { 
			
			//if destination directory existed or not,if not then create one
			if(!desdir.exists()){ 
				desdir.mkdir();
			}
			
			//get the file separator
			String fileSeparator = System.getProperty("file.separator"); 
	        
	        //absolute file name with path
	        String absoluteFilePath = desdir+ fileSeparator+filename;
			File newfile = new File(absoluteFilePath); //create the new file in the destination directory
			
			//checking file already existed or not
			if(!newfile.exists()) {
				
				if(newfile.createNewFile()) {
					
					try {
						writer = new BufferedWriter(new FileWriter(newfile));
						reader = new BufferedReader(new FileReader(file));
						String str;
						
						//copying the contents of the file
						while((str = reader.readLine())!= null) {
							writer.write(str);
							writer.write("\n");
							//System.out.println(str);
						}
						System.out.println("file Copied to the destination folder");
						
					} catch (IOException e) {
						e.printStackTrace();
						}
					finally {
						writer.close();
						reader.close();
					}
				
				}
				else {
					System.out.println("File can't be created .");
				}
			}
			else {
				System.out.println("File with the same name already existed!!!!");
			}
			
		}
		else {
			System.out.println("********Source Directory or File Not Found**********");
		}
		
	}

}
