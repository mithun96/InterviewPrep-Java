//LendingHome Challenge
    /*
     * Complete the function below.
     */

class Solution{
    private String maxString = "";
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i=0; i<length; i++) {
            // find longest odd palindrome
            findPalindrome(chars, length, i, 0);
            // find longest even palindrome
            findPalindrome(chars, length, i, 1);
        }
        return maxString;
    }

    private void findPalindrome(char[] chars, int length, int i, int shift) {
        int left = i;
        int right= i+shift; 

        // Check from inside to out
        while (left >= 0 && right < length && chars[left] == chars[right]){
            left--; right++;
        }
        if ((right-left-1) > maxLength) {
            maxLength = right-left-1;
            maxString = new String(chars, left+1, maxLength);
        }
    }
}

// ------------------------------------------



    static String longest_palindrome(String input) {
        String s = input;
        int len = s.length();
        String longest = "";
        String longEven = "";
        String longOdd = "";

        for (int i = 0; i < len; i++){  
            
            //Even Palindrones
            int bufff = 0;
            while ((i - bufff >= 0) && (i + bufff + 1 < len)  && (Character.toLowerCase(s.charAt(i - bufff)) == Character.toLowerCase(s.charAt(i + bufff + 1)))){
                longEven = s.substring(i - bufff, i + bufff + 2);
                System.out.println(longEven);
                bufff++; 
            }
            
            //Odd Palindrones
            int buff = 1;
            while ((i - buff>= 0) && (i + buff < len)  && (Character.toLowerCase(s.charAt(i - buff)) == Character.toLowerCase(s.charAt(i+buff)))){
				longOdd = s.substring(i - buff, i + buff + 1);
                System.out.println(longOdd);                
                buff++;
            }

            if(longEven.length() > longOdd.length() && longEven.length() > longest.length()){
            	longest = longEven;
            }
            else if(longOdd.length() >= longEven.length() && longOdd.length() > longest.length()) {
            	longest = longOdd;
            }
        }
        return longest;
    
    }   
