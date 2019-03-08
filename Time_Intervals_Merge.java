
/* Question 

Given a collection of intervals, merge all overlapping intervals.


Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

*/


public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
        	return intervals;

     	List<Interval> ans = new ArrayList<>();

        Collections.sort(intervals, (a, b)->(a.start - b.start));
        int mergedStart = intervals.get(0).start; 
        int mergedEnd = intervals.get(0).end;
        
        for (Interval interval : intervals) {
        	if (interval.start <= mergedEnd) {
        		mergedEnd = Math.max(mergedEnd, interval.end);
        	} else {
        		ans.add(new Interval(mergedStart, mergedEnd));
        		mergedStart = interval.start;
        		mergedEnd = interval.end;
        	}
        }
        ans.add(new Interval(mergedStart, mergedEnd));
        return ans;
    }
}