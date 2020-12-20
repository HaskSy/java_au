# Graph

+ [Course Schedule](#course-schedule)

## Course Schedule
https://leetcode.com/problems/course-schedule/
```java
class Solution {
    
    HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
    HashSet<Integer> cycled = new HashSet<>();
    HashSet<Integer> nonCycled = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!nonCycled.contains(i)) {
                boolean hasCycle = dfsDetectCycle(i);
                if (hasCycle) return false;
            }
        }
        return true;
    }

    private boolean dfsDetectCycle(int n) {
        if (nonCycled.contains(n)) return false;

        if (cycled.contains(n)) return true;

        cycled.add(n);

        for (int e: adj.get(n)) {
            if (!nonCycled.contains(e)) {
                boolean hasCycle = dfsDetectCycle(e);
                if (hasCycle) return true;
            }
        }

        nonCycled.add(n);
        return false;
    }
}

```