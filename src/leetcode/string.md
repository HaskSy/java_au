# String
+ [Palindromic Substrings](#palindromic-substrings)
## Palindromic Substrings
https://leetcode.com/problems/palindromic-substrings/
```java
class Solution {
    int ans = 0;
    char[] charArray = null;
    int length = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) return 0;
        charArray = s.toCharArray();
        length = charArray.length;
        for (int i = 0; i < length; i++) {
            fromCentre(i, i);
            fromCentre(i, i + 1);
        }
        return ans;
    }
    void fromCentre(int left, int right) {
        while (0 <= left && right < length) {
            if (charArray[left] != charArray[right]) return;
            right++;
            left--;
            ans++;
        }
    }
}

```
