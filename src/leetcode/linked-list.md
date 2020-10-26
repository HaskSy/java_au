# Linked List
+ [Palindrome Linked List](#palindrome-linked-list)
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
