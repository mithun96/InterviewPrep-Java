class Solution {

	public static void main(String[] args){
		char[][] b = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		boolean ans = exist(b, "ABCCED");
		System.out.println(ans);
	}
  
    
    public static boolean exist(char[][] board, String word) {
        
        int len = board.length;
        int wid = board[0].length;
        char[] letters = word.toCharArray();

        for(int i = 0; i < len; i++){
        	for(int j = 0; j < wid; j++){

        		if(board[i][j] == letters[0]){
        			if (DFS(board, i, j, 0, letters))
        				return true;
        		}
        	}
        }
        return false;
   
    }
    public static boolean DFS(char[][] board, int l, int w, int index, char[] letters){
    	if(l >= board.length || l < 0 || w >= board[0].length || w < 0 || index >= letters.length || board[l][w] != letters[index]){
    		return false;
    	}
        
        if (index == letters.length - 1) {
           return true;
        }

    	char temp = board[l][w];
    	board[l][w] = '$';

    	int left = DFS(board, l - 1, w, index + 1, letters);  // left
    	int down = DFS(board, l, w + 1, index + 1, letters);  // down
    	int right = DFS(board, l + 1, w, index + 1, letters);  // right
    	int up = DFS(board, l, w - 1, index + 1, letters);  // up

    	board[l][w] = temp;
    	
    	if(left == 1 || down == 1 || up == 1 || right == 1){
    		System.out.println(letters[index +1]);

    		return true;
    	}
    	return false;

    }
}