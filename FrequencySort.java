package assignment.day3.collections_generic;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class FrequencySort {
	public List<String> sortByFrequency(List<String> list){
		Map<String,Integer> sfm = new HashMap<String, Integer>();
		for(String s:list) {
 			if(sfm.containsKey(s))
				sfm.put(s, sfm.get(s)+1);
			else 
				sfm.put(s,1);
		}	
		 List<Map.Entry<String, Integer> > l = 
	               new LinkedList<Map.Entry<String, Integer> >(sfm.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(l, new Comparator<Map.Entry<String, Integer> >() { 
	            public int compare(Map.Entry<String, Integer> o1,  
	                               Map.Entry<String, Integer> o2) 
	            { 
	                if(o1.getValue()<=o2.getValue())
	                	return 1;
	                else return -1;
	            } 
	        });	
	       List<String> newlist =new LinkedList<String>();
	    for(Map.Entry<String, Integer> m: l) {
	    	newlist.add(m.getKey());
	    }
		return newlist;
	}
	
	public void  printList(List<String> list) {
		for(String s : list) {
			System.out.print(s+" ,");
		}
	}

	public static void main(String[] args) {
		Scanner scn =  new  Scanner(System.in);
		FrequencySort fs = new FrequencySort();
		int n;
		System.out.println("Enter the number of strings :");
		n = scn.nextInt();
		List<String> list = new LinkedList<>();
		System.out.println("Enter the Strings :(Please enter only one word string )");
		for(int i=0;i<n;i++) {
			list.add(scn.next()); 
		}
		list = fs.sortByFrequency(list);
		System.out.println("The strings in the Decreasing order of their Frequency are : ");
		fs.printList(list);
		scn.close();
	}

}
