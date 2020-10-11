# Linked-list
+ [Reverse Linked List](#reverse-linked-list)
+ [Middle of the Linked List](#middle-of-the-linked-list)
+ [Palindrome Linked List](#palindrome-linked-list)
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
+ [Sort List](#sort-list)
## Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/
```java

```
## Middle of the Linked List
https://leetcode.com/problems/middle-of-the-linked-list/
```java

```
## Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/
```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode reversedMiddle = null, slowTemp;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowTemp = slow.next;
            slow.next = reversedMiddle;
            reversedMiddle = slow;
            slow = slowTemp;
        }
        ListNode slowPointer = reversedMiddle, fastPointer;
        if (fast == null) fastPointer = slow;
        else fastPointer = slow.next;
        while (slowPointer != null && fastPointer != null) {
            if (slowPointer.val != fastPointer.val) return false;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return true;
    }
}
```
## Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/
```java

```
## Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
```java

```
## Sort List
https://leetcode.com/problems/sort-list/
```java

```
