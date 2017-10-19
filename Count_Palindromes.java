
    /*
     * Complete the function below.
     */
class Solution {     
    public static void main(String[] args){
        int x = countPalindromes("mithunnuhtim");
        System.out.println(x);
        return;
    }
    static int countPalindromes(String s) {
        int result = 0;        
        result = checking(s);
        return result; 
    }
     static int moreCheck(String s) {
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
    static boolean check(String s) {
        int len = s.length();
        for (int i = 0; i < len/2 ; i++){
            if (s.charAt(i) != s.charAt(len- 1 - i)){
                return false;
            }
        }
        return true;
    }

    static int checking (String s){
        int result = s.length();
        String temp = "";

        for (int i = 0; i < s.length()-1; i++){
            temp = s.substring(i, s.length());
                                        System.out.println(temp);

            if(check(temp)){
                result = result + (temp.length()/2);

            }
        }
        for (int i = s.length()-1; i > 1; i--){
            temp = s.substring(0, i);
                                        System.out.println(temp);

            if(check(temp)){
                result = result + (temp.length()/2);

            }
        }

        return result; 
    }
}
