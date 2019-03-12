
class Trie{
	TrieNode root;
	int size;

	public Trie(){
		root = new TrieNode();
		size = 0;
	}

	public static void addWord(String str){
        char[] chars = str.toCharArray();
        TrieNode node = root;

        for(char c : chars){
            if(node.child[(int)c] != null){
                node.child[(int) c].freq++;
            }
            else{
                node.child[(int)c] = new TrieNode();
            }
            node = node.child[(int)c];
        }
    }

    class TrieNode{
		TrieNode[] child;
		int freq;

		public TrieNode(){
			child = new TrieNode[128]; // the index of the array reps the char as an integer
			freq = 1;
		}

	}
}


