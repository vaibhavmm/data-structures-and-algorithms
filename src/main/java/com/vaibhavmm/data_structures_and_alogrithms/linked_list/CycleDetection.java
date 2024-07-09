package main.java.com.vaibhavmm.data_structures_and_alogrithms.linked_list;

// https://leetcode.com/problems/linked-list-cycle/submissions/1310630900/
public class CycleDetection {

    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {

        ListNode slwPtr = head, fastPr = head;

        while(fastPr != null && fastPr.next != null) {

            slwPtr = slwPtr.next;
            fastPr = fastPr.next.next;

            if (slwPtr == fastPr) return true;

        }

        return false;

    }
}
