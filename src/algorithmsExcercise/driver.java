package algorithmsExcercise;

import java.io.*;
import java.util.*;
  

public class driver {

	// returns the index of the char that exist the most in string s
	public static int maxCharacter(String s) {
		int[] counter = new int[26];
		for(int i=0;i<s.length();i++)
			counter[s.charAt(i)%26] = 0;
		for(int i=0; i < s.length();i++) {
//			if(counter[s.charAt(i)]==Null)
			
			counter[s.charAt(i)%26]++;
		}
		int maxChar=-1;
		int index = -1;
		for(int i=0; i < 26;i++) {
			if(counter[i]>maxChar) {
				index = i;
				maxChar = counter[i];
			}
		}
		for(int i=0; i < s.length();i++) {
			if(s.charAt(i)%26==index) {
				return i;
			}
		}
		return -1;
	}
	
	// Checks if a string is palindorme
	public static boolean palindCheck(String s) {
		int last = s.length()-1;
		int begin = 0;
		while(begin < last) {
			if(s.charAt(last)!=s.charAt(begin))
				return false;
			last--;
			begin++;
		}
		return true;
	}
	
	public static boolean balance(String s) {
		Stack s1= new Stack();
		for(int i = 0; i < s.length();i++) {
			if(s.charAt(i)=='[' ||s.charAt(i)=='(' ||s.charAt(i)=='{' ||s.charAt(i)=='<') {
				s1.push(s.charAt(i));
			}
			else {
				char temp =  (char)s1.pop();
				if (temp == '(' && s.charAt(i)==')') {
					continue;
				}
				else if (temp == '[' && s.charAt(i)==']') {
					continue;
				}
				else if (temp == '{' && s.charAt(i)=='}') {
					continue;
				}
				else if (temp == '<' && s.charAt(i)=='>') {
					continue;
				}
				else
					return false;	
			}
		}
		return true;
	}
	
	public static int birthday(int candles[]) {
		int max = -1;
		int count = 0;
		for (int i=0;i<candles.length;i++) {
			if(candles[i]>max)
				max = candles[i];
		}
		for(int i=0; i < candles.length;i++) {
			if(max==candles[i])
				count++;
		}
		return count;
		// not done
//		return -1;
	}
	
	public static int positives(int n) {
		if (n==1)
			return 1;
		else
			return positives(n-1)+n;
	}
	
	public static void main(String[] args) {
		String m1 = "leettmmssss";
		String m2 = "pallap";
		String m3 = "palllap";
		String m4 = "palbp";
		String m5 = "{{}}";
		String m6 = "{[()]}";
		String m7 = "{[(])}";

		int[] i1 = new int[] {3,2,1,3,3,2,3};
		int[] i2 = new int[] {3,2,1,5,3,3,2,5,3};
		
		int seq = 5;
		int seq2 = 11;
		// testers
		System.out.println("The max character index for " + m1 + " is " +maxCharacter(m1));
		System.out.println("____________________________");
		// Palindrome test
		System.out.println("palindrom for " + m2 + " is " +palindCheck(m2));
		System.out.println("palindrom for " + m3 + " is " +palindCheck(m3));
		System.out.println("palindrom for " + m4 + " is " +palindCheck(m4));
		System.out.println("____________________________");
		// Balance test
		System.out.println("The string " + m5 + " is balanced " +balance(m5));
		System.out.println("The string " + m6 + " is balanced " +balance(m6));
		System.out.println("The string " + m7 + " is balanced " +balance(m7));
		System.out.println("____________________________");
		// birthday test
		System.out.println("the maximum number of candles is: " +birthday(i1));
		System.out.println("the maximum number of candles is: " +birthday(i2));
		System.out.println("____________________________");
		// sequence sum tester
		System.out.println(positives(seq));
		System.out.println(positives(seq2));
	}

}
