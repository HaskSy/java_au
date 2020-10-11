# Intervals
+ [Non-overlapping intervals](#non-overlapping-intervals)
+ [Merge Intervals](#merge-intervals)
+ [Insert Interval](#insert-interval)
## Non-overlapping intervals
https://leetcode.com/problems/non-overlapping-intervals/
```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int prev_result = intervals[0][1], count = intervals.length - 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev_result) {
                prev_result = intervals[i][1];
                count--;
            }
        }
        return count;
    }
}
```
## Merge Intervals
https://leetcode.com/problems/merge-intervals/
```java

```
## Insert Interval
https://leetcode.com/problems/insert-interval/
```java

```
