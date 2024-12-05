package com.vaibhavmm.data_structures_and_alogrithms.linked_list;

public class ReorderLinkedList {
    public static void reorderList(ListNode head) {
        ListNode slwPt = head;
        ListNode fstPt = head;

        while (fstPt != null && fstPt.next != null ) {
            slwPt = slwPt.next;
            if (fstPt.next != null) {
                fstPt = fstPt.next.next;
            } else {
                fstPt = null;
            }
        }

        ListNode dummy = slwPt.next;
        slwPt.next = null;
        ListNode rev = reverseList(dummy);
        mergeTwoLists(head, rev);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode merge = new ListNode(-1);
        ListNode head = merge;
        int count = 0;

        while (list1 != null && list2 != null) {
            if (count %2 == 0) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
            count ++;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return merge.next;
    }


    public static ListNode reverseList(ListNode rev) {

        ListNode curr = rev;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

}
