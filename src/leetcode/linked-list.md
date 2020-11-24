# Linked-list
+ [Reverse Linked List](#reverse-linked-list)
## Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/
```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = cur.next;
            cur.next = prev;
            prev = cur;
            cur = node;
        }
        return prev;
    }
}
```
