/*
 * 352. Data Stream as Disjoint Intervals Hard
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/ Given a data
 * stream input of non-negative integers a1, a2, ..., an, ..., summarize the
 * numbers seen so far as a list of disjoint intervals.
 * 
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6,
 * ..., then the summary will be:
 * 
 * [1, 1] [1, 1], [3, 3] [1, 1], [3, 3], [7, 7] [1, 3], [7, 7] [1, 3], [6, 7]
 * 
 * 
 * Explanation from comments: The idea is map all map all val to its left bond
 * of containing interval for fast lookup. Store intervals in TreeMap as it
 * seems to require output intervals in ascending order.(if ascending order is
 * not required, I would use a hashmap for maximum performance)
 * 
 * 5 cases 0: isolated val
 * 
 * 1: val already in existing interval e.g [1,6] 3, do nothing
 * 
 * val is connected to interval on its left e.g [1,2] 3
 * 
 * val is connected to interval on its right e.g. [4, 7] 3
 * 
 * val is connected on both side e.g [1,2] [4, 7] 3.
 * 
 * The algorithm actually finds the possible left or right intervals to val, (or
 * both). remove the old intervals, insert the new interval in the TreeMap.
 * Update valueToBond hashmap to ensure the right bound val can find its correct
 * left bound. Note that some val in the middle of the interval won't find
 * correct left bound. But that is OK as we will not access to the middle values
 * in the future! The left bound, right bound values must find their correct
 * left bound.
 */

class SummaryRanges {

    class Interval {
        int start, end;
        Interval(int l, int r) {
            start = l;
            end   = r;
        }
    }
    
    HashMap<Integer, Integer> treeBounds;
    TreeMap<Integer, Interval> treeIntervals;
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        treeBounds = new HashMap<>();
        treeIntervals = new TreeMap<>();
    }
    
    public void addNum(int val) {
        // if num is already present
        if(treeBounds.containsKey(val)) return;
        
        // if num is isolated
        if(!treeBounds.containsKey(val-1) && !treeBounds.containsKey(val+1)) {
            treeBounds.put(val, val);
            treeIntervals.put(val, new Interval(val, val));
            return;
        }
        
        // the num must have some immediate bindings
        int left = treeBounds.containsKey(val - 1)?treeBounds.get(val - 1):val;
        int right = treeBounds.containsKey(val + 1)?treeIntervals.get(val + 1).end:val;
        treeBounds.put(val, left);
        treeBounds.put(right, left);
        treeIntervals.remove(val + 1); //remove old interval value
        treeIntervals.put(left, new Interval(left, right)); //put new interval
    }
    
    public int[][] getIntervals() {
        int[][] retArray = new int[treeIntervals.size()][2];
        int index = 0;
        for(int key: treeIntervals.keySet()) {
            retArray[index][0] = treeIntervals.get(key).start;
            retArray[index++][1] = treeIntervals.get(key).end;
        }
        return retArray;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */