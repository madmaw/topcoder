package madmaw.topcoder.andequation;

import java.util.Arrays;

/**
 * An AND-equation is an equation that looks like this:
 * X[0] AND X[1] AND ... AND X[N-1] = Y
 * Here X[i] and Y are non-negative integers and the bitwise AND operation is defined in the Notes.
 * In C++, C#, and Java the operator AND is denoted "&". So for example (P & Q & R) is the bitwise AND of numbers P, Q, and R. In VB the same operator is denoted "And".
 * You are given a A that contains exactly N+1 elements. Your task is to construct an AND-equation using each element of A exactly once.
 * (That is, N of them will be on the left hand side of the AND-equation and the remaining one will be on the right hand side.)
 * If this is possible, return the value of Y in this AND-equation. If no AND-equation can be constructed, return -1.
 * (It can be shown that for each A there is at most one possible value Y, so the return value is always defined correctly.)
 */
public class ANDEquation {

    public int restoreY(int[] A) {

        return _restoreY(A);

    }

    // O(n*2) => O(n)
    public int _restoreY(int[] A) {
        // our result will always only be the smallest value
        int smallestIndex = 0;
        int Y = A[0];
        for( int i=1; i<A.length; i++ ) {
            int x = A[i];
            if( x < Y ) {
                Y = x;
                smallestIndex = i;
            }
        }
        int X = -1;
        for( int i=0; i<A.length; i++ ) {
            if( i != smallestIndex ) {
                X &= A[i];
                if( X < Y ) {
                    return -1;
                }
            }
        }
        if( X == Y ) {
            return X;
        } else {
            return -1;
        }
    }

    // O(n*n)
    public int _bruteForceRestoreY(int[] A) {
        for( int i=0; i<A.length; i++ ) {
            int Y = A[i];
            int X = -1;
            for( int j=0; j<A.length; j++ ) {
                if( j != i ) {
                    X &= A[j];
                }
            }
            if( Y == X ) {
                return Y;
            }
        }
        return -1;
    }
}
