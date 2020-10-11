# Intervals
+ [Non-overlapping intervals](#non-overlapping-intervals)
+ [Merge Intervals](#merge-intervals)
+ [Insert Interval](#insert-interval)
## Non-overlapping intervals
https://leetcode.com/problems/non-overlapping-intervals/
```java

```
## Merge Intervals
https://leetcode.com/problems/merge-intervals/
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        ArrayList<int[]> result = new ArrayList<>();
        int[] prevInterval = intervals[0];
        result.add(prevInterval);
        for (int[] interval : intervals) {
            if (prevInterval[1] >= interval[0])
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            else {
                prevInterval = interval;
                result.add(prevInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
```
## Insert Interval
https://leetcode.com/problems/insert-interval/
```java

```
