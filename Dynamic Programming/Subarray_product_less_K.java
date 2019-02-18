
/* Question 

Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

*/

// Using sliding window approach


class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int prod = 1; 
        int left = 0;
        int right;
        
        for(right = 0; right < nums.length; right++){
            prod *= nums[right];
            while(prod >= k && left <= right){
                prod /= nums[left++];
            }
            ans += right - left + 1; // number of elements in the interval
        }
        
        return ans;
    }
}
