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

```
## Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/
```java

```
## Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
```java
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA, pointerB = headB;
        while (pointerA != pointerB) {
            if (pointerA != null) pointerA = pointerA.next;
            else pointerA = headB;
            if (pointerB != null) pointerB = pointerB.next;
            else pointerB = headA;
        }
        return pointerA;
    }
}
```
## Sort List
https://leetcode.com/problems/sort-list/
```java

```
