package madmaw.topcoder.abcpath;

public class ABCPath {

    // this seemed way too easy?!
    public int length(String[] grid) {
        int maxLength = 0;
        for( int row = 0; row<grid.length; row++ ) {
            String rowValue = grid[row];
            for( int col = 0; col<rowValue.length(); col++ ) {
                maxLength = Math.max(maxLength, this._length(grid, row, col, 'A'));
            }
        }
        return maxLength;
    }

    public int _length(String[] grid, int row, int col, char expectedCharacter) {
        int length = 0;
        if( row < grid.length && row >= 0 ) {
            String rowValue = grid[row];
            if( col < rowValue.length() && col >= 0 ) {
                char c = rowValue.charAt(col);
                if( c == expectedCharacter ) {
                    char nextCharacter = expectedCharacter;
                    nextCharacter++;
                    for( int dRow = -1; dRow <= 1; dRow++ ) {
                        for( int dCol = -1; dCol <= 1; dCol++ ) {
                            if( dRow != 0 || dCol != 0 ) {
                                length = Math.max(length, this._length(grid, row + dRow, col + dCol, nextCharacter));
                            }
                        }
                    }
                    // add our own length
                    length ++;
                }
            }
        }
        return length;
    }
}
