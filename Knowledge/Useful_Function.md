
# String Manuplation 

## Convert String to Array of Char
	char[] chars = str.toCharArray();

## Convert Array of Char to String
	String str = String.copyValueOf(chars);

## Remove all spaces in string
	import java.lang.String;
	str.replaceAll("\\s+","");


# HashMap Shortcuts

## Iterate Through Hashmap 
	for(Map.Entry<String, String> entry : myMap.entrySet()){
		entry.getKey();
		entry.getValue();
	}

## Sort Hashmap by Key 
	// Sort of HashMap Key
	Map<String, Integer> sorted = new TreeMap<String, Integer>(myHashMap);

	// Display the TreeMap which is naturally sorted 
    for (Map.Entry<String, Integer> entry : sorted.entrySet())  
        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
	
## Sort Hashmap by Key  ????



// Sorting a list
Collections.sort(list)
	

## Creating ArrayList (one line)
	ArrayList<String> myList = new ArrayList<String>(Array.asList("Bob", "Tom")); 

## Iterating through an ArrayList
	ArrayList al = new ArrayList();
	
	Iterator iter = al.iterator();
	while(iter.hasNext()){
		System.out.println(iter.next());
	}	