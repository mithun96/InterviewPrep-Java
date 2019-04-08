


// ============FIRST WAY===========================================================

	// Sort HashMap by value 
	// Create a list from elements of HashMap 
    List<Map.Entry<String, Integer> > list = 
           new LinkedList<Map.Entry<String, Integer> >(map.entrySet()); 

    // Sort the list 
    Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
        public int compare(Map.Entry<String, Integer> o1,  
                           Map.Entry<String, Integer> o2) 
        { 
            return (o2.getValue()).compareTo(o1.getValue()); 
        } 
    }); 
      
    // put data from sorted list to hashmap  
    HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
    for (Map.Entry<String, Integer> aa : list) { 
        temp.put(aa.getKey(), aa.getValue()); 
    } 

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

