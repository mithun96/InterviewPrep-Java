//Pocket Gems

/*
Given an array with n objects colored red, white or blue, sort them so that objects 
of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/



public void sortColors(int[] nums) {
    // 1-pass
    int p1 = 0;
    int p2 = nums.length - 1;
    int index = 0;
    
    while (index <= p2) {
        if (nums[index] == 0) {
            nums[index] = nums[p1];
            nums[p1] = 0;
            p1++;
        }
        if (nums[index] == 2) {
            nums[index] = nums[p2];
            nums[p2] = 2;
            p2--;
            index--;
        }
        index++;
    }
}