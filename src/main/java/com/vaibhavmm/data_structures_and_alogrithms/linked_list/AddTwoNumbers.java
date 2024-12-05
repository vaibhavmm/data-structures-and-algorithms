package com.vaibhavmm.data_structures_and_alogrithms.linked_list;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {

        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        int carry = 0;

        while (list1 != null && list2 != null) {

            int value = list1.val + list2.val + carry;
            carry = value / 10;
            head.next = new ListNode(value%10);
            head = head.next;
            list1 = list1.next;
            list2 = list2.next;

        }

        while (list1 != null) {
            int value = list1.val  + carry;
            carry = value / 10;
            head.next = new ListNode(value%10);
            head = head.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            int value = list2.val  + carry;
            carry = value / 10;
            head.next = new ListNode(value%10);
            head = head.next;
            list2 = list2.next;
        }

        if (carry != 0) {
            head.next = new ListNode(carry) ;
        }

        return ans.next;


    }
}
