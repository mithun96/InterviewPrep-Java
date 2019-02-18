

/* Question 

Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows 
the first 11 ugly numbers. By convention, 1 is included.

Given a number n, the task is to find n’th Ugly number.

*/

/* Explaination 
Here is a time efficient solution with O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
     because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …

     We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5. Then we use similar merge method 
     as merge sort, to get every ugly number from the three subsequence. Every step we choose the smallest one, and move one step after.
	
	Time Complexity: O(n)
	Auxiliary Space: O(n)
*/

import java.util.*;
import java.lang.Math;

class Soltuion{

	public static void main(String args[]){
		int n = 150; 
        UglyNumber obj = new UglyNumber(); 
        System.out.println(obj.getNthUglyNo(n));
	}

	int getNthUglyNo(int n){
		int ugly[] = new int[n];

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;


		int next2 = 2;
		int next3 = 3;
		int next5 = 5;

		ugly[0] = 1;

		for(int i = 1; i < n; i++){
			int next_ugly = Math.min(next2, Math.min(next5, next3));

			ugly[i] = next_ugly;

			if(next_ugly == next2){
				next2 = ugly[++i2] * 2; 
			}
			if(next_ugly == next3){
				next3 = ugly[++i3] * 3; 
			}			
			if(next_ugly == next5){
				next5 = ugly[++i5] * 5; 
			}
		}

		return ugly[n - 1];
	}
}