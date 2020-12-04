# Array

+ [Squares of a Sorted Array](#squares-of-a-sorted-array)

## Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/
```java
class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null) return null;

        int [] ans = new int[A.length];

        int start = 0, end = A.length - 1;
        int i = end; // insert position.
        while (start <= end) {
            int startPower = A[start] * A[start];
            int endPower = A[end] * A[end];
            if (startPower > endPower) {
                ans[i--] = startPower;
                start++;
            } else {
                ans[i--] = endPower;
                end--;
            }
        }
        return ans;
    }
}

```