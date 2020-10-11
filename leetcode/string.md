# String
+ [Group Anagrams](#group-anagrams)
+ [Valid Palindrome](#valid-palindrome)
+ [Longest Palindromic Substring](#longest-palindromic-substring)
+ [Palindromic Substrings](#palindromic-substrings)
## Group Anagrams
https://leetcode.com/problems/group-anagrams/
```java

```
## Valid Palindrome
https://leetcode.com/problems/valid-palindrome/
```java

```
## Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/
```java
class Solution {
    int start = 0;
    int end = 0;
    char[] cs = null;
    int length = 0;
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        cs = s.toCharArray();
        length = cs.length;
        fill(0);
        return s.substring(start, end + 1);
    }
    private void fill(int i) {
        if (i + 1 == length || 2 * (length - i) + 1 < end - start) return;
        int cs_start = i;
        int cs_end = i;
        while (cs_end < length - 1 && cs[cs_end] == cs[cs_end + 1]) cs_end++;
        i = cs_end;
        while (cs_start > 0 && cs_end < length - 1 && cs[cs_start - 1] == cs[cs_end + 1]) {
            cs_start--;
            cs_end++;
        }
        if (cs_end - cs_start > end - start) {
            end = cs_end;
            start = cs_start;
        }
        fill(i + 1);
    }
}
```
## Palindromic Substrings
https://leetcode.com/problems/palindromic-substrings/
```java

```
