package madmaw.topcoder.aboardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Your friends Alice and Bob are playing a board game. They have asked you to help them to determine the winner.
 * The game is played on a square board with 2N rows and 2N columns. The exact rules of the game itself are not important for this problem.
 * Once the game is over, each cell of the board is either empty or contains a single piece that belongs to either Alice or Bob.
 * You are given board, where the j-th character in i-th element (0-based indices) describes the contents of the cell in row i, column j: '.'
 * represents an empty cell, 'A' a cell with Alice's piece and 'B' a cell with Bob's piece.
 *
 * The entire board is divided into N regions. Region 1 occupies the 4 central cells of the board.
 * Each next region contains all cells that are horizontally, vertically or diagonally adjacent to cells of the
 * immediately previous region and do not belong to any of the previous regions. For example, when N = 4, here is how the regions look:
 * 44444444
 * 43333334
 * 43222234
 * 43211234
 * 43211234
 * 43222234
 * 43333334
 * 44444444
 * The winner is determined as follows. Consider the lowest numbered region that contains a different number of Alice's and Bob's pieces.
 * The player who has more pieces in this region is the winner. If all regions contain the same number of Alice's and Bob's pieces, the game ends in a draw.
 *
 * Return "Alice" if Alice wins the given game, "Bob" if Bob wins and "Draw" if the game ends in a draw. Note that return values are case-sensitive.
 */
public class ABoardGame {

    public String whoWins(String[] board) {
        char c = this._whoWins(board);
        switch(c) {
            case 'A':
                return "Alice";
            case 'B':
                return "Bob";
            default:
                return "Draw";
        }
    }

    private char _whoWins(String[] board) {
        // board should always be 2nx2n in dimension
        int n = board.length/2;

        for( int d=0; d<n; d++ ) {
            // walk around the edge
            HashMap<Character, Integer> counts = new HashMap<Character, Integer>(d*4);
            for( int i=0; i<=d*2; i++ ) {
                // top row
                checkAndAddCount(board, n - d - 1, n - d - 1 + i, counts);
                // bottom row
                checkAndAddCount(board, n + d, n + d - i, counts);
                // left column
                checkAndAddCount(board, n + d - i, n - d - 1, counts);
                // right column
                checkAndAddCount(board, n - d - 1 + i, n + d, counts);
            }
            // attempt to work out a winner
            int maxCount = 0;
            ArrayList<Character> winners = null;
            for(Map.Entry<Character, Integer> entry : counts.entrySet() ) {
                if( Character.isLetter(entry.getKey()) ) {
                    if( maxCount <= entry.getValue() ) {
                        if( maxCount < entry.getValue() ) {
                            // reset the winners
                            winners = new ArrayList<Character>();
                            maxCount = entry.getValue();
                        }
                        winners.add(entry.getKey());
                    }
                }
            }
            if( winners != null && winners.size() == 1 ) {
                return winners.get(0);
            }
        }
        return '.';
    }

    private void checkAndAddCount(String[] board, int row, int col, HashMap<Character, Integer> counts) {
        Character c = board[row].charAt(col);
        Integer count = counts.get(c);
        if( count == null ) {
            count = 1;
        } else {
            count++;
        }
        counts.put(c, count);
    }
}
