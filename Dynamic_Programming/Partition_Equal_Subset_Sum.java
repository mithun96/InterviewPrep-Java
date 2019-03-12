/*
Given a non-empty array containing only positive integers, find if the array can
be partitioned into two subsets such that the sum of elements in both subsets is equal.
*/

// Solution is the same as a KnapSack problem (DP)

/* Explaination
    If you subtract the number from the target and that value can be formed (is true in the array/ memory) 
    then the target can be reached with this number. 
*/
public boolean canPartition(int[] nums) {
    int sum = 0;
    
    for (int num : nums) {
        sum += num;
    }
    
    if ((sum % 2) == 1) {
        return false;
    }
    
    sum /= 2;
    
    int n = nums.length;
    boolean[] dp = new boolean[sum+1];
    Arrays.fill(dp, false);
    dp[0] = true;
    
    for (int num : nums) {
        for (int i = sum; i > 0; i--) {
            if (i >= num) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
    }
    
    return dp[sum];
}