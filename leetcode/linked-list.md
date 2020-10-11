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
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
```
## Palindrome Linked List
https://leetcode.com/problems/palindrome-linked-list/
```java

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
