# Intervals

+ [Non-overlapping Intervals](#non-overlapping-intervals)
+ [Merge Intervals](#merge-intervals)
+ [Insert Interval](#insert-interval)

## Non-overlapping intervals

https://leetcode.com/problems/non-overlapping-intervals

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
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int[][] result = new int[1][2];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int j = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (start[i + 1] > end[i]) {
                result[result.length - 1] = new int[]{start[j], end[i]};
                j = i + 1;
                result = Arrays.copyOf(result, result.length + 1);
            }
        }
        result[result.length - 1] = new int[]{start[j], end[intervals.length - 1]};
        return result;
    }
}
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