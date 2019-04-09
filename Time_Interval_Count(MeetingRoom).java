
/* Question 

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
find the minimum number of conference rooms required.
*/



// HEAP Solution with O(nlogn)
public int minMeetingRooms(Interval[] intervals) {
    if (intervals == null || intervals.length == 0)
        return 0;
        
    // Sort the intervals by start time
    Arrays.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { return a.start - b.start; }
    });
    
    // Use a min heap to track the minimum end time of merged intervals
    PriorityQueue<Interval> heap = new PriorityQueue<Interval>(new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { return a.end - b.end; }
    });
    
    // start with the first meeting, put it to a meeting room
    heap.offer(intervals[0]);
    
    for (int i = 1; i < intervals.length; i++) {
        // get the meeting room that finishes earliest
        Interval interval = heap.poll();
        
        if (intervals[i].start >= interval.end) {
            // if the current meeting starts right after 
            // there's no need for a new room, merge the interval
            interval.end = intervals[i].end;
        } else {
            // otherwise, this meeting needs a new room
            heap.offer(intervals[i]);
        }
        
        // don't forget to put the meeting room back
        heap.offer(interval);
    }
    
    return heap.size();
}


// Using one list with 0(N)

/* Explaination 
I used a list of int array to save each start and end point. I used 1 to mark the start and 0 for end, 
this way end comes before start in case their time equals to each other. For example, [5, 13], [13, 15] 
will only need one meeting room. So if end comes before start, the meeting room count will decrease by one 
before increase.

Then we just iterate the new list, increment count by 1 when see a start and decrement 1 when see a end time. 
ans will keep the final result. Hope it helps!
*/

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        List<int[]> meet = new ArrayList<>();
        for(Interval interval : intervals) {
            meet.add(new int[] {interval.start, 1});
            meet.add(new int[] {interval.end, 0});
        }

        Collections.sort(meet, new Comparator<int[]> () {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });

        int count = 0;
        int ans = 0;
        for(int[] m : meet) {
            if(m[1] == 1) { // if starting time
                count++;
            } else {       // if ending time
                count--;
            }
            
            ans = Math.max(ans, count);
        }
        return ans;
    }
}