# String
+ [Group Anagrams](#group-anagrams)
+ [Valid Palindrome](#valid-palindrome)
+ [Longest Palindromic Substring](#longest-palindromic-substring)
+ [Palindromic Substrings](#palindromic-substrings)
## Group Anagrams
https://leetcode.com/problems/group-anagrams/
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
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

```
