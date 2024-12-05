package com.vaibhavmm.data_structures_and_alogrithms.linked_list;

import java.util.HashMap;
import java.util.Map;

public class CopyWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        Node head2 = head;
        Map<Node, Node> mapNode = new HashMap<>();

        while(head2 != null) {

            Node temp = new Node(head2.val);
            mapNode.put(head2, temp);
            head2 = head2.next;

        }

        head2 = head;

        while(head2 != null) {

            Node copy = mapNode.get(head2);
            copy.next =  mapNode.get(head2.next);
            copy.random =  mapNode.get(head2.random);

            head2 = head2.next;

        }

        return mapNode.get(head);
    }

}
