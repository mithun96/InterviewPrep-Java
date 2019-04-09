//Twitter Challenge

class Solution{
    /*
     * Complete the function below.
     */
    static int[] countOperationsToK(long[] kValues) {
        int [] results = new int[kValues.length];     
        for (int i = 0; i < kValues.length; i++){
           results[i] = counting(kValues[i]);
        }
        return results;
    }

    static int counting(long num){
        int result = 0; 
        while(num > 0){
            if(num % 2 == 1){
                num--;
            }
            else{
                num = num/2;
            }
            result++;
        }
        return result;
    }
}
