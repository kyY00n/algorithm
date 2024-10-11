package leetcode;

public class Leetcode_21 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            /**
             * Remember the order of operation to move forward in linked list.
             */
            if (list1.val < list2.val) { // compare list1 with list2
                tail.next = list1; // First, we have to assign list1 to tail.next
                tail = list1; // Second, we have to assign list1 to tail (and this means that we attached list1 at the end of the linked list.)
                list1 = list1.next; // Third, we have to move list1 pointer forward.
                continue; // and continue to compare list1 with list2
            }
            tail.next = list2;
            tail = list2;
            list2 = list2.next;
        }
        while(list1 != null) {
            tail.next = list1;
            tail = list1;
            list1 = list1.next;
        }
        while(list2 != null) {
            tail.next = list2;
            tail = list2;
            list2 = list2.next;
        }

        return head.next;
    }

}
