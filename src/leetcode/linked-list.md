# Linked List
+ [Merge Two Sorted Lists](#merge-two-sorted-lists)
## Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currentNode = new ListNode();
        ListNode merged_list = currentNode;
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
        return merged_list.next;
    }
}

```
