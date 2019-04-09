//Lyft Challenge 

/*
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.
*/



class Solution {

    public int compress(char[] chars){
        int achor = 0; 
        int write = 0;
        for(int read = 0; read < chars.length; read++){
            if(read + 1 == chars.length || chars[read + 1] != chars[read]){
                chars[write++] = chars[anchor];
                
                // if more than one occurance
                if(read > anchor){  
                    for( char c: ("" + (read - achor + 1)).toCharArray()){
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }
}