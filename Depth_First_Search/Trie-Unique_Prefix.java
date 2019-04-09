/* https://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/

Given an array of words, find all shortest unique prefixes to represent each word in the given array. 
Assume that no word is prefix of another.

Examples:

Input: arr[] = {"zebra", "dog", "duck", "dove"}
Output: dog, dov, du, z
Explanation: dog => dog
             dove = dov 
             duck = du
             z   => zebra 

Input: arr[] =  {"geeksgeeks", "geeksquiz", "geeksforgeeks"};
Output: geeksf, geeksg, geeksq}

*/

/* Solution Explained:

1. Simple Solution is to consider every prefix of every word (starting from the shortest to largest), 
and if a prefix is not prefix of any other string, then print it.

2. An Efficient Solution is to use Trie. The idea is to maintain a count in every node. Below are steps.

    1) Construct a Trie of all words. Also maintain frequency of every node (Here frequency is number 
       of times node is visited during insertion). Time complexity of this step is O(N) where N is total 
       number of characters in all words.

    2) Now, for every word, we find the character nearest to the root with frequency as 1. The prefix 
    of the word is path from root to this character. To do this, we can traverse Trie starting from root. 
    For every node being traversed, we check its frequency. If frequency is one, we print all characters 
    from root to this node and don’t traverse down this node.

    Time complexity if this step also is O(N) where N is total number of characters in all words.
*/

import java.util.*;

// Java program to print all prefixes that 
// uniquely represent words. 
class Solution { 
       
    static final int MAX  = 256; 
       
    // Maximum length of an input word 
    static final int MAX_WORD_LEN = 500; 
       
    // Trie Node. 
    static class TrieNode 
    { 
        HashMap<Character, TrieNode> child = new HashMap<>();
        int freq;  // To store frequency 

        TrieNode() { 
            freq =1; 
        } 
    } 
    static TrieNode root; 
      
    // Method to insert a new string into Trie 
    static void insert(String str) 
    { 
        // Length of the URL 
        int len = str.length(); 
        TrieNode pCrawl = root; 
       
        // Traversing over the length of given str. 
        for (int level = 0; level<len; level++) 
        { 
            // Get index of child node from current character 
            // in str. 
            char c = str.charAt(level); 
            // Create a new child if not exist already 
            if (!pCrawl.child.containsKey(c)) 
                pCrawl.child.put(c, new TrieNode()); 
            else{
                TrieNode temp = pCrawl.child.get(c);
                temp.freq++;
                pCrawl.child.put(c, temp); 

            }
            
       
            // Move to the child 
            pCrawl = pCrawl.child.get(c); 
        } 
    } 
       
    // This function prints unique prefix for every word stored 
    // in Trie. Prefixes one by one are stored in prefix[]. 
    // 'ind' is current index of prefix[] 
    static void findPrefixesUtil(TrieNode root, StringBuilder str) 
    { 
        // Corner case 
        if (root == null) 
           return; 
       
        // Base case 
        if (root.freq == 1) 
        { 
            System.out.println(str.toString());            
            return; 
        } 
       
        for (Map.Entry<Character, TrieNode> entry : root.child.entrySet()) 
        { 
        
           str.append(entry.getKey());
           findPrefixesUtil(entry.getValue(), str); 
           str.deleteCharAt(str.length() - 1);
           
        } 
    } 
       
    // Function to print all prefixes that uniquely 
    // represent all words in arr[0..n-1] 
    static void findPrefixes(String arr[], int n) 
    { 
        // Construct a Trie of all words 
        root = new TrieNode(); 
        root.freq = 0; 
        for (int i = 0; i<n; i++) 
            insert(arr[i]); 
          
        // Print all prefixes using Trie Traversal 
        findPrefixesUtil(root, new StringBuilder()); 
    } 
       
    // Driver function. 
    public static void main(String args[]) 
    { 
        String arr[] = {"zebra", "dog", "duck", "dove"}; 
        int n = arr.length; 
        findPrefixes(arr, n); 
        // Will Print: "dog  dov  du  z "
    } 
} 
// This code is contributed by Sumit Ghosh 