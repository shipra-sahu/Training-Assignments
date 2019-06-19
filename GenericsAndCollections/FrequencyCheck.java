/* Program to print the frequency of each character of the string(Considering lowercase and uppercase as same ->Uppercase) */

package assignment.day3.collections_generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class FrequencyCheck {
	
	public static void printit(int n) {
		for(int i=0;i<n;i++) {
			System.out.print("#"); 
		}
	}

	public static void main(String[] args) {

		Map<Character,Integer> charCountmap = new HashMap<>();
		Scanner scn =  new  Scanner(System.in);
		System.out.println("Enter a String : "); 
		scn.close();
		String s = scn.nextLine();
		//System.out.println(s);
		s = s.toUpperCase();
		for(int i=0;i<s.length();i++) {
			char c1 = s.charAt(i);
 			if(charCountmap.containsKey(c1))
				charCountmap.put(c1, charCountmap.get(c1)+1);
			else 
				charCountmap.put(c1,1);
		}	
		
		 Iterator<Map.Entry<Character, Integer>> itr = charCountmap.entrySet().iterator(); 
         
	        while(itr.hasNext()) 
	        { 
	             Map.Entry<Character, Integer> entry = itr.next(); 
	             System.out.print(entry.getKey() +  
	                                 " \t  " );
	             printit(entry.getValue());
	             System.out.println();
	
	}	
	}
	    
}
