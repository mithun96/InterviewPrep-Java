//Blend Challenge (Not Complete!!)
// Find all the missing document Types. Print the docType and applicationID that are missing for that docType

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        Map<String, Set<Integer>> docs = new HashMap<String, Set<Integer>>();        

        while(in.hasNextLine()){
            str = in.nextLine();
            List<String> doc = Arrays.asList(str.split(","));
            ids.add(Integer.parseInt(doc.get(3)));
            
            if(docs.containsKey(doc.get(2))){
                Set<Integer> newD = docs.get(doc.get(2));
                newD.add(Integer.parseInt(doc.get(3)));

                docs.put(doc.get(2), newD);
            }
            else{
                Set<Integer> newDoc = new HashSet<String>() {{
    add(Integer.parseInt(doc.get(3)));
            }}
                //newDoc.add(Integer.parseInt(doc.get(3)));
                docs.put(doc.get(2), newDoc);
            }
            
            
                        
        }
        

        Iterator it = docs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        
        
        
        /*
   
        for (String s : sortedList) {
            System.out.println(s);
        }
        */
        //System.out.println(docType.get(1));
    }
}