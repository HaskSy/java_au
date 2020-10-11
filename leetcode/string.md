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

```
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
