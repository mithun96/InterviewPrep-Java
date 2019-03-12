


// ============FIRST WAY===========================================================

HashMap<String, Integer> map = new HashMap<String, String>();

HashMap<String, Integer> sortedByValue = map.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByValue())
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


// ============SECOND WAY===========================================================

HashMap<String, String> map = new HashMap<String, String>();



Comparator<Entry<String, String>> valueComparator = new Comparator<Entry<String,String>>() { 
	@Override public int compare(Entry<String, String> e1, Entry<String, String> e2) { 
		String v1 = e1.getValue(); 
		String v2 = e2.getValue(); 
		return v1.compareTo(v2); 
	} 
}; 


// Sort method needs a List, so let's first convert Set to List in Java 
List<Entry<String, String>> listOfEntries = new ArrayList<Entry<String, String>>(map.entrySet()); 

// sorting HashMap by values using comparator 
Collections.sort(listOfEntries, valueComparator);

LinkedHashMap<String, String> sortedByValue = new LinkedHashMap<String, String>(listOfEntries.size());

// copying entries from List to Map 
for(Entry<String, String> entry : listOfEntries){ 
	sortedByValue.put(entry.getKey(), entry.getValue()); 
}

System.out.println("HashMap after sorting entries by values "); 
Set<Entry<String, String>> entrySetSortedByValue = sortedByValue.entrySet(); 

for(Entry<String, String> mapping : entrySetSortedByValue){ 
	System.out.println(mapping.getKey() + " ==> " + mapping.getValue()); 
}

