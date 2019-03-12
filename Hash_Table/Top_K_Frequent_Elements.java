/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/

class Solution{

	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int num : nums){
			if(!map.containsKey(num))
				map.put(num, 1);
			else
				map.put(num, map.get(num) + 1);
		}

		// Sort hashmap based on values
		TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			if (!tree.containsKey(entry.getValue()))
				tree.put(entry.getValue(), new ArrayList<Integer>());

			tree.get(entry.getValue()).add(entry.getKey());
		}

		List<Integer> ans = new ArrayList<>();
		while (ans.size() < k){
			Map.Entry<Integer, ArrayList<Integer>> entry = tree.pollLastEntry();
			ans.addAll(entry.getValue());
		}

		return ans;
	}
}