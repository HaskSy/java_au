# String
+ [Longest Palindromic Substring](#longest-palindromic-substring)
## Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/
```java
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = Center(s, i, i);
            int len2 = Center(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private Center(String s, int left, int right) {
        int _left = left, _right = right;
        while (_left >= 0 && _right < s.length() && s.charAt(_left) == s.charAt(_right)) {
            _left--;
            _right++;
        }
        return _right - _left - 1;
    }
}

```
