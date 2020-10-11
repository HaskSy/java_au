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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode();
        ListNode mergedList = currentNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        if (l1 != null) currentNode.next = l1;
        if (l2 != null) currentNode.next = l2;
        return mergedList.next;
    }
}
```
## Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
```java

```
## Sort List
https://leetcode.com/problems/sort-list/
```java

```
