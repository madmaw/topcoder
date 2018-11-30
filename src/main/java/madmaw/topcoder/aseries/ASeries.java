package madmaw.topcoder.aseries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class ASeries {

    public int longest(int[] series) {
        return this._longestBruteForce(series);
    }

    private int _longestBruteForce(int[] series) {
        // dedupe
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Integer, Integer> duplicateCounts = new HashMap<Integer, Integer>(series.length);
        int maxDuplicateCount = 0;
        for( int i : series ) {
            if( !set.contains(i) ) {
                set.add(i);
            } else {
                // add it into the diff count for that number
                Integer duplicateCount = duplicateCounts.get(i);
                if( duplicateCount == null ) {
                    duplicateCount = 1;
                } else {
                    duplicateCount ++;
                }
                maxDuplicateCount = Math.max(duplicateCount, maxDuplicateCount);
                duplicateCounts.put(i, duplicateCount);
            }
        }

        ArrayList<Integer> a = new ArrayList<Integer>(set);
        Collections.sort(a);
        HashMap<Integer, Integer> diffCounts = new HashMap<Integer, Integer>(series.length);
        diffCounts.put(0, maxDuplicateCount);
        int maxDiffCount = maxDuplicateCount;


        for( int i = 0; i<a.size(); i++ ) {
            int prev = a.get(i);
            for( int j=i+1; j<a.size(); j++ ) {

                int current = a.get(j);
                int diff = current - prev;
                Integer diffCount = diffCounts.get(diff);
                if( diffCount == null ) {
                    diffCount = 1;
                } else {
                    diffCount ++;
                }
                maxDiffCount = Math.max(diffCount, maxDiffCount);
                diffCounts.put(diff, diffCount);
            }
        }
        return maxDiffCount+1;
    }
}
