package com.vaibhavmm.data_structures_and_alogrithms.linked_list;

public class MergeTwoSortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode merge = new ListNode(-1);
        ListNode head = merge;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }

        return merge.next;

    }
}
