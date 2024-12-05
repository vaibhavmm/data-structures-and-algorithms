package com.vaibhavmm.data_structures_and_alogrithms.linked_list;


//
//        Input: head = [1,2,3,4,5]
//        Output: [5,4,3,2,1]
public class ReverseLinkedList {


    public static void main(String[] args) {

    }

    public ListNode reverseListI(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;


        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

        }

        return prev;


    }


    public ListNode reverseLinkedListII(ListNode head, int left, int right) {

        int i = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy.next;

        while (i < left) {
            prev = head;
            head = head.next;
            i ++;
        }

        ListNode curr = head;


        while (curr != null && i < right) {

            ListNode frw = curr.next;


            curr.next = frw;
            frw.next = prev.next;
            prev.next = frw;
            i++;

        }

        return dummy.next;

    }
}
