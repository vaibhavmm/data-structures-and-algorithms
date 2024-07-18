package com.vaibhavmm.data_structures_and_alogrithms.linked_list;

public class FlattenLinkedList {


    Node flatten(Node root) {

        if(root == null) {
            return null;
        }

        return mergeTwoLists(flatten(root.next), root);

    }


    public Node mergeTwoLists(Node list1, Node list2) {

        Node merge = new Node(-1);
        Node head = merge;

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                head.bottom = list1;
                list1 = list1.bottom;
            } else {
                head.bottom = list2;
                list2 = list2.bottom;
            }
            head = head.bottom;
        }
        if (list1 != null) {
            head.bottom = list1;
        }
        if (list2 != null) {
            head.bottom = list2;
        }

        return merge.bottom;

    }
}
