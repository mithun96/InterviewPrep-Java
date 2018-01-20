//Twitter Challenge
import java.lang.*;
    /*
     * Complete the function below.
     */
class Solution {     
    public static void main(String[] args){

        int x = countPalindromes("draarata");
        System.out.println(x);
        return;
    }

    static int countPalindromes(String s) {
        int result = 0;        
        result = checkFinal(s);
        return result; 
    }


    // FINAL and OPTIMAL SOLUTION
    static int checkFinal(String s) {
        int len = s.length() ;
        int result = len;
        for (int i = 0; i < len; i++){  
            
            //Even Palindrones
            int bufff = 0;
            while ((i - bufff >= 0) && (i + bufff + 1 < len)  && (s.charAt(i - bufff) == s.charAt(i + bufff + 1))){
                result++;
                bufff++; 
            }
            
            //Odd Palindrones
            int buff = 1;
            while ((i - buff >= 0) && (i + buff < len)  && (s.charAt(i - buff) == s.charAt(i + buff))){
                result++;
                buff++;
            }
        }
        return result;
    }

    static int moreCheck1(String s) {
        String temp;
        int result =0 ;
        int len = s.length();
        for (int i = 0; i < len; i++){  
            for (int j = i+1; j <= len; j++){
               temp = s.substring(i, j);
                if(temp.length() == 1){
                    result++;
                }
                else if (temp.length() == 2 && (temp.charAt(0) == temp.charAt(1))){
                    result++;
                }
                else if(check(temp)) {
                    result++;
                }
            }         
        }
        return result;
    }

    static int moreCheck2(String s) {
        int result = s.length() ;
        int len = s.length();
        for (int i = 0; i < len/2 + 1; i++){  
        System.out.println("pivot: " + s.substring(i, i+1));

            for (int j = 1; j < len; j++){
                int left = i - j ;
                int right = i + j +1;
                if(left >= 0 && check(s.substring(left, i+1))  ){
                    result++;
                    System.out.println(s.substring(left, i+1));
                }

                if (right <= len && check(s.substring(i , right))    ){
                    result++;
                    System.out.println(s.substring(i , right));
                }
            } 
        }
        return result;
    }

    // Check if input is Palindrome
    static boolean check(String s) {
        int len = s.length();
        for (int i = 0; i < len/2 ; i++){
            if (s.charAt(i) != s.charAt(len- 1 - i)){
                return false;
            }
        }
        return true;
    }



}



