+ [Merge Intervals](#merge-intervals)
## Merge Intervals
https://leetcode.com/problems/merge-intervals/
```java
class Solution {
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
