/* 
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

*/
 class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[(i+k)%nums.length] = nums[i];
        }
        System.out.println(temp[1]);
        for(int j = 0; j < temp.length; j++){
            nums[j]= temp[j];
        }
        nums = temp;
    }
}