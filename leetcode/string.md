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
class Solution {
    private static int toLowerCase(char c) {
        return (c >= 'A' && c <= 'Z' ? c + ('a' - 'A') : c);
    }
    static boolean isAlphaNumeric(char c) {
        return  (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        while (start < end) {
            if (!isAlphaNumeric(ch[start])) start++;
            else if (!isAlphaNumeric(ch[end])) end--;
            else if (toLowerCase(ch[start++]) == toLowerCase(ch[end--])) {
            } else return false;
        }
        return true;
    }
}
```
## Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/
```java

```
## Palindromic Substrings
https://leetcode.com/problems/palindromic-substrings/
```java

```
