
//Given a column title as appear in an Excel sheet, return its corresponding column numbe

import java.lang.String;
class Solution {
    public int titleToNumber(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++){
        	result = (s.charAt(i) - 'A' + 1) + (result * 26) ; 
        }

        return result;
    }
}




import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        
        int result = 0;

        for (int i = 0; i < s.length(); i++){
        	result = (s.charAt(i) - 'A' + 1) + (result * 26) ; 
        }

        System.out.println(result);
    
    }
}