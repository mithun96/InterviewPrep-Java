/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
        	if(map.containsKey(target - nums[i])){
        		ans[0] = map.get(target - nums[i]);
        		ans[1]= i;
        		return ans;
        	}
        	map.put(nums[i], i);
        }
        return ans;
    }
}