//Count the number of prime number between 0 and n. 


class Solution {
    public int countPrimes(int n) {
        	
        boolean[] notPrime = new boolean[n];
        int result = 0;

        for(int i = 2; i < n; i++){
        	if(notPrime[i] == false){
        		result++;
        		for(int j = 2; j * i < n; j++){
        			notPrime[i * j] = true;
        		}
        	}

        }
        return result;
    }
}