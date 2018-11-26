package madmaw.topcoder.abc;

/**
 *
 * Problem Statement
 *
 * You are given two ints: N and K. Lun the dog is interested in strings that satisfy the following conditions:
 *
 * The string has exactly N characters, each of which is either 'A', 'B' or 'C'. The string s has exactly K pairs (i, j)
 * (0 <= i < j <= N-1) such that s[i] < s[j]. If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 *
 * Definition
 *
 * Class:	ABC Method:	createString Parameters:	int, int Returns:	String Method signature:	String createString(int N, int K) (be sure your method is public)
 *
 * Constraints
 *
 * N will be between 3 and 30, inclusive.
 * K will be between 0 and N(N-1)/2, inclusive.
 */

public class ABC {

    public String createString(int N, int K) {
        String s = this.createShortestString(K);
        if( s.length() <= N ) {
            while(s.length() < N ) {
                s = "C" + s;
            }
            return s;
        } else {
            return "";
        }
    }
    // from AB question
    // AB -> 1
    // AABB -> 2 + 2 =4
    // AAABBB -> 3 + 3 + 3 = 9
    // AAAABBBB -> 4 + 4 + 4 + 4 = 16

    // broaden out to ABC
    // ABC -> 2 + 1 = 3 (1)
    // AABBCC -> 4 + 4 + 2 + 2 = 12 (2)
    // AAABBBCCC -> 6 + 6 + 6 + 3 + 3 + 3 = 27 (3)
    // AAAABBBBCCCC -> 8 + 8 + 8 + 8 + 4 + 4 + 4 + 4 = 48 (4)
    //
    // So, if our string is always the regex (A*)(B+)(C+) then K = #As * #Bs * #Cs + remainder
    private String createShortestString(int K) {
        if( K > 0 ) {
            int aCount = (int)Math.floor(Math.sqrt(K/3));
            // calculate bCount and cCount so we have shorter strings
            int bCount;
            if( aCount > 0 ) {
                // assume #C = #A, so for #B we get
                // #B = (K - #A*#A)/(#A*2)
                bCount = (K - aCount * aCount)/(aCount * 2);
            } else {
                // special case when there are no A's - I think K is always 1 or 2 in this case, so B is always 1, but why risk it?
                bCount = (int)Math.floor(Math.sqrt(K));
            }
            // now we have gotten #A and #B, calculate the best fit for #C (minimise the remainder)
            // #C = (K - #A*#B)/(#A+#B)
            int cCount = (K - aCount * bCount)/(aCount + bCount);

            StringBuilder s = new StringBuilder();
            for( int i=0; i<aCount; i++ ) {
                s.append("A");
            }
            for( int i=0; i<bCount; i++ ) {
                s.append("B");
            }
            for( int i=0; i<cCount; i++ ) {
                s.append("C");
            }
            int remainder = K - (aCount * bCount + aCount * cCount + bCount * cCount);
            // insert C's from the front (AA -> ACA == +1, AA -> AAC == +2)
            // TODO pretty sure this can be done more efficiently (can index into correct spot based on remainder and aCount/bCount)
            // additionally I suspect that we will never actually go beyond the A's, so it's even easier
            // TODO not sure this will always produce the shortest string (is it ever more efficient to go ABAABBBCCC?)
            while(remainder > 0 ) {
                int index = 0;
                boolean done = false;
                while(!done ) {
                    if( index + 1 < s.length() ) {
                        StringBuilder test = new StringBuilder(s);
                        test.insert(index + 1, 'C');
                        int count = this.countCombinations(test);
                        if( count > K ) {
                            // go back to previous index
                            s.insert(index, 'C');
                            done = true;
                        } else {
                            index++;
                        }
                    } else {
                        // should never happen
                        s.append('C');
                        done = true;
                    }
                }
                remainder = K - countCombinations(s);
            }
            return s.toString();
        } else {
            return "";
        }
    }

    int countCombinations(StringBuilder s) {
        int count = 0;
        for( int i=0; i<s.length(); i++ ) {
            char c = s.charAt(i);
            for( int j=i+1; j<s.length(); j++ ) {
                char d = s.charAt(j);
                if( c == 'A' && d != 'A' || c == 'B' && d == 'C' ) {
                    count++;
                }
            }
        }
        return count;
    }

}
