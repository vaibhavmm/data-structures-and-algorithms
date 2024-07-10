package com.vaibhavmm.data_structures_and_alogrithms.linked_list;

// https://www.geeksforgeeks.org/problems/find-the-sum-of-last-n-nodes-of-the-linked-list/0
public class SumOfLastNNodes {

    public static void main(String[] args) {


    }

    public int sum(ListNode head, int k) {

        ListNode ptr1 = head, ptr2 = head;
        int sum = 0 , subSum = 0;
        while(ptr1 != null && k-- > 0) { // first k elements
            sum += ptr1.val;
            ptr1 = ptr1.next;
        }

        while(ptr1 != null) { // rest size - k elements

            subSum += ptr2.val; // sum of first size -k elements
            sum += ptr1.val; // sum of all elements
            ptr1 = ptr1.next;
            ptr2= ptr2.next;
        }

        return sum - subSum; // sum of whole (size) - sum of first (size -k) elements == gives sum of k elements


    }




}
