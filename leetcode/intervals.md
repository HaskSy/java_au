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

```
## Insert Interval
https://leetcode.com/problems/insert-interval/
```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int middle = 0;
        ArrayList<int[]> results = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                results.add(interval);
                middle++;
            } else if (interval[0] > newInterval[1]) {
                results.add(interval);
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        results.add(middle, newInterval);
        return results.toArray(new int[results.size()][2]);
    }
}
```
