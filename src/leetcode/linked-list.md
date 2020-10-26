# Linked List
+ [Intersection of Two Linked Lists](#intersection-of-two-linked-lists)
## Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/
```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head_a_copy = headA, head_b_copy = headB;
        while (head_a_copy != head_b_copy) {
            if (head_a_copy != null) head_a_copy = head_a_copy.next;
            else head_a_copy = headB;
            if (head_b_copy != null) head_b_copy = head_b_copy.next;
            else head_b_copy = headA;
        }
        return head_a_copy;
    }
}

```
