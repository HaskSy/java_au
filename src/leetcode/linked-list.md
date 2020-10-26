# Linked List
+ [Sort List](#sort-list)
## Sort List
https://leetcode.com/problems/sort-list/
```java
class Solution {
    private ListNode mergeSort(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode StartPointer = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                StartPointer.next = l1;
                l1 = l1.next;
            } else {
                StartPointer.next = l2;
                l2 = l2.next;
            }
            StartPointer = StartPointer.next;
        }
        if (l1 != null) StartPointer.next = l1;
        else StartPointer.next = l2;
        return result.next;
    }
    public ListNode sortList(ListNode headList) {
        if (headList == null || headList.next == null) return headList;
        ListNode fast = headList;
        ListNode slow = headList;
        ListNode middlePointer = null;
        while (fast != null && fast.next != null) {
            middlePointer = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        middlePointer.next = null;
        ListNode left = sortList(headList);
        ListNode right = sortList(slow);
        return mergeSort(left, right);
    }
}

```
