/*

Alice is a kindergarten teacher. She wants to give some candies to the children in her class.  All the children sit in a line and each of them has a rating score according to his or her performance in the class.  Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher rating must get more candies. Alice wants to minimize the total number of candies she must buy.

For example, assume her students' ratings are [4, 6, 4, 5, 6, 2]. She gives the students candy in the following minimal amounts: [1, 2, 1, 2, 3, 1]. She must buy a minimum of 10 candies.

Function Description

Complete the candies function in the editor below. It must return the minimum number of candies Alice must buy.

candies has the following parameter(s):

n: an integer, the number of children in the class
arr: an array of integers representing the ratings of each student

*/


public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] ratings) {
		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);
		
		int i = 0;
		while (i < candies.length) {
			if (i > 0 && ratings[i] > ratings[i-1] && candies[i] <= candies[i-1]) { 
				candies[i] = candies[i-1] + 1;
				i--;
			}
			
			else 
			
			if (i < candies.length - 1 && ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) { 
				candies[i] = candies[i+1] + 1;
				if (i > 0) i--;
			} 
			
			else i++;
		}
		
		
		int totalCandies = 0;
		for (int c: candies) {
			totalCandies += c;
		}
		
		return totalCandies;
	}

}













