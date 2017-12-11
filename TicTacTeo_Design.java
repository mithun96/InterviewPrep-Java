import static java.lang.*;

class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int dia;
    private int aDia;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val;
        
        if (player == 1) {
            val = 1;
        }
        else {
            val = -1;
        }

        rows[row] += val;
        cols[col] += val;

        if (col == row){
            dia += val;
        }

        if (col == cols.length - row - 1) {
            aDia += val;
        }

        int size = cols.length;

        if( Math.abs(dia) == size || 
            Math.abs(aDia) == size ||
            Math.abs(cols[col]) == size || 
            Math.abs(rows[row]) == size){
                return player;
        }
        else
            return 0;
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */