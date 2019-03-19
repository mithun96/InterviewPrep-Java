
/*Question 

You are given several logs that each log contains a unique id and timestamp. 
Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:Second, 
for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.

Design a log storage system to implement the following functions:

void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log 
in your storage system.


int[] Retrieve(String start, String end, String granularity): Return the id of logs whose 
timestamps are within the range from start to end. Start and end all have the same format as 
timestamp. However, granularity means the time level for consideration. For example, 
start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means 
that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.

Example 1:
put(1, "2017:01:01:23:59:59");
put(2, "2017:01:01:22:59:59");
put(3, "2016:01:01:00:00:00");
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.

*/

/* Solution explained 
put: Firstly, we split the given timestamp based on : and store the individual components obtained 
into an stst array. Now, in order to put this log's entry into the storage, firstly, we convert 
this timestamp, now available as individual components in the stst array into a single number. To 
obtain a number which is unique for each timestamp, the number chosen is such that it represents 
the timestamp in terms of seconds. But, doing so for the Year values can lead to very large numbers, 
which could lead to a potential overflow. Since, we know that the Year's value can start from 2000 
only, we subtract 1999 from the Year's value before doing the conversion of the given timestamp into
 seconds. We store this timestamp(in the form of a number now), along with the Log's id, in s 
 listlist, which stores data in the form [converted\_timestamp, id][converted_timestamp,id].

Retreive: However, we can save some time in retrieve approach by making use of tailMap function of TreeMap, 
which stores the entries in the form of a sorted navigable binary tree. By making use of this 
function, instead of iterating over all the timestamps in the storage to find the timestamps 
lying within the required range(after considering the granularity as in the last approach), we 
can reduce the search space to only those elements whose timestamp is larger than(or equal to) 
the starting timestamp value.

*/
public class LogSystem {
    TreeMap < Long, Integer > map;
    public LogSystem() {
        map = new TreeMap < Long, Integer > ();
    }

    public void put(int id, String timestamp) {
        int[] st = Arrays.stream(timestamp.split(":")).mapToInt(Integer::parseInt).toArray();
        map.put(convert(st), id);
    }
    public long convert(int[] st) {
        st[1] = st[1] - (st[1] == 0 ? 0 : 1);
        st[2] = st[2] - (st[2] == 0 ? 0 : 1);
        return (st[0] - 1999L) * (31 * 12) * 24 * 60 * 60 + st[1] * 31 * 24 * 60 * 60 + st[2] * 24 * 60 * 60 + st[3] * 60 * 60 + st[4] * 60 + st[5];
    }
    public List < Integer > retrieve(String s, String e, String gra) {
        ArrayList < Integer > res = new ArrayList();
        long start = granularity(s, gra, false);
        long end = granularity(e, gra, true);
        for (long key: map.tailMap(start).keySet()) {
            if (key >= start && key < end)
                res.add(map.get(key));
        }
        return res;
    }

    public long granularity(String s, String gra, boolean end) {
        HashMap < String, Integer > h = new HashMap();
        h.put("Year", 0);
        h.put("Month", 1);
        h.put("Day", 2);
        h.put("Hour", 3);
        h.put("Minute", 4);
        h.put("Second", 5);
        String[] res = new String[] {"1999", "00", "00", "00", "00", "00"};
        String[] st = s.split(":");
        for (int i = 0; i <= h.get(gra); i++) {
            res[i] = st[i];
        }
        int[] t = Arrays.stream(res).mapToInt(Integer::parseInt).toArray();
        if (end)
            t[h.get(gra)]++;
        return convert(t);
    }
}

/*
**Performance Analysis**
The TreeMap is maintained internally as a Red-Black(balanced) tree. 
Thus, the putmethod takes O\big(log(n)\big)O(log(n)) time to insert a new entry 
into the given set of logs. Here, nn refers to the number of entries currently present 
in the given set of logs.

The retrieve method takes O(m_{start}) time to retrieve the logs in the required range. 
Determining the granularity takes O(1) time. To find the logs in the required range, we only need to iterate 
 over those elements which already lie in the required range. Here, m_{start}
 refers to the number of entries in the current set of logs which have a timestamp greater 
 than the current startstart value.

*/