/* 
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

*/

// Using Extra Array- Space complexity : O(n). Another array of the same size is used.
 class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[(i + k) % nums.length] = nums[i];
        }
        System.out.println(temp[1]);
        for(int j = 0; j < temp.length; j++){
            nums[j]= temp[j];
        }
        nums = temp;
    }
}


// Using Cyclic Replacements - Time complexity : O(n). Only one pass is used.
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}