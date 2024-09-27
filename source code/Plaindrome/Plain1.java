package Plaindrome;
import java.util.Scanner;
public class Plain1 {
		
		public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);

	        String text = scanner.nextLine();

	        if (is_Palindrome(text))
	            System.out.println("Is Palindrome");
	        else
	            System.out.println("Is not Palindrome");

	    }
		    public static char lower(char c) {  //To convert capital to small
		        int asci = (int) c;
		        if (asci >= 65 && asci <= 90)
		            return (char)(asci + 32);
		        return c;
		    }

		    public static boolean is_equal(char[] s1, char[] s2) {

		        if (s1.length != s2.length)
		            return false;

		        for (int i = 0; i < s1.length; i++) {
		            if (lower(s1[i]) != lower(s2[i]))
		                return false;
		        }

		        return true;
		    }


		    public static boolean is_Palindrome(String text) { 
		        
		        char [] s = text.toCharArray();
		        
		        LinkedStack stack = new LinkedStack();
		        
		        for (int i = 0; i < s.length; i++) {
		            stack.push(s[i]);
		        }
		        
		        char[] reversed = new char[s.length];
		        for (int i = 0; i < s.length; i++) {
		            reversed[i] = stack.top();
		            stack.pop();
		        }
		        
		        return is_equal(s, reversed);
		    }

		    
		

	}


