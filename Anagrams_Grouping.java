/* 	

Write a method to sort an array of strings so that all the anagrams are next to each other (grouping).

*/

class Solution {

	String[] sort(String[] array){
		HashMap<String, ArrayList<String>> map = new HashMap<>();

		for(String str: array){
			String key = sortString(str);
			ArrayList<String> list = null;
			
			if(!map.containsKey(key)){
				list = new ArrayList<>()
			}
			else {
				list.get(key);
			}
			list.add(str);
			map.put(key, list);
		}

		int = 0;
		for(String key : map.keySet()){
			ArrayList<String> list = map.get(key);
			for(String str : list){
				array[i++] = str;
			}
		}

		return array;
	}

	String sortString(String str){

		char[] temp = str.toCharArray();
		Arrays.sort(temp);
		// return Character.toString(temp);
		return new String(temp);
	}
}