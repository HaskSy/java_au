# Graph

+ [Number of Islands](#number-of-islands)

## Number of Islands
https://leetcode.com/problems/number-of-islands/
```java
class Solution {
    public int numIslands(char[][] grid) {
        int numberIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    explore(grid, i, j);
                    numberIslands++;
                }
            }
        }
        return numberIslands;
    }

    public void explore(char[][] grid, int i, int j) {
        if (endOfMap(grid, i, j) || grid[i][j] == '0') return;

        grid[i][j] = '0';

        explore(grid, i + 1, j);
        explore(grid, i, j + 1);
        explore(grid, i - 1, j);
        explore(grid, i, j - 1);
    }

    public boolean endOfMap(char[][] grid, int i, int j) {
        return i < 0 ||
                i >= grid.length ||
                j < 0 ||
                j >= grid[0].length;
    }
}

```