/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/


// Hash Tabel Solution 

class Solution {
	public int singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
			if (set.contains(num))
				set.remove(num);
            else 
                set.add(num);
		}
		Iterator<Integer> it = set.iterator();
		return it.next();
	}
}


// Bit manulation solution 

/*
we use bitwise XOR to solve this problem :

first , we have to know the bitwise XOR in java

0 ^ N = N
N ^ N = 0
So..... if N is the single number

N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

= 0 ^ 0 ^ ..........^ 0 ^ N

= N

*/

class Solution {
    public int singleNumber(int[] nums) {
        int ans =0;
    
	    int len = nums.length;
	    for(int i=0;i!=len;i++)
	        ans ^= nums[i];
	    
	    return ans;
    }
}

