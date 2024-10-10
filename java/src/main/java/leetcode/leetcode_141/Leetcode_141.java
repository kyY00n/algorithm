package leetcode.leetcode_141;

public class Leetcode_141 {
    public boolean hasCycle(ListNode head) {
        ListNode rabbit = head; // iterate the linked list by 2 at once
        ListNode turtle = head; // iterate the linked list by 1 at once

        while (rabbit != null) {
            rabbit = rabbit.next;
            if (rabbit != null) {
                rabbit = rabbit.next;
            }
            turtle = turtle.next;

            if (rabbit != null && rabbit == turtle) { // there is a cycle in the linked list
                return true;
            }
        }

        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
