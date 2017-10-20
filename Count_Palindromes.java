
    /*
     * Complete the function below.
     */
class Solution {     
    public static void main(String[] args){
        int x = countPalindromes("mithunanuhtim");
        System.out.println(x);
        return;
    }
    static int countPalindromes(String s) {
        int result = 0;        
        result = moreCheck2(s);
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

    static int moreCheck2(String s) {
        int result = s.length() ;
        int len = s.length();
        for (int i = 0; i < len/2; i++){  
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
