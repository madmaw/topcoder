package madmaw.topcoder.anewhope;

import java.util.*;

/**
 * The key to solving (quickly) was to realise that at the end of the week Luke can wear any shirt because they are
 * all (excepting the ones you have already worn that week) clean. So all you need to do is progressively move the shirts
 * you want to the order you want in the last week, starting at the final day
 *
 * That said, both algorithms fail on TopCoder system testing. Fast because there's something I haven't thought of
 * (maybe a corner case, maybe a test case where moving everything to the tail is sub-optimal), slow
 * because it's too slow
 */
public class ANewHope {
    public int count(int[] firstWeek, int[] lastWeek, int D) {
        ArrayList<Integer> firstWeekList = new ArrayList<Integer>();
        ArrayList<Integer> lastWeekList = new ArrayList<Integer>();
        for( int day = 0; day < firstWeek.length; day++ ) {
            firstWeekList.add(firstWeek[day]);
            lastWeekList.add(lastWeek[day]);
        }
        return _count(firstWeekList, lastWeekList, D);
    }

    private Integer _count(List<Integer> firstWeekList, List<Integer> lastWeekList, int D) {
        System.out.println(firstWeekList);

        Integer result;
        if( firstWeekList.equals(lastWeekList) ) {
            result = 1;
        } else {

            // calculate number of free shirts for each day
            ArrayList<ArrayList<Integer>> permutations = createPermutations(firstWeekList, D, new ArrayList<Integer>());
            // pick the "best" permutation
            int longestTail = 0;
            ArrayList<Integer> longestMatch = null;
            for( ArrayList<Integer> permutation : permutations ) {
                int tail = 0;
                for( int i=permutation.size(); i>0; ) {
                    i--;
                    int p = permutation.get(i);
                    int l = lastWeekList.get(i);
                    if( p == l ) {
                        tail++;
                    } else {
                        break;
                    }
                }
                if( tail >= longestTail ) {
                    longestMatch = permutation;
                    longestTail = tail;
                }
            }
            // safe way
            result = _count(longestMatch, lastWeekList, D) + 1;
            // pretty sure we can speed this up even further!
            //int l = firstWeekList.size() - longestTail;
            //result = _count(longestMatch.subList(0, l), lastWeekList.subList(0, l), D - longestTail) + 1;

        }

        return result;
    }

    public int slowCount(int[] firstWeek, int[] lastWeek, int D) {
        HashMap<List<Integer>, Integer> inProgress = new HashMap<List<Integer>, Integer>();
        ArrayList<Integer> firstWeekList = new ArrayList<Integer>();
        ArrayList<Integer> lastWeekList = new ArrayList<Integer>();
        for( int day = 0; day < firstWeek.length; day++ ) {
            firstWeekList.add(firstWeek[day]);
            lastWeekList.add(lastWeek[day]);
        }
        return _slowCount(firstWeekList, lastWeekList, D, inProgress);
    }


    private Integer _slowCount(List<Integer> firstWeekList, List<Integer> lastWeekList, int D, Map<List<Integer>, Integer> inProgress) {
        Integer result;
        if( firstWeekList.equals(lastWeekList) ) {
            result = 1;
        } else {
            result = null;
            if( !inProgress.containsKey(firstWeekList) ) {
                inProgress.put(firstWeekList, null);

                // calculate number of free shirts for each day
                ArrayList<ArrayList<Integer>> permutations = createPermutations(firstWeekList, D, new ArrayList<Integer>());

                for (ArrayList<Integer> permutation : permutations) {
                    Integer permutationResult;
                    if (!inProgress.containsKey(permutation)) {
                        permutationResult = _slowCount(permutation, lastWeekList, D, inProgress);
                    } else {
                        permutationResult = inProgress.get(permutation);
                    }
                    if (permutationResult != null) {
                        if (result == null || result > permutationResult) {
                            result = permutationResult + 1;
                        }
                    }
                }
                inProgress.put(firstWeekList, result);
            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> createPermutations(List<Integer> week, int D, ArrayList<Integer> shirtsSoFar) {
        int availableShirtCounts = week.size() - D + 1;
        int day = shirtsSoFar.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if( day >= week.size() ) {
            result.add(shirtsSoFar);
        } else {
            for( int i=0; i<Math.min(day+availableShirtCounts, week.size()); i++ ) {
                int shirt = week.get(i);
                if( !shirtsSoFar.contains(shirt) ) {
                    ArrayList<Integer> newShirtsSoFar = new ArrayList<Integer>(shirtsSoFar);
                    newShirtsSoFar.add(shirt);
                    result.addAll(createPermutations(week, D, newShirtsSoFar));
                }
            }
        }
        return result;
    }
}