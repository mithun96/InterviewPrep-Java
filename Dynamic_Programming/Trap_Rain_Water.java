/* https://leetcode.com/problems/trapping-rain-water/
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        
        int ans = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int i;
        leftMax[0] = height[0];
        for(i = 1; i < height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        
        rightMax[height.length - 1] = height[height.length - 1];
        for(i = height.length - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        
        rightMax[height.length - 1] = height[height.length - 1];
        for(i = 1; i < height.length - 1; i++){
            ans += Math.min(leftMax[i] - height[i], rightMax[i] - height[i]);
        }
        
        
        return ans;
    }
}