/* Questions

In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

1. Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
2. Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.

Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?

*/

import java.io.*;
import java.util.*;

class Solution{
	public static void main(String[] args){
		int sol = totalFruit([0,1,2,2]);
		
	}

   public static int totalFruit(int[] tree) {
		HashMap<Integer, Integer> backets = new HashMap<>();
		int max = 0;
		int j = 0;
		int i = 0;
   
		while(i < tree.length){
			while(i < tree.length && backets.size() <= 2){	
				if(backets.containsKey(tree[i]) || backets.size() < 2){
					backets.put(tree[i], backets.getOrDefault(tree[i], 0) + 1);
					i++;
				}
				else 
					break;
			}

			// update max 
			max = Math.max(max, i - j);

			//move the sliding window up one until can remove a backet
			while(j < i && backets.size() > 1){
				backets.put(tree[j], backets.get(tree[j]) - 1);
				if(backets.get(tree[j]) == 0)
					backets.remove(tree[j]);
				j++;
			}
		}
		return max;
	}
}







