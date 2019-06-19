/* Program to check if any anagram of the given string is a palindrome*/

package assignment.day3.collections_generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class PalindromeAnagram {

	public boolean isPalindrome(String s) {
		Map<Character,Integer> charCountmap = new HashMap<>();
		
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(charCountmap.containsKey(c))
				charCountmap.put(c, charCountmap.get(c)+1);
			else 
				charCountmap.put(c,1);
		}
		
		int odd = 0;
		for(Integer i : charCountmap.values()) {
			if(i%2!=0) odd++;
		}
		
		if(odd>1) 
			return false;
		
		return true;		
	}

	public static void main(String[] args) {
		
		PalindromeAnagram cd = new PalindromeAnagram();
		Scanner scn =  new  Scanner(System.in);
		System.out.println("Enter a String : "); 
	
		String s = scn.next();
		scn.close();
		if(cd.isPalindrome(s)) {
			System.out.println("Yes the anagram of the string is a palindrome.!!!!!");
		}
		else {
			System.out.println("No anagram of the string is a palindrome.!!!!!");
		}

	}

}
