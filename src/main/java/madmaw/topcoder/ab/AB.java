package madmaw.topcoder.ab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Couldn't get this to download from the official site, so I found the problem statement online
 *
 * Problem Statement
 * You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
 *     The string has exactly N characters, each of which is either 'A' or 'B'.
 *     The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
 * If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 * Definition
 * Class: AB
 * Method: createString
 * Parameters: integer, integer
 * Returns: string
 * Method signature: def createString(self, N, K):
 */
public class AB {

    public String createString(int N, int K) {
        //return this.createString(N, K, null);
        String shortest = this._createShortestString(K);
        if( shortest == null || shortest.length() > N ) {
            return "";
        } else {
            // just append extra Bs on the front if it's too short
            while(shortest.length() < N ) {
                shortest = "B" + shortest;
            }
            return shortest;
        }
    }

    public String createString(int N, int K, String preferredPermutation) {
        // the number of pairs in a string is
        // #As * #Bs
        // however, that assumes all the As are before all the Bs..
        /*
        List<String> strings = this._createStrings("", N, K);
        if( strings.size() > 0 ) {
            if( preferredPermutation != null && strings.contains(preferredPermutation) ) {
                return preferredPermutation;
            } else {
                return strings.get(0);
            }
        } else {
            return "";
        }
        */
        // ignore preferred string!
        return this.createString(N, K);
    }

    String _createShortestString(int K) {
        if( K >= 1 ) {
            // the square root *should* give us the most leverage of any #A*#B combination
            int sqrtK = (int)Math.floor(Math.sqrt(K));
            int aCount = K / sqrtK;
            // we might get lucky and divide evenly straight away
            int bCount = K / aCount;
            int remainder = K % (aCount * bCount);
            String tail;
            if( remainder > 0 ) {
                // create the remainder
                tail = this._createShortestString(remainder);
            } else {
                tail = "";
            }

            int bTailCount = 0;
            for( int i=0; i<tail.length(); i++ ) {
                if(tail.charAt(i) == 'B' ) {
                    bTailCount++;
                }
            }
            if( bCount >= bTailCount) {
                String s = "";
                for( int i=0; i<aCount; i++ ) {
                    s += "A";
                }
                for( int i=0; i<bCount - bTailCount; i++ ) {
                    s += "B";
                }
                s += tail;
                return s;
            } else {
                throw new RuntimeException("our algorithm is terrible!!!");
            }
        } else {
            return "";
        }
    }

    // naive solution
    List<String> _createStrings(String s, int N, int K) {
        if( s.length() >= N ) {
            if( matches(s, N, K) ) {
                return Arrays.asList(s);
            } else {
                return Collections.emptyList();
            }
        } else {
            ArrayList<String> results = new ArrayList<String>();
            results.addAll(this._createStrings(s+"A", N, K));
            results.addAll(this._createStrings(s+"B", N, K));
            return results;
        }
    }

    boolean matches(String s, int N, int K) {
        int count = 0;
        for( int i=0; i<N; i++ ) {
            if( s.charAt(i) == 'A' ) {
                for( int j=i; j<N; j++ ) {
                    if( s.charAt(j) == 'B' ) {
                        count++;
                    }
                }
            }
        }
        return count == K;
    }
}
