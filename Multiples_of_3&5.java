// Find multiples of 3 and 5. 

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        
        for(int i = 1; i <= input; i++){
            if(i % 5 == 0 && i % 3 == 0){
                System.out.println("BooHoo");
            }
            else if(i % 3 == 0){
                System.out.println("Boo");
            }
            else if(i % 5 == 0){
                System.out.println("Hoo");
            }
            else {
                System.out.println(i);
            }
        }        
    }
}