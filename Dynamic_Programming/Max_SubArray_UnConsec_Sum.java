
/*
Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.

For example, given an array we have the following possible subsets:

Subset      Sum
[-2, 3, 5]   6
[-2, 3]      1
[-2, -4]    -6
[-2, 5]      3
[1, -4]     -3
[1, 5]       6
[3, 5]       8
Our maximum subset sum is 8.

sample input: 
3 5 -7 8 10
3 7 4 6 5
2 1 5 8 4 

*/

// Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
    	int dp[] = new int[arr.size()];

    	for(int i=1;i<arr.size();i++)
		{
		    dp[i]=max(dp[i-2],max(dp[i-1],dp[i-2]+arr[i]));
		}

		int n=arr.size();
		return max(dp[n-1],dp[n-2]);
    }

