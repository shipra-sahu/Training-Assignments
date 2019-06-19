/* Program to copy one file into another */

package assignment.day3.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileContents {

	public static void main(String[] args) throws IOException {
		BufferedWriter writer =null;
		BufferedReader reader  = null;
		
		try {
			File file1 = new File("C:\\MyFolder/file1.txt");		//opening file1 to read
			File file2 = new File("C:\\MyFolder/file2.txt");		//opening file2 to write
			reader = new BufferedReader(new FileReader(file1));
			writer = new BufferedWriter(new FileWriter(file2));
			String str;
			while((str = reader.readLine())!= null) {
				writer.write(str);
				writer.write("\n");
				System.out.println(str);
			}
			System.out.println("\n*********Successfully Data Copied!!!**********");
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {			//to close the open files
			writer.close();
			reader.close();
		}
		
		

	}

}
