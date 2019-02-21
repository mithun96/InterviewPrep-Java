/* Question 

Given an array nums of n integers where n > 1,  return an array output such that output[i] 
is equal to the product of all the elements of nums except nums[i].

*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
     
        int ans[] = new int[nums.length];
        int temp = 1;
        
        for(int i = 0; i < nums.length; i++){
            ans[i] = temp;
            temp *= nums[i];
        }
        
        temp = 1;
        for(int j = nums.length - 1; j >= 0; j--){
            ans[j] *= temp;
            temp *= nums[j]; 
        }
        
        return ans;
    }
}