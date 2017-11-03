/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1; 
        int x = m + n - 1; 

        while(a >= 0 && b >= 0){
        	if (nums1[a] > nums2[b]){
        		nums1[x] = nums1[a--];
        	}
        	else {
        		nums1[x] = nums2[b--];
        	}
        	x--;
        } 

        while (b >= 0){
        	nums1[x--] = nums2[b--];
        }
    }
}
