/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
*/




class Solution {

	public static void main(String[] args){
		int a = hammingDistance(1,4);
		System.out.println(a);
	}

    public static int hammingDistance(int x, int y) {
		String xBin = numToBin(x);
		String yBin = numToBin(y);
		int result = 0;

        for (int i = 0; i < 31; i++){
        	if (xBin.charAt(i) != (yBin.charAt	(i)))
        		result++;
        }
        return result;
    }

    public static String numToBin(int num){
    	int mod; 
    	String bin = "";
    	for(int i = 0; i < 31; i++){
    		mod = num % 2;
    		if (mod == 0)
    			bin = "0" + bin;
    		else 
    			bin = "1" + bin;

    		num = num / 2;
    	}
    	return bin;
    }
}