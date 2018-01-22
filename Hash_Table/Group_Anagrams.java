/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String s : strs){
        	char[] c = s.toCharArray();
        	Arrays.sort(c);
        	String key = String.valueOf(c);
        	
        	if(!map.containsKey(key)){
        		map.put(key, new ArrayList<String>());
        	}

        	map.get(key).add(s);
        }

       for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
        	ans.add(entry.getValue());
        }
        
        return ans;

        //return new ArrayList<List<String>>(map.values());
    }
}